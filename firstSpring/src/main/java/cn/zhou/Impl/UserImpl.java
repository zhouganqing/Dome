package cn.zhou.Impl;

import cn.zhou.InterFaces.UserBase;
import cn.zhou.pojo.User;

/**
 * @author zhouganqing
 * @create 2020- 07- 16- 16:14
 */
public class UserImpl implements UserBase {

    @Override
    public void save(User user) {
        System.out.println("userName:"+user.getUserName());
        System.out.println("passWord:"+user.getPassWord());
        System.out.println("age:"+user.getAge());
        System.out.println("保存到数据库成功!");

    }
}
