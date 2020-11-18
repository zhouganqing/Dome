package cn.zhougq.Service.Impl;

import cn.zhougq.Dao.Impl.UserImpl;
import cn.zhougq.Entitys.SysUserList;
import cn.zhougq.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 08- 04- 10:19
 */

@Service
public class UserService implements IUserService {

    @Autowired
    @Qualifier("userDao")
    UserImpl user;

    @Override
    public List getUserList() {
        return user.getUserList();
    }

    @Override
    public SysUserList getUserById(int id) {
        return user.getUserById(id);
    }
}
