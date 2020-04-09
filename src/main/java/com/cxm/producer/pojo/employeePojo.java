package com.cxm.producer.pojo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
@Document("employee")
public class employeePojo implements Serializable {
    private static final long serialVersionUID = -1094662776033001737L;

    public employeePojo(String id, String name, String sex, String age, String createdDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.createdDate = createdDate;
    }

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("sex")
    private String sex;

    @Field("age")
    private String age;

    @Field("createdDate")
    @CreatedDate
    private String createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}