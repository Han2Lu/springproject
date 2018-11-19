package com.han.sm.service;

import com.han.sm.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-09 16:15
 */
public interface EmpService {

    /**
     * 员工列表方法
     * @param map
     * @return
     */
    List<Emp> getList(Map map);

    /**
     * 新增
     * @param map
     * @return
     */
    int add(Emp emp);

    /**
     * 根据雇员编号查询雇员信息
     * @param empNo
     * @return
     */
    Map getByNo(int empNo);

    /**
     * 更新雇员信息
     * @param emp
     * @return
     */
    int update(Emp emp);

    /**
     * 删除雇员信息
     * @param empNo
     * @return
     */
    int delete(int empNo);

    /**
     * 调用存储过程，根据部门编号获取人员列表
     * @param deptNo
     * @return
     */
    List<Emp> getProListByDeptNo(Integer deptNo);
}
