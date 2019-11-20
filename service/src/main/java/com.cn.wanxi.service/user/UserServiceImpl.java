package com.cn.wanxi.service.user;

import com.cn.wanxi.dao.user.UserDao;
import com.cn.wanxi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-20 12:47
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserByID(Integer id) {
        return userDao.getUserByID(id);
    }
}