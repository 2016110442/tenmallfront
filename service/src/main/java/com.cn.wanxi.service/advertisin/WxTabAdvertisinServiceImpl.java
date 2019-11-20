package com.cn.wanxi.service.advertisin;

import com.cn.wanxi.dao.advertisin.WxTabAdvertisinMapper;
import com.cn.wanxi.model.advertisin.WxTabAdvertisin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019/11/20 14:29
 */
@Service
public class WxTabAdvertisinServiceImpl implements WxTabAdvertisinService {

    @Autowired
    private WxTabAdvertisinMapper wxTabAdvertisinMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return wxTabAdvertisinMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WxTabAdvertisin record) {
        return wxTabAdvertisinMapper.insert(record);
    }

    @Override
    public int insertSelective(WxTabAdvertisin record) {
        return wxTabAdvertisinMapper.insert(record);
    }

    @Override
    public WxTabAdvertisin selectByPrimaryKey(Integer id) {
        return wxTabAdvertisinMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WxTabAdvertisin record) {
        return wxTabAdvertisinMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WxTabAdvertisin record) {
        return wxTabAdvertisinMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<WxTabAdvertisin> selectByPosition(String position) {
        return wxTabAdvertisinMapper.selectByPosition(position);
    }
}
