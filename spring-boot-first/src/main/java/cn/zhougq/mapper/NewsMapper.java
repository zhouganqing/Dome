package cn.zhougq.mapper;

import cn.zhougq.entity.NewsInfo;
import org.apache.ibatis.annotations.*;

/**
 * @author zhouganqing
 * @create 2020- 08- 29- 17:33
 *
 * 使用mybatis注解的方式操作数据库
 */

//@Mapper
public interface NewsMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "newName", column = "newName"),
            @Result(property = "newinfo", column = "newinfo")
    })
    @Select("select * from news where id=#{id}")
    NewsInfo getNewsInfoById(Integer id);

    @Delete("delete from news where id=#{id}")
    int deleteNewsById(Integer id);

    //自增ID,写入实体
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into news(newName,newinfo) values (#{newName},#{newinfo})")
    int insertNews(NewsInfo newsInfo);

    @Update("update news set newName=#{newName},newinfo=#{newinfo} where id=#{id}")
    NewsInfo updateNews(NewsInfo newsInfo);
}
