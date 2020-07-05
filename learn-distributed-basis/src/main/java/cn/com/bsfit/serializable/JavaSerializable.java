package cn.com.bsfit.serializable;

import java.io.*;

/**
 * @author wml
 * @date 2020年06月29日  16:41:19
 **/
public class JavaSerializable implements ISerializable{
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream("user"));
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//            ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream("user"));
            return (T)objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
