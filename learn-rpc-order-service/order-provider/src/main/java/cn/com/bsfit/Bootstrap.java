package cn.com.bsfit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wml
 * @date 2020年06月30日  20:34:36
 **/
//新增一个配置类
@Configuration
@ComponentScan("cn.com.bsfit") //扫描包路径
public class Bootstrap {

    public static void main(String[] args) {
        //Springboot

//        IOrderService orderService = new OrderServiceImpl();
//        RpcProxyServer rpcProxyServer = new RpcProxyServer();
//        rpcProxyServer.publisher(orderService, 8080);
        //通过annotation的方式去扫描装载需要被spring管理的类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Bootstrap.class);
    }
}
