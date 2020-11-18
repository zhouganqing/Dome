package cn.zhougq.service;

import cn.zhougq.entitys.SysUserAddress;

/**
 * @author zhouganqing
 * @create 2020- 08- 10- 17:40
 */
public interface IAddressService {
    void saveAddress(SysUserAddress address);

    SysUserAddress selectByID(Integer id);

    void updateAddress(SysUserAddress address);

    void mergeAddress(SysUserAddress address);
}
