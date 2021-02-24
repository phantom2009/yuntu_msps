package com.hoperun.yuntu_maps.entities;

import java.util.Date;

public class UserInfo {
	
	private Integer id;
	private String name;
	private String password;
	private String realName;
	private Date registerDate;
	private Date birthDay;
	private String picture; 
	private String token;
	
	public UserInfo() {
		super();
	}	
	public UserInfo(Integer id, String name, String password, String realName, Date registerDate, Date birthDay,
			String picture, String token) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.realName = realName;
		this.registerDate = registerDate;
		this.birthDay = birthDay;
		this.picture = picture;
		this.token = token;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}	
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", password=" + password + ", realName=" + realName
				+ ", registerDate=" + registerDate + ", birthDay=" + birthDay + ", picture=" + picture + ", token="
				+ token + "]";
	}
}
