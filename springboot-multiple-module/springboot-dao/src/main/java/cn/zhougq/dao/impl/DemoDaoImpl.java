package cn.zhougq.dao.impl;

import cn.zhougq.dao.IdemoDao;
import cn.zhougq.dao.entitys.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @author zhouganqing
 * @create 2020- 09- 20- 10:45
 */

@Component
public class DemoDaoImpl implements IdemoDao {

    @Override
    public UserInfo getUser(Integer id) {
        System.out.println("获取用户信息成功");
        UserInfo info = new UserInfo();
        info.setId(id);
        info.setUsername("zhoguq");
        info.setPassword("123456");
        return info;

    }
}
