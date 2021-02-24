package com.hoperun.yuntu_maps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hoperun.yuntu_maps.entities.JSONBean;
import com.hoperun.yuntu_maps.entities.UserInfo;
import com.hoperun.yuntu_maps.mapper.UserInfoMapper;
import com.hoperun.yuntu_maps.utils.TokenUtil;

@RequestMapping("/user")
@Controller
public class UserInfoController {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public JSONBean get(Integer id) {
		UserInfo userInfo=userInfoMapper.getUser(id);
		if(null!=userInfo) {
			return JSONBean.success().addData(userInfo);
		}else {
			return JSONBean.failure();
		}
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public JSONBean login(@RequestBody UserInfo userInfo) {		
		UserInfo user=userInfoMapper.login(userInfo);
		if(null!=user && !user.getName().equals("")) {
			String token= TokenUtil.sign(userInfo);
			user.setToken(token);   
			return JSONBean.success().addData(user);
		}	
		return JSONBean.failure();
	}	
}
