package cn.zhougq.redisson.lockBasic;

import cn.zhougq.constants.RedisConstants;
import cn.zhougq.redisson.execption.UnableToRedisLockException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 20:54
 *
 * 分布式锁实现
 */

@Component
public class RedissonLocker implements DistributedLocker {

    /*@Qualifier("getClient")*/
    @Autowired
    @Qualifier("getClient")
    private RedissonClient redissonClient;

    @Override
    public <T> T lock(String resName, RedisLocker<T> locker) throws UnableToRedisLockException, Exception {
        return lock(resName, locker, RedisConstants.REDISSON_LOCKER_TIME);
    }

    @Override
    public <T> T lock(String resName, RedisLocker<T> locker, int lockTime)
            throws UnableToRedisLockException, Exception {
        RLock lock = redissonClient.getLock(RedisConstants.REDISSON_LOCKER_PREFIX + resName);
        boolean success = lock.tryLock(RedisConstants.REDISSON_WAIT_TIME, lockTime, TimeUnit.SECONDS);
        if(success) {
            try {
                return locker.invokeAfterLockAquire();
            } finally {
                lock.unlock();
            }
        }
        throw new UnableToRedisLockException();
    }
}
