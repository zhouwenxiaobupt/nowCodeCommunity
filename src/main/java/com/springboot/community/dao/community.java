package com.springboot.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author zhouwenxiao
 * @create 2020-12-31 17:55
 */
@Repository("Hibernate")
public class community implements testDao {
    @Override
    public String select() {
        return "Hello I am Hibernate";
    }
}
