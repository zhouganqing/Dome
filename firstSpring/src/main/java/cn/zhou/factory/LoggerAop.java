package cn.zhou.factory;

import cn.zhou.test.printerTest;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhouganqing
 * @create 2020- 07- 12- 19:53
 */


public class LoggerAop {
    private static final Logger log= LoggerFactory.getLogger(printerTest.class);

    //代表前置增强的方法
    public void before(JoinPoint jp)
    {
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法.方法入参:"+ Arrays.toString(jp.getArgs()));
    }

    //代表后置增强的方法
    public void afterReturning(JoinPoint jp,Object result)
    {
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法.方法返回值:"+ result);
    }

    //代表异常增强的方法
    public void errorThrow(JoinPoint jp,RuntimeException e)
    {
        log.error("调用"+jp.getTarget()+"的方法"+jp.getSignature().getName()+"出现异常:"+ e);
    }

    //代表最终增强的方法
    public void after(JoinPoint jp)
    {
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法最后执行；用于GC垃圾回收");
    }
}
