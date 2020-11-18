package cn.zhougq.mappers;

import cn.zhougq.pojo.NewsMod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhouganqing
 * @create 2020- 06- 21- 16:31
 */
@Repository
public interface NewMapper  {

    List<NewsMod> selectAll();



}
