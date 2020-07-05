package cn.com.bsfit;

import java.lang.reflect.Method;

/**
 * @author wml
 * @date 2020年07月01日  9:42:07
 **/
public class BeanMethod {

    private Object bean;

    private Method method;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
