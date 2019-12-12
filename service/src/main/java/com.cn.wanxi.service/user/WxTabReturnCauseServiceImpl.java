package com.cn.wanxi.service.user;

import com.auth0.jwt.JWT;
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

import javax.servlet.http.HttpServletRequest;
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
    public boolean addAssociated(HttpServletRequest request, String orderId, String orderItemid, String evidence, String description, String returnCause, String type) {
        //退货退款原因表
        WxTabReturnCause wxTabReturnCause = new WxTabReturnCause();
        String seq = wxTabReturnCauseDao.findMaxSeq();
        if(StringUtils.isEmpty(seq)){
            wxTabReturnCause.setSeq(1);
        }else{
            wxTabReturnCause.setSeq(Integer.valueOf(seq)+1);
        }
        wxTabReturnCause.setCause(returnCause);
        boolean flag=add(wxTabReturnCause);
        if (flag) wxTabReturnCause=find(wxTabReturnCause);
        if(StringUtils.isEmpty(orderId)) return false;
        WxTabOrder wxTabOrder =wxTabOrderService.selectByIds(orderId.split(",")).get(0);
        if(wxTabOrder==null){
            return false;
        }

        //退货退款申请表
        WxTabReturnOrder wxTabReturnOrder = new WxTabReturnOrder();
        wxTabReturnOrder.setReturnMoney(wxTabOrder.getPayMoney());
        if(!StringUtils.isEmpty(orderId)){
            if(!StringUtils.isEmpty(wxTabReturnOrder.getIsReturnFreight())){
                wxTabReturnOrder.setIsReturnFreight(wxTabReturnOrder.getIsReturnFreight());
            }else{
                wxTabReturnOrder.setIsReturnFreight('0');
            }
        }
        wxTabReturnOrder.setLinkman(wxTabOrder.getUsername());
        wxTabReturnOrder.setLinkmanMobile(wxTabOrder.getReceiverMobile());
        //获取用户信息
//        String phone = WebTools.getSession("username");
        String phone = JWT.decode(request.getHeader("token")).getAudience().get(0);
        boolean flag1 = false;
        wxTabReturnOrder.setUserAccount(phone);
        if(!StringUtils.isEmpty(phone)){
            List<User> users = userService.findByPhone(phone);
            if(users.size()>0){
                wxTabReturnOrder.setUserId(users.get(0).getId());
//                wxTabReturnOrder.setUserAccount(users.get(0).getUsername());
            }else{
                flag1=true;
            }
        }else{
            flag1=true;
        }
        if(flag1){
            wxTabReturnOrder.setUserId(-1);
//            wxTabReturnOrder.setUserAccount("no");
        }

        //admin_id lxq 用户操作退货退款申请，目前随意存一个管理员id,之后管理员审判通过后保存管理员id
        wxTabReturnOrder.setAdminId(-1);
        wxTabReturnOrder.setReturnCause(wxTabReturnCause.getId());
        wxTabReturnOrder.setOrderId(orderId);
        if(StringUtils.isEmpty(evidence)) evidence = "-1";//无凭证图片
        wxTabReturnOrder.setEvidence(evidence);
        wxTabReturnOrder.setDescription(description);
        if(!StringUtils.isEmpty(orderId)) wxTabReturnOrder.setType(type.charAt(0));
        if(flag) {
            flag = wxTabReturnOrderService.add(wxTabReturnOrder);
        }

        String[] orderItemIds = orderItemid.split(",");
        for(String findOrderItemId : orderItemIds){
            WxTabOrderItem wxTabOrderItem =wxTabOrderItemService.get(findOrderItemId);
            if(wxTabOrderItem==null){
                return false;
            }
            //更改订单是否退货状态
            wxTabOrderItem.setIsReturn("1");
            wxTabOrderItemService.update(wxTabOrderItem);

            //退货退款申请明细表
            WxTabReturnOrderItem wxTabReturnOrderItem = new WxTabReturnOrderItem();
            if(StringUtils.isEmpty(wxTabOrderItem.getName())){
                wxTabReturnOrderItem.setTitle("无标题");
            }else{
                wxTabReturnOrderItem.setTitle(wxTabOrderItem.getName());
            }
            wxTabReturnOrderItem.setPrice(wxTabOrderItem.getPrice());
            wxTabReturnOrderItem.setNum(wxTabOrderItem.getNum());
            if(StringUtils.isEmpty(wxTabOrderItem.getImage())){
                wxTabReturnOrderItem.setImage("无图片");
            }else{
                wxTabReturnOrderItem.setImage(wxTabOrderItem.getImage());
            }
            wxTabReturnOrderItem.setMoney(wxTabOrderItem.getMoney());
            wxTabReturnOrderItem.setPayMoney(wxTabOrderItem.getPayMoney());
            wxTabReturnOrderItem.setWeight(wxTabOrderItem.getWeight());
            wxTabReturnOrderItem.setReturnOrderId(wxTabOrder.getId());
            if(wxTabOrderItem.getCategoryId1() != null && wxTabOrderItem.getCategoryId1()!= 0){
                wxTabReturnOrderItem.setCategoryId(wxTabOrderItem.getCategoryId1());
            }else if(wxTabOrderItem.getCategoryId2() != null && wxTabOrderItem.getCategoryId2()!= 0){
                wxTabReturnOrderItem.setCategoryId(wxTabOrderItem.getCategoryId2());
            }else if(wxTabOrderItem.getCategoryId3() != null && wxTabOrderItem.getCategoryId3()!= 0){
                wxTabReturnOrderItem.setCategoryId(wxTabOrderItem.getCategoryId3());
            }else{
                wxTabReturnOrderItem.setCategoryId(-1);
            }
            if(StringUtils.isEmpty(wxTabOrderItem.getSpuId())){
                wxTabReturnOrderItem.setSpuId("-1");
            }else{
                wxTabReturnOrderItem.setSpuId(wxTabOrderItem.getSpuId());
            }
            if(StringUtils.isEmpty(wxTabOrderItem.getSkuId())){
                wxTabReturnOrderItem.setSkuId("-1");
            }else{
                wxTabReturnOrderItem.setSkuId(wxTabOrderItem.getSkuId());
            }
            wxTabReturnOrderItem.setOrderId(orderId);
            wxTabReturnOrderItem.setOrderItemId(findOrderItemId);
            if(flag) {
                flag = wxTabReturnOrderItemService.add(wxTabReturnOrderItem);
            }
        }
        return flag;
    }
}