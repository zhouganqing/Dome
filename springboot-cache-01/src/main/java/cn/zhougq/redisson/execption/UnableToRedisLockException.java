package cn.zhougq.redisson.execption;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 20:57
 *
 * redis锁异常类
 */
public class UnableToRedisLockException extends RuntimeException {

    private static final long serialVersionUID = -4752324949319721984L;

    public UnableToRedisLockException() {

    }

    public UnableToRedisLockException(String msg) {
        super(msg);
    }

    public UnableToRedisLockException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
