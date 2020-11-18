package cn.zhougq.service.impl;

import cn.zhougq.service.IAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author zhouganqing
 * @create 2020- 10- 14- 10:07
 *
 * 异步方法
 */

@Service
public class AsyncServiceImpl implements IAsyncService {

    @Async  /*异步执行*/
    @Override
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("处理中...");
    }


    /*定时任务
    *   秒，分，小时，日，月，周几
    *   1 * * * * * 每次第1秒的时候执行,可以认为是每分钟执行一次
    *   1,5 * * * * * 每分钟的1秒和5秒执行,    , 枚举：用于设置指定多个时间
    *   1-5 * * * * * 每分钟执行5次,          - 区间：用于设置执行次数
    *   1/5 * * * * * 每5秒执行一次,          / 步长：用于设置相隔时间
    *   * 1/5 * * * * 每5分钟执行一次
    *   * 1 * * * * 每小时执行一次
    *   * * 6 * * * 每天6点执行一次
    *
    * */
    @Scheduled(cron = "* * 6 * * *")
    @Override
    public void scheduledTask() {
        //System.out.println("2秒执行一次");
    }
}
