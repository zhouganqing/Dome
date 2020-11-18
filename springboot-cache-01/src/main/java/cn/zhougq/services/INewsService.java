package cn.zhougq.services;

import cn.zhougq.entitys.NewsInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * @author zhouganqing
 * @create 2020- 09- 05- 12:11
 */
public interface INewsService {

    //可以存多个缓存名：{"newsId","newsId2"}  默认参数值==KEY
    /**
    *1、方法之前运行,先判断缓存是否有值,缓存不存在才执行方法
    *2、属性作用：
    *   1、cacheNames：指定缓存组件的名字
    *   2、key：缓存数据使用的key,默认是方法参数的值,
    *          取值方式：#id / root.args[0]
    *   3、KeyGenerator：自定义key组件生成器；key/KeyGenerator 二选一
    *   4、cacheManager：指定缓存管理器;cacheResolver：指定获取解析器
    *   5、condition：符合条件才加入缓存 例如：condition=#id>1    id大于1才加入缓存
    *   6、unless：否定缓存,当条件为true的时候不加入缓存；例：result==null   结果集为null不加入缓存
    *   7、sync：是否使用异步模式,默认false； 当值为true时,unless条件无效
    * redis：
    *   默认使用：SimpleCacheConfiguration
    *   org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
    *   org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
    * */
    @Cacheable(cacheNames = "news" ,key = "#id")
    NewsInfo getNewsById(Integer id);


    /**
    * @CachePut既调用方法,又更新缓存,同步更新修改数据
    * 1、先执行方法,在同步缓存
    * 2、更新的缓存key必须存在,不存在则新建key
    * 3、key: newsInfo.id 或者 result.id(result返回参数实体)
    * */
    @CachePut(value = "news",key="#newsInfo.id")
    NewsInfo updateNews(NewsInfo newsInfo);

    /**
     * @CacheEvict清除缓存
     * allEntries = true 清理news下的所有key缓存,默认false
     * beforeInvocation = true 缓存清除是否在方法执行之前执行,不管方法是否出错,都会清理缓存
     * 默认false：方法执行之后删除缓存，如果方法出现异常,缓存不会清除
     */
    @CacheEvict(value = "news",allEntries = true)
    void deleteNewsById(Integer id);



    /**
     * 多个缓存；cacheable  方法之前执行,有数据不会执行方法
     * put： 方法之后执行,有数据也会执行方法
     * */
    @Caching(
            cacheable = {
                    @Cacheable(value = "news",key = "#id")
            },
            put = {
                    @CachePut(value = "news", key = "result.newinfo"),
                    @CachePut(value = "news", key = "result.newName")
            }
    )
    NewsInfo getNews(Integer id);
}
