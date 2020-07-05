package cn.com.bsfit.serializable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * @author wml
 * 基于xml进行序列化
 * @date 2020年06月29日  17:37:35
 **/
public class XMLSerializable implements ISerializable {
    XStream stream = new XStream(new DomDriver());
    @Override
    public <T> byte[] serialize(T obj) {
        return stream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data) {
            return (T)stream.fromXML(new String(data));

    }
}
