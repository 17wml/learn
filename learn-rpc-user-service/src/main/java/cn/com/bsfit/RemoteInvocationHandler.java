package cn.com.bsfit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author wml
 * @date 2020年06月30日  21:44:37
 **/
@Component
public class RemoteInvocationHandler implements InvocationHandler {
    @Value("${wml.host}")
    private String host;
    @Value("${wml.port}")
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public RemoteInvocationHandler() {

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //建立远程连接
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);

        //传递数据
        //要调用哪个接口调用哪个方法，参数是什么？
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setArgs(args);//参数
        rpcRequest.setClassName(method.getDeclaringClass().getName());//类名称
        rpcRequest.setMethodName(method.getName());//方法名
        rpcRequest.setTypes(method.getParameterTypes());//参数类型

       return rpcNetTransport.send(rpcRequest);//发送到远程
    }
}
