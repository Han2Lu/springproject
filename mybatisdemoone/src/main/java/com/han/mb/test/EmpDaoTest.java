package com.han.mb.test;

import com.han.mb.dao.EmpDao;
import com.han.mb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:EmpDaoTest
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-05 16:49
 */
public class EmpDaoTest {

    @Test
    public void testGetList(){
        SqlSession sqlSession=null;
        try {
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            Map mapa=new HashMap();
            mapa.put("job","CLERK");
            mapa.put("startDate","1981-01-01");
            mapa.put("endDate","1987-01-01");
            List<Map> list = empDao.getList(mapa);
            for (Map map : list) {
                System.out.println("名称："+map.get("ENAME")+"，职位："+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetListByParm(){
        SqlSession sqlSession=null;
        try {
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            Map mapa=new HashMap();
            mapa.put("empNo",7369);
            mapa.put("job","CLERK");
            //mapa.put("startDate","1981-01-01");
            List<Map> list = empDao.getListByParam(mapa);
            for (Map map : list) {
                System.out.println("名称："+map.get("ENAME")+"，职位："+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetListByList(){
        SqlSession sqlSession=null;
        try {
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            List list=new ArrayList();
            list.add(7369);
            list.add(7900);
            list.add(7654);
            list.add(7566);
            List<Map> lists = empDao.getListByList(list);
            for (Map map : lists) {
                System.out.println("名称："+map.get("ENAME")+"，职位："+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
