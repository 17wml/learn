package cn.com.bsfit.serializable;

import java.io.UnsupportedEncodingException;

/**
 * @author wml
 * @date 2020年06月29日  16:30:14
 **/
public interface ISerializable {

    /**
     * 序列化
     * */
    public <T> byte[] serialize(T obj);


    /**
     * 反序列化
     * */
    public <T> T deserialize(byte [] data);


}
