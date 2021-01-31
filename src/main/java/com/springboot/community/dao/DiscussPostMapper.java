package com.springboot.community.dao;

import com.springboot.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhouwenxiao
 * @create 2021-01-01 3:16
 */
@Repository
@Mapper
public interface DiscussPostMapper {
    //这里涉及到了动态sql的条件
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@param 注解用于给参数取别名，
    // 如果只有一个参数，并且在<if> 中使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);

}
