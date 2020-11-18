package cn.zhougq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author zhouganqing
 * @create 2020- 07- 12- 19:53
 */

@Aspect
public class LoggerAop {
    private static final Logger log= LoggerFactory.getLogger(LoggerAop.class);

    /*
    * 定义公用切入点
    * 使用* cn.zhougq.dao.impl.*(..)会报错？？？？？
    * */
    @Pointcut("execution(public * saveUser(..))")
    public void pointcut(){}

    //代表前置增强的方法;
    @Before("pointcut()")
    public void before(JoinPoint jp)
    {
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法.方法入参:"+ Arrays.toString(jp.getArgs()));
    }

    //代表后置增强的方法;public * saveUser(..)
    @AfterReturning(pointcut = "execution(public * saveUser(..))",
    returning = "result")
    public void afterReturning(JoinPoint jp,Object result)
    {
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法.方法返回值:"+ result);
    }

    //代表异常增强的方法
    @AfterThrowing(pointcut = "pointcut()",throwing = "e")
    public void errorThrow(JoinPoint jp,RuntimeException e)
    {
        log.error("调用"+jp.getTarget()+"的方法"+jp.getSignature().getName()+"出现异常:"+ e);
    }

    //代表最终增强的方法；在异常之前执行了？？？？？
    @After("pointcut()")
    public void after(JoinPoint jp)
    {
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法最后执行；用于GC垃圾回收");
    }

}
