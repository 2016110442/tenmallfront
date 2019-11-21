package com.cn.wanxi.front.advertisin;

import com.cn.wanxi.model.advertisin.Result;
import com.cn.wanxi.model.advertisin.WxTabAdvertisin;
import com.cn.wanxi.service.advertisin.WxTabAdvertisinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @date 2019/11/20 12:13
 */
@RestController
@RequestMapping("/advertisin")
public class WxTabAdvertisinController {

    @Autowired(required = false)
    private WxTabAdvertisinService wxTabAdvertisinService;

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public List<WxTabAdvertisin> findAll(@RequestParam String position){
        return wxTabAdvertisinService.selectByPosition(position);
    }

    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public WxTabAdvertisin findAll(@RequestParam Integer id){
        return wxTabAdvertisinService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result findAll(@RequestBody WxTabAdvertisin wxTabAdvertisin){
        Integer i = wxTabAdvertisinService.insert(wxTabAdvertisin);
        Result result = new Result();
        if (i==1){
            result.setCode(1);
            result.setMessage("添加成功");
        }else{
            result.setCode(0);
            result.setMessage("添加失败");
        }
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody WxTabAdvertisin wxTabAdvertisin){
        Integer i = wxTabAdvertisinService.updateByPrimaryKey(wxTabAdvertisin);
        Result result = new Result();
        if (i==1){
            result.setCode(1);
            result.setMessage("添加成功");
        }else{
            result.setCode(0);
            result.setMessage("添加失败");
        }
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestParam Integer id){
        Integer i = wxTabAdvertisinService.deleteByPrimaryKey(id);
        Result result = new Result();
        if (i==1){
            result.setCode(1);
            result.setMessage("添加成功");
        }else{
            result.setCode(0);
            result.setMessage("添加失败");
        }
        return result;
    }

}
