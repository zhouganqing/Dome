package cn.zhougq.util.jdk;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 09- 14- 19:37
 */
public class CollectionUtil {
    public static List arrayToList(Object source) {
        return Arrays.asList(ObjectUtil.toObjectArray(source));
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return CollectionUtils.isNotEmpty(coll);
    }

}
