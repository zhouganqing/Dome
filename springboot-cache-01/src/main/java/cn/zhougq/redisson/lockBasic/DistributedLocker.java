package cn.zhougq.redisson.lockBasic;

import cn.zhougq.redisson.execption.UnableToRedisLockException;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 20:55
 *
 * Redisson 分布式锁接口
 */
public interface DistributedLocker {
    <T> T lock(String resName, RedisLocker<T> locker) throws UnableToRedisLockException, Exception;

    <T> T lock(String resName, RedisLocker<T> locker, int lockTime) throws UnableToRedisLockException, Exception;

}
