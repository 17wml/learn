package cn.com.bsfit.serializable;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wml
 * @date 2020年06月29日  16:05:54
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -3587569335530784504L;
    private String name;

    private transient String passwd;


    private void writeObject(ObjectOutputStream out) throws IOException {
//         out.defaultWriteObject();
//         out.writeBytes(passwd);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//         in.defaultReadObject();
//         byte [] data = new byte[1024];
//         int len = 0;
//         while (in.read(data)!=-1)    {
//
//         }
//         passwd = new String(data, "utf-8");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
