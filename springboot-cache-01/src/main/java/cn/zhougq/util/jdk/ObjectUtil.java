package cn.zhougq.util.jdk;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouganqing
 * @create 2020- 09- 14- 19:40
 */
public class ObjectUtil {
    public static void copyProperties(Object source, Object dest) {
        BeanUtils.copyProperties(dest, source);
    }

    public static Object[] toObjectArray(Object source) {
        return ObjectUtils.toObjectArray(source);
    }

    public static boolean isArray(Object obj) {
        return ObjectUtils.isArray(obj);
    }

    public static boolean isEmpty(Object[] array) {
        return ObjectUtils.isEmpty(array);
    }

    public static boolean isEmpty(Object obj) {
        return ObjectUtils.isEmpty(obj);
    }

    public static boolean containsElement(Object[] array, Object element) {
        return ObjectUtils.containsElement(array, element);
    }

    public static boolean equals(Object o1,Object o2) {
        if(o1.equals(o2)) {
            return true;
        }
        return false;
    }
    private static boolean check(Object o) {
        return o == null ? false : true;
    }
    public static Integer parseInt(Object o) {
        if(!check(o)) {
            return null;
        }
        if(o instanceof Integer) {
            return (Integer)o;
        }
        return Integer.parseInt(o.toString());
    }

    public static Long parseLong(Object o){
        if(!check(o)) {
            return null;
        }
        if(o instanceof Long) {
            return (Long)o;
        }
        return Long.parseLong(o.toString());
    }

    public static Short parseShort(Object o) {
        if(!check(o)) {
            return null;
        }
        if(o instanceof Short) {
            return (Short)o;
        }
        return Short.parseShort(o.toString());
    }

    public static Float parseFloat(Object o) {
        if(!check(o)) {
            return null;
        }
        if(o instanceof Float) {
            return (Float)o;
        }
        return Float.parseFloat(o.toString());
    }

    public static Double parseDouble(Object o) {
        if(!check(o)) {
            return null;
        }
        if(o instanceof Double) {
            return (Double)o;
        }
        return Double.parseDouble(o.toString());
    }

    public static Boolean parseBoolean(Object o) {
        if(!check(o)) {
            return null;
        }
        if(o instanceof Boolean) {
            return (Boolean)o;
        }
        return Boolean.parseBoolean(o.toString());
    }

    public static Date parseDate(Object o, String dateFormat) throws Exception {
        if(!check(o)) {
            return null;
        }
        if(o instanceof Date) {
            return (Date)o;
        }
        if(o instanceof Long) {
            return new Date((Long)o);
        }
        if(o instanceof String) {
            return new SimpleDateFormat(dateFormat).parse((String)o);
        }
        throw new Exception("Sorry,I don't know how to parse this value to a date");
    }

    public static <T> void clone(T t1,T t2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{

        Method[] t_methods=t1.getClass().getDeclaredMethods();

        for(Method m:t_methods){
            if(m.getName().startsWith("set")){
                m.invoke(t2, new Object[]{
                        t1.getClass().getMethod(m.getName().replaceFirst("s", "g"), null).invoke(t1, null)
                });
            }
        }
    }
}
