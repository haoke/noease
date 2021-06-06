package com.hk.dao;

import com.hk.pojo.User;

import java.util.List;

/**
 * @author haoke
 */
public interface UserMapper {
    /**
     * find user by id
     * @param id int
     * @return user
     */
    public User findUserById(int id);
}
