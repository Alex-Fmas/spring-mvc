package com.ssm.springmvchello.controller;

import com.ssm.springmvchello.bean.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
     * 无论请求参数带到了 请求体中还是 urL？后面，他们都是请求参数。都可以直接用@RequestParam或者同一个变量名获取到
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

    /**
     * 如果目标方法参数是一个 pojo;SpringMVC 会自动把请求参数 和 pojo 属性进行匹配；
     * 效果：
     * 1、p0jo的所有属性值都是来自于请求参数
     *2、如果请求参数没带，封装为nuLl；
     * @param person
     * dreturn
     */
    @RequestMapping("/handle03")
    public String handle03(Person person) {
        System.out.println(person);
        return "handle03";
    }

    /**
     * CRequestHeader 获取请求头信息
     * @param host
     * @param userAgent
     * @return "handle04"
     */
    @RequestMapping("/handle04")
    public String handle04(@RequestHeader(value = "host") String host,
                           @RequestHeader(value = "user-agent") String userAgent) {
        System.out.println("host:" + host);
        System.out.println("userAgent:" + userAgent);
        return "handle04:host " + host;
    }

    /**
     * @CookieValue 获取cookie值
     * @param haha
     * @return "ok: cookie: " + haha;
     */
    @RequestMapping("/handle05")
    public String handle05(@CookieValue("haha") String haha) {
        return "ok: cookie: " + haha;
    }

    /**
    * @CookieValue：获取cookie值
    * @param person
    * @return "ok: " + person;
    */
    @RequestMapping("/handle06")
    public String handle06(Person person) {
        System.out.println(person);
        return "ok: " + person;
    }

    /**
     * @RequestBody：获取请求体json数据，自动转为person对象
     * ★pRequestBody Person person
     * 拿到请求体中的jsop字符串
     * 把json字符串转为person对象
     *测试接受json数据
     * 1、发出：
     * @param person
     * @return
     */
    @RequestMapping("/handle07")
    public String handle07(@RequestBody Person person) {
        System.out.println(person);
        return "ok: " + person;
    }

    /**
     * 文件上传；
     * 1、@RequestParam 取出文件项，封装为MultipartFile，就可以掌到文件内容
     * Cparam person
     * dreturn
     */
    @RequestMapping("/handle08")
    public String handle08(Person person,
                           @RequestParam("headerImg") MultipartFile headerImgFile,
                           @RequestParam("lifeImg") MultipartFile[] lifeImgFile) throws IOException {
        // 处理头像
        String originalFilename1 = headerImgFile.getOriginalFilename();
        long size = headerImgFile.getSize();
        System.out.println("originalFilename:" + originalFilename1);
        // 保存到/Users/fmas
        headerImgFile.transferTo(new File("/Users/fmas/Photo/" + originalFilename1));
        // 处理生活照
        if (lifeImgFile != null && lifeImgFile.length > 0) {
            for (MultipartFile multipartFile : lifeImgFile) {
                String originalFilename2 = multipartFile.getOriginalFilename();
                long size2 = multipartFile.getSize();
                System.out.println("originalFilename:" + originalFilename2);
                multipartFile.transferTo(new File("/Users/fmas/Photo/" + originalFilename2));
            }
        }
        return "handle08";
    }


}
