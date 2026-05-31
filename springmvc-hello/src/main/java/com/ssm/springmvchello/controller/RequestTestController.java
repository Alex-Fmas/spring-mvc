package com.ssm.springmvchello.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestTestController {
    /**
     * 请求参数：username=zhangsan&password=12345&cellphone=12345456&agreement=on
     * 命名需要与参数名一致
     * @return "handle01"
     */
    @RequestMapping("/handle01")
    public String handle01(String username,
                           String password,
                           String cellphone,
                           boolean agreement) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("cellphone:" + cellphone);
        System.out.println("agreement:" + agreement);
        return "handle01";
    }
    /**
     * RequestParam 用来映射请求参数
     * defaultValue 默认值
     * required 是否必须
     * 命名不一致
     * @return "handle02"
     */
    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam(value = "password", defaultValue = "123456") String pwd,
                           @RequestParam("cellphone") String phone,
                           @RequestParam(value = "agreement", required = false) boolean ok) {
        System.out.println("username:" + name);
        System.out.println("password:" + pwd);
        System.out.println("cellphone:" + phone);
        System.out.println("agreement:" + ok);
        return "handle02";
    }


}
