package cn.zhougq.test;

import cn.zhougq.mappers.NewMapper;
import cn.zhougq.pojo.NewsMod;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 08- 23- 16:57
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DruidTest {

    @Autowired
    DruidDataSource dataSource;

    @Autowired
    NewMapper newMapper;

    @Test
    public void contextLoads() {
        System.out.println(dataSource.getClass());
    }

    @Test
    public void newsLoads() {
        List<NewsMod> list = newMapper.selectAll();
        for (NewsMod mod: list) {
            System.out.println(mod.toString());
        }
    }

}
