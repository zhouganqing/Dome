package cn.zhougq.aop;

import cn.zhougq.services.IMonitorable;
import cn.zhougq.until.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author zhouganqing
 * @create 2020- 07- 20- 19:21
 */
public class Interceptor extends DelegatingIntroductionInterceptor implements IMonitorable {

    //保存性能监控功能的开关，通过 ThreadLocal，会让每一个线程都能够单独使用一个状态
    private ThreadLocal<Boolean> monitorStatuses = new ThreadLocal<>();

    @Override
    public void setActive(boolean active) {
        monitorStatuses.set(active);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object obj = null;

        if (monitorStatuses.get() != null && monitorStatuses.get()) {//开启性能监控
            PerformanceMonitor.begin(invocation.getClass().getName() + "." + invocation
                    .getMethod().getName());
            obj = super.invoke(invocation);
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(invocation);
        }
        return obj;
    }
}
