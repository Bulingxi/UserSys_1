package com.lingnan.usersys.usermgr.business.dao;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

import org.junit.Test;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void testLogin() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		UserVO user=new UserVO();
		System.out.println("��¼����");
		System.out.println(user=u.login("JACK", "666666"));
		System.out.println();
	}

	@Test
	public void testAddUser() {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
//		
//		try {
//			//ʵ�����û�����
//			UserVO user=new UserVO();
//			//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
//			System.out.println("�������û���ţ�");
//			user.setUSERID(Integer.parseInt(br.readLine()));
//			System.out.println("�������û�����");
//			user.setNAME(br.readLine());
//			System.out.println("���������䣺");
//			user.setAGE(Integer.parseInt(br.readLine()));
//			System.out.println("������������ڣ�");
//			user.setBIRTH(TypeUtils.StringToDate(br.readLine()));
//			System.out.println("�������Ա�");
//			user.setSEX(br.readLine());
//			System.out.println("�������û����룺");
//			user.setPASSWORD(br.readLine());
//			System.out.println("������Ȩ�ޣ�");
//			user.setSUPERUSER(Integer.parseInt(br.readLine()));
//			while(true) {
//				System.out.println("���������䣺");
//				String email=br.readLine();
//				if(TypeUtils.isMail(email)) {
//					user.setMAIL(email);
//					break;
//				}
//			}
//			//�����û��������е�registerUser�����������û�ע�����
//			UserController uc = new UserController();
//			boolean register = uc.doRegister(user);
//			//�������ֵΪtrue��ע��ɹ�����ʾ�ɹ���Ϣ������ע��ʧ�ܣ���ʾʧ����Ϣ
//			if(register){
//				System.out.println("�û�ע��ɹ���");
//			}else{
//				System.out.println("����û�ʧ�ܣ�");
//			}
//		} catch (DateException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		
	}

	@Test
	public void testFindAllUser() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		Vector< UserVO> v = new Vector<UserVO>();
		v=u.findAllUser();
		System.out.println("����ȫ���û���Ϣ��");
		for(UserVO user:v) 
			System.out.println("��ţ� "+user.getUSERID()+"  ������ "+user.getNAME()+"  ���䣺 "+user.getAGE()+"  �������ڣ� "+user.getBIRTH()+"  �Ա� "+user.getSEX()+"  ���룺 "+user.getPASSWORD()+"  Ȩ�ޣ� "+user.getSUPERUSER());
		System.out.println();
	}

	@Test
	public void testFindMaxId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByid() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		UserVO user=new UserVO();
		System.out.println("���û���Ų��ң�");
		System.out.println(user=u.findUserByid(1001));
		System.out.println();
	}
	@Test
	public void testFindUserByName() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		Vector< UserVO> v = new Vector<UserVO>();
		v=u.findUserByName("SMITH");
		for(UserVO user:v) 
			System.out.println("����������------"+"��ţ� "+user.getUSERID()+"  ������ "+user.getNAME()+"  ���䣺 "+user.getAGE()+"  �������ڣ� "+user.getBIRTH()+"  �Ա� "+user.getSEX()+"  ���룺 "+user.getPASSWORD()+"  Ȩ�ޣ� "+user.getSUPERUSER());
		System.out.println();
	}

	@Test
	public void testUpdateUser()  {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
//		
//		try {
//			//ʵ�����û�����
//			UserVO user=new UserVO();
//			//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
//			System.out.println("�������û���ţ�");
//			user.setUSERID(Integer.parseInt(br.readLine()));
//			System.out.println("�������û�����");
//			user.setNAME(br.readLine());
//			System.out.println("���������䣺");
//			user.setAGE(Integer.parseInt(br.readLine()));
//			System.out.println("������������ڣ�");
//			user.setBIRTH(TypeUtils.StringToDate(br.readLine()));
//			System.out.println("�������Ա�");
//			user.setSEX(br.readLine());
//			System.out.println("�������û����룺");
//			user.setPASSWORD(br.readLine());
//			System.out.println("������Ȩ�ޣ�");
//			user.setSUPERUSER(Integer.parseInt(br.readLine()));
//			while(true) {
//				System.out.println("���������䣺");
//				String email=br.readLine();
//				if(TypeUtils.isMail(email)) {
//					user.setMAIL(email);
//					break;
//				}
//			}
//			//�����û��������е�registerUser�����������û�ע�����
//			UserController uc = new UserController();
//			boolean register = uc.updateUser(user);
//			//�������ֵΪtrue��ע��ɹ�����ʾ�ɹ���Ϣ������ע��ʧ�ܣ���ʾʧ����Ϣ
//			if(register){
//				System.out.println("�����û�ע��ɹ���");
//			}else{
//				System.out.println("�����û�ʧ�ܣ�");
//			}
//		} catch (DateException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

	}

	@Test
	public void testDeleteUser() {
//		Scanner input =new Scanner(System.in);
//		UserDaoImpl ua = new UserDaoImpl(DBUtils.getConnection());
//		boolean flag = false;
//		System.out.println("������Ҫɾ����ID��");
//		
//		int ID = input.nextInt();
//		flag = ua.deleteUser(ID);
//		if(flag)
//			System.out.println("ɾ���ɹ���");
//		else
//			System.out.println("ɾ��ʧ�ܣ�");

	}

	@Test
	public void testFindAllVaild() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUsers() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		Vector< UserVO> v = new Vector<UserVO>();
		v=u.findUsers(2, 2);
		System.out.println("��ҳ�Ų����û���Ϣ��");
		for(UserVO user:v) 
			System.out.println("��ţ� "+user.getUSERID()+"  ������ "+user.getNAME()+"  ���䣺 "+user.getAGE()+"  �������ڣ� "+user.getBIRTH()+"  �Ա� "+user.getSEX()+"  ���䣺"+user.getMAIL()+"  ���룺 "+user.getPASSWORD()+"  Ȩ�ޣ� "+user.getSUPERUSER());
		System.out.println();
	}

	@Test
	public void testGetRecordCount() {
		fail("Not yet implemented");
	}

}
