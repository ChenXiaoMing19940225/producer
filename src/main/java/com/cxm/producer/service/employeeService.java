package com.cxm.producer.service;

import com.cxm.producer.pojo.employeePojo;
import org.hibernate.sql.Select;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface employeeService{

    employeePojo saveAndUpdate(employeePojo pojo);//保存或者更新数据时
    employeePojo findById(String id); //根据id查找
    List<employeePojo> findByDate(String createDate);//根据日期查找
    employeePojo delById(String  id);//根据id删除
    List<employeePojo> findByzhengze();//正则查询
    Long count(); //统计查询
}
