package cn.zhougq.until;

/**
 * @author zhouganqing
 * @create 2020- 07- 20- 19:31
 */
public class PerformanceMonitor {

    //通过 ThreadLocal，保存与调用线程相关的性能监视信息
    private static ThreadLocal<PerformanceRecord> record=new
            ThreadLocal<PerformanceRecord>();

    /**
     * 开启监视
     * @param method 需要监视的方法
     */
    public static void begin(String method) {
        System.out.println("开启监视...");
        record.set(new PerformanceRecord(method));
    }

    /**
     * 结束监视
     */
    public static void end() {
        System.out.println("结束监视...");
        record.get().print();

    }
}
