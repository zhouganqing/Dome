package cn.zhougq.service.annotation;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhouganqing
 * @create 2020- 09- 21- 11:51
 *
 * 自定义注解+AOP
 */

@Component
@Aspect
@Slf4j
public class MyAnn {
    //日志
    //Logger log = LoggerFactory.getLogger(getClass());

    /*
    * 环绕增强,切入点(当前文件夹下的ImyAnn==cn.zhougq.service.annotation.ImyAnn)
    * */
    @Around("@annotation(ImyAnn)")
    public Object lock(ProceedingJoinPoint point){

        //环绕增强的前置增强（主体方法执行前）时执行
        log.info("前置增强====调用"+point.getTarget()+"的方法"+point.getSignature().getName()+".方法入参:"+ Arrays.toString(point.getArgs()));

        //解析参数
        MyAnnInfo annInfo = lockPoint(point);

        //获取锁在这里执行,反射方式获取
        //lock.tryLock();

        //开始执行时间
        long beginTime = System.currentTimeMillis();
        //返回参数,环绕增强后置增强(主体方法执行后)时执行
        Object result = null;
        try {
            //获取锁后执行方法
            result = point.proceed();
            /*可对返回值进行修改*/
            //result = "asdf";
            log.info("调用"+point.getTarget()+"的方法"+point.getSignature().getName()+".方法返回值:"+ result);
        } catch (Throwable e) {
            //解锁
            //lock.unLock();
            //环绕增强异常增强(出现异常时执行)
            log.error("调用"+point.getTarget()+"的方法"+point.getSignature().getName()+"出现异常:" + e);
            throw new RuntimeException(e);
        }
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        log.info("后置增强");

        return result;

    }

    //反射解析
    private MyAnnInfo lockPoint(ProceedingJoinPoint joinPoint) {
        MyAnnInfo annInfo = null;

        try {
            //返回目标方法的签名(void cn.zhougq.service.test.TestAnn.testLock(String))
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //获取方法入参
            Object[] args = joinPoint.getArgs();
            //获取目标方法(public void cn.zhougq.service.test.TestAnn.testLock(java.lang.String))
            Method method = signature.getMethod();
            //获取方法中的参数名
            String[] paramNames = new DefaultParameterNameDiscoverer().getParameterNames(method);

            //获取自定义注解类@cn.zhougq.service.annotation.ImyAnn(leaseTime=30, waitTime=5, key=#key)
            ImyAnn imyAnn = method.getAnnotation(ImyAnn.class);

            //获取注解的参数
            String keyEL = imyAnn.key();
            int waitTime = imyAnn.waitTime();
            int leaseTime = imyAnn.leaseTime();

            //解析注解参数
            ExpressionParser expressionParser = new SpelExpressionParser();
            Expression expression = expressionParser.parseExpression(keyEL);
            EvaluationContext evaluationContext = new StandardEvaluationContext();
            for (int i = 0; i < paramNames.length; i++) {
                //方法参数索引==自定义注解入参索引
                evaluationContext.setVariable(paramNames[i], args[i]);
            }
            //参数加前缀
            //evaluationContext.setVariable("redisKeyPrefix", "prefix");
            //参数转换成功String格式?
            String redisKey = expression.getValue(evaluationContext, String.class);
            //返回解析后的参数实体
            annInfo = MyAnnInfo.builder().key(redisKey).waitTime(waitTime).leaseTime(leaseTime).build();

        }catch (Exception e){
            log.error("解析异常",e);
        }

        return  annInfo;
    }

}
