package cn.zhougq.dao;

import cn.zhougq.entitys.SysUserAddress;

/**
 * @author zhouganqing
 * @create 2020- 08- 10- 17:41
 */
public interface IAddress {

    void save(SysUserAddress address);

    SysUserAddress selectByID(Integer id);

    void updateAddress(SysUserAddress address);

    void mergeAddress(SysUserAddress address);
}
