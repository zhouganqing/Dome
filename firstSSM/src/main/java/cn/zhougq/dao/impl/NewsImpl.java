/*
package cn.zhougq.dao.impl;

import cn.zhougq.dao.NewsMapper;
import cn.zhougq.entitys.NewsMod;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

*/
/**
 * @author zhouganqing
 * @create 2020- 07- 19- 12:53
 *//*

public class NewsImpl extends SqlSessionDaoSupport implements NewsMapper {

    */
/*@Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<NewsMod> getNewsList() {
        return sqlSession.getMapper(NewsMapper.class).getNewsList();
    }*//*


    */
/*继承SqlSessionDaoSupport this.getSqlSession() ;
      怎么注解SqlSessionFactory？？？？？ *//*

    @Override
    public List<NewsMod> getNewsList() {
        return this.getSqlSession().selectList("cn.zhougq.dao.NewsMapper.getNewsList");
    }
}
*/
