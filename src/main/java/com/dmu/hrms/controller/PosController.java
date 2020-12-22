package com.dmu.hrms.controller;

import com.dmu.hrms.bean.*;
import com.dmu.hrms.config.PaginationConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dmu.hrms.service.IDeptService;
import com.dmu.hrms.service.IEmpService;
import com.dmu.hrms.service.INationService;
import com.dmu.hrms.service.IPositionService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PosController {
    @Autowired
    IPositionService positionService;

    @Autowired
    IDeptService deptService;

    @Autowired
    IEmpService empService;

    // 查询所有岗位返回列表页面
    @GetMapping("/positions")
    public String list(Model model,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
        // 放在请求域中
        // thymleaf默认就会拼串
        // classpath:/templates/xxx.html
        if(ObjectUtils.isEmpty(pageNum)){
            pageNum= PaginationConstant.CURRENT_NUM;
        }
        //设置分页(当前页，和每页显示数据条数)
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //查找数据
        List<Position> positions = positionService.getAllPosition();
        //将查找出的结果封装到PageInfo对象中，这个对象包含了 depts集合和关于分页的方法，如下
        //pageInfo.getPageNum();
        //pageInfo.getPages(); 得到总页数
        //pageInfo.getNextPage(); 得到下一页
        //pageInfo.getPrePage(); 得到前一页
        PageInfo<Position> pageInfo=new PageInfo<>(positions);
        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "post/poslist";
    }

    // 来到岗位添加页面
    @GetMapping("/position")
    public String toAddPage(Model model) {
        // 来到添加页面，查出所有的部门，在页面显示
        List<Dept> depts = deptService.getAllDepts();
        model.addAttribute("depts",depts);
        //List<Position> positions=positionService.getAllPositions();
        //model.addAttribute("positions",positions);
        // 查出所有民族
        //List<Nation> nations = nationService.getAllNations();
        // model.addAttribute("nations",nations);
        // 查出所有职位
        //List<Position> positions = positionService.getAllPositions();
        //model.addAttribute("positions",positions);
        return "post/add";
    }

    // 岗位添加
    // SpringMVC 自动将请求参数和入参对象的属性进行一一绑定，要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/position")
    public String addPosition(Position position) {
        positionService.addPosition(position);
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/positions";
    }

    // 来到修改页面，查出当前岗位，在页面显示
    @GetMapping("/position/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model) {
        Position position = positionService.getPositionById(id);
        model.addAttribute("position",position);
        // 页面要显示所有的部门列表
        List<Dept> depts = deptService.getAllDepts();
        model.addAttribute("depts",depts);
        // 回到修改页面（add是一个修改添加二合一的页面）
        return "post/add";
    }

    // 岗位修改，需要提交岗位id
    @PutMapping("/position")
    public String updatePosition(Position position) {
        positionService.updatePosition(position);
        return "redirect:/positions";
    }

    //岗位删除
    @DeleteMapping("/position/{id}")
    public String deletePositionById(@PathVariable("id") Integer id){
        positionService.deletePositionById(id);
        return "redirect:/positions";
    }


    //查询某个岗位
    @PostMapping("/searchByPosition")//提交表单+传回前端的映射
    public String queryByPosition(@RequestParam String name, Model model, @RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        //查找数据
        List<Emp> emps=empService.queryByPosition(name);
        model.addAttribute("emps",emps);//传回前端
        PageInfo<Emp> pageInfo=new PageInfo<>(emps);
        // model.addAttribute("emps",emps);
        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "emp/list";
    }
}
