package com.cxm.producer.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *切面配置类
 */
@Aspect
@Component
public class weblogAspect {
    private static final Logger logger = LoggerFactory.getLogger(weblogAspect.class);

    @Pointcut("execution(* com.cxm.producer.controller..*.*(..))")
    public void  webLog(){

    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
     logger.info("用户发起请求。。。");
    }

    @AfterReturning(pointcut = "webLog()",returning = "o")
    public void doAfterReturning(Object o){
        logger.info("返回值为："+o);
        logger.info("请求结束。。。");
    }

    @After("webLog()")
    public void doAfter(){
     logger.info("方法最后执行。。。");
    }

    @AfterThrowing(pointcut ="webLog()",throwing = "e")
    public void doThrows(JoinPoint joinPoint,Exception e){
     logger.info("方法异常执行。。。");
    }
}
