package com.cxm.producer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "菜单", value = "menu")
public class menu implements Serializable {
    private static final long serialVersionUID = 1100795536777292286L;
    @ApiModelProperty(name = "id",value = "id编码",dataType = "String")
    private String id;
    @ApiModelProperty(name = "name",value = "姓名",dataType = "String")
    private String name;
    @ApiModelProperty(name = "path",value = "路径",dataType = "String")
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
