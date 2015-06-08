package com.tl.common;

import java.io.Serializable;

public enum TranObjectType implements Serializable{
	REGISTER, // 注册
	LOGIN, // 用户登录
	LOGOUT, // 用户退出登录
	FRIENDLOGIN, // 好友上线
	FRIENDLOGOUT, // 好友下线
	MESSAGE, // 用户发送消息
	GETOFFMSG,//获取离线消息
	GETOFFGROUPMSG,//获取群消息
	GETOFFTRENDS,//获取动态
	GROUP_MESSAG,//群消息
	TRENDS,
	UNCONNECTED, // 无法连接
	FILE, // 传输文件
	REFRESH, // 刷新
}
