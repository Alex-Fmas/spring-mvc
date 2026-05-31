package com.ssm.springmvchello.bean;


import lombok.Data;

@Data
public class Person {
    private String username;
    private String password;
    private String cellphone;
    private String agreement;
    private Assress address;
    private String sex;
    private String[] hobby;
    private String grade;
}
class Assress {
    private String province;
    private String city;
    private String area;
}
