package com.lingnan.usersys.common.dto;

import java.sql.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

public class UserDTO {

	private int USERID;
	private String NAME;
	private int AGE;
	private Date BIRTH;
	private String SEX;
	private String PASSWORD;
	private int SUPERUSER;
	public int getUSERID() {
		return USERID;
	}
	public void setUSERID(int uSERID) {
		USERID = uSERID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getAGE() {
		return AGE;
	}
	public void setAGE(int aGE) {
		AGE = aGE;
	}
	public Date getBIRTH() {
		return BIRTH;
	}
	public void setBIRTH(Date bIRTH) {
		BIRTH = bIRTH;
	}
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String sEX) {
		SEX = sEX;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getSUPERUSER() {
		return SUPERUSER;
	}
	public void setSUPERUSER(int sUPERUSER) {
		SUPERUSER = sUPERUSER;
	}
}
