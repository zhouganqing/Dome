package cn.zhougq.untils;

/**
 * @author zhouganqing
 * @create 2020- 07- 30- 15:10
 */
public class BaseType {
    public static boolean IsEmpty(String val)
    {
        if (val==null||val.isEmpty())
        {
            return true;
        }
        return false;
    }
}
