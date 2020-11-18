package cn.zhou.service;

import cn.zhou.InterFaces.Ink;
import cn.zhou.InterFaces.Paper;

/**
 * @author zhouganqing
 * @create 2020- 07- 12- 18:30
 */
public class Printer {
    //面向接口编程
    private Ink ink;
    private Paper paper;


    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public void print(String str)
    {
        System.out.println("使用"+ink.getColor()+"打印");
        //逐个字符输出到纸上
        for (int i = 0; i < str.length(); i++) {
            paper.putInChar(str.charAt(i));
        }
        System.out.println("每行字数:"+paper.getCharPerLine());
        System.out.println("每页行数:"+paper.getLinePage());
        System.out.println("内容："+paper.getContent());

        throw new RuntimeException("测试程序运行时异常情况下的增强操作");
    }
}
