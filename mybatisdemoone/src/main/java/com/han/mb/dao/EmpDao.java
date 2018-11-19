package com.han.mb.dao;

import java.util.*;

public interface EmpDao {

    /**
     * 获取雇员列表
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 获取雇员列表(choose when otherwise 用法)
     * @param map
     * @return
     */
    List<Map> getListByParam(Map map);

    /**
     * 获取雇员列表(foreach 用法)
     * @param list
     * @return
     */
    List<Map> getListByList(List list);
}
