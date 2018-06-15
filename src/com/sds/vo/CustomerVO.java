package com.sds.vo;

public class CustomerVO {
	private String id;
	private String pwd;
	private String name;
	ItemVO item;
	public CustomerVO() {
	}
	public CustomerVO(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	public CustomerVO(String id, String pwd, String name, ItemVO item) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.item = item;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ItemVO getItem() {
		return item;
	}
	public void setItem(ItemVO item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", item=" + item + "]";
	}
	
	
}
