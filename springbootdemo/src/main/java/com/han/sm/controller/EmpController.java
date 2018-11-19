package com.han.sm.controller;

import com.han.sm.entity.Emp;
import com.han.sm.service.EmpService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * className:EmpController
 * discriptoin:
 * author:韩愈
 * createTime:2018-11-09 16:20
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
     private EmpService empService;

    private ResourceLoader resourceLoader;

    @Autowired
    public EmpController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @Value("${upload.path}")
    private String filePath;

    private static Map emp;

    /**
     * 跳转上传
     * @return
     */
    @RequestMapping("/toUpload")
    public String toUpload(){
        return "picupload";
    }

    /**
     * 上传方法
     * @param filePic
     * @return
     */
    @RequestMapping("/picUpload")
    public String picUpload(Emp emp,@RequestParam MultipartFile filePic){
        uploadFile(filePic,filePath);
        /*//获取原文件名称
        String originalFilename = filePic.getOriginalFilename();
        //获取原文件名称后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //组装新名称
        String newFileName = UUID.randomUUID() + suffix;
        System.out.println("...."+emp.getEname());
        //创建文件
        File file=new File(filePath,newFileName);
        *//*if(!file.exists()){
            file.mkdirs();//创建父目录
        }*//*
        try {
            //文件读写
            filePic.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return "emplist";
    }

    public String uploadFile(MultipartFile oldfile,String savePath){
        //获取原文件名称
        String originalFilename = oldfile.getOriginalFilename();
        //获取原文件名称后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //组装新名称
        String newFileName = UUID.randomUUID() + suffix;//随机串+后缀
        //创建文件
        File file=new File(filePath,newFileName);
        /*if(!file.exists()){
            file.mkdirs();//创建父目录
        }*/
        try {
            //文件读写
            oldfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }

    /**
     * 文件显示方法
     * @param fileName
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity show(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    /**
     * 跳转查询
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "emplist";
    }

    /**
     * 跳转更新
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(){
        return "update";
    }

    /**
     * 跳转登录
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 员工列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object list(@RequestParam Map map){
        map.put("sort",map.get("sort")==null?"empno":map.get("sort"));
        map.put("order",map.get("order")==null?"asc":map.get("order"));
        return empService.getList(map);
    }

    /**
     * 员工新增
     * @param emp
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public Object addEmp(@RequestBody Emp emp){
        System.out.println(emp);
        int add = empService.add(emp);
        Map map=new HashMap();
        if(add>0){
            map.put("info","添加成功！");
        }else{
            map.put("info","添加失败！");
        }
        return map;
    }

    /**
     *根据ID查询员工
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getByNo")
    public Object getEmpByNo(@RequestParam Map map){
        Object empno = map.get("empno");
        //System.out.println(empno);
        int empNo=0;
        if(!"".equals(empno)&&empno!=null){
            empNo=Integer.valueOf(empno+"");
            System.out.println(empNo);
            emp = empService.getByNo(empNo);
            System.out.println(emp);
        }
        return emp;
    }

    /**
     * 用户更新
     * @param emp
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object updateEmp(@RequestBody Emp emp){
        System.out.println(emp);
        int update = empService.update(emp);
        Map map=new HashMap();
        if(update>0){
            map.put("info","添加成功！");
        }else{
            map.put("info","添加失败！");
        }
        return map;
    }

    /**
     * 员工删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteEmp(@RequestParam Map map){
        Object empno = map.get("empno");
        System.out.println(empno);
        int empNo=0;
        if(!"".equals(empno)&&empno!=null){
            empNo=Integer.valueOf(empno+"");
        }
        System.out.println(empNo);
        int delete = empService.delete(empNo);
        Map mapa=new HashMap();
        if(delete>0){
            mapa.put("info","删除成功！");
        }else{
            mapa.put("info","删除失败！");
        }
        return mapa;
    }

    @RequestMapping("login")
    public String checkLogin(@RequestParam Map map, HttpSession httpSession){
        String user = map.get("user")+"";
        String pwds = map.get("pwd")+"";
        System.out.println(user+pwds);
        int pwd=0;
        if(!"".equals(pwds)&&pwds!=null){
            pwd=Integer.valueOf(pwds);
        }
        if(user.equals("hanyu")&&pwd==123456) {
            httpSession.setAttribute("user",user);
            httpSession.setAttribute("pwd",pwd);
            map.put("info","");
            return "emplist";
        }else{
            map.put("info","用户名或密码输入错误！");
            return "login";
        }
    }

    /**
     * 调用存储过程，根据部门编号获取人员列表
     * @param deptNo
     * @return
     */
    @ResponseBody
    @RequestMapping("/proList")
    public Object getProListByDeptNo(Integer deptNo){
        return  empService.getProListByDeptNo(deptNo);
    }
}
