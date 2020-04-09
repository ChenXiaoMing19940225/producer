package com.cxm.producer.config;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service("redisCacheUtilBase")
public abstract class redisCacheUtilBase <T> extends redisCacheUtil <T>  {


    protected abstract String getPrefix();

    public void cacheOne(String key, T value){
        setCacheObject(key, value);
    }
    public void cacheOne(String key, T value, long timeout){
        setCacheObject(getPrefix()+key, value, timeout);
    }
    public void refreshTimeout(String key, long timeout){
        T t = getCachedValue(key);
        setCacheObject(getPrefix()+key, t, timeout);
    }
    public T getCachedValue(String key){
        return super.getCacheObject(getPrefix()+key);
    }

    public List<T> getValueList(){
        Set<String> keys = super.keys(getPrefix()+"*");
        Iterator<String> itor = keys.iterator();
        List<T> sys = new ArrayList<>();
        while(itor.hasNext()){
            T s = super.getCacheObject(itor.next());
            sys.add(s);
        }
        return sys;
    }

    public boolean isEmpty(){
        Set<String> keys = super.keys(getPrefix()+"*");
        return keys != null && keys.size() > 0 ? false : true;
    }

    public void cacheObject(String key, Object value) {
        setCacheObject(key, value);
    }

}
