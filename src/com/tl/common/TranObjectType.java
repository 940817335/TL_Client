package com.tl.common;

import java.io.Serializable;

public enum TranObjectType implements Serializable{
	REGISTER, // ע��
	LOGIN, // �û���¼
	LOGOUT, // �û��˳���¼
	FRIENDLOGIN, // ��������
	FRIENDLOGOUT, // ��������
	MESSAGE, // �û�������Ϣ
	GETOFFMSG,//��ȡ������Ϣ
	GETOFFGROUPMSG,//��ȡȺ��Ϣ
	GETOFFTRENDS,//��ȡ��̬
	GROUP_MESSAG,//Ⱥ��Ϣ
	TRENDS,
	UNCONNECTED, // �޷�����
	FILE, // �����ļ�
	REFRESH, // ˢ��
}
