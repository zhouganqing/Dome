package cn.zhougq;

import cn.zhougq.entitys.Users;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouganqing
 * @create 2020- 10- 13- 17:27
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestHighLevelTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    //查看索引是否存在
    @Test
    public void existIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("zhouganqing");
        boolean bl = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(bl);
    }

    //创建索引
    @Test
    public void testCreatIndex() throws IOException {
        //创建索引请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("zhougq");
        //创建执行请求
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);

    }

    //获取索引
    @Test
    public void testGetIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("zhougq");
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //删除索引
    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("zhougq");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    //文档添加信息
    @Test
    public void testDocument() throws IOException {
        Users users = new Users();
        users.setId(1);
        users.setUserName("zhougq");
        users.setPassword("123456");

        IndexRequest indexRequest = new IndexRequest("zhouganqing");
        indexRequest.id("1");//这个ID是索引的ID，不是数据的ID
        indexRequest.timeout(TimeValue.timeValueSeconds(1));
        indexRequest.timeout("1s");
        indexRequest.source(JSON.toJSONString(users), XContentType.JSON);
        //发送请求
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
    }

    //获取文档
    @Test
    public void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("zhouganqing", "1");
        //不获取 _souce上下文
//		getRequest.fetchSourceContext(new FetchSourceContext(false));
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        if (exists) {
            //获取文档信息
            GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            System.out.println(documentFields.getSourceAsString());
            System.out.println(documentFields);
        }
    }

    //更新文档信息
    @Test
    public void testUpdateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("zhouganqing", "1");
        updateRequest.timeout("1s");
        Users user = new Users(1,"白仙子", "654231");
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(update.status());
    }

    //删除文档
    @Test
    public void testDelectDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("zhouganqing", "1");
        deleteRequest.timeout("1s");
        DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse);
    }

    //批量插入数据
    @Test
    public void testInsertListDocument() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        List<Users> list =new ArrayList<Users>();
        list.add(new Users(19,"白仙子","19"));
        list.add(new Users(18,"诸葛仙子","18"));
        list.add(new Users(20,"张仙子","20"));
        list.add(new Users(21,"刘仙子","21"));
        list.add(new Users(25,"李仙子","25"));
        for (int i = 0; i <list.size() ; i++) {
            //这个.id是索引的ID，不是数据的ID
            bulkRequest.add(new IndexRequest("zhouganqing").id("0"+i).source(JSON.toJSONString(list.get(i)),XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        //是否失败 false 代表成功
        System.out.println(bulk.hasFailures());
    }

    //查询文档信息
    @Test
    public void testSearchDocumen() throws IOException {
        SearchRequest searchRequest = new SearchRequest("zhouganqing");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //QueryBuilders.termQuery 精确查找
//		TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "李仙子");
        //QueryBuilders.matchAllQuery查询所有
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        searchSourceBuilder.query(matchAllQueryBuilder);
        //构建分页
        searchSourceBuilder.from();
        searchSourceBuilder.size();
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSON(search.getHits()));
        for (SearchHit searchHit : search.getHits().getHits()) {
            System.out.println(searchHit.getSourceAsMap());
        }

    }
}
