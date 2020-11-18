package cn.zhougq.util;

/**
 * @author zhouganqing
 * @create 2020- 07- 26- 9:53
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
