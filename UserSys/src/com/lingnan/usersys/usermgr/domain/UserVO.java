package com.lingnan.usersys.usermgr.domain;

import java.util.Date;

import org.omg.CORBA.PRIVATE_MEMBER;
/**
 * �û���Ϣ��
 * @author 16485
 *
 */
public class UserVO {

	private int USERID;//�û���ţ�����
	private String NAME;//����
	private int AGE;//����
	private Date BIRTH;//��������
	private String SEX;//�Ա�
	private String PASSWORD;//����
	private int SUPERUSER;//Ȩ��
	/**
	 * ��ȡ�û����
	 * @return ���
	 */
	public int getUSERID() {
		return USERID;
	}
	/**
	 * �����û����
	 * @param userid 
	 */
	public void setUSERID(int userid) {
		USERID = userid;
	}
	/**
	 * ��ȡ�û�����
	 * @return ����
	 */
	public String getNAME() {
		return NAME;
	}
	/**
	 * �����û�����
	 * @param name
	 */
	public void setNAME(String name) {
		NAME = name;
	}
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public int getAGE() {
		return AGE;
	}
	/**
	 * ��������
	 * @param age
	 */
	public void setAGE(int age) {
		AGE = age;
	}
	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public Date getBIRTH() {
		return BIRTH;
	}
	/**
	 * ��������
	 * @param birth
	 */
	public void setBIRTH(Date birth) {
		BIRTH = birth;
	}
	/**
	 * ��ȡ�Ա�
	 * @return �Ա�
	 */
	public String getSEX() {
		return SEX;
	}
	/**
	 * �����Ա�
	 * @param sex
	 */
	public void setSEX(String sex) {
		SEX = sex;
	}
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public String getPASSWORD() {
		return PASSWORD;
	}
	/**
	 * ��������
	 * @param password
	 */
	public void setPASSWORD(String password) {
		PASSWORD = password;
	}
	/**
	 * ��ȡȨ��
	 * @return
	 */
	public int getSUPERUSER() {
		return SUPERUSER;
	}
	/**
	 * ����Ȩ��
	 * @param superuser
	 */
	public void setSUPERUSER(int superuser) {
		SUPERUSER = superuser;
	}
}
