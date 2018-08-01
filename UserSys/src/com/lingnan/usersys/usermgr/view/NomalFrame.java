package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDaoImpl;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class NomalFrame extends IndexFrame{
	//用户对象
	UserVO uu = null;
	/**
	 * 带参数的构造器，用户初始化user属性
	 * @param user
	 */
	public NomalFrame(UserVO user) {
		this.uu=user;
	}
	
	/**
	 * 进行用户管理的操作界面和操作结果
	 */
	public void show() {
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("请选择以下功能：");
			System.out.println("修改自己的信息-----------------1");
			System.out.println("查询自己的信息-----------------2");
			System.out.println("程序退出----------------------3");
			int i =0;
			
			while(true) {
				try {
					i=Integer.parseInt(br.readLine());
					break;
				} catch (Exception e) {
					System.out.println("输入错误，只能输入1~3之间的数字");
				}
			}
			/*
			 * 值为1，修改操作
			 * 值为2，查询本人信息操作
			 * 值为3，退出程序
			 */
			switch (i) {
			case 1:
				this.updateShow("修改",uu);
				break;
			case 2:
				this.searchShow();
				break;
			case 3:
				System.out.println("感谢您使用本软件~~");
				System.exit(0);
				break;
			default:
				System.out.println("您输入的数字不正确，只能输入1~3之间的数字，请重新输入");
				break;
			}
		
		}

	}
	
	/**
	 * 修改页面
	 * @param type
	 * @param user
	 */
	public void updateShow(String type,UserVO user) {

		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			//实例化用户对象
			
			user.setUSERID(user.getUSERID());
			//读取输入的各个值，赋值给用户对象的各个属性
//			System.out.println("请输入用户编号：");
//			user.setUSERID(Integer.parseInt(br.readLine()));
			System.out.println("请输入用户名：");
			user.setNAME(br.readLine());
			System.out.println("请输入年龄：");
			user.setAGE(Integer.parseInt(br.readLine()));

			System.out.println("请输入性别：");
			user.setSEX(br.readLine());
			System.out.println("请输入用户密码：");
			user.setPASSWORD(br.readLine());
//			System.out.println("请输入权限：");
//			user.setSUPERUSER(Integer.parseInt(br.readLine()));
			while(true) {
				System.out.println("请输入邮箱：");
				String email=br.readLine();
				if(TypeUtils.isMail(email)) {
					user.setMAIL(email);
					break;
				}
			}
			System.out.println("请输入出生日期(yyyy-MM-dd)：");
			user.setBIRTH(TypeUtils.StringToDate(br.readLine()));
			//调用控制器中的doRegister方法，进行用户注册操作
			UserController uc=new UserController();
			
			boolean update=uc.updateUser(user);
			//如果返回值为真，插入成功，显示成功信息，否则插入失败，显示失败信息
			if (update) {
				if("修改".equals(type)) 
					System.out.println("用户修改成功");
				else
					System.out.println("修改用户成功");
			}else {
				if ("修改".equals(type)) 
					System.out.println("用户修改失败");
				else 
					System.out.println("修改用户失败");
				 }
	
		} catch (DateException e) {
			//显示异常信息
			if ("修改".equals(type)) 
				System.out.println("（普通用户）修改用户的时候出错了"+e.getMessage());
			else 
				System.out.println("修改用户的时候出错了"+e.getMessage());

		}catch (Exception e) {
			
			if ("修改".equals(type)) 
				System.out.println("（普通用户）修改用户的时候出错了"+e.getMessage());
			else 
				System.out.println("修改用户的时候出错了"+e.getMessage());

		}
	}	
	/**
	 * 查询自己的信息界面
	 */
	public void searchShow() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		UserVO user=new UserVO();
		System.out.println("您的信息如下：");
		System.out.println();
		user=u.findUserByid(uu.getUSERID());
		System.out.println();
	}
	
	
	
	
	
}
