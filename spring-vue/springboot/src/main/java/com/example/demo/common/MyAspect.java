package com.example.demo.common;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

@Order(1)
@Component
@Aspect
public class MyAspect {

    public static long beforetime;
    public static long aftertime;

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void pointcut(){}//提取切点表达式

    //前置增强
    @Before("pointcut()")
    public void before(JoinPoint jp) {
        Object obj = jp.getTarget();
        Object[] args = jp.getArgs();
        String methodName = jp.getSignature().getName();
        beforetime = System.currentTimeMillis();
        System.out.println(obj.getClass().getName()+"：方法名称："+methodName+" 准备执行 开始时间："+new Date());
//        System.out.println(obj.getClass().getName()+"：Parameters of the "+methodName+" method： ["+args[0]+","+args[1]+"]");
    }
    //返回增强
//    @AfterReturning(value="execution(* cn.itcast.service.impl.*.*(..))",returning="result")
//    public void afterReturning(JoinPoint jp,Object result) {
//        Object obj = jp.getTarget();
//        String methodName = jp.getSignature().getName();
//        System.out.println(obj.getClass().getName()+"：Result of the "+methodName+" method："+result);
//    }
    //异常增强
//    @AfterThrowing(value="execution(* cn.itcast.service.impl.*.*(..))",throwing="exception")
//    public void afterThrowing(JoinPoint jp, NullPointerException exception) {
//        Object obj = jp.getTarget();
//        String methodName = jp.getSignature().getName();
//        System.out.println(obj.getClass().getName()+"：Exception of the method "+methodName+": "+exception.getMessage());
//    }
    //后置增强
    @After("pointcut()")
    public void after(JoinPoint jp) {
        Object obj = jp.getTarget();
        String methodName = jp.getSignature().getName();
        aftertime = System.currentTimeMillis();
        System.out.println(obj.getClass().getName()+"：方法名称："+methodName+" 结束了 结束时间："+new Date());
        System.out.println(methodName+" 方法总执行耗时"+(aftertime-beforetime)+"毫秒");
    }

    //环绕增强
//    public class AroundLog implements MethodInterceptor {
//        public Object invoke(MethodInvocation arg0) throws Throwable {
//            Object target = arg0.getThis(); //获取被代理的对象
//            Method method = arg0.getMethod(); //获取被代理的方法
//            Object[] args = arg0.getArguments(); //获取方法参数
//            System.out.println("环绕---调用" + target + "的 " + method.getName() + "方法。方法入参：" + Arrays.toString(args));
//            try {
//                Object result = arg0.proceed();//调用目标方法，获取返回值
//                System.out.println("环绕---调用" + target + "的 " + method.getName() + "方法。"
//                        + "方法返回值：" + result);
//                return result;
//            } catch (Throwable e) {
//                System.out.println(method.getName() + " 方法发生异常" + e);
//                throw e;
//            }
//        }
//
//    }

}
