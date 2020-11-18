package cn.zhougq.redis.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouganqing
 * @create 2020- 09- 14- 19:29
 *
 * 如果是作为项目内部使用,不需要建立Service接口,只需要做静态类即可
 * 如果作为公用jar包，需要创建接口对外使用
 */
public interface RedisService {

    /**
     * hset if exists
     * @param key
     * @param field
     * @param value
     */
    public void hsetx(String key, String field, String value);

    public Set<String> keys(String keyPattern);

    public boolean hdel(String key, String... field);

    Map<String, Object> getObjectMap(String key);

    public Map<String, String> getMapByString(String key);

    public Map<String,Object> getMap(String key);

    public void setMap(String key, Map<String,Object> value);

    public void setHash(String key, Map<String, String> value);

    public Map<String,String> getHash(String key);

    public <T> void setHash(String key, String field, T obj);

    public void delHash(String key, String ... hashKeys);

    /**
     * 删除缓存
     */
    public void del(String... key);

    /**
     * 取得缓存(int)
     */
    public Integer getInt(String key);

    /**
     * 取得缓存(string)
     */
    public String getStr(String key);


    /**
     * 获取旧值设置新值(String)
     */
    String getAndSetStr(String key, String value);

    /**
     * 获取旧值设置新值(String)
     */
    String getAndSetStrByExecute(String key, String value);

    /**
     * 设置字符串值
     * @param key
     * @param value
     */
    void setStr(String key, String value);

    /**
     * 设置字符串值
     * @param key
     * @param value
     * @param timeoutInSec 过期时间，以秒为单位
     */
    void setStr(String key, String value, long timeoutInSec);

    /**
     * 设置字符串值
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    void setStr(String key, String value, long timeout, TimeUnit unit);

    /**
     * 不存在设置值，存在不设置(String)
     */
    Boolean setStrNX(String key, String value);

    /**
     * 取得缓存(string)
     *
     * @param retain 是否保留缓存
     */
    public String getStr(String key, boolean retain);

    /**
     * 获取缓存(获取基本类型请使用此方法获取)
     */
    public <T> T get(String key, Class<T> clazz);

    /**
     * 获取缓存json对象
     */
    public <T> T getJson(String key, Class<T> clazz);

    /**
     * 将value对象以JSON格式写入缓存
     *
     * @param time 默认为秒
     */
    public void setJson(String key, Object value, int time);

    /**
     * 将value对象以JSON格式写入缓存 (默认时间)
     */
    public void setJson(String key, Object value);

    /**
     * 更新key对象field的值
     *
     * @param key 缓存key
     * @param field 缓存对象field
     * @param value 缓存对象field值
     */
    public void setJsonField(String key, String field, String value);

    /**
     * 递减操作
     */
    public Long decr(String key, long by);

    /**
     * 递增操作
     */
    public Long incr(String key, long by);

    /**
     * 递减操作
     */
    public Long decr(String key);

    /**
     * 递增操作
     */
    public Long incr(String key);

    /**
     * 递减操作
     */
    public Double decr(String key, double by);

    /**
     * 递增操作
     */
    public Double incr(String key, double by);

    /**
     * 获取double类型值
     */
    public Double getDouble(String key);

    /**
     * 设置double类型值
     *
     * @param time 秒
     */
    public void setDouble(String key, double value, int time);

    /**
     * 设置double类型值
     */
    public void setDouble(String key, double value);

    /**
     * 设置int类型值
     */
    public void setInt(String key, int value, int time);

    /**
     * 设置int类型值
     */
    public void setInt(String key, int value);

    /**
     * 将map写入缓存
     */
    public void setMap(String key, Map<String, Object> map, int time);

    /**
     * 向key对应的map中添加缓存对象
     */
    public void setMap(String key, String field, String value);

    /**
     * 向key对应的map中添加缓存对象
     */
    public <T> void setMap(String key, String field, T obj);

    /**
     * 获取map缓存中的某个对象
     */
    public <T> T getMapField(String key, String field, Class<T> clazz);


    <T> List<T> getMapLon(String key, String field, Class clazz);

    /**
     * 指定缓存的失效时间
     *
     * @param key 缓存KEY
     * @param time 失效时间(秒)
     */
    public void expire(String key, long time);

    /**
     * 指定秒数key的过期时间
     */
    void expireSecond(String key, long time);

    /**
     * 指定毫秒数key的过期时间
     */
    void expireMsec(String key, long time);

    /**
     * 添加set
     */
    public void strSadd(String key, String... value);

    /**
     * 删除set集合中的对象
     */
    public void srem(String key, String... value);

    /**
     * set重命名
     */
    public void srename(String oldkey, String newkey);

    /**
     * set: Check if set at key contains value.
     * @param key
     * @param value
     * @return
     */
    Boolean sisMember(String key, String value);

    /**
     * <br>ZSet集合:通过key-score写入Redis</br>
     * @param key 键
     * @param score 分数
     * @param value 值
     * @return Boolean
     */
    public Boolean zAdd(String key, double score, String value);

    /**
     *<br>  ZSet集合分页：通过元素index来获取集合区间的元素并做Asc排序操作<br/>
     * @param key 键
     * @param start 开始元素
     * @param end 结束元素
     * @return Set<String>
     * @exception
     */
    public Set<String> zRange(String key, long start, long end);

    /**
     * <br>查询指定key的集合元素数量</br>
     * @param     key 键
     * @return
     * @exception
     */
    public Long zCard(String key);


    /**
     *<br> ZSet集合分页：通过元素index来获取集合区间的元素并做Desc排序操作<br/>
     * @param key 键
     * @param start 开始元素
     * @param end 结束元素
     * @return Set<String>
     * @exception
     */
    public Set<String> zRevRange(String key, long start, long end);


    /**
     * <br>ZSet集合：通过积分来获取集合区间的元素并做Asc排序操作</br>
     * @param key 键
     * @param min 积分上限
     * @param max 积分下限
     * @return Set<String>
     * @exception
     */
    public Set<String> zRangeByScore(String key, double min, double max);

    /**
     * <br>ZSet集合：通过积分来获取集合区间的元素并做Desc排序操作</br>
     * 注：返回集合为HashSet集合
     * @param key 键
     * @param min 积分上限
     * @param max 积分下限
     * @return Set<String>
     * @exception
     */
    public Set<String> zRevRangeByScore(String key, double min, double max);

    /**
     * <br>Hash集合：通过fields批量获取map的值</br>
     *
     * @param key 键
     * @param fields map keys
     * @return List<Long>
     */
    List<Long> hMGetLon(String key, List<String> fields);

    /**
     * <br>Hash集合：通过fields批量获取map的值</br>
     *
     * @param key 键
     * @param fields map keys
     * @return List<Long>
     */
    List hMGet(String key, List fields);

    /**
     * <br>Hash集合：通过map集合批量写入Redis</br>
     *
     * @param key 键
     * @param map map值
     */
    void hMSetLon(String key, Map<String, Long> map);

    /**
     * <br>Hash集合：通过map集合批量写入Redis</br>
     *
     * @param key 键
     * @param map map值
     */
    void hMSet(String key, Map map);

    Set<String> getSet(String key);

    public void addSets(String key, List<String> sets);

    void addSet(String key, Object... value);

    void addSet(String key, List<Long> sets);


    Long getExpire(String key);

    /**
     * 通过订阅发布触发；消息内容无意义；
     * @param channel
     */
    void sendTrigger(String channel);

    /**
     * 发送消息
     * @param channel
     * @param message
     */
    void sendMessage(String channel, Object message);

    /**
     * 某个key是否存在
     *
     * @param key
     * @return
     */
    boolean exists(String key);
    /**
     * 批量删除
     * @param key
     */
    public void batchDel(String key);

    <T> T getHash(String key, String field);
}
