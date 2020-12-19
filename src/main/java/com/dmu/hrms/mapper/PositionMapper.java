package com.dmu.hrms.mapper;

import com.dmu.hrms.bean.Position;
import com.dmu.hrms.bean.Position;

import java.util.List;

public interface PositionMapper {
    //    根据id查询部门
//    @Select("select * from Position where id=#{id}")
    Position getPositionById(Integer id);

    //    查询所有部门
    List<Position> getAllPositions();

    //    根据id删除部门
    int deletePositionById(Integer id);

    //    添加部门
    int addPosition(Position Position);

    //    更新部门
//    @Update("update Position set name=#{name} where id=#{id}")
    int updatePosition(Position Position);

    //List<Position> query(String name);
}
