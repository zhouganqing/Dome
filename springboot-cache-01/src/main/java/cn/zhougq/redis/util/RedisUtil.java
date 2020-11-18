package cn.zhougq.redis.util;

import cn.zhougq.constants.GlobalConstants;
import cn.zhougq.util.jdk.CollectionUtil;
import cn.zhougq.util.jdk.IPUtil;
import cn.zhougq.util.jdk.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouganqing
 * @create 2020- 09- 14- 19:16
 * Redis基础操作
 */
//@Service
@Component
public class RedisUtil implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Map<String, Object> getObjectMap(String key) {
        BoundHashOperations<String, String, Object> stringObjectObjectBoundHashOperations = redisTemplate
                .boundHashOps(key);
        return stringObjectObjectBoundHashOperations.entries();
    }

    @Override
    public Map<String, Object> getMap(String key) {
        BoundHashOperations<String, String, Object> stringObjectObjectBoundHashOperations = stringRedisTemplate
                .boundHashOps(key);
        return stringObjectObjectBoundHashOperations.entries();
    }

    @Override
    public Map<String, String> getMapByString(String key) {
        BoundHashOperations<String, String, String> stringObjectObjectBoundHashOperations = stringRedisTemplate
                .boundHashOps(key);
        return stringObjectObjectBoundHashOperations.entries();
    }

    @Override
    public Map<String, String> getHash(String key) {
        BoundHashOperations<String, String, String> stringObjectObjectBoundHashOperations = redisTemplate
                .boundHashOps(key);
        return stringObjectObjectBoundHashOperations.entries();
    }

    @Override
    public void setMap(String key, Map<String, Object> value) {
        redisTemplate.opsForHash().putAll(key, value);
    }


    @Override
    public void setHash(String key, Map<String, String> value) {
        redisTemplate.opsForHash().putAll(key, value);
    }

    @Override
    public <T> void setHash(String key, String field, T obj) {
        redisTemplate.opsForHash().put(key, field, obj);
    }

    @Override
    public <T> T getHash(String key, String field) {
        return (T) redisTemplate.opsForHash().get(key, field);
    }

    @Override
    public void delHash(String key, String... hashKeys) {
        redisTemplate.opsForHash().delete(key, hashKeys);
    }

    @Override
    public void hsetx(String key, String field, String value) {
        Map<String, Object> map = getMap(key);
        if (!map.isEmpty()) {
            stringRedisTemplate.opsForHash().put(key, field, value);
        }
    }

    @Override
    public boolean hdel(String key, String... fields) {
        if (StringUtil.isEmpty(key)) {
            throw new RuntimeException("key is empty");
        }

        if (ArrayUtils.isEmpty(fields)) {
            return true;
        }

        stringRedisTemplate.boundHashOps(key).delete(fields);
        return true;
    }

    @Override
    public void del(String... keys) {
        if (ArrayUtils.isNotEmpty(keys)) {
            if (keys.length == 1) {
                stringRedisTemplate.delete(keys[0]);
            } else {
                stringRedisTemplate.delete(CollectionUtil.arrayToList(keys));
            }
        }
    }

    @Override
    public Integer getInt(String key) {
        String value = stringRedisTemplate.boundValueOps(key).get();
        if (StringUtil.isNotBlank(value)) {
            return Integer.valueOf(value);
        }
        return null;
    }

    @Override
    public String getStr(String key) {
        return stringRedisTemplate.boundValueOps(key).get();
    }

    @Override
    public String getAndSetStr(String key, String value) {
        return stringRedisTemplate.boundValueOps(key).getAndSet(value);
    }

    @Override
    public String getAndSetStrByExecute(String key, String value) {
        return stringRedisTemplate.execute(new SessionCallback<String>() {
            @Override
            public String execute(RedisOperations operations) throws DataAccessException {
                return (String) operations.boundValueOps(key).getAndSet(value);
            }
        });
    }

    @Override
    public void setStr(String key, String value) {
        this.stringRedisTemplate.boundValueOps(key).set(value);
    }

    @Override
    public void setStr(String key, String value, long timeoutInSec) {
        setStr(key, value, timeoutInSec, TimeUnit.SECONDS);
    }

    @Override
    public void setStr(String key, String value, long timeout, TimeUnit unit) {
        this.stringRedisTemplate.boundValueOps(key).set(value, timeout, unit);
    }

    @Override
    public Boolean setStrNX(String key, String value) {

        return stringRedisTemplate.execute(new SessionCallback<Boolean>() {
            @Override
            public Boolean execute(RedisOperations redisOperations) throws DataAccessException {
                return redisOperations.boundValueOps(key).setIfAbsent(value);
            }
        });
    }

    @Override
    public String getStr(String key, boolean retain) {
        String value = stringRedisTemplate.boundValueOps(key).get();
        if (!retain) {
            stringRedisTemplate.delete(key);
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String key, Class<T> clazz) {
        return (T) stringRedisTemplate.boundValueOps(key).get();
    }

    @Override
    public <T> T getJson(String key, Class<T> clazz) {
        return JSONObject.parseObject(stringRedisTemplate.boundValueOps(key).get(), clazz);
    }

    @Override
    public void setJson(String key, Object value, int time) {
        stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(value));
        if (time > 0) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    @Override
    public void setJson(String key, Object value) {
        setJson(key, value, GlobalConstants.ZERO);
    }

    @Override
    public void setJsonField(String key, String field, String value) {
        JSONObject obj = JSON.parseObject(stringRedisTemplate.boundValueOps(key).get());
        obj.put(field, value);
        stringRedisTemplate.opsForValue().set(key, obj.toJSONString());
    }

    @Override
    public Long decr(String key, long by) {
        return stringRedisTemplate.opsForValue().increment(key, -by);
    }

    @Override
    public Long incr(String key, long by) {
        return stringRedisTemplate.opsForValue().increment(key, by);
    }

    @Override
    public Long decr(String key) {
        return stringRedisTemplate.opsForValue().increment(key, -1L);
    }

    @Override
    public Long incr(String key) {
        return stringRedisTemplate.opsForValue().increment(key, 1L);
    }

    @Override
    public Double decr(String key, double by) {
        return stringRedisTemplate.opsForValue().increment(key, -by);
    }

    @Override
    public Double incr(String key, double by) {
        return stringRedisTemplate.opsForValue().increment(key, by);
    }

    @Override
    public Double getDouble(String key) {
        String value = stringRedisTemplate.boundValueOps(key).get();
        if (StringUtil.isNoneBlank(value)) {
            return Double.valueOf(value);
        }
        return 0d;
    }

    @Override
    public void setDouble(String key, double value, int time) {
        stringRedisTemplate.boundValueOps(key).get();
        if (time > 0) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    @Override
    public void setDouble(String key, double value) {
        stringRedisTemplate.boundValueOps(key).get();
    }

    @Override
    public void setInt(String key, int value, int time) {
        stringRedisTemplate.opsForValue().set(key, String.valueOf(value));
        if (time > 0) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    @Override
    public void setInt(String key, int value) {
        stringRedisTemplate.opsForValue().set(key, String.valueOf(value));
    }

    @Override
    public void setMap(String key, Map<String, Object> map, int time) {
        stringRedisTemplate.opsForHash().putAll(key, map);
        if (time > 0) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    @Override
    public void setMap(String key, String field, String value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
    }

    @Override
    public <T> void setMap(String key, String field, T obj) {
        stringRedisTemplate.opsForHash().put(key, field, obj);
    }

    @Override
    public <T> T getMapField(String key, String field, Class<T> clazz) {
        return (T) stringRedisTemplate.boundHashOps(key).get(field);
    }

    @Override
    public <T> List<T> getMapLon(String key, String field, Class clazz) {

        return stringRedisTemplate.execute(new SessionCallback<List<T>>() {
            @Override
            public List<T> execute(RedisOperations redisOperations) throws DataAccessException {
                return redisOperations.boundHashOps(key).multiGet(Arrays.asList(new String[]{field}));
            }
        });
    }

    @Override
    public void expire(String key, long time) {
        if (time > 0) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    @Override
    public void expireSecond(String key, long time) {
        if (time > 0) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    @Override
    public void expireMsec(String key, long time) {
        if (time > 0) {
            stringRedisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void strSadd(String key, String... value) {
        stringRedisTemplate.boundSetOps(key).add(value);
    }

    @Override
    public void srem(String key, String... value) {
        stringRedisTemplate.boundSetOps(key).remove(value);
    }

    @Override
    public void srename(String oldkey, String newkey) {
        stringRedisTemplate.boundSetOps(oldkey).rename(newkey);
    }

    @Override
    public Boolean sisMember(String key, String value) {
        return stringRedisTemplate.opsForSet().isMember(key, value);
    }

    @Override
    public Boolean zAdd(String key, double score, String value) {

        Boolean isSuccess = stringRedisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                Boolean set = stringRedisConnection.zAdd(key, score, value);
                return set;
            }
        });
        return isSuccess == null ? false : isSuccess;
    }

    @Override
    public Set<String> zRange(String key, long start, long end) {

        Set<String> setStr = stringRedisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                Set<String> set = stringRedisConnection.zRange(key, start, end);
                return set;
            }
        });
        return setStr;
    }

    @Override
    public Long zCard(String key) {

        Long count = stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                Long count = stringRedisConnection.zCard(key);
                return count;
            }
        });
        return count;
    }

    @Override
    public Set<String> zRevRange(String key, long start, long end) {
        Set<String> setStr = stringRedisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                Set<String> set = stringRedisConnection.zRevRange(key, start, end);
                return set;
            }
        });
        return setStr;
    }

    @Override
    public Set<String> zRangeByScore(String key, double min, double max) {
        Set<String> setStr = stringRedisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                Set<String> set = stringRedisConnection.zRangeByScore(key, min, max);
                return set;
            }
        });
        return setStr;
    }

    @Override
    public Set<String> zRevRangeByScore(String key, double min, double max) {
        Set<String> setStr = stringRedisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                Set<String> set = stringRedisConnection.zRevRangeByScore(key, min, max);
                return set;
            }
        });
        return setStr;
    }

    @Override
    public List<Long> hMGetLon(String key, List<String> fields) {

        return stringRedisTemplate.execute(new SessionCallback<List<Long>>() {
            @Override
            public List<Long> execute(RedisOperations redisOperations) throws DataAccessException {
                return redisOperations.boundHashOps(key).multiGet(fields);
            }
        });
    }

    @Override
    public List hMGet(String key, List fields) {
        return stringRedisTemplate.execute(new SessionCallback<List<Object>>() {
            @Override
            public List<Object> execute(RedisOperations redisOperations) throws DataAccessException {
                return redisOperations.boundHashOps(key).multiGet(fields);
            }
        });
    }

    @Override
    public void hMSetLon(String key, Map<String, Long> map) {
        stringRedisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public void hMSet(String key, Map map) {
        stringRedisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public Set<String> getSet(String key) {
        return stringRedisTemplate.boundSetOps(key).members();
    }

    public void addSets(String key, List<String> sets) {
        if (CollectionUtil.isNotEmpty(sets)) {
            for (String obj : sets) {
                stringRedisTemplate.opsForSet().add(key, obj);
            }
        }
    }

    @Override
    public void addSet(String key, Object... value) {
        if (ArrayUtils.isNotEmpty(value)) {
            for (Object obj : value) {
                redisTemplate.opsForSet().add(key, obj);
            }
        }
    }

    @Override
    public void addSet(String key, List<Long> sets) {
        if (CollectionUtil.isNotEmpty(sets)) {
            for (Object obj : sets) {
                redisTemplate.opsForSet().add(key, obj);
            }
        }
    }

    @Override
    public Long getExpire(String key) {
        return this.stringRedisTemplate.getExpire(key);
    }

    @Override
    public Set<String> keys(String keyPattern) {
        return redisTemplate.keys(keyPattern);
    }

    @Override
    public void sendTrigger(String channel) {
        String message  = "trigger from " + IPUtil.getLocalIp();
        this.sendMessage(channel, message);
    }

    @Override
    public void sendMessage(String channel, Object message) {
        this.stringRedisTemplate.convertAndSend(channel, message);
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public void batchDel(String key) {
        Set<String> set = stringRedisTemplate.keys(key);
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String keyStr = it.next();
            stringRedisTemplate.delete(keyStr);;
        }
    }
}
