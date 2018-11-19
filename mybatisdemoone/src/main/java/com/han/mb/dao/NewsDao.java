package com.han.mb.dao;

import com.han.mb.entity.News;

import java.util.*;

/**
 * className:NewsDao
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-06 08:22
 */
public interface NewsDao {

    /**
     * 查询新闻列表
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 新增新闻
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 根据新闻标号查询新闻信息
     * @param newsId
     * @return
     */
    Map getById(int newsId);

    /**
     * 更新新闻
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    int delete(int newsId);

    /**
     * 多对一
     * @return
     */
    List<News> manyToOne();
}
