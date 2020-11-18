package cn.zhougq.repository;

import cn.zhougq.entitys.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 10- 13- 16:14
 */
public interface UsersRepository extends ElasticsearchRepository<Users,Integer> {
    /*自定义方法不需要写实现,按照属性的方法名直接使用*/
    List<Users> findByUserName(String userName);
    List<Users> findByUserNameOrPassword(String userName,String password, Pageable pageable);
}
