package cn.com.bsfit;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wml
 * @date 2020年06月30日  20:56:01
 **/
public class RpcProxyServer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object service , int port){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while(true){
               Socket socket = serverSocket.accept();//连接阻塞
//               executorService.execute(new ProcessorHandler(service, socket));//Io不阻塞

            }

        }catch (Exception e){

        }
    }
}
