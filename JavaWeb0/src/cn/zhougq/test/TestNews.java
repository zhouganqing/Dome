package cn.zhougq.test;

import cn.zhougq.base.dao.BaseDao;

/**
 * @author zhouganqing
 * @create 2020- 06- 04- 18:32
 */
public class TestNews {
    public static void main(String[] args) {
        BaseDao bd = new BaseDao();
        System.out.println(bd.getConnection());

        /*NewDaoImpl iNewsDao = new NewDaoImpl();
        int a = iNewsDao.addNews("哈哈哈","123456789");
        System.out.println("a:"+a);

        int b =iNewsDao.addNews("嘿嘿嘿","987654321");
        System.out.println("b:"+b);

        NewsMod mod = iNewsDao.getNewMod(b);
        System.out.println("mod:"+mod.toString());

        iNewsDao.updateNews("嘿嘿2","3333333333",b);

        mod = iNewsDao.getNewMod(b);
        System.out.println("mod2:"+mod.toString());

        List<NewsMod> list = iNewsDao.getNews();
        for (NewsMod newsMod : list) {
            System.out.println("list:"+newsMod.toString());
        }

        list = iNewsDao.getNewsByTitle("哈哈哈");
        for (NewsMod newsMod : list) {
            System.out.println("title:"+newsMod.toString());
        }

        iNewsDao.deleteNews(b);

        iNewsDao.closeResource();*/
    }
}
