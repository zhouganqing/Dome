package cn.zhougq.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.*;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author zhouganqing
 * @create 2020- 07- 20- 15:29
 *
 * DelegatingIntroductionInterceptor    引界增强，可以用于监控性能,比如执行时间等
 * MethodBeforeAdvice       前置增强
 * AfterReturningAdvice     后置增强
 * ThrowsAdvice             异常增强
 * MethodInterceptor        环绕增强
 *
 */

public class AopLogger implements MethodBeforeAdvice, AfterReturningAdvice,ThrowsAdvice,MethodInterceptor{
    Logger log = LoggerFactory.getLogger(AopLogger.class);

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) {
        //log.info("调用"+target+"的"+method.getName()+"方法.返回值："+ returnValue);
    }

    @Override
    public void before(Method method, Object[] objects, Object target) {
        //log.info("调用"+target+"的"+method.getName()+"方法.入参："+ Arrays.toString(objects));
    }

    /*异常增强，必须遵循命名规则，只有最后一个参数必填，其他要么都不填，要么都填*/
    public void afterThrowing(Method method, Object[] objects, Object target,RuntimeException e){
        //log.info("调用"+target+"的"+method.getName()+"方法发生异常："+ e);
    }
    public void afterThrowing(SQLException e){
        log.info("SQL发生异常："+e );
    }


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //前置增强处理
        Object[] o = invocation.getArguments();//获取参数
        log.info(invocation.getMethod().getName()+"方法.入参："+ Arrays.toString(o));

        //调用目标方法
        Object refO;
        try {
            refO = invocation.proceed();
            //后置增强处理
            log.info(invocation.getMethod().getName()+"方法.返回值："+ refO);
            //可以修改返回值；比如打折时；可以用于返回折扣
            //refO = "123456";
            return refO;
        }catch (Throwable e){
            log.info(invocation.getMethod().getName()+"方法发生异常："+ e);
            throw e;
        }finally {
            //最终增强处理
            log.info(invocation.getMethod().getName()+"方法结束");
        }
    }


}
