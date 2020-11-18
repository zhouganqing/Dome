package cn.zhou.service;

/**
 * @author zhouganqing
 * @create 2020- 07- 12- 17:50
 */
public class HelloSpring {
    private String who=null;

    public void print()
    {
        System.out.println("Helow,"+this.getWho());
    }

    //aop
    public String print(String _who)
    {
        System.out.println("Helow,"+_who);
        return "Helow,"+_who;
    }


    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
