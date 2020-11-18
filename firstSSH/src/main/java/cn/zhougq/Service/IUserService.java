package cn.zhougq.Service;

import cn.zhougq.Entitys.SysUserList;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 08- 04- 10:19
 */
public interface IUserService {

    List getUserList();

    SysUserList getUserById(int id);
}
