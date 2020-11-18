package cn.zhougq.redis.lock;

import cn.zhougq.redis.enums.RedisKeyPrefixEnum;
import cn.zhougq.redis.enums.ResultCodeEnums;
import cn.zhougq.redis.execption.ResultRuntimeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 17:48
 *
 * 对自定义RedisLock注解实现AOP切面
 */

@Component
@Aspect
@Order(0)
public class RedisLockAspect {

    private static final int LOCK_NUM = 3;

    @Autowired
    @Qualifier("getClient")
    private RedissonClient redissonClient;

    Logger log = LoggerFactory.getLogger(getClass());

    @Around("@annotation(RedisLock)")
    public Object lock(ProceedingJoinPoint proceedingJoinPoint){
        RedisLockInfo redisLockInfo = parseRedisKey(proceedingJoinPoint);
        log.info("redis锁信息:{}", redisLockInfo);
        String redisKey = redisLockInfo.getKey();
        if(StringUtils.isEmpty(redisKey)){
            throw new ResultRuntimeException(ResultCodeEnums.FAIL, "redisKey为空");
        }
        RedissonRedLock lock = createRedLock(redisKey);
        boolean lockSucc;
        try {
            lockSucc = lock.tryLock(redisLockInfo.getWaitTime(), redisLockInfo.getLeaseTime(), TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            throw new ResultRuntimeException(ResultCodeEnums.FAIL, "获取锁超时");
        }
        // 抢锁失败
        if (!lockSucc) {
            throw new ResultRuntimeException(ResultCodeEnums.FAIL, "获取锁失败");
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("redis 切面执行异常" , throwable);
            if(throwable instanceof ResultRuntimeException){
                throw (ResultRuntimeException) throwable;
            }
            throw new ResultRuntimeException(ResultCodeEnums.FAIL, throwable.getMessage());
        } finally {
            lock.unlock();
        }
    }

    private RedissonRedLock createRedLock(String redisKey) {
        RLock[] locks = new RLock[LOCK_NUM];
        for (int i = 0; i < LOCK_NUM; i++) {
            // TODO：确保 key 分布在不同节点
            String keyName = redisKey + ":redlock" + i;
            locks[i] = redissonClient.getLock(keyName);
        }
        return new RedissonRedLock(locks);
    }

    private RedisLockInfo parseRedisKey(ProceedingJoinPoint proceedingJoinPoint){
        RedisLockInfo redisLockInfo = null;
        try{
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            Object[] args = proceedingJoinPoint.getArgs();
//        Method method = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
            Method method = methodSignature.getMethod();
            String[] paramNames = new DefaultParameterNameDiscoverer().getParameterNames(method);
            RedisLock redisLock = method.getAnnotation(RedisLock.class);
            String keyEL = redisLock.key();
            int waitTime = redisLock.waitTime();
            int leaseTime = redisLock.leaseTime();
            ExpressionParser expressionParser = new SpelExpressionParser();
            Expression expression = expressionParser.parseExpression(keyEL);
            EvaluationContext evaluationContext = new StandardEvaluationContext();
            for(int i = 0; i < paramNames.length; i++){
                evaluationContext.setVariable(paramNames[i], args[i]);
            }
            evaluationContext.setVariable("redisKeyPrefix", RedisKeyPrefixEnum.FUND.getPrefix());
            String redisKey = expression.getValue(evaluationContext, String.class);
            redisLockInfo = RedisLockInfo.builder().key(redisKey).waitTime(waitTime).leaseTime(leaseTime).build();
        } catch(Exception ex){
            log.error("Redis锁信息解析异常", ex);
        }
        return redisLockInfo;
    }
}
