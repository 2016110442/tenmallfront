package com.cn.wanxi.service.order;

import com.auth0.jwt.JWT;
import com.cn.wanxi.dao.order.WxTabOrderItemMapper;
import com.cn.wanxi.model.order.WxTabOrderItem;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.user.UserService;
import com.cn.wanxi.util.WebTools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class WxTabOrderItemServiceImpl implements WxTabOrderItemService {

    @Autowired
    private WxTabOrderItemMapper wxTabOrderItemMapper;
    @Autowired
    private UserService userService;

    @Override
    public int insert(WxTabOrderItem record) {
        return wxTabOrderItemMapper.insert(record);
    }

    @Override
    public List<WxTabOrderItem> findBySkuIds(String[] skuIds) {
        return wxTabOrderItemMapper.findBySkuIds(skuIds);
    }

    @Override
    public List<WxTabOrderItem> findByIds(String[] Ids) {
        return wxTabOrderItemMapper.findByIds(Ids);
    }

    @Override
    public PageInfo<Map<String,Object>> pageByPayStatusAndConsignStatus(HttpServletRequest request,Integer page, Integer size, String payStatus, String consignStatus, String username) {
        if(StringUtils.isEmpty(username)){
            //获取用户信息
//            String phone = WebTools.getSession("username");
            String phone = JWT.decode(request.getHeader("token")).getAudience().get(0);
            if(!StringUtils.isEmpty(phone)){
                List<User> users = userService.findByPhone(phone);
                if(users.size()>0){
                    username =users.get(0).getUsername();
                }
            }
        }
        PageHelper.startPage(page,size);
        return new PageInfo<Map<String,Object>>(wxTabOrderItemMapper.findByPayStatusAndConsignStatus(payStatus,consignStatus,username));
    }

    @Override
    public WxTabOrderItem get(String id) {
        return wxTabOrderItemMapper.get(id);
    }

    @Override
    public int update(WxTabOrderItem record) {
        return wxTabOrderItemMapper.update(record);
    }
}