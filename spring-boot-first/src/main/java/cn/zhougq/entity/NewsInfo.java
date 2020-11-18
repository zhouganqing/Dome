package cn.zhougq.entity;

/**
 * @author zhouganqing
 * @create 2020- 08- 29- 17:29
 */
public class NewsInfo {

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
