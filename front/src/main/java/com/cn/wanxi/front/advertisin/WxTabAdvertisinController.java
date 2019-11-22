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
    public List<WxTabAdvertisin> findAll(@RequestParam(required = true) String position){
        if (position==null||"".equals(position)){
            return null;
        }
        return wxTabAdvertisinService.selectByPosition(position);
    }

    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public WxTabAdvertisin findAll(@RequestParam(required = true) Integer id){
        return wxTabAdvertisinService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result findAll(@RequestBody WxTabAdvertisin wxTabAdvertisin){
        Boolean is = true;
        if (wxTabAdvertisin.getPosition()==null||"".equals(wxTabAdvertisin.getPosition())){
            is=false;
        }else if (wxTabAdvertisin.getName()==null||"".equals(wxTabAdvertisin.getName())){
            is=false;
        }else if (wxTabAdvertisin.getStartTime()==null||"".equals(wxTabAdvertisin.getStartTime())){
            is=false;
        }else if (wxTabAdvertisin.getEndTime()==null||"".equals(wxTabAdvertisin.getEndTime())){
            is=false;
        }else if (wxTabAdvertisin.getImage()==null||"".equals(wxTabAdvertisin.getImage())){
            is=false;
        }else if (wxTabAdvertisin.getUrl()==null||"".equals(wxTabAdvertisin.getUrl())){
            is=false;
        }else if (wxTabAdvertisin.getRemarks()==null||"".equals(wxTabAdvertisin.getRemarks())){
            is=false;
        }
        Integer i = 0;
        if (is){
            i = wxTabAdvertisinService.insert(wxTabAdvertisin);
        }else{
            i=2;
        }
        Result result = new Result();
        if (i==1){
            result.setCode(1);
            result.setMessage("添加成功");
        }else if (i==0){
            result.setCode(0);
            result.setMessage("添加失败");
        }else if (i==2){
            result.setCode(2);
            result.setMessage("添加出错，请检查格式");
        }
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody WxTabAdvertisin wxTabAdvertisin){
        Boolean is = true;
        if (wxTabAdvertisin.getPosition()==null||"".equals(wxTabAdvertisin.getPosition())){
            is=false;
        }else if (wxTabAdvertisin.getName()==null||"".equals(wxTabAdvertisin.getName())){
            is=false;
        }else if (wxTabAdvertisin.getStartTime()==null||"".equals(wxTabAdvertisin.getStartTime())){
            is=false;
        }else if (wxTabAdvertisin.getEndTime()==null||"".equals(wxTabAdvertisin.getEndTime())){
            is=false;
        }else if (wxTabAdvertisin.getImage()==null||"".equals(wxTabAdvertisin.getImage())){
            is=false;
        }else if (wxTabAdvertisin.getUrl()==null||"".equals(wxTabAdvertisin.getUrl())){
            is=false;
        }else if (wxTabAdvertisin.getRemarks()==null||"".equals(wxTabAdvertisin.getRemarks())){
            is=false;
        }
        Integer i = 0;
        if (is){
            i = wxTabAdvertisinService.updateByPrimaryKey(wxTabAdvertisin);
        }else{
            i=2;
        }
        Result result = new Result();
        if (i==1){
            result.setCode(1);
            result.setMessage("添加成功");
        }else if (i==0){
            result.setCode(0);
            result.setMessage("添加失败");
        }else if (i==2){
            result.setCode(2);
            result.setMessage("添加出错，请检查格式");
        }
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestParam(required = true) Integer id){
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
