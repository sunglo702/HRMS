package com.dmu.hrms.service;

import com.dmu.hrms.bean.Empsalary;

import java.util.List;

public interface IEmpsalaryService {
    Empsalary getEmpsalaryById(Integer id);

    List<Empsalary> getAllEmpsalarys();

    List<Empsalary> getAll();

    int deleteEmpsalaryById(Integer id);

    int addEmpsalary(Empsalary empsalary);

    int updateEmpsalary(Empsalary empsalary);

    List<Empsalary> query(String name);
}
