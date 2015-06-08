package com.tl.view;

public class TrendsEntity {
	private int id;
	private int img;
	private String trends;
	private String time;
	private String name;
	
	public TrendsEntity(int img,String trends,String name,String time) {
		this.img=img;
		this.trends=trends;
		this.name=name;
		this.time=time;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public String getTrends() {
		return trends;
	}
	public void setTrends(String trends) {
		this.trends = trends;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
