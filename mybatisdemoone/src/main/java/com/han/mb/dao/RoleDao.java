package com.han.mb.dao;

import com.han.mb.entity.Role;

import java.util.List;

/**
 * className:RoleDao
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-06 16:58
 */
public interface RoleDao {

    /**
     * 多对多
     * @return
     */
    List<Role> manyToMany();
}
