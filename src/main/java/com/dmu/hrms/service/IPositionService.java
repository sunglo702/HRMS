package com.dmu.hrms.service;

import com.dmu.hrms.bean.Emp;
import com.dmu.hrms.bean.Position;

import java.util.List;

public interface IPositionService {

    Position getPositionById(Integer id);

    int deletePositionById(Integer id);

    int addPosition(Position position);

    int updatePosition(Position position);

    List<Position> getAllPosition();

    List<Emp> queryByPosition(String name);

}
