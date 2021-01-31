package com.springboot.community;

import com.springboot.community.dao.UserMapper;
import com.springboot.community.dao.testDao;
import com.springboot.community.entity.User;
import com.springboot.community.service.communityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SocketHandler;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext() {
        System.out.println(applicationContext);
        testDao testdao = applicationContext.getBean(testDao.class);
        System.out.println(testdao.select());
        testdao = applicationContext.getBean("Hibernate", testDao.class);
        System.out.println(testdao.select());
    }

    @Test
    public void testBeanManagement() {
        communityService communityservice = applicationContext.getBean(communityService.class);
        System.out.println(communityservice);
        communityservice = applicationContext.getBean(communityService.class);
        System.out.println(communityservice);
    }

    @Test
    public void testBeanConfig() {
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    /*
    下面演示依赖注入的方法
    在这里把testDao 直接注入了testdao 这个属性
     */
    @Autowired
    private testDao testdao;
    @Autowired
    private communityService communityservice;
    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Test
    /*
    测试依赖注入
     */
    public void testDI() {
        System.out.println(testdao);
        System.out.println(communityservice);
        System.out.println(simpleDateFormat);
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);
    }
}
