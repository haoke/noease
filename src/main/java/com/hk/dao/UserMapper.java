package com.hk.dao;

import com.hk.pojo.User;
import com.hk.pojo.UserQueryVo;

import java.util.List;

public interface UserMapper {
    public abstract User findUserById(Integer id) throws  Exception;
    public abstract List<User> findUserByName1(String username) throws Exception;
    public abstract List<User> findUserByName2(String username) throws Exception;
    public abstract List<User> findUserByName3(UserQueryVo user) throws Exception;

    public abstract Integer insertUser(User user) throws Exception;
    public abstract void updateUser(User user)  throws Exception;
    public abstract void deleteUserById(Integer id) throws Exception;
}
