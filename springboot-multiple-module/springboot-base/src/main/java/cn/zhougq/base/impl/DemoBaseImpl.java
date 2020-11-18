package cn.zhougq.base.impl;

import cn.zhougq.base.IdemoBase;
import org.springframework.stereotype.Component;

/**
 * @author zhouganqing
 * @create 2020- 09- 20- 10:40
 */

@Component
public class DemoBaseImpl implements IdemoBase {
    @Override
    public Boolean GetConnection() {
        System.out.println("创建数据库连接成功！");
        return true;
    }
}
