package cn.zhougq.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhouganqing
 * @create 2020- 09- 22- 15:25
 */
public class News {
    private Integer id;
    private String title;
    private String cretareTime;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cretareTime=" + cretareTime +
                '}';
    }

    public News() {
    }

    public News(Integer id, String title) {
        this.id = id;
        this.title = title;
        this.cretareTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

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

    public String getCretareTime() {
        return cretareTime;
    }

    public void setCretareTime(String cretareTime) {
        this.cretareTime = cretareTime;
    }
}
