package com.hk.dao;

import com.hk.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//TODO 注解 会报错
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")*/
public class UserDaoImplTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    

}