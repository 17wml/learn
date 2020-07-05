package cn.com.bsfit;

import cn.com.bsfit.annotation.WMLRemoteService;

/**
 * @author wml
 * @date 2020年06月30日  20:33:54
 **/
@WMLRemoteService //声明这个注解之后，自动发布服务
public class OrderServiceImpl implements IOrderService {
    public String queryOrderList() {
        return "orderimpl for queryOrderList";
    }

    public String orderById(String id) {
        return "orderimpl for orderById" + id;
    }
}
