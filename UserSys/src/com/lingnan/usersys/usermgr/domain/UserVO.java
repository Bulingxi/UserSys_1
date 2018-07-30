package com.lingnan.usersys.usermgr.domain;

import java.util.Date;

import org.omg.CORBA.PRIVATE_MEMBER;
/**
 * 用户信息类
 * @author 16485
 *
 */
public class UserVO {

	private int USERID;//用户编号，主键
	private String NAME;//姓名
	private int AGE;//年龄
	private Date BIRTH;//出生日期
	private String SEX;//性别
	private String PASSWORD;//密码
	private int SUPERUSER;//权限
	/**
	 * 获取用户编号
	 * @return 编号
	 */
	public int getUSERID() {
		return USERID;
	}
	/**
	 * 传入用户编号
	 * @param userid 
	 */
	public void setUSERID(int userid) {
		USERID = userid;
	}
	/**
	 * 获取用户姓名
	 * @return 姓名
	 */
	public String getNAME() {
		return NAME;
	}
	/**
	 * 输入用户姓名
	 * @param name
	 */
	public void setNAME(String name) {
		NAME = name;
	}
	/**
	 * 获取年龄
	 * @return 年龄
	 */
	public int getAGE() {
		return AGE;
	}
	/**
	 * 输入年龄
	 * @param age
	 */
	public void setAGE(int age) {
		AGE = age;
	}
	/**
	 * 获取出生日期
	 * @return 出生日期
	 */
	public Date getBIRTH() {
		return BIRTH;
	}
	/**
	 * 输入日期
	 * @param birth
	 */
	public void setBIRTH(Date birth) {
		BIRTH = birth;
	}
	/**
	 * 获取性别
	 * @return 性别
	 */
	public String getSEX() {
		return SEX;
	}
	/**
	 * 输入性别
	 * @param sex
	 */
	public void setSEX(String sex) {
		SEX = sex;
	}
	/**
	 * 获取密码
	 * @return 密码
	 */
	public String getPASSWORD() {
		return PASSWORD;
	}
	/**
	 * 输入密码
	 * @param password
	 */
	public void setPASSWORD(String password) {
		PASSWORD = password;
	}
	/**
	 * 获取权限
	 * @return
	 */
	public int getSUPERUSER() {
		return SUPERUSER;
	}
	/**
	 * 输入权限
	 * @param superuser
	 */
	public void setSUPERUSER(int superuser) {
		SUPERUSER = superuser;
	}
}
