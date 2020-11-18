package cn.zhougq.service.annotation;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhouganqing
 * @create 2020- 09- 21- 11:54
 */

@Data
@Builder
public class MyAnnInfo {

    private String key;

    private int waitTime;

    private int leaseTime;
}
