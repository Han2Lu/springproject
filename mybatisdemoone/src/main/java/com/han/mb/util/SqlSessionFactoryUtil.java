package com.han.mb.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * className:SqlSessionFactoryUtil
 * discriptoin:创建SqlSession的工具类
 * author:韩愈
 * createTime:2018-11-03 16:35
 */
public class SqlSessionFactoryUtil {
    //私有的空构造，保证其他地方不能实例化对象
    private SqlSessionFactoryUtil(){}

    //私有的静态的属性，保证只有一个，并且其他地方不能调用
    private static SqlSessionFactory sqlSessionFactory;

    //使用静态块，保证只执行一次
    static {
        try {
            //使用mybatis提供的Resources类读取主配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactory
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //提供一个可以对外调用的方法，返回SqlSession
    public static SqlSession creatSqlSession(){
        //使用上面的单例模式产生的工厂类，创建SqlSession
        return sqlSessionFactory.openSession();
    }
}
