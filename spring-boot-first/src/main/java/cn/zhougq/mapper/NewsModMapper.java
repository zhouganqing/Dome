package cn.zhougq.mapper;

import cn.zhougq.entity.NewsInfo;
import cn.zhougq.entity.NewsMod;

/**
 * @author zhouganqing
 * @create 2020- 08- 29- 21:46
 *
 * NewsModMapper接口和NewsModMapper.xml文件在同一个目录下不需要其他配置,可直接使用
 */
public interface NewsModMapper {

    NewsMod getNewsModById(Integer id);
}
