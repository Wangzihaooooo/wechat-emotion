package com.sys.service;

import com.sys.persistence.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    User getUserById(int userId);

}
