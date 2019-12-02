package com.cn.wanxi.service.user;

import com.cn.wanxi.dao.user.WxTabReturnCauseDao;
import com.cn.wanxi.model.order.WxTabOrder;
import com.cn.wanxi.model.order.WxTabOrderItem;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.model.user.WxTabReturnCause;
import com.cn.wanxi.model.user.WxTabReturnOrder;
import com.cn.wanxi.model.user.WxTabReturnOrderItem;
import com.cn.wanxi.service.order.WxTabOrderItemService;
import com.cn.wanxi.service.order.WxTabOrderService;
import com.cn.wanxi.util.WebTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@Service
public class WxTabReturnCauseServiceImpl implements WxTabReturnCauseService {
    @Autowired
    private WxTabReturnCauseDao wxTabReturnCauseDao;
    @Autowired
    private WxTabReturnOrderService wxTabReturnOrderService;
    @Autowired
    private WxTabReturnOrderItemService wxTabReturnOrderItemService;
    @Autowired
    private WxTabOrderItemService wxTabOrderItemService;
    @Autowired
    private WxTabOrderService wxTabOrderService;
    @Autowired
    private UserService userService;

    @Override
    public boolean add(WxTabReturnCause wxTabReturnCause) {
        wxTabReturnCause.setStatus('0');
        Integer num = wxTabReturnCauseDao.insert(wxTabReturnCause);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    public WxTabReturnCause find(WxTabReturnCause wxTabReturnCause) {
        List<WxTabReturnCause> list =wxTabReturnCauseDao.find(wxTabReturnCause);
        if(list.size()>0){
            return list.get(0);
        }
        return new WxTabReturnCause();
    }

    @Override
    @Transactional
    public boolean addAssociated(String orderId, String orderItemid, String evidence, String description, String returnCause, String type) {
        //退货退款原因表
        WxTabReturnCause wxTabReturnCause = new WxTabReturnCause();
        wxTabReturnCause.setCause(returnCause);
        boolean flag=add(wxTabReturnCause);
        if (flag) wxTabReturnCause=find(wxTabReturnCause);
        WxTabOrderItem wxTabOrderItem =wxTabOrderItemService.get(orderItemid);
        if(StringUtils.isEmpty(orderId)) return false;
        WxTabOrder wxTabOrder =wxTabOrderService.selectByIds(orderId.split(",")).get(0);
        if(wxTabOrderItem==null || wxTabOrder==null){
            return false;
        }

        //退货退款申请表
        WxTabReturnOrder wxTabReturnOrder = new WxTabReturnOrder();
        wxTabReturnOrder.setReturnMoney(wxTabOrder.getPayMoney());
        if(!StringUtils.isEmpty(orderId)) wxTabReturnOrder.setIsReturnFreight(wxTabOrderItem.getIsReturn().charAt(0));
        wxTabReturnOrder.setLinkman(wxTabOrder.getUsername());
        wxTabReturnOrder.setLinkmanMobile(wxTabOrder.getReceiverMobile());
        //获取用户信息
        String phone = WebTools.getSession("username");
        boolean flag1 = false;
        if(!StringUtils.isEmpty(phone)){
            List<User> users = userService.findByPhone(phone);
            if(users.size()>0){
                wxTabReturnOrder.setUserId(users.get(0).getId());
                wxTabReturnOrder.setUserAccount(users.get(0).getUsername());
            }else{
                flag1=true;
            }
        }else{
            flag1=true;
        }
        if(flag1){
            wxTabReturnOrder.setUserId(-1);
            wxTabReturnOrder.setUserAccount("no");
        }

        //TODO admin_id lxq 当前还不知道从哪获取
        wxTabReturnOrder.setAdminId(-1);
        wxTabReturnOrder.setReturnCause(wxTabReturnCause.getId());
        wxTabReturnOrder.setOrderId(orderId);
        if(StringUtils.isEmpty(evidence)) evidence = "无凭证图片";
        wxTabReturnOrder.setEvidence(evidence);
        wxTabReturnOrder.setDescription(description);
        if(!StringUtils.isEmpty(orderId)) wxTabReturnOrder.setType(type.charAt(0));
        if(flag) {
            flag = wxTabReturnOrderService.add(wxTabReturnOrder);
        }

        //退货退款申请明细表
        WxTabReturnOrderItem wxTabReturnOrderItem = new WxTabReturnOrderItem();
        wxTabReturnOrderItem.setTitle(wxTabOrderItem.getName());
        wxTabReturnOrderItem.setPrice(wxTabOrderItem.getPrice());
        wxTabReturnOrderItem.setNum(wxTabOrderItem.getNum());
        wxTabReturnOrderItem.setImage(wxTabOrderItem.getImage());
        wxTabReturnOrderItem.setMoney(wxTabOrder.getTotalMoney());
        wxTabReturnOrderItem.setPayMoney(wxTabOrder.getPayMoney());
        wxTabReturnOrderItem.setWeight(wxTabOrderItem.getWeight());
        wxTabReturnOrderItem.setReturnOrderId(wxTabOrder.getId());
        if(wxTabOrderItem.getCategoryId1() != null && wxTabOrderItem.getCategoryId1()!= 0){
            wxTabReturnOrderItem.setCategoryId(wxTabOrderItem.getCategoryId1());
        }else if(wxTabOrderItem.getCategoryId2() != null && wxTabOrderItem.getCategoryId2()!= 0){
            wxTabReturnOrderItem.setCategoryId(wxTabOrderItem.getCategoryId2());
        }else if(wxTabOrderItem.getCategoryId3() != null && wxTabOrderItem.getCategoryId3()!= 0){
            wxTabReturnOrderItem.setCategoryId(wxTabOrderItem.getCategoryId3());
        }
        wxTabReturnOrderItem.setSpuId(wxTabOrderItem.getSpuId());
        wxTabReturnOrderItem.setSkuId(wxTabOrderItem.getSkuId());
        wxTabReturnOrderItem.setOrderId(orderId);
        wxTabReturnOrderItem.setOrderItemId(orderItemid);
        if(flag) {
            flag = wxTabReturnOrderItemService.add(wxTabReturnOrderItem);
        }
        return flag;
    }
}