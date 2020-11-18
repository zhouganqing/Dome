package cn.zhougq.dao.impl;

import cn.zhougq.dao.IUserDao;
import cn.zhougq.entitys.User;
import org.springframework.stereotype.Repository;

/**
 * @author zhouganqing
 * @create 2020- 07- 18- 14:25
 */
/*Repository注解Dao数据层*/
@Repository
public class UserDaoImpl implements IUserDao {

    @Override
    public void saveUser(User user) {
        System.out.println("保存数据库成功");
    }
}
