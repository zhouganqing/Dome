package cn.zhougq.entitys;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.Alias;

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
        return JSONObject.toJSONString(this);
    }
}
