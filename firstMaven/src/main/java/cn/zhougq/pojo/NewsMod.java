package cn.zhougq.pojo;

/**
 * @author zhouganqing
 * @create 2020- 06- 21- 14:37
 */

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 *默认 NewsMod 的别名为 newsMod
 *@Alias("newsMod") 取别名
 * **/
@Alias("newsMod")
@Setter
@Getter
@Table(name ="news")
public class NewsMod {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="newName")
    private String title;

    @Column(name="newinfo")
    private String content;

    /*association 实体嵌套实体*/
    private NewInfo info;

    /*collection  实体嵌套List*/
    private List<NewInfo> listInfo;
}
