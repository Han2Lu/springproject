package com.han.mb.test;

import com.han.mb.dao.DeptDao;
import com.han.mb.entity.Dept;
import com.han.mb.entity.Emp;
import com.han.mb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * className:DeptDaoTest
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-03 16:49
 */
public class DeptDaoTest {

    public static void main(String[] args) {
        //查询
       /* SqlSession sqlSession=null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
            //调用接口中的方法得到数据
            List<Dept> list = deptDao.getList();
            //循环打印结果
            for (Dept dept : list) {
                System.out.println("名称："+dept.getDname()+",位置："+dept.getLoc());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }*/
       //添加
       /* SqlSession sqlSession=null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
            //调用接口中的方法得到数据
            Dept dept=new Dept();
            //dept.setDeptNo(21);
            dept.setDname("开发1部");
            dept.setLoc("21楼");
            int result = deptDao.add(dept);
            //提交事务
            sqlSession.commit();
            if(result>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }*/
       //添加
        /*SqlSession sqlSession=null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
            //调用接口中的方法得到数据
            Dept dept=deptDao.getById(42);
            dept.setDname("开发42部");
            dept.setLoc("42楼");
            int result=deptDao.update(dept);
            //提交事务
            sqlSession.commit();
            if(result>0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }*/
        //删除
        SqlSession sqlSession=null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
            //调用接口中的方法得到数据
            int result=deptDao.delete(42);
            //提交事务
            sqlSession.commit();
            if(result>0){
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
    public void update(){
        SqlSession sqlSession=null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
            //调用接口中的方法得到数据
            Dept dept=deptDao.getById(21);
            dept.setDname("开发42部");
            dept.setLoc("42楼");
            int result=deptDao.update(dept);
            //提交事务
            sqlSession.commit();
            if(result>0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testOneToMany(){
        SqlSession sqlSession=null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFactoryUtil.creatSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper 使用接口和配置文件实例化接口的实现类
            DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
            List<Dept> list=deptDao.oneToMany();
            if(list!=null&&list.size()>0){
                for (Dept dept : list) {
                    System.out.println("部门名称："+dept.getDname()+"，位置："+dept.getLoc());
                    List<Emp> empList=dept.getEmpList();
                    if(empList!=null&&empList.size()>0){
                        System.out.println("该部门的员工如下,共有"+empList.size()+"名员工");
                        for (Emp emp : empList) {
                            System.out.println("----------员工姓名："+emp.getEname()+"，工资："+emp.getSalary()+"，奖金："+emp.getComm());
                        }
                    }else{
                        System.out.println("该部门下没有员工");
                    }
                }
                System.out.println("--------------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(sqlSession!=null)
                 sqlSession.close();
        }
    }

}
