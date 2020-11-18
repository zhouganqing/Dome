package cn.zhougq.base.impl;

import cn.zhougq.base.dao.BaseDao;
import cn.zhougq.base.idao.INewsDao;
import cn.zhougq.model.NewsMod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 06- 04- 9:38
 * 继承类使用extend
 * 继承接口使用implements
 */
public class NewDaoImpl extends BaseDao implements INewsDao {
    @Override
    public void closeResource() {
        super.closeResource();
    }

    @Override
    public int addNews(String title, String content) {
        String sql = "insert into news(newName,newinfo) values(?,?)";
        Object[] obj={title,content};
        return InsertStatement(sql,obj);
    }

    @Override
    public int updateNews(String title, String content, int id) {
        String sql = "update news set newName=?,newinfo=? where id=?";
        Object[] obj={title,content,id};
        return setStatement(sql,obj);
    }

    @Override
    public int deleteNews(int id) {
        String sql = "delete from news where id=?";
        Object[] obj={id};
        return setStatement(sql,obj);
    }

    @Override
    public NewsMod getNewMod(int id) {
        String sql = "select * from news where id=?";
        Object[] obj = {id};
        ResultSet resultSet = getResultSet(sql, obj);
        NewsMod mod = null;
        try {
            //判断结果集的下一条是否有数据，如果有数据返回true,并指针下移；如果返回false,指针不会下移。
            if (resultSet.next())
            {
                String title = resultSet.getString(2);
                String content = resultSet.getString("newinfo");
                mod = new NewsMod(id,title,content);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mod;
    }

    @Override
    public List<NewsMod> getNews() {
        String sql = "select * from news ";
        Object[] obj = {};
        ResultSet resultSet = getResultSet(sql, obj);
        List<NewsMod> list = new ArrayList<>();
        try {
            //判断结果集的下一条是否有数据，如果有数据返回true,并指针下移；如果返回false,指针不会下移。
            while (resultSet.next())
            {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String content = resultSet.getString("newinfo");
                list.add(new NewsMod(id,title,content));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<NewsMod> getNewsByTitle(String title) {
        String sql = "select * from news where newname=?";
        Object[] obj = {title};
        ResultSet resultSet = getResultSet(sql, obj);
        List<NewsMod> list = new ArrayList<>();
        try {
            //判断结果集的下一条是否有数据，如果有数据返回true,并指针下移；如果返回false,指针不会下移。
            while (resultSet.next())
            {
                int id = resultSet.getInt(1);
                String content = resultSet.getString("newinfo");
                list.add(new NewsMod(id,title,content));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
