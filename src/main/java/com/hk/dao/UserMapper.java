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

    /**
     * find user by  name
     * sql: select * from user where username like ?
     * @param user
     * @return user
     */
    public List findUserByName1(User user);
}
