package com.han.aop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * className:LogUtil
 * discriptoin:通知类 是切面（日志记录功能）的具体实现类，放置切面代码的地方
 * author:韩愈
 * createTime:2018-11-08 14:07
 */
@Component  //三个分层之外，用该注解
@Aspect    //通知类的注解
public class LogUtilA {

    /**
     * 配置切入点
     */
    @Pointcut(value = "execution(void add(..)) || execution(void update(..)) || execution(void delete(..))")
    public void pointA(){}

    /**
     * 记录日志记录功能(后置通知)
     */
    //@AfterReturning(value = "pointA()")
    public void saveLog(){
        System.out.println("模拟日志记录。。。");
    }

    /**
     * 前置通知
     * @param joinPoint  连接点
     */
    //@Before(value = "pointA()")
    public void  beforeAdvice(JoinPoint joinPoint){
        //获取连接点方法名称
        String name = joinPoint.getSignature().getName();
        System.out.println("执行业务方法"+name+"之前执行的操作。。。。");
    }

    /**
     * 异常通知
     * @param joinPoint 连接点
     * @param ex  异常
     */
    @AfterThrowing(value = "pointA()",throwing = "ex")
    public void exceptionAdvice(JoinPoint joinPoint,Exception ex){
        //获取连接点方法名称
        String name = joinPoint.getSignature().getName();
        System.out.println("执行业务方法"+name+"的时候，发生名称为："+ex.getClass().getName()
        +"的异常，异常描述为："+ex.getMessage());
    }

    /**
     * 最终通知
     */
    //@After(value = "pointA()")
    public void finalAdvice(){
        System.out.println("无论连接点方法执行过程中有没有异常，都会执行。。。");
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "pointA()")
    public Object arroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println(System.currentTimeMillis()+"在业务执行方法之前操作");
        Object o=null;
        try {
            //调用业务方法
             o = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+"在业务执行方法之后操作");
        return o;
    }
}
