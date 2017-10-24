package com.sys.persistence.dao;

import com.sys.persistence.domain.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByOpenId(String openId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}