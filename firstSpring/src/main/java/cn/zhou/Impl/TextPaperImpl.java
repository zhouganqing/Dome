package cn.zhou.Impl;

import cn.zhou.InterFaces.Paper;

/**
 * @author zhouganqing
 * @create 2020- 07- 12- 18:43
 */
public class TextPaperImpl implements Paper {
    //每行字数
    private int charPerLine =8;

    //每页行数
    private int linePage=3;
    //内容
    private  String content ="";

    @Override
    public int getCharPerLine() {
        return charPerLine;
    }

    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }

    @Override
    public int getLinePage() {
        return linePage;
    }

    public void setLinePage(int linePage) {
        this.linePage = linePage;
    }

    @Override
    public void putInChar(char c) {
        content+=c;
    }

    @Override
    public String getContent() {
        return content;
    }

}
