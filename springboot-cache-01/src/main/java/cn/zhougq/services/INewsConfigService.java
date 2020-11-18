package cn.zhougq.services;


import cn.zhougq.entitys.NewsInfo;
import org.springframework.cache.annotation.*;

/**
 * @author zhouganqing
 * @create 2020- 09- 05- 19:02
 *
 * 抽取缓存的公共配置
 */

@CacheConfig(cacheNames = "news")
public interface INewsConfigService {

    @Cacheable(key = "#id")
    NewsInfo getNewsById(Integer id);

    @CachePut(key="#newsInfo.id")
    NewsInfo updateNews(NewsInfo newsInfo);

    @CacheEvict(allEntries = true)
    void deleteNewsById(Integer id);

    @Caching(
            cacheable = {
                    @Cacheable(key = "#id")
            },
            put = {
                    @CachePut(key = "result.newinfo"),
                    @CachePut(key = "result.newName")
            }
    )
    NewsInfo getNews(Integer id);
}
