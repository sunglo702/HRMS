package com.dmu.hrms.service.impl;

import com.dmu.hrms.bean.Emp;
import com.dmu.hrms.bean.Position;
import com.dmu.hrms.mapper.DeptMapper;
import com.dmu.hrms.mapper.PositionMapper;
import com.dmu.hrms.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Position getPositionById(Integer id) {
        return positionMapper.getPositionById(id);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }

    @Override
    public int deletePositionById(Integer id) {
        return positionMapper.deletePositionById(id);
    }

    @Override
    public int addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public int updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public List<Emp> queryByPosition(String name) {
        return positionMapper.queryByPosition(name);
    }

}
