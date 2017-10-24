package com.sys.service.Impl;

import com.sys.persistence.dao.UserDao;
import com.sys.persistence.domain.User;
import com.sys.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByOpenId(String openId) {
        return userDao.selectByOpenId(openId);
    }


}
