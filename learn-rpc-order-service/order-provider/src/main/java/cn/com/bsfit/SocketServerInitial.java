package cn.com.bsfit;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wml
 * @date 2020年07月01日  9:54:42
 **/
//spring 容器启动完成后，会发布一个ContextRefreshedEvent这个事件
@Component
public class SocketServerInitial implements ApplicationListener<ContextRefreshedEvent> {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //启动服务
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(8888);
            while(true){
                Socket socket = serverSocket.accept();//连接阻塞
                executorService.execute(new ProcessorHandler(socket));//Io不阻塞

            }

        }catch (Exception e){

        }

    }
}
