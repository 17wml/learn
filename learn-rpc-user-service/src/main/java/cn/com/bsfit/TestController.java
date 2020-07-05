package cn.com.bsfit;

import cn.com.bsfit.annotation.WMLReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wml
 * @date 2020年07月01日  10:21:58
 **/
@RestController
public class TestController {

    @WMLReference
    private IOrderService orderService;
    @GetMapping("/query")
    public String query(){
        return  orderService.queryOrderList();
    }
}
