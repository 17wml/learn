package cn.com.bsfit.serializable;

/**
 * Hello world!
 *
 */
public class Main
{
//    public static void main( String[] args )
//    {
//        ISerializable serializable = new JavaSerializable();
//
//        User user = new User();
//        user.setName("Mic");
//        user.setPasswd("1234");
//        byte [] bytes = serializable.serialize(user);
//        System.out.println(bytes.length);
//        for (int i = 0; i <bytes.length ; i++) {
//            System.out.print(bytes[i] + "  ");
//        }
//        System.out.println();
//        User user1 = serializable.deserialize(bytes);
//        System.out.println(user1);
//
//    }
//public static void main( String[] args )
//{
//    ISerializable serializable = new XMlSerializable();
//
//    User user = new User();
//    user.setName("Mic");
//    user.setPasswd("1234");
//    byte [] bytes = serializable.serialize(user);
//    System.out.println(bytes.length);
//    for (int i = 0; i <bytes.length ; i++) {
//        System.out.print(bytes[i] + "  ");
//    }
//    System.out.println(new String(bytes));
//    User user1 = serializable.deserialize(bytes);
//    System.out.println(user1);
//
//}
        public static void main( String[] args )
    {
//        ISerializable serializable = new HessianSerializable();
//        ISerializable serializable = new JavaSerializable();
        ISerializable serializable = new XMLSerializable();

        User user = new User();
        user.setName("Mic");
        user.setPasswd("1234");
        byte [] bytes = serializable.serialize(user);
        System.out.println(bytes.length);
        for (int i = 0; i <bytes.length ; i++) {
            System.out.print(bytes[i] + "  ");
        }
        System.out.println();
        User user1 = serializable.deserialize(bytes);
        System.out.println(user1);

    }
}
