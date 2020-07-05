package cn.com.bsfit;

import org.springframework.context.annotation.Bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wml
 * @date 2020年07月01日  9:41:22
 **/
public class Meditor {

    public  static Map<String, BeanMethod> map = new ConcurrentHashMap<>();


    private volatile static Meditor instance;
    public static Meditor getInstance(){
        if(instance == null){
            synchronized (Meditor.class){
                if(instance == null){
                    return new Meditor();
                }
            }
        }
        return instance;
    }

    public Object processor(RpcRequest request){
        String key = request.getClassName()+"."+request.getMethodName(); //key
        //服务路由
        BeanMethod beanMethod =  map.get(key);

        Object bean= beanMethod.getBean();
        Method method = beanMethod.getMethod();

        try {
            return method.invoke(bean, request.getArgs());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
