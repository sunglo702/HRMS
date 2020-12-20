package com.dmu.hrms.mapper;

import com.dmu.hrms.bean.Position;

import java.util.List;

public interface PositionMapper {
    //    根据id查询岗位
//    @Select("select * from dept where id=#{id}")
    Position getPositionById(Integer id);

    //    查询所有岗位
    List<Position> getAllPosition();

    //    根据id删除岗位
    int deletePositionById(Integer id);

    //    添加岗位
    int addPosition(Position position);

    //    更新岗位
//    @Update("update dept set name=#{name} where id=#{id}")
    int updatePosition(Position position);

    //List<Dept> query(String name);
}
