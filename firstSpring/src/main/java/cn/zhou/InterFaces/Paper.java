package cn.zhou.InterFaces;

import java.sql.Statement;

/**
 * @author zhouganqing
 * @create 2020- 07- 12- 18:24
 */
public interface Paper {

    String newline="\r\n";

    /**
     * 输出一个字符到纸张
     *
     * */
    void putInChar(char c);

    /**
     * 获取纸张上的内容
     * */
    String getContent();

    int getCharPerLine();
    int getLinePage();
}
