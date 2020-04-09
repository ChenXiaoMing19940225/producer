package com.cxm.producer.service.impl;


import com.cxm.producer.pojo.employeePojo;
import com.cxm.producer.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class employeeServiceimpl implements employeeService{
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 插入文档
     * @param pojo
     * @return
     */
    @Override
    public employeePojo saveAndUpdate(employeePojo pojo) {
        mongoTemplate.save(pojo);
        return null;
    }

    /**
     * 查询一条收据
     * @param id
     * @return
     */
    @Override
    public employeePojo findById(String id) {
        Query query=new Query(Criteria.where("id").is(id));
        employeePojo pojo=mongoTemplate.findOne(query,employeePojo.class);
        return pojo ;
    }


    /**
     *根据日期批量查询
     * @param createdDate
     * @return
     */
    @Override
    public List<employeePojo> findByDate(String createdDate) {

        Query query=new Query(Criteria.where("createdDate").is(createdDate)).with(Sort.by("Id").ascending()).limit(10);
        new Update().set("key","value"); //添加一个文档成员
        new Update().unset("key"); //删除一个文档成员
        new Update().rename("oldname","newname"); //重命名key
        new Update().currentDate("Date"); //把Date元素对应的值修改为当前时间

        //数组操作
        new Update().addToSet("key","value"); //向数组中新增一个数据(不能重复)
        new Update().addToSet("key").each("1","2","3"); //批量添加数据(不能重复)
        new Update().push("key","value"); //向数组中新增一个数据(可以重复)
        new Update().push("key").each("1","2","3时"); //向数组中批量添加数据(可以重复)
        new Update().pull("key","value");//删除数组中某个元素
        new Update().set("add.1", "updateField"); //把数组下标为1的元素更新
        new Update().set("add.10", "nullBefore"); //如果数组大小小于待更新的索引位置，则索引位置之前的没有的元素置null
        List list=mongoTemplate.find(query,employeePojo.class);
        return list;
    }

    /**
     * 匹配正则表达式
     * @param
     * @return
     */
    @Override
    public List<employeePojo> findByzhengze() {
        Query query=new Query(Criteria.where("name").regex("^zhangsan"));
        //不采用实体类的集合而是采用collectionName
        List list=mongoTemplate.find(query,employeePojo.class,"person");
        return list;
    }

    /**
     * 统计名字为张三的数量
     * @return
     */
    @Override
    public Long count() {
        long count=mongoTemplate.count(new Query(Criteria.where("name").is("zhangsan")),"person");
        return count;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public employeePojo delById(String id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,employeePojo.class);
        return null;
    }
}
