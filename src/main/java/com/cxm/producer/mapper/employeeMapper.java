package com.cxm.producer.mapper;

import com.cxm.producer.pojo.employeePojo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeeMapper {

    employeePojo findById(String id); //根据id查找
    employeePojo saveAndUpdate(employeePojo pojo);//保存或者更新数据时
    List<employeePojo> findByDate(String createDate);//根据日期查找
    employeePojo delById(String  id);//根据id删除
    List<employeePojo> findByzhengze();//正则查询
    Long count(); //统计查询
}
