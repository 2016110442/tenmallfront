package com.cn.wanxi.service.address;

import com.auth0.jwt.JWT;
import com.cn.wanxi.dao.address.WxTabAddressDao;
import com.cn.wanxi.model.address.WxTabAddress;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.user.UserService;
import com.cn.wanxi.util.WebTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@Service
public class WxTabAddressServiceImpl implements WxTabAddressService {
    @Autowired
    private WxTabAddressDao wxTabAddressDao;
    @Autowired
    private UserService userService;

    @Override
    public WxTabAddress get(String id) {
        return wxTabAddressDao.get(id);
    }

    @Override
    public List<WxTabAddress> find(WxTabAddress address) {
        List<WxTabAddress> wxTabAddresses = wxTabAddressDao.find(address);
        List<WxTabAddress> updateWxTabAddresses = new ArrayList<>();
        for (WxTabAddress wxTabAddress:wxTabAddresses) {
            wxTabAddress.setReceiverAddress(wxTabAddress.getReceiverAddress().replaceAll("\"","'"));
            wxTabAddress.setReceiverName(wxTabAddress.getReceiverName().replaceAll("\"","'"));
            updateWxTabAddresses.add(wxTabAddress);
        }
        return updateWxTabAddresses;
    }

    @Override
    public boolean add(WxTabAddress address, HttpServletRequest request) {
        String phone = JWT.decode(request.getHeader("token")).getAudience().get(0);
        if(!StringUtils.isEmpty(phone)){
            address.setUsername(phone);
        }
        Integer num = wxTabAddressDao.insert(address);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(WxTabAddress address, HttpServletRequest request) {
        if(address.getIsDefault().equals("0")){
            //获取用户信息
//            String phone = WebTools.getSession("username");
            String phone = JWT.decode(request.getHeader("token")).getAudience().get(0);
            if(!StringUtils.isEmpty(phone)){
                List<User> users = userService.findByPhone(phone);
                if(users.size()>0){
                    wxTabAddressDao.updateIsDefault("1",users.get(0).getUsername());
                }
            }else{
                wxTabAddressDao.updateIsDefault("1","");
            }
        }

        Integer num = wxTabAddressDao.update(address);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Integer num = wxTabAddressDao.delete(id);
        if(num == 1){
            return true;
        }
        return false;
    }
}
