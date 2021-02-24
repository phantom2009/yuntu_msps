package com.hoperun.yuntu_maps.mapper;

//import java.util.List;
//import org.apache.ibatis.annotations.Param;
import com.hoperun.yuntu_maps.entities.UserInfo;


public interface UserInfoMapper {
	
	//public void add(@Param(value="userinfo") UserInfo userInfo);

	public UserInfo getUser(Integer id);	
	
	public UserInfo login(UserInfo userInfo);
		
	//public List<UserInfo> getUserInfos(@Param(value = "offset") Integer offset,@Param(value = "limit") Integer limit);
	
}
