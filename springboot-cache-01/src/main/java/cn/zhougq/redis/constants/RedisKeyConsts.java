package cn.zhougq.redis.constants;

import cn.zhougq.redis.enums.RedisKeyPrefixEnum;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 18:03
 */
public class RedisKeyConsts {
    public static final String NAME_SEPERATOR = ":";

    public static final String LIKE_SEPERATOR = "*";

    public static final String NAME_SEPARATOR = NAME_SEPERATOR;

    public static final String NAMESPACE_FN = "fn";

    public static final String PREFIX_FN = NAMESPACE_FN + NAME_SEPERATOR;

    /**
     * fn:gateway:apitoken:
     */
    public static final String API_TOKEN_PREFIX = RedisKeyPrefixEnum.GATEWAY.getPrefix() + "apitoken" + NAME_SEPERATOR;
}
