package com.hoperun.yuntu_maps.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Point {

	private Integer id;
	@JsonIgnore
	private String uuid;
	@JsonProperty("dateTime")
	private String time;
	@JsonIgnore
	private String eventId;
	@JsonIgnore
	private String province;	
	@JsonIgnore
	private String city;
	@JsonIgnore
	private String district;
	private Double longitude;           //经度
	private Double latitude;            //维度
	@JsonIgnore
	public String location;
	
	public Point() {
		super();
	}	
	public Point(Integer id, String uuid, String time, String eventId, String province, String city, String district,
			Double longitude, Double latitude, String location) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.time = time;
		this.eventId = eventId;
		this.province = province;
		this.city = city;
		this.district = district;
		this.longitude = longitude;
		this.latitude = latitude;
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Double getLongitude() {
		String[] locations=this.getLocation().split(",");
		Double lng=Double.parseDouble(locations[0]);
		return lng;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		String[] locations=this.getLocation().split(",");
		Double lat=Double.parseDouble(locations[1]);
		return lat;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Point [id=" + id + ", uuid=" + uuid + ", time=" + time + ", eventId=" + eventId + ", province="
				+ province + ", city=" + city + ", district=" + district + ", longitude=" + longitude + ", latitude="
				+ latitude + ", location=" + location + "]";
	}
}
