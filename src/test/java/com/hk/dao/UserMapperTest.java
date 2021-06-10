package com.hk.dao;

import com.hk.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    UserMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream inputstream = Resources.getResourceAsStream("SqlMapConfig.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

    }

    @Test
    public void testFindUserById() throws Exception{
         sqlSession = sqlSessionFactory.openSession();
         mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(4);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName1() throws Exception{
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);

        User user =  new User();
        user.setUsername("%王%");
        List<User> userList = mapper.findUserByName1(user);  //TODO 必须使用范型  否则会报错

        for(User user1 : userList){
            System.out.println(user1);
        }
    }
}