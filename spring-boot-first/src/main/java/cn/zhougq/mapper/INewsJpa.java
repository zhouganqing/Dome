package cn.zhougq.mapper;

import cn.zhougq.entity.NewsJpa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhouganqing
 * @create 2020- 08- 31- 9:03
 *
 * 继承JpaRepository,<映射表的类,ID主键>
 */
public interface INewsJpa extends JpaRepository<NewsJpa,Integer> {
}
