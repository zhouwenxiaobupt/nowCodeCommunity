package com.springboot.community;

import com.springboot.community.dao.DiscussPostMapper;
import com.springboot.community.dao.UserMapper;
import com.springboot.community.entity.DiscussPost;
import com.springboot.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

/**
 * @author zhouwenxiao
 * @create 2021-01-01 2:46
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);
        user = userMapper.selectByName("liubei");
        System.out.println(user);
        user = userMapper.selectByEmail("nowcode101@sina.com");
        System.out.println(user);

    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("yangmi");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("11258325@qq.com");
        user.setHeaderUrl("http//www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);
        rows = userMapper.updateHeader(150, "http//www.nowcoder.com/102.png");
        System.out.println(rows);
        rows = userMapper.updatePassword(150, "122334455");
        System.out.println(rows);

    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }
        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);

    }
}
