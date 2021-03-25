package com.youyuan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 类名称：MyAspect <br>
 * 类描述： 自定义切面类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/7 21:18<br>
 */
@Component
@Aspect
public class MyAspect {

    @Before("execution(* com.youyuan.aop.CalcServiceImpl.*(..))")
    public void beforeNotify() {
        System.out.println("@Before前置通知");
    }

    @After("execution(* com.youyuan.aop.CalcServiceImpl.*(..))")
    public void afterNotify() {
        System.out.println("@After后置通知");
    }

    @AfterReturning("execution(* com.youyuan.aop.CalcServiceImpl.*(..))")
    public void afterReturningNotify() {
        System.out.println("@AfterReturning返回通知");
    }

    @AfterThrowing("execution(* com.youyuan.aop.CalcServiceImpl.*(..))")
    public void afterThrowingNotify() {
        System.out.println("@AfterThrowing异常通知");
    }

    @Around("execution(* com.youyuan.aop.CalcServiceImpl.*(..))")
    public Object aroundNotify(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around环绕通知目标方法前");
        Object proceed = joinPoint.proceed();
        System.out.println("@Around环绕通知目标方法后");
        return proceed;
    }
}
