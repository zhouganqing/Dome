package cn.zhougq.service.impl;

import cn.zhougq.dao.IdemoDao;
import cn.zhougq.dao.entitys.UserInfo;
import cn.zhougq.service.IdemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouganqing
 * @create 2020- 09- 20- 11:17
 */

@Service
public class DemoService implements IdemoService {

    @Autowired
    IdemoDao idemoDao;

    @Override
    public UserInfo GetUserById(Integer id) {
        if (id<=0){
            return null;
        }else {
            return  idemoDao.getUser(id);
        }
    }
}
