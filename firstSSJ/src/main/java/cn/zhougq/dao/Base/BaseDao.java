package cn.zhougq.dao.Base;


import cn.zhougq.util.PropertiesBase;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author zhouganqing
 * @create 2020- 06- 03- 17:32
 */
public class BaseDao {

    //声明一个数据库连接对象
    private Connection connection = null;

    //声明一个执行sql的对象(statement)
    private PreparedStatement pStatement=null;

    //声明一个结果集对象(resultSet)
    ResultSet resultSet =null;

    PropertiesBase base = PropertiesBase.base;

    //获取连接（连接数据库）
    public Boolean getConnection() {
        try {
            if (connection==null) {
                //加载数据库DLL(反射方式)
                Class.forName(base.getKey("driver"));
                //创建连接数据库(jdbc:数据库类型://数据库IP:端口/数据库名)serverTimezone=UTC必须加；解决中文乱码
                connection = DriverManager.getConnection(base.getKey("conUrl"),base.getKey("username"),base.getKey("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return  true;
    }

    public  Boolean getConnection2() {
        try {
            if (connection==null) {
                //初始化上下文
                Context cxt = new InitialContext();
                //获取与逻辑名相关联的数据源对象(固定值：java:comp/env/；数据源名称：jdbc/test)
                DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/test");
                connection = ds.getConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return  true;
    }

    public int InsertStatement(String sql,Object[] params) {
        if (getConnection()) {
            try {
                //预编译sql
                pStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                //循环加入参数（sql参数索引从1开始）
                for (int i = 1; i <= params.length; i++) {
                    pStatement.setObject(i,params[i-1]);
                }
                //返回影响行数
                if(pStatement.executeUpdate()>0){
                    //获取生成的主键值
                    ResultSet setT = pStatement.getGeneratedKeys();
                    if (setT.first())
                    {
                        return setT.getInt(1);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    //执行sql脚本(增删改)
    public int setStatement(String sql,Object[] params) {
        if (getConnection()) {
            try {
                //预编译sql
                pStatement = connection.prepareStatement(sql);
                //循环加入参数（sql参数索引从1开始）
                for (int i = 1; i <= params.length; i++) {
                    pStatement.setObject(i,params[i-1]);
                }
                //返回影响行数
                return pStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                //释放资源
                closeResource();
            }
        }
        return 0;
    }

    //查询，返回数据集
    public ResultSet getResultSet(String sql,Object[] params){
        if (getConnection())
        {
            try {
                //使用resultSet.first()或者resultSet.last()时，需使用下面的方式;
                //设置ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
                /*pStatement = connection.prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);*/

                pStatement = connection.prepareStatement(sql);
                //循环加入参数
                for (int i = 1; i <= params.length; i++) {
                    pStatement.setObject(i,params[i-1]);
                }
                return pStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //释放资源
    public void closeResource(){
        try {
            //最后使用最先释放
            if (resultSet!=null){
                resultSet.close();
                System.out.println("resultSet.close");
            }
            if (pStatement!=null){
                pStatement.close();
                System.out.println("pStatement.close");
            }
            if (connection!=null){
                connection.close();
                System.out.println("connection.close");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
