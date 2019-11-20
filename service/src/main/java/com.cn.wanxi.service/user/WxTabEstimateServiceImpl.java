package com.cn.wanxi.service.user;

import com.cn.wanxi.dao.user.WxTabEstimateDao;
import com.cn.wanxi.model.user.WxTabEstimate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxq
 * @date 2019/11/20 9:38
 */
@Service
public class WxTabEstimateServiceImpl implements WxTabEstimateService {
    @Autowired
    private WxTabEstimateDao wxTabEstimateDao;

    @Override
    public List<WxTabEstimate> find(WxTabEstimate wxTabEstimate) {
        return wxTabEstimateDao.find(wxTabEstimate);
    }

    @Override
    public boolean add(WxTabEstimate wxTabEstimate) {
        Integer num = wxTabEstimateDao.insert(wxTabEstimate);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(WxTabEstimate wxTabEstimate) {
        Integer num = wxTabEstimateDao.update(wxTabEstimate);
        if(num == 1){
            return true;
        }
        return false;
    }

}
