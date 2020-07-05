package cn.com.bsfit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IOrderService orderService = new RpcProxyClient().clientProxy(IOrderService.class, "localhost",8080);

        System.out.println(orderService.queryOrderList());
        System.out.println(orderService.orderById("balabala"));
    }
}
