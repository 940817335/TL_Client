package com.tl.view;

public class GroupEntity {
	private int img;
	private int group;
	private String name;
	private String lable;// Ç©Ãû

	public GroupEntity() {
		// TODO Auto-generated constructor stub
	}

	public GroupEntity(int img, int group,String name, String lable) {
		super();
		this.img = img;
		this.name = name;
		this.lable = lable;
		this.group=group;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "GroupEntity [img=" + img + ", group=" + group + ", name="
				+ name + ", lable=" + lable + "]";
	}


	

}
