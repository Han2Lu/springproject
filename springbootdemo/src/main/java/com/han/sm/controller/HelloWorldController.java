package com.han.sm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className:HelloWorldController
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-09 13:58
 */
@RestController    //默认该类的所有方法的返回值都是json对象
public class HelloWorldController {

    /**
     * 打印方法
     * @return
     */
    @RequestMapping("/hello")
    public Object print(){
        return "hello springboot!!";
    }
}
