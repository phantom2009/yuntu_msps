package com.hoperun.yuntu_maps.entities;

import javax.validation.constraints.Size;

/**
 *  商圈定义
 */
public class MerchantDefinition {

    private String id;                    //key
    @Size(min = 6,max = 20)
    private String merchantName;            //商圈名称
    private String geoType;                 //几何图形类别，circle,rectangle,polygon之一,es不区分api不区分rectangel与polygen
    private String center;                  //对圆最重要
    private String bounds;                  //多边形以顶点作为几何图形特征参数，圆也能用这个，他会是一条对角线两端的点
    private String area;                    //面积
    private String level;                  //商圈等级
    private String description;             //商圈描述
    private String inputBy;                 //创建人
    private String inputDate;               //创建日期
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getGeoType() {
		return geoType;
	}
	public void setGeoType(String geoType) {
		this.geoType = geoType;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getBounds() {
		return bounds;
	}
	public void setBounds(String bounds) {
		this.bounds = bounds;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInputBy() {
		return inputBy;
	}
	public void setInputBy(String inputBy) {
		this.inputBy = inputBy;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	@Override
	public String toString() {
		return "MerchantDefinition [id=" + id + ", merchantName=" + merchantName + ", geoType=" + geoType + ", center="
				+ center + ", bounds=" + bounds + ", area=" + area + ", level=" + level + ", description=" + description
				+ ", inputBy=" + inputBy + ", inputDate=" + inputDate + "]";
	}
}