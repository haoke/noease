package com.hk.dao;

import com.hk.pojo.User;
import com.hk.pojo.UserCustom;
import com.hk.pojo.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        InputStream inputstream = Resources.getResourceAsStream("SqlMapConfig.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void findUserByName1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUserByName1("hhk%");
        users.stream().forEach(System.out::println);
    }

    @Test
    public void findUserByName2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUserByName2("hhk");
        users.stream().forEach(System.out::println);
    }

    @Test
    public void findUserByName3() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom =new UserCustom();

        userCustom.setUsername("hhk");
        userQueryVo.setUserCustom(userCustom);
        List<Integer> ids = new ArrayList<Integer> ();
        ids.add(7);
        ids.add(11);
        ids.add(12);
        userQueryVo.setIds(ids);

        List<User> users = mapper.findUserByName3(userQueryVo);
        users.stream().forEach(System.out::println);
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("Pallor");
        user.setPassword("123123");
        user.setBirthday(new Date());
        mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(46);
        user.setUsername("Wolly");
        user.setPassword("0000000000000000000");
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUserById(41);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testCache() throws Exception {

        User user;
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();


        UserMapper  mapper1 = sqlSession1.getMapper(UserMapper.class);
         user = mapper1.findUserById(2);
        sqlSession1.close();

        UserMapper   mapper2 = sqlSession2.getMapper(UserMapper.class);
        user = mapper2.findUserById(2);
        sqlSession2.close();
        System.out.println(user);
    }
}