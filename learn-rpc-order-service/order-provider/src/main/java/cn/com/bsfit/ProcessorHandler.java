package cn.com.bsfit;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author wml
 * @date 2020年07月01日  8:08:53
 **/
public class ProcessorHandler implements Runnable {

    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest request = (RpcRequest) objectInputStream.readObject();//反序列化
            //要调用哪个类哪个方法,,路由
            Meditor meditor = Meditor.getInstance();

//            Object obj = invoke(request);
            Object obj = meditor.processor(request);
            System.out.println("服务端处理的结果"+obj);//服务端处理的结果

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //TODO 关闭流
        }

    }

    ///通过反射进行服务调用
//    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        //通过反射调用
//        Class<?> clazz = Class.forName(request.getClassName());
//        //找到目标方法
//        Method method = clazz.getMethod(request.getMethodName(), request.getTypes());
//
//        return method.invoke(service, request.getArgs());
//    }
}
