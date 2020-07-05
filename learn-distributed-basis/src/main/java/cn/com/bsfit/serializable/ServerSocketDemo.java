package cn.com.bsfit.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wml
 * @date 2020年06月29日  15:57:46
 **/
public class ServerSocketDemo {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        User user =  (User)objectInputStream.readObject();
        System.out.println(user);
//        objectInputStream.
    }
}
