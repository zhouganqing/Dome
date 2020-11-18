package cn.zhougq.constants;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 20:58
 *
 * redis常量
 */
public class RedisConstants {
    // 锁的有效时间
    public final static Integer REDISSON_LOCKER_TIME = 20;
    // 获取锁最长等待时间
    public final static Integer REDISSON_WAIT_TIME = 5;
    // 锁前缀
    public final static String REDISSON_LOCKER_PREFIX = "lockBasic:";

}
