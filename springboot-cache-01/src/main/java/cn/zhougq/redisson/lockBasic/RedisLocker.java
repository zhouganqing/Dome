package cn.zhougq.redisson.lockBasic;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 20:56
 *
 * 锁接口
 */
public interface RedisLocker<T> {
    T invokeAfterLockAquire() throws Exception;
}
