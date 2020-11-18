package cn.zhougq.redis.enums;

import static cn.zhougq.redis.constants.RedisKeyConsts.NAME_SEPERATOR;
import static cn.zhougq.redis.constants.RedisKeyConsts.PREFIX_FN;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 18:02
 */
public enum RedisKeyPrefixEnum {
    GATEWAY(PREFIX_FN + "gateway" + NAME_SEPERATOR, "网关前缀"),

    DATA(PREFIX_FN + "data" + NAME_SEPERATOR, "基础数据前缀"),

    CREDIT(PREFIX_FN + "credit" + NAME_SEPERATOR, "合同前缀"),

    CUSTOMER(PREFIX_FN + "customer" + NAME_SEPERATOR, "客户建档前缀"),

    FUND(PREFIX_FN + "fund" + NAME_SEPERATOR, "资金前缀"),

    CONTRACT(PREFIX_FN + "contract" + NAME_SEPERATOR, "合同中心前缀")
            ;

    private String prefix;

    private String remark;

    RedisKeyPrefixEnum(String prefix, String remark) {
        this.prefix = prefix;
        this.remark = remark;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getRemark() {
        return remark;
    }
}
