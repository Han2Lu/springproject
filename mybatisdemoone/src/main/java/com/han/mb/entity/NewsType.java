package com.han.mb.entity;

/**
 * className:NewsType
 * discriptoin:新闻分类
 * author:韩愈
 * createTime:2018-11-06 15:56
 */
public class NewsType {

    private Integer typeId;
    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
