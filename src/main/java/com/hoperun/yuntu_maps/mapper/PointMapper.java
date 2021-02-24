package com.hoperun.yuntu_maps.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoperun.yuntu_maps.entities.Point;

public interface PointMapper {

	public List<Point> getAllPoints(@Param("tableName") String tableName);
	
}
