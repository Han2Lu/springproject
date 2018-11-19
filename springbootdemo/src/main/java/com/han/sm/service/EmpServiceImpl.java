package com.han.sm.service;

import com.han.sm.dao.EmpDao;
import com.han.sm.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-09 16:16
 */
@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> getList(Map map) {
        return empDao.getList(map);
    }

    @Override
    public int add(Emp emp) {
        return empDao.add(emp);
    }

    @Override
    public Map getByNo(int empNo) {
        return empDao.getByNo(empNo);
    }

    @Override
    public int update(Emp emp) {
        return empDao.update(emp);
    }

    @Override
    public int delete(int empNo) {
        return empDao.delete(empNo);
    }

    @Override
    public List<Emp> getProListByDeptNo(Integer deptNo) {
        Map map=new HashMap();
        map.put("deptNo",deptNo);
        //调用了Dao方法之后，map中就会有了一个出参
        empDao.getProListByDeptNo(map);
        //调用返回Object结果,强转为用户列表做返回值
        List<Emp> csrEmp = (List<Emp>) map.get("csrEmp");
        return csrEmp;
    }
}
