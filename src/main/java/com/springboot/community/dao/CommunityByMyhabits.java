package com.springboot.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author zhouwenxiao
 * @create 2020-12-31 18:08
 */
@Repository
@Primary
public class CommunityByMyhabits implements testDao {

    @Override
    public String select() {
        return "I am myhabits";
    }
}
