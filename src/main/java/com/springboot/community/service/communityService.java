package com.springboot.community.service;

import com.springboot.community.dao.testDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.context.SpringContextUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhouwenxiao
 * @create 2020-12-31 18:19
 */
@Service
//  产生多例模式 多次创建
//  @Scope("prototype")
public class communityService {
    @Autowired
    private testDao testdao;

    public communityService() {
        System.out.println("实例化communityService");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化communityServices方法");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁该方法");
    }

    public String find() {
        return testdao.select();
    }
}
