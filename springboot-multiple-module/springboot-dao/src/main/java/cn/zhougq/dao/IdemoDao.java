package cn.zhougq.dao;

import cn.zhougq.dao.entitys.UserInfo;

/**
 * @author zhouganqing
 * @create 2020- 09- 20- 10:45
 */
public interface IdemoDao {

    UserInfo getUser(Integer id);
}
