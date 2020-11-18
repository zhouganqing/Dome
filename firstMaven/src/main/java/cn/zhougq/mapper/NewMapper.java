package cn.zhougq.mapper;

import cn.zhougq.pojo.NewsMod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author zhouganqing
 * @create 2020- 06- 21- 16:31
 */

@Mapper
public interface NewMapper extends BaseMapper<NewsMod> {

    List<NewsMod> selectAll();

    /*
    * 编码习惯，不管多少参数都加 @Param；
    * 默认一个参数可以不加，建议加
    * */
    NewsMod selectModeById(@Param("id")Integer id);

    Integer insertNews(NewsMod mod);

    Integer updateNews(NewsMod mod);
    Integer updateNewsByMap(Map map);

    Integer deleteNews(@Param("id")Integer id);

    List<NewsMod> selectModeInArray(Integer[] id);

    List<NewsMod> selectModeInList(List<Integer> id);

    List<NewsMod> selectModeInMapList(Map<String,Object> map);

    List<NewsMod> selectListChoose(@Param("id")Integer id);

    List<NewsMod> selectListPage(@Param("from")Integer from,@Param("pageSize")Integer pageSize);




}
