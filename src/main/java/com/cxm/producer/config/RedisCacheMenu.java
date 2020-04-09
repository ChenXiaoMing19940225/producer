package com.cxm.producer.config;

import com.cxm.producer.pojo.menu;
import org.springframework.stereotype.Service;

@Service("redisCacheMenu")
public class RedisCacheMenu extends redisCacheUtilBase <menu> {
    @Override
    protected String getPrefix() {
        return "zhjg:sys:menu:";
    }
}
