package cn.com.bsfit;

import cn.com.bsfit.annotation.WMLReference;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * @author wml
 * @date 2020年07月01日  11:04:09
 **/
@Component
public class ReferenceInvokeProxy implements BeanPostProcessor {

    @Autowired
    RemoteInvocationHandler remoteInvocationHandler;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //得到bean里面的每一个field。
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(WMLReference.class)){

                //针对private的属性的处理
                field.setAccessible(true);
                //针对这个加了WMLReference注解的字段，设置为一个代理的值
                Object proxy = Proxy.newProxyInstance(field.getType().getClassLoader(), new Class<?>[]{field.getType()}, remoteInvocationHandler);
                try {
                    field.set(bean, proxy); //针对加了WMLReference的注解，设置了一个代理。
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
