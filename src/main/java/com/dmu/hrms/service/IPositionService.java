package com.dmu.hrms.service;

import com.dmu.hrms.bean.Dept;
import com.dmu.hrms.bean.Position;
import javafx.geometry.Pos;

import java.util.List;

public interface IPositionService {

    Position getPositionById(Integer id);

    int deletePositionById(Integer id);

    int addPosition(Position position);

    int updatePosition(Position position);

    List<Position> getAllPositions();


}
