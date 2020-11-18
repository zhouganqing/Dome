import cn.zhougq.entitys.SysUserAddress;
import cn.zhougq.entitys.SysUserList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 08- 05- 17:14
 */
public class firstHi {

    Configuration cfg =null;//加载Hibernate配置文件

    SessionFactory sf = null; //创建连接

    Session session =null;//操作sql

    Transaction tx = null;//事务控制

    @Test
    public void HibTest(){

        try {
            cfg = new Configuration().configure();//读取配置文件
            sf = cfg.buildSessionFactory();//获取session工厂
            session = sf.getCurrentSession();//基于当前线程的会话,避免同一个用户创建多个会话

            tx = session.beginTransaction();

            //新增
            /*SysUserAddress address = new SysUserAddress();
            address.setProvince("深圳1");
            address.setCity("福田1");
            address.setRegion("开发区");
            address.setAddress("鱼花下新村");
            address.setAddressType(0);
            address.setStreet("高埔镇");
            session.save(address);
            System.out.println("===================ID:" +address.getId());*/

            //修改
              //不存在返回null
            /*SysUserAddress address = session.get(SysUserAddress.class,279698);
              //不存在会抛异常
              SysUserAddress address = session.load(SysUserAddress.class,279717);
            address.setProvince("深圳12");
            session.save(address);*/

            //删除
            /*SysUserAddress address = new SysUserAddress();
            address.setId(279699);
            session.delete(address);*/



            //查询
            //List<SysUserList> userLists = session.createQuery("from SysUserList where id=800281").list();

            Query query = session.createQuery("from SysUserList where id =:id");
            query.setParameter("id",800281);
            List<SysUserList> userLists = query.list();
            for (SysUserList user : userLists) {
                System.out.println(user.getUserName());
            }

            tx.commit();

        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null)
            {
                tx.rollback();
            }
        }
        /*getCurrentSession 会自动关闭*/
        /*finally {
            session.close();
        }*/




    }
}
