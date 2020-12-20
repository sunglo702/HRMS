package com.dmu.hrms.controller;

import com.dmu.hrms.bean.*;
import com.dmu.hrms.config.PaginationConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dmu.hrms.service.IDeptService;
import com.dmu.hrms.service.IEmpService;
import com.dmu.hrms.service.INationService;
import com.dmu.hrms.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeptController {
    @Autowired
    IDeptService deptService;

    // 查询所有部门返回列表页面
    @GetMapping("/depts")
    public String list(Model model,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
        if(ObjectUtils.isEmpty(pageNum)){
            pageNum= PaginationConstant.CURRENT_NUM;
        }
        //设置分页(当前页，和每页显示数据条数)
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //查找数据
        List<Dept> depts = deptService.getAllDepts();
        //将查找出的结果封装到PageInfo对象中，这个对象包含了 depts集合和关于分页的方法，如下
        //pageInfo.getPageNum();
        //pageInfo.getPages(); 得到总页数
        //pageInfo.getNextPage(); 得到下一页
        //pageInfo.getPrePage(); 得到前一页
        PageInfo<Dept> pageInfo=new PageInfo<>(depts);
        model.addAttribute("pageInfo",pageInfo);
        return "department/deptlist";
    }

    // 来到部门添加页面
    @GetMapping("/dept")
    public String toAddPage(Model model) {
        // 来到添加页面，查出所有的部门，在页面显示
        //List<Dept> depts = deptService.getAllDepts();
        //model.addAttribute("depts",depts);
        // 查出所有民族
        //List<Nation> nations = nationService.getAllNations();
       // model.addAttribute("nations",nations);
        // 查出所有职位
        //List<Position> positions = positionService.getAllPositions();
        //model.addAttribute("positions",positions);
        return "department/add";
    }

    // 部门添加
    // SpringMVC 自动将请求参数和入参对象的属性进行一一绑定，要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/dept")
    public String addDept(Dept dept) {
//        System.out.println("保存的部门信息"+dept);
        // 保存部门
        deptService.addDept(dept);
        // 来到部门列表页面
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/depts";
    }

    // 来到修改页面，查出当前部门，在页面显示
    @GetMapping("/dept/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model) {
        Dept dept = deptService.getDeptById(id);
        model.addAttribute("dept",dept);

        // 页面要显示部门
        //List<Dept> depts = deptService.getAllDepts();
        //model.addAttribute("depts",depts);
        // 回到修改页面（add是一个修改添加二合一的页面）
        return "department/add";
    }

    // 部门修改，需要提交部门id
    @PutMapping("/dept")
    public String updateDept(Dept dept) {
        deptService.updateDept(dept);
        return "redirect:/depts";
    }

    //部门删除
    @DeleteMapping("/dept/{id}")
    public String deleteDeptById(@PathVariable("id") Integer id){
        deptService.deleteDeptById(id);
        return "redirect:/depts";
    }


    // 查询某个部门
    /*@PostMapping("/search")//提交表单+传回前端的映射
    public String queryDept(@RequestParam String name, Model model, @RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        //查找数据
        List<Dept> depts=deptService.query(name);
        model.addAttribute("depts",depts);//传回前端
        PageInfo<Dept> pageInfo=new PageInfo<>(depts);
        // model.addAttribute("emps",emps);
        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "dept/list";
    }*/
}
