package cn.zhougq.entitys;

import java.io.Serializable;

/**
 * @author zhouganqing
 * @create 2020- 09- 05- 11:57
 */
public class NewsInfo implements Serializable {
    private int id;

    private String newName;

    private String newinfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String title) {
        this.newName = title;
    }

    public String getNewinfo() {
        return newinfo;
    }

    public void setNewinfo(String content) {
        this.newinfo = content;
    }

    @Override
    public String toString() {
        return "NewsMod{" +
                ", title='" + newName + '\'' +
                ", content='" + newinfo + '\'' +
                '}';
    }
}
