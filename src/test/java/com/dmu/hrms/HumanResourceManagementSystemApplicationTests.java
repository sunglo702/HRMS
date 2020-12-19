package com.dmu.hrms;

import com.dmu.hrms.bean.Emp;
import com.dmu.hrms.service.IEmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HumanResourceManagementSystemApplicationTests {

    @Autowired
    IEmpService empService;
    @Test
    void contextLoads() {
        String name = "张三";
        List<Emp> emps = empService.query(name);
        for(Emp emp:emps){
            System.out.println(emp);
        }
    }

}
