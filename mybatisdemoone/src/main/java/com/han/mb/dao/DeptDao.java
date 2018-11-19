package com.han.mb.dao;

import com.han.mb.entity.Dept;

import java.util.List;

public interface DeptDao {

    /**
     * 获取部门列表
     * @return
     */
    List<Dept> getList();

    /**
     * 部门添加
     * @param dept
     * @return
     */
    int add(Dept dept);

    /**
     * 根据部门ID查询部门信息
     * @param deptNo
     * @return
     */
    Dept getById(int deptNo);

    /**
     * 部门更新
     * @param dept
     * @return
     */
    int update(Dept dept);

    /**
     * 部门删除
     * @param deptNo
     * @return
     */
    int delete(int deptNo);

    /**
     * 高级映射（一对多）
     * @return
     */
    List<Dept> oneToMany();
}
