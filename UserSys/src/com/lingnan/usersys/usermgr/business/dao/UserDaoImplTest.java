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
		System.out.println("登录操作");
		System.out.println(user=u.login("JACK", "666666"));
		System.out.println();
	}

	@Test
	public void testAddUser() {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
//		
//		try {
//			//实例化用户对象
//			UserVO user=new UserVO();
//			//读取输入的各个值，赋值给用户对象的各个属性
//			System.out.println("请输入用户编号：");
//			user.setUSERID(Integer.parseInt(br.readLine()));
//			System.out.println("请输入用户名：");
//			user.setNAME(br.readLine());
//			System.out.println("请输入年龄：");
//			user.setAGE(Integer.parseInt(br.readLine()));
//			System.out.println("请输入出生日期：");
//			user.setBIRTH(TypeUtils.StringToDate(br.readLine()));
//			System.out.println("请输入性别：");
//			user.setSEX(br.readLine());
//			System.out.println("请输入用户密码：");
//			user.setPASSWORD(br.readLine());
//			System.out.println("请输入权限：");
//			user.setSUPERUSER(Integer.parseInt(br.readLine()));
//			while(true) {
//				System.out.println("请输入邮箱：");
//				String email=br.readLine();
//				if(TypeUtils.isMail(email)) {
//					user.setMAIL(email);
//					break;
//				}
//			}
//			//调用用户控制器中的registerUser方法，进行用户注册操作
//			UserController uc = new UserController();
//			boolean register = uc.doRegister(user);
//			//如果返回值为true则注册成功，显示成功信息；否则注册失败，显示失败信息
//			if(register){
//				System.out.println("用户注册成功！");
//			}else{
//				System.out.println("添加用户失败！");
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
		System.out.println("查找全部用户信息：");
		for(UserVO user:v) 
			System.out.println("编号： "+user.getUSERID()+"  姓名： "+user.getNAME()+"  年龄： "+user.getAGE()+"  出生日期： "+user.getBIRTH()+"  性别： "+user.getSEX()+"  密码： "+user.getPASSWORD()+"  权限： "+user.getSUPERUSER());
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
		System.out.println("按用户编号查找：");
		System.out.println(user=u.findUserByid(1001));
		System.out.println();
	}
	@Test
	public void testFindUserByName() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		Vector< UserVO> v = new Vector<UserVO>();
		v=u.findUserByName("SMITH");
		for(UserVO user:v) 
			System.out.println("按姓名查找------"+"编号： "+user.getUSERID()+"  姓名： "+user.getNAME()+"  年龄： "+user.getAGE()+"  出生日期： "+user.getBIRTH()+"  性别： "+user.getSEX()+"  密码： "+user.getPASSWORD()+"  权限： "+user.getSUPERUSER());
		System.out.println();
	}

	@Test
	public void testUpdateUser()  {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
//		
//		try {
//			//实例化用户对象
//			UserVO user=new UserVO();
//			//读取输入的各个值，赋值给用户对象的各个属性
//			System.out.println("请输入用户编号：");
//			user.setUSERID(Integer.parseInt(br.readLine()));
//			System.out.println("请输入用户名：");
//			user.setNAME(br.readLine());
//			System.out.println("请输入年龄：");
//			user.setAGE(Integer.parseInt(br.readLine()));
//			System.out.println("请输入出生日期：");
//			user.setBIRTH(TypeUtils.StringToDate(br.readLine()));
//			System.out.println("请输入性别：");
//			user.setSEX(br.readLine());
//			System.out.println("请输入用户密码：");
//			user.setPASSWORD(br.readLine());
//			System.out.println("请输入权限：");
//			user.setSUPERUSER(Integer.parseInt(br.readLine()));
//			while(true) {
//				System.out.println("请输入邮箱：");
//				String email=br.readLine();
//				if(TypeUtils.isMail(email)) {
//					user.setMAIL(email);
//					break;
//				}
//			}
//			//调用用户控制器中的registerUser方法，进行用户注册操作
//			UserController uc = new UserController();
//			boolean register = uc.updateUser(user);
//			//如果返回值为true则注册成功，显示成功信息；否则注册失败，显示失败信息
//			if(register){
//				System.out.println("更新用户注册成功！");
//			}else{
//				System.out.println("更新用户失败！");
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
//		System.out.println("请输入要删除的ID：");
//		
//		int ID = input.nextInt();
//		flag = ua.deleteUser(ID);
//		if(flag)
//			System.out.println("删除成功！");
//		else
//			System.out.println("删除失败！");

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
		System.out.println("按页号查找用户信息：");
		for(UserVO user:v) 
			System.out.println("编号： "+user.getUSERID()+"  姓名： "+user.getNAME()+"  年龄： "+user.getAGE()+"  出生日期： "+user.getBIRTH()+"  性别： "+user.getSEX()+"  邮箱："+user.getMAIL()+"  密码： "+user.getPASSWORD()+"  权限： "+user.getSUPERUSER());
		System.out.println();
	}

	@Test
	public void testGetRecordCount() {
		fail("Not yet implemented");
	}

}
