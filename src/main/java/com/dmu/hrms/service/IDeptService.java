package com.dmu.hrms.service;

import com.dmu.hrms.bean.Dept;
import com.dmu.hrms.bean.Emp;

import java.util.List;

public interface IDeptService {
    Dept getDeptById(Integer id);

    List<Dept> getAllDepts();

    int deleteDeptById(Integer id);

    int addDept(Dept dept);

    int updateDept(Dept dept);

    List<Emp> queryByDept(String name);
}
