package cn.zhougq.entity;

import javax.persistence.*;

/**
 * @author zhouganqing
 * @create 2020- 08- 31- 8:52
 *
 * 使用jpa注解配置映射关系
 * Entity 告诉jpa这是一个实体类,和数据库表映射的类
 * Table 指定数据库表名,默认为类名 newsJpa
 */

@Entity
@Table(name = "news")
public class NewsJpa {

    //GenerationType.SEQUENCE  oracle使用
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;

    @Column//默认列名就是属性名(name = "newName")
    private String newName;

    @Column
    private String newinfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewinfo() {
        return newinfo;
    }

    public void setNewinfo(String newinfo) {
        this.newinfo = newinfo;
    }

    @Override
    public String toString() {
        return "NewsJpa{" +
                "id=" + id +
                ", newName='" + newName + '\'' +
                ", newinfo='" + newinfo + '\'' +
                '}';
    }
}
