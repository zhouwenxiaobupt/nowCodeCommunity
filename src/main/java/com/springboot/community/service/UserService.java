package com.springboot.community.service;

import com.springboot.community.dao.UserMapper;
import com.springboot.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * @author zhouwenxiao
 * @create 2021-01-01 22:10
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
