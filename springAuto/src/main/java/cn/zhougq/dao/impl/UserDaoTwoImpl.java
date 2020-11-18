package cn.zhougq.dao.impl;

import cn.zhougq.dao.IUserDao;
import cn.zhougq.entitys.User;
import org.springframework.stereotype.Repository;

/**
 * @author zhouganqing
 * @create 2020- 07- 18- 14:36
 */
/*Repository注解Dao数据层;取别名*/
@Repository("userDaoTwo")
public class UserDaoTwoImpl implements IUserDao {

    @Override
    public void saveUser(User user) {
        System.out.println("我是第二个实现IUserDao接口的");
        throw new RuntimeException("我错啦");
    }
}
