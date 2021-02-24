package com.hoperun.yuntu_maps.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hoperun.yuntu_maps.entities.JSONBean;
import com.hoperun.yuntu_maps.entities.Point;
import com.hoperun.yuntu_maps.mapper.PointMapper;

@RequestMapping("/point")
@Controller
public class PointController {

	@Autowired
	private PointMapper pointMapper;
	
	@RequestMapping("/getAllPoints")
	@ResponseBody
	public JSONBean getAllPoints(String tableName) {		
		List<Point> list=pointMapper.getAllPoints(tableName);
		if(list.size()>0) {
			return JSONBean.success().addData(list);
		}
		return JSONBean.failure();
	}
	
	
}
