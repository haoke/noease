package com.hk.dao;

import com.hk.pojo.User;
import com.hk.pojo.UserQueryVo;

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

    /**
     *find user by name
     * sql: select * from user where username like %%
     * @param user
     * @return user
     */
    public List findUserByName2(User user);

    /**
     * insert user
     * sql: insert user
     * @param user
     * @return void
     */
    public void insertUser(User user);

    /**
     * update user
     * sql: update user set username=#{username} wehre id=#{id}
     * @param user
     * @return void
     */
    public void updateUser(User user);


    public UserQueryVo findUserByNameFromUserQueryVo(UserQueryVo userQueryVo);

}
