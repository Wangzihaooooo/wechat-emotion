package com.sys.service.Impl;

import com.sys.persistence.dao.UserDao;
import com.sys.persistence.domain.User;
import com.sys.service.UserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

//@Service("userService")
@Repository
public class UserServiceImpl implements UserService{
    @Resource
    UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }

    @Override
    public User getUserById(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.selectAll();
    }
}
