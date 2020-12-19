package com.dmu.hrms.service;

import com.dmu.hrms.bean.Dept;

import java.util.List;

public interface IDeptService {
    Dept getDeptById(Integer id);

    List<Dept> getAllDepts();

    int deleteDeptById(Integer id);

    int addDept(Dept dept);

    int updateDept(Dept dept);

    //List<Dept> query(String name);
}
