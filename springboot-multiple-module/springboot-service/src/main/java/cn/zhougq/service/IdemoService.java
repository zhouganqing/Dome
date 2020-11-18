package cn.zhougq.service;

import cn.zhougq.dao.entitys.UserInfo;

/**
 * @author zhouganqing
 * @create 2020- 09- 20- 11:14
 */
public interface IdemoService {
    UserInfo GetUserById(Integer id);
}
