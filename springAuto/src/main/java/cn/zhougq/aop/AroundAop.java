package cn.zhougq.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author zhouganqing
 * @create 2020- 07- 17- 16:30
 */
@Aspect
public class AroundAop {

    private static final Logger log= LoggerFactory.getLogger(AroundAop.class);

    //代表环绕增强的方法
    @Around("execution(public * saveUser(..))")
    public Object aroundThrow(ProceedingJoinPoint jp) throws Throwable {
        //环绕增强的前置增强（主体方法执行前）时执行
        log.info("调用"+jp.getTarget()+"的方法"+jp.getSignature().getName()+".方法入参:"+ Arrays.toString(jp.getArgs()));

        //返回参数,环绕增强后置增强(主体方法执行后)时执行
        Object result;
        try {
            result = jp.proceed();
            /*可对返回值进行修改*/
            result = "asdf";
            log.info("调用"+jp.getTarget()+"的方法"+jp.getSignature().getName()+".方法返回值:"+ result);
            return result;
        } catch (Throwable e) {
            //环绕增强异常增强(出现异常时执行)
            log.error("调用"+jp.getTarget()+"的方法"+jp.getSignature().getName()+"出现异常:" + e);
            throw e;//抛出异常
        }finally {
            //环绕增强,最终增强(GC垃圾回收)
            log.info("调用"+jp.getTarget()+"的方法"+jp.getSignature().getName()+"结束");
        }


    }
}
