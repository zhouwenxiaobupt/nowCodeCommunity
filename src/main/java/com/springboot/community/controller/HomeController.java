package com.springboot.community.controller;

import com.springboot.community.entity.DiscussPost;
import com.springboot.community.entity.Page;
import com.springboot.community.entity.User;
import com.springboot.community.service.DisscussPostService;
import com.springboot.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouwenxiao
 * @create 2021-01-01 22:16
 */
@Controller
public class HomeController {
    @Autowired
    private DisscussPostService disscussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        // 方法调用之前，springmvc 会自动实例化 model,  并将 page  注入model之中
        //所以在 thymeleaf  中 就可以直接访问page 对象中的数据
        page.setRows(disscussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = disscussPostService.findDiscussPosts(0, page.get0ffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);

            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}
