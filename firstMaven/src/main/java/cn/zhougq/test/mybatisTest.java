package cn.zhougq.test;

import cn.zhougq.Utils.MybatisUtil;
import cn.zhougq.mapper.NewMapper;
import cn.zhougq.pojo.NewsMod;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouganqing
 * @create 2020- 06- 21- 17:12
 */
public class mybatisTest {

    public static void main(String[] args) {
        /*
         * try类似c#的using  会自动释放资源，不需要专门写释放资源的代码
         * getSqlSession(true) 事务自动提交，增删改操作
         */
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            /*通过直接使用xml的方式执行*/
            //List<NewsMod> list =sqlSession.selectList("cn.zhougq.mapper.NewMapper.selectAll");
            /*通过接口mapper方式执行*/
            List<NewsMod> list =sqlSession.getMapper(NewMapper.class).selectAll();
            for (NewsMod newsMod : list) {
                System.out.println(newsMod.getId()+":"+newsMod.getTitle());
            }
            //NewsMod mod =sqlSession.selectOne("selectModeById",2);
            NewsMod mod =sqlSession.getMapper(NewMapper.class).selectModeById(2);
            System.out.println(mod.getId()+":"+mod.getContent());

            //新增数据，返回自增ID
            //getSqlSession(true) 事务自动提交
            NewsMod mod1 = new NewsMod();
            mod1.setTitle("Mybatis 新增");
            mod1.setContent("Mybatis 新增明细");
            sqlSession.getMapper(NewMapper.class).insertNews(mod1);
            System.out.println("Mybatis 新增ID:"+mod1.getId());

            //删除
            int i =sqlSession.getMapper(NewMapper.class).deleteNews(29);
            System.out.println("删除ID："+i);
        }

        //不自动提交事务，手动提交（默认为false）
        SqlSession sqlSession=null;
        try{
            sqlSession = MybatisUtil.getSqlSession(false);

            NewMapper mapper =sqlSession.getMapper(NewMapper.class);

            NewsMod mod =new NewsMod();
            mod.setContent("Mybatis 修改");
            mod.setTitle("Mybatis 修改明细");
            mod.setId(25);

            Map<String,String> map = new HashMap<>();
            map.put("id","22");
            map.put("title","map221");
            map.put("content","map221");

            int i =mapper.updateNews(mod);
            System.out.println("mod修改1:"+i);
            i=mapper.updateNewsByMap(map);
            System.out.println("map修改1："+i);
            //i = i/0;  //制造异常不提交事务
            sqlSession.commit();

        }catch (Exception e){
            System.out.println("回滚");
            sqlSession.rollback();

        }finally {
            //释放资源
            sqlSession.close();
        }
    }
}
