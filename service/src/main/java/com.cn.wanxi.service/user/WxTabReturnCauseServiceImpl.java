package com.cn.wanxi.service.user;

import com.cn.wanxi.dao.user.WxTabReturnCauseDao;
import com.cn.wanxi.model.user.WxTabReturnCause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author lxq
 * @date 2019年11月21日15:58:52
 */
@Service
public class WxTabReturnCauseServiceImpl implements WxTabReturnCauseService {
    @Autowired
    private WxTabReturnCauseDao wxTabReturnCauseDao;

    @Override
    public boolean add(WxTabReturnCause wxTabReturnCause) {
        wxTabReturnCause.setStatus('0');
        Integer num = wxTabReturnCauseDao.insert(wxTabReturnCause);
        if(num == 1){
            return true;
        }
        return false;
    }
}