package cn.zhougq.mapper;

import cn.zhougq.entitys.NewsInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhouganqing
 * @create 2020- 09- 05- 11:57
 */

public interface NewsMapper {

    @Select("select * from news where id=#{id}")
    NewsInfo getNewsInfoById(Integer id);

    @Update("update news set newName=#{newName},newinfo=#{newinfo} where id=#{id}")
    Integer updateNews(NewsInfo newsInfo);

    @Delete("delete from news where id=#{id}")
    int deleteNewsById(Integer id);
}
