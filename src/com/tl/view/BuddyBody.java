package com.tl.view;

public class BuddyBody {
	private int level;
	private int account;
	private String trends;
	private String niks;
	public BuddyBody(int account,int level,String trends)
	{
		this.account=account;
		this.level=level;
		this.trends=trends;
	}
	public String getNiks() {
		return niks;
	}
	public void setNiks(String niks) {
		this.niks = niks;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getTrends() {
		return trends;
	}
	public void setTrends(String trends) {
		this.trends = trends;
	}
	
}
