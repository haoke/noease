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
     * sql: select * from user where username like ?  /  like concat('%'+?+'%')
     *
     * @param user
     * @return user
     */
    public List findUserByNameAndIdIn(User user);

    /**
     *find user by name
     * sql: select * from user where username like %%
     * @param user
     * @return user
     */
    public List findUserByName2(User user);

    /**
     *
     * @param user
     * @return list
     */
    public List findUserByNameUseBind(User user);


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


    public void deleteUser(Integer id);

    public UserQueryVo findUserByNameFromUserQueryVo(UserQueryVo userQueryVo);

}
