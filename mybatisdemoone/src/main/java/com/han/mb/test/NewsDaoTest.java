package com.han.mb.test;

import com.han.mb.dao.NewsDao;
import com.han.mb.entity.News;
import com.han.mb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:NewsDaoTest
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-06 08:31
 */
public class NewsDaoTest {

    @Test
    public void testGetList(){
        SqlSession sqlSession=null;
        try {
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            List<Map> list = newsDao.getList(null);
            for (Map map : list) {
                System.out.println("标题："+map.get("TITLE")+"，内容："+map.get("CONTENT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testAdd(){
        SqlSession sqlSession=null;
        try {
            sqlSession = SqlSessionFactoryUtil.creatSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            Map mapa=new HashMap();
            mapa.put("title","不爱我就拉倒");
            mapa.put("content","不要爱的抱抱");
            mapa.put("typeid",3);
            System.out.println(mapa);
            int add = newsDao.add(mapa);
            sqlSession.commit();
            if(add>0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession=null;
        try {
            sqlSession=SqlSessionFactoryUtil.creatSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            Map map = newsDao.getById(7);
            //System.out.println(map.get("NEWSID"));
            Map mapa=new HashMap();
            mapa.put("title","寒流来了");
            mapa.put("content","刚好可以把你手放外套");
            mapa.put("typeid",1);
            mapa.put("newsid",map.get("NEWSID"));
            int update = newsDao.update(mapa);
            sqlSession.commit();
            if(update>0){
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession=null;
        try {
            sqlSession=SqlSessionFactoryUtil.creatSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            int delete = newsDao.delete(11);
            sqlSession.commit();
            if(delete>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testManyToOne(){
        SqlSession sqlSession=null;
        try {
            sqlSession=SqlSessionFactoryUtil.creatSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            List<News> news=newsDao.manyToOne();
            if(news!=null&&news.size()>0){
                for (News news1 : news) {
                    System.out.println("新闻标题："+news1.getTitle()+"，内容："+news1.getContent()
                    +"，分类名称："+news1.getNewsType().getTypeName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
    }
}
