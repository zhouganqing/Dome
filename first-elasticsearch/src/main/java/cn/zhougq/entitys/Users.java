package cn.zhougq.entitys;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author zhouganqing
 * @create 2020- 10- 13- 16:12
 */

/*
索引库名为zhougq,type="users";类型为users,7.6版本该配置无效;
shards = 5,replicas = 1 分片为5，每片备份1片
*/
@Document(indexName = "zhougq")
public class Users {
    private Integer id;
    private String userName;
    private String password;

    public Users(){}

    public Users(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
