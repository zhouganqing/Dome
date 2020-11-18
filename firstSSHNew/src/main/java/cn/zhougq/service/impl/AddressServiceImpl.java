package cn.zhougq.service.impl;

import cn.zhougq.Untils.HibernateUntil;
import cn.zhougq.dao.IAddress;
import cn.zhougq.dao.impl.AddressDao;
import cn.zhougq.entitys.SysUserAddress;
import cn.zhougq.service.IAddressService;
import org.hibernate.Transaction;

/**
 * @author zhouganqing
 * @create 2020- 08- 10- 17:44
 */
public class AddressServiceImpl implements IAddressService {

    private final IAddress iAddress = new AddressDao();
    Transaction tx= null;

    @Override
    public void saveAddress(SysUserAddress address) {
        try {
            tx = HibernateUntil.currentSession().beginTransaction();
            iAddress.save(address);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null)
            {
                tx.rollback();
            }
        }
    }

    @Override
    public SysUserAddress selectByID(Integer id) {

        SysUserAddress address=null;
        try {
            tx = HibernateUntil.currentSession().beginTransaction();
            address = iAddress.selectByID(id);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null)
            {
                tx.rollback();
            }
        }
        return address;
    }

    @Override
    public void updateAddress(SysUserAddress address) {
        try {
            tx = HibernateUntil.currentSession().beginTransaction();
            iAddress.updateAddress(address);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null)
            {
                tx.rollback();
            }
        }
    }

    @Override
    public void mergeAddress(SysUserAddress address) {
        try {
            tx = HibernateUntil.currentSession().beginTransaction();
            iAddress.mergeAddress(address);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null)
            {
                tx.rollback();
            }
        }
    }
}
