package com.cxm.producer.controller;

import com.cxm.producer.TopicProducer;
import com.cxm.producer.config.RedisCacheMenu;
import com.cxm.producer.pojo.employeePojo;
import com.cxm.producer.pojo.menu;
import com.cxm.producer.service.employeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "redis、mongoDB、activeMQ访问测试")
@RestController()
@RequestMapping("/api")
public  class TopicController {

 @Autowired
    TopicProducer topicProducer;
 @Autowired
    employeeService empervice;
 @Autowired
    RedisCacheMenu redisCacheMenu;


    @ApiOperation("activeMQ发送消息接口")
    @ApiImplicitParam(name = "msg",value = "消息内容" ,required = true)
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String publish(@RequestParam(required = true) String msg){
        topicProducer.sendMessage(msg);
        String a="a";
        String b="b";
        if(a==b){
            return "false";
        }
     return "消息已经发布";
}
    @ApiOperation("测试springBoot访问")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 500, message = "内部错误")})
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String publish(){
        return "hellos";
    }

    /**
     * 插入文档
     * @return
     */
    @ApiOperation("mongoDB插入文档接口")
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    @ResponseBody
    public String insertMongodb(){
        employeePojo pojo=new employeePojo("1","chenxiaoming","nan","15","2019-12-13");
        empervice.saveAndUpdate(pojo);
        return "插入成功！";
    }

    /**
     * 正则匹配
     * @return
     */
    @ApiOperation("mongoDB正则匹配接口")
    @RequestMapping(value = "/zhengze",method = RequestMethod.GET)
    @ResponseBody
    public List zhengzepipei(){
        List list=empervice.findByzhengze();
        return list;
    }

    /**
     * 统计数量
     * @return
     */
    @ApiOperation("mongoDB数量统计接口")
    @GetMapping(value = "/count")
    @ResponseBody
    public Long count(){
        Long count=empervice.count();
        return count;
    }

    @ApiOperation("redis存值接口")
    @RequestMapping(value = "/redisTest",method = RequestMethod.GET)
    @ResponseBody
    public String redisCacheTest(){
          menu menu=new menu();
          menu.setId("123456");
          menu.setName("test");
          menu.setPath("/http:path");
          redisCacheMenu.cacheOne("test:sys:menu:",menu);

     return "success";
    }
    @ApiOperation("redis取值接口")
    @RequestMapping(value = "/getRedisTest",method = RequestMethod.GET)
    @ResponseBody
    public String getRedisCacheTest(){
        menu me=redisCacheMenu.getCacheObject("test:sys:menu:");
        return me.getId();
    }

    @ApiOperation("实体类接口测试")
    @RequestMapping(value = "/getmunu",method = RequestMethod.POST)
    @ResponseBody
    public menu test(@RequestBody menu m){
      /* return "id="+m.getId()+",name="+m.getName()+",path"+m.getPath();*/
        return m;
    }
}
