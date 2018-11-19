package com.han.aop.test;

import com.han.aop.service.DeptServiceImpl;
import com.han.aop.service.GoodsServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * className:AopTest
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-08 14:28
 */
public class GoodsTest {

    public static void main(String[] args) {
        //使用 spring提供的配置文件加载类，加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("springaop-annotation-config.xml");
        //使用BeanFactory接口中提供的getBean方法获取对象
        GoodsServiceImpl  goodsService= (GoodsServiceImpl) applicationContext.getBean("goodsServiceImpl");
        goodsService.add();
        //goodsService.update();
    }
}
