package cn.zhougq.Dao;


import cn.zhougq.Entitys.SysUserList;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 08- 04- 9:59
 */
public interface IUser {

    List getUserList();

    SysUserList getUserById(int id);

}
