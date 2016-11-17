package com.tywy.data.sc.dao;

import com.tywy.data.sc.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}