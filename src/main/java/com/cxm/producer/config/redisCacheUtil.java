package com.cxm.producer.config;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Service(value ="redisCacheUtil")
public class redisCacheUtil <T> {

    @Resource
    public RedisTemplate redisTemplate;


    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key    缓存的键值
     * @param value    缓存的值
     * @return        缓存的对象
     */
    public <T> ValueOperations<String,T> setCacheObject(String key, T value)
    {
        ValueOperations<String,T> operation = redisTemplate.opsForValue();
        operation.set(key,value);
        return operation;
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key    缓存的键值
     * @param value    缓存的值
     * @return        缓存的对象
     */
    public <T> ValueOperations<String,T> setCacheObject(String key,T value, long timeout)
    {
        ValueOperations<String,T> operation = redisTemplate.opsForValue();
        operation.set(key, value, timeout, TimeUnit.SECONDS);
        return operation;
    }

    /**
     *
     * @param key 缓存键值
     * @return   获取键值对应的数据
     */
    public T getCacheObject(String  key){
        ValueOperations<String,T> operation=redisTemplate.opsForValue();
        return  operation.get(key);
    }

    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public <T> HashOperations<String,String,T> setCacheMap(String key, Map<String,T> dataMap)
    {

        HashOperations hashOperations = redisTemplate.opsForHash();
        if(null != dataMap)
        {
            for (Map.Entry<String, T> entry : dataMap.entrySet()) {
                /*System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  */
                hashOperations.put(key,entry.getKey(),entry.getValue());
            }

        }

        return hashOperations;
    }

    /**
     * 获得缓存的Map
     * @param key
     * @param
     * @return
     */
    public <T> Map<String,T> getCacheMap(String key/*,HashOperations<String,String,T> hashOperation*/)
    {
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }

    /**
     * 缓存List数据
     * @param key        缓存的键值
     * @param dataList    待缓存的List数据
     * @return            缓存的对象
     */
    public <T> ListOperations<String, T> setCacheList(String key, List<T> dataList)
    {
        ListOperations listOperation = redisTemplate.opsForList();
        if(null != dataList)
        {
            for(int i = 0; i < dataList.size(); i ++)
            {
                listOperation.rightPush(key,dataList.get(i));
            }
        }
        return listOperation;
    }
    /**
     * 获得缓存的list对象
     * @param key    缓存的键值
     * @return        缓存键值对应的数据
     */
    public <T> List<T> getCacheList(String key)
    {
        List<T> dataList = new ArrayList<>();
        ListOperations<String,T> listOperation = redisTemplate.opsForList();
        for(int i = 0 ; i < listOperation.size(key) ; i ++)
        {
            dataList.add((T) listOperation.leftPop(key));
        }
        return dataList;
    }


    /**
     * 缓存Set
     * @param key        缓存键值
     * @param dataSet    缓存的数据
     * @return            缓存数据的对象
     */
    public <T> BoundSetOperations<String,T> setCacheSet(String key, Set<T> dataSet)
    {
        BoundSetOperations setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while(it.hasNext())
        {
            setOperation.add(it.next());
        }

        return setOperation;
    }

    /**
     * 获取缓存的Set
     * @param key
     * @return
     */
    public Set <T> geCacheSet(String key){
      Set<T> set = new HashSet<T>();
      BoundSetOperations<String,T>  setOperation=redisTemplate.boundSetOps(key);
        for (int i = 0; i < setOperation.size(); i++) {
            set.add(setOperation.pop());
        }
       return  set;
    }

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 移除缓存
     * @param key
     * @return
     */
    public void removeCache(String key){
        if(exists(key)){
            redisTemplate.delete(key);
        }
    }

    public Set<String> keys(String pattern){
        return redisTemplate.keys(pattern);
    }
}
