package cn.com.bsfit;

import cn.com.bsfit.annotation.WMLRemoteService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wml
 * @date 2020年07月01日  9:43:44
 **/
@Component
public class InitialMerdiator implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //这里肯定会扫描到加了@Componet 注解的bean
        //加了rpc服务发布的的bean 进行远程发布。
        if(bean.getClass().isAnnotationPresent(WMLRemoteService.class)){

            Method[] methods  = bean.getClass().getDeclaredMethods();
            for (Method method : methods) {

                //以接口的全路径加上方法名组成的一个key ,,, interface内部路由
                String key = bean.getClass().getInterfaces()[0].getName()+"."+method.getName();
                BeanMethod beanMethod = new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                //完成需要发布的服务的存储
                Meditor.map.put(key, beanMethod);
            }
        }
        return bean;
    }
}
