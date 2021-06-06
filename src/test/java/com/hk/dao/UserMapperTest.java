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

public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        InputStream inputstream = Resources.getResourceAsStream("SqlMapConfig.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
    }

    @Test
    public void testFindUserById() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(4);
        System.out.println(user);
    }


}