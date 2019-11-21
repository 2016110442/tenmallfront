package com.cn.wanxi.front.order;

import com.cn.wanxi.model.advertisin.Result;
import com.cn.wanxi.model.order.WxOrderVO;
import com.cn.wanxi.service.order.WxTabOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2019/11/20 15:50
 */
@RestController
@RequestMapping("/order")
public class WxTabOrderController {

    @Autowired
    private WxTabOrderService wxTabOrderService;

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public Result insert(@RequestBody WxOrderVO wxOrderVO){
        Result result = new Result();
        int i = wxTabOrderService.insert(wxOrderVO);
        if (i==1){
            result.setCode(1);
            result.setMessage("XXX");
        }else{
            result.setCode(0);
            result.setMessage("XXX");
        }
        return result;
    }


}
