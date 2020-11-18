package cn.zhougq;

import cn.zhougq.entitys.Users;
import cn.zhougq.repository.UsersRepository;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.metrics.ParsedAvg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class FirstElasticsearchApplicationTests {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ElasticsearchRestTemplate template;


    @Test
    void contextLoads() {
        for (int i = 0; i <= 20; i++) {
            Users users =new Users();
            users.setId(i);
            users.setUserName("测试用户名"+i);
            users.setPassword("测试密码"+i);
            //把文档写入索引库
            usersRepository.save(users);
        }
    }

    @Test
    public void deleteDocumentById() {
        usersRepository.deleteById(1);
        //全部删除
//		usersRepository.deleteAll();
    }

    //查询所有文档
    @Test
    public void findAll() {
        Iterable<Users> userList = usersRepository.findAll();
        for (Users users : userList) {
            System.out.println(users);
        }
    }

    //根据ID查询
    @Test
    public void testFindById() {
        Users users = template.get("1", Users.class);
        //Optional<Users> article = usersRepository.findById(1);
        System.out.println(users);
    }

    //匹配标题，精准匹配
    @Test
    public void testFindByTitle() {
        List<Users> list = usersRepository.findByUserName("1");
        for (Users users : list) {
            System.out.println(users);
        }
    }
    //匹配标题或者内容
    @Test
    public void testFindByTitleOrContent() {
        Pageable pageable = PageRequest.of(1, 5);
        List<Users> list = usersRepository.findByUserNameOrPassword("1", "", pageable);
        for (Users users : list) {
            System.out.println(users);
        }
    }

    //分词查询
    @Test
    public void testNativeSearchQuery() {
        //创建一个查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("测试").defaultField("userName"))
                .withPageable(PageRequest.of(0, 15))
                .build();
        //执行查询
        SearchHits<Users> search = template.search(query, Users.class);
        List<SearchHit<Users>> searchHits = search.getSearchHits();
        for (SearchHit<Users> searchHit : searchHits) {
            System.out.println(searchHit.getContent());
        }

        System.out.println("===============");
        //获取聚合结果
        if (search.hasAggregations()) {
            ParsedAvg parsedAvg = search.getAggregations().get("1");
            Assertions.assertNotNull(parsedAvg, "无聚合结果");
            System.out.println(parsedAvg.getValue());
        }
    }

}
