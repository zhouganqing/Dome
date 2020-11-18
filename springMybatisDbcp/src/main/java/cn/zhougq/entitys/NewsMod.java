package cn.zhougq.entitys;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * @author zhouganqing
 * @create 2020- 07- 19- 11:07
 */

@Alias("news")
public class NewsMod {
    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NewsMod{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
