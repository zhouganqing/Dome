package cn.zhougq.entytis;



import com.sun.istack.internal.NotNull;

import java.util.Date;

/**
 * @author zhouganqing
 * @create 2020- 06- 04- 9:29
 */

public class NewsMod {
    private int id;
    /*@NotNull(Message="标题不能为空")*/
    private String title;
    private String content;
    //private String imgPath;

/*@DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date time;*/

    public NewsMod(){}

    public NewsMod(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    /*public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
*/
    @Override
    public String toString() {
        return "NewsMod{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
