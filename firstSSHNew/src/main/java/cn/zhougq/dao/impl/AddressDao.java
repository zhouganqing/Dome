package cn.zhougq.dao.impl;

import cn.zhougq.dao.IAddress;
import cn.zhougq.entitys.SysUserAddress;

/**
 * @author zhouganqing
 * @create 2020- 08- 10- 17:39
 */
public class AddressDao extends BaseDao implements IAddress {

    @Override
    public void save(SysUserAddress address)
    {
        currentSession().save(address);
    }

    @Override
    public SysUserAddress selectByID(Integer id)
    {
        return currentSession().get(SysUserAddress.class,id);
    }

    @Override
    public void updateAddress(SysUserAddress address) {
        //所有字段都修改
        currentSession().update(address);
    }

    @Override
    public void mergeAddress(SysUserAddress address) {
        /*修改有变动的字段*/
        currentSession().merge(address);
    }


}
