package cn.zhougq.redis.lock;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 17:49
 */

@Data
@Builder
public class RedisLockInfo {

    private String key;

    private int waitTime;

    private int leaseTime;
}
