package com.sys.service;

import com.sys.persistence.domain.User;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param user the user
     */
    void addUser(User user);

    /**
     * 根据用户id获取用户
     *
     * @param userId the user id
     * @return user by id
     */
    User getUserById(int userId);

    /**
     * Gets user by open id.
     *
     * @param openId the open id
     * @return the user by open id
     */
    User getUserByOpenId(String openId);

}
