package cn.zhougq.redisson.lock;

import cn.zhougq.constants.RedisConstants;
import cn.zhougq.redisson.execption.UnableToRedisLockException;
import cn.zhougq.util.HttpKit;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
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
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 17:21
 */
@Aspect
@Component
public class RedissonLockAspect {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("getClient")
    private RedissonClient client;

    // 默认的锁持有时间（默认30s）
    private static final int DEFAULT_LEASE_TIME = 30;

    // 锁最长持有时间（5分钟）
    private static final int MAX_LEASE_TIME = 30 * 10;

    @Around(value = "@annotation(redissonLock)")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint,
                               RedissonLock redissonLock) throws Throwable {
        long start = System.currentTimeMillis();
        if (!redissonLock.isLockMethod() &&"".equals(redissonLock.businessType())) {
            log.error("businessType is null");
            throw new IllegalArgumentException("businessType is null");
        }
        String key = null;
        try {
            key = genKey(proceedingJoinPoint, redissonLock);
        } catch (Exception e) {
            log.error("genkey error" + ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        int leaseTime = redissonLock.leaseTime();
        leaseTime = leaseTime < 0 ? DEFAULT_LEASE_TIME : (leaseTime > MAX_LEASE_TIME ? MAX_LEASE_TIME : leaseTime);
        int waitTime = redissonLock.waitTime();
        boolean tryLockOnly = redissonLock.tryLockOnly();
        Object result;
        RLock lock = client.getLock(key);
        try {
            if (tryLockOnly) {
                boolean lockFlag = lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
                if (!lockFlag) {
                    throw new UnableToRedisLockException(key + "acquired lock failed.");
                }
            } else {
                lock.lock(leaseTime, TimeUnit.SECONDS);
            }
            if (log.isInfoEnabled()) {
                log.info("====== Get redissonLock lock success. key: {}, getLockTime: {},leaseTime: {}s", key,(System.currentTimeMillis()-start)+"ms", leaseTime);
            }
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.error(ExceptionUtils.getStackTrace(e));
            throw e;
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        return result;
    }

    private String genKey(ProceedingJoinPoint proceedingJoinPoint, RedissonLock redissonLock) throws Exception {
        StringBuilder key = new StringBuilder();
        Object[] args = proceedingJoinPoint.getArgs();
        if (!redissonLock.isLockMethod() && args.length != 0) {
            Map<String, Object> lockKeyMap = new HashMap<>();
            ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            Method method = methodSignature.getMethod();
            String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                String parameterPrefixName = parameterNames[i];
                Class<?> clazz = arg.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object value = field.get(arg);
                    if (value != null) {
                        lockKeyMap.put(parameterPrefixName + "." + field.getName(), value);
                    }
                }
            }
            String[] lockKeyArr = redissonLock.lockKey();

            for (String lockKey : lockKeyArr) {
                Object value = lockKeyMap.get(lockKey);
                if (value != null) {
                    key.append(value).append(":");
                }
            }
        }
        if (redissonLock.isLockMethod()) {
            key = new StringBuilder(HttpKit.getLocalIp() + proceedingJoinPoint.getSignature().toString());
        }
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("key is null");
        }
        return RedisConstants.REDISSON_LOCKER_PREFIX + redissonLock.businessType() + ":" + key.toString();
    }
}
