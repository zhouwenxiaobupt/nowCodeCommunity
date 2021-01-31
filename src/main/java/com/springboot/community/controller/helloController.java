package com.springboot.community.controller;

import com.springboot.community.service.communityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zhouwenxiao
 * @create 2020-12-31 0:33
 */
@Controller
@RequestMapping("/demo")
public class helloController {
    @Autowired
    private communityService communityService;

    @RequestMapping("/hello")
    @ResponseBody
    public String saveHello() {
        return "hello Zhouwenxiao";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return communityService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);
        }
        System.out.println(request.getParameter("code"));
        //返回响应数据
        //返回类型
        response.setContentType("text/html; charset = utf-8");
        try (PrintWriter writer = response.getWriter()) {

            writer.write("<p> 牛客网 </p>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //利用spring 提供的简单方法来处理请求 1，get( 默认的请求是get)
    //student?current=1&limit=20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@RequestParam(name = "current", required = false, defaultValue = "1") int current,
                             @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {

        System.out.println(current);
        System.out.println(limit);
        return " Go! Students";
    }

    //student/123
    @RequestMapping(path = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@PathVariable("id") int id) {
        System.out.println(id);
        return "I am the new students";
    }

    // post 请求 ，一般浏览器向服务器提交数据
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "WOW You success!";
    }

    // 响应动态的html数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    //此处不加responseBody  因为默认返回就是html
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 20);
        mav.setViewName("/demo/view.html");
        return mav;
    }

    //第二种响应数据
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "maojian");
        model.addAttribute("age", 21);
        return "/demo/view.html";
    }

    //响应json 数据  （一般在异步请求之中）
    //比如百度输入的自动联想功能 类似于ajax
    //java 对象  ->通过 json  -> js 然后再转成js对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    //自动把map 转为json对象给浏览器
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "毛健");
        emp.put("age", 30);
        emp.put("salary", 80000.00);

        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "毛健");
        emp.put("age", 30);
        emp.put("salary", 80000.00);
        list.add(emp);
        emp = new HashMap<>();
        emp.put("name", "李倩");
        emp.put("age", 20);
        emp.put("salary", 60000.00);
        list.add(emp);
        emp = new HashMap<>();
        emp.put("name", "周文校");
        emp.put("age", 21);
        emp.put("salary", 70000.00);
        list.add(emp);
        return list;
    }
}
