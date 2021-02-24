package com.hoperun.yuntu_maps.entities;


public class JSONBean {	
	
	//神一样的说明state与status的区别
	//status 指人时暗指相对的地位，指物时相当于 situation。situation 较狭义地指由环境综合决定的特定时间上的状态或情形。 
	//state 人或物存在或所处的状态，和 condition 大体上可以互换使用。condition 指一定的原因/条件或环境所产生的特定情况。
	//以 Recordset 为例
	//Recordset 具有 Status 和 State 属性，说明二者还是有区别的。
	//Recordset.Status 表示进行批处理后，当前记录的情况。结果有：操作被取消，结果未被保存；记录被锁无法保存……。
	//Recordset.State 表示 Recordset 对象是打开的，还是关闭的，还是正在执行异步操作。
	
	private Boolean state;
	private String msg;
	private String code;
	private Object data;
	
	public JSONBean(Boolean state, String msg, String code) {
		super();
		this.state = state;
		this.msg = msg;
		this.code = code;
	}
	public JSONBean(Boolean state, String msg, Object data, String code) {
		super();
		this.state = state;
		this.msg = msg;
		this.data = data;
		this.code = code;
	}
	
	/*********************** getters and setters  ****************************/
	
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	//TODO:成功默认
	public static JSONBean success(){
		return new JSONBean(true, "操作成功", "success");
	}
	//TODO:失败默认
	public static JSONBean failure(){
		return new JSONBean(false, "操作失败", "failure");
	}
	//TODO:添加数据,实例方法
	public JSONBean addData(Object object){
		this.setData(object);
		return this;
	}
	//TODO:添加msg消息,实例方法
	public JSONBean addMsg(String str) {
		this.setMsg(str);
		return this;
	}
	//TODO:添加msg消息,实例方法
	public JSONBean addCode(String str) {
		this.setCode(str);
		return this;
	}
}
