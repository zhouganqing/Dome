package cn.zhougq.Action;

import cn.zhougq.Entitys.SysUserList;
import cn.zhougq.Service.IUserService;
import cn.zhougq.Service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 08- 04- 10:24
 */
public class UserAction {

    @Autowired
    IUserService userService;

    public List getUserList() {
        return userService.getUserList();
    }

    public SysUserList getUserById(int id) {
        return userService.getUserById(id);
    }
}
