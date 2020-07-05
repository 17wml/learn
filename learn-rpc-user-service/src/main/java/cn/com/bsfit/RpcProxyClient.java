package cn.com.bsfit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wml
 * @date 2020年06月30日  20:57:57
 **/
public class RpcProxyClient {




    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
