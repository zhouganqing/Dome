package cn.zhougq.redisson.lock;

import java.lang.annotation.*;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 11:44
 *
 * @interface Annotation{ } 定义一个注解 @Annotation，一个注解是一个类；
 * 可以在方法上直接使用@RedissonLock 方式注解,自定义注解
 *
 * @Target({ElementType.METHOD})   表示该注解只能用来修饰在方法上
 * @Retention(RetentionPolicy.RUNTIME )修饰的注解，表示注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时，
 * 所以他们可以用反射的方式读取。RetentionPolicy.RUNTIME 可以让你从JVM中读取Annotation注解的信息，以便在分析程序的时候使用.
 * @Inherited 类实现接口或接口继承接口时,不会继承任何接口中定义的注解
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME )
/*@Documented
@Inherited*/
public @interface RedissonLock {

    /**
     * 锁的名称
     * eg:如果是入参对象 则使用 arg[0].field[0] 目前只支持一层级联对象，若是基础数据类型或者包装类则使用 arg[1].value
     *  @RedissonLock(businessType = "giveu-contract-service:entry:doApplyEntry",lockKey={"applyEntry.creditModel","applyEntry.contractNo"})
     *  public Result<JSONObject> doApplyEntry(ApplyEntry applyEntry)
     * @return
     */
    String[] lockKey() default {};

    /**
     * the maximum time to aquire the lock
     *
     * @return
     */
    int waitTime() default 5;

    /**
     * 锁持有时间 默认30秒
     * @return
     */
    int  leaseTime() default -1;

    /**
     * 是否使用 tryLock 方式获取锁
     *
     * @return
     */
    boolean tryLockOnly() default true;

    /**
     * 是否锁定方法  默认不锁定方法 若锁定方法时候 则isLockMethod=true
     * 锁定方法的时候锁的名称是: ip+方法的全限定名
     * @return
     */
    boolean isLockMethod() default false;

    /** 业务类型前缀
     * 1、锁定方法的时候可以不传
     * 2、使用方法的参数作为锁的key的时候必传 eg：
     *    项目名称 +“:”+业务模块+":"+方法名
     *    giveu-contract-service:entry:doApplyEntry
     * @return
     */
    String  businessType() default "";
}
