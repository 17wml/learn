package cn.com.bsfit.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author wml
 * @date 2020年06月29日  15:57:24
 **/
public class ClientSocketDemo {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8080);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        User user = new User();
        user.setName("wml");
        user.setPasswd("12345");
        objectOutputStream.writeObject(user);

    }
}
