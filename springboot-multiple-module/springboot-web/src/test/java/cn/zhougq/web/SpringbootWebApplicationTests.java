package cn.zhougq.web;

import cn.zhougq.service.test.TestAnn;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootWebApplicationTests {

    @Autowired
    private TestAnn testAnn;

    @Test
    void contextLoads() {
        testAnn.testLock("aa");
    }

}
