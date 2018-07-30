package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;
	/**
	 * 用于用户登录和注册操作
	 * @author 16485
	 *
	 */
public class IndexFrame implements BaseFrame {
	/**
	 * 用户登录和注册界面
	 */
	public void show() {
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			//用户登录注册界面
			System.out.println("欢迎使用Buling的用户管理系统 *00*");
			System.out.println("============================");
			System.out.println("请选择您需要的功能：");
			System.out.println("用户登录---------------------1");
			System.out.println("用户注册---------------------2");
			System.out.println("退出程序---------------------3");
			int i=0;
			
			while(true) {
				
					try {
						//读取用户输入操作选项的数字，同时转换为int型
						i=Integer.parseInt(br.readLine());
						//中断该循环，进行下一步操作：i值判断
						break;
					}catch (Exception e) {
						//出现宜昌市，提示错误信息，再重新输入
						System.out.println("输入错误，只能输入1~3的数字");
						System.out.println("请重新输入");
					}				
			}
			/*
			 * 判断用户输入值，如果值为1，进行用户登陆操作
			 * 值为2，进行注册操作
			 * 值为3，退出系统
			 */
			switch (i) {
			case 1:
				this.loginShow();
				break;
			case 2:
				this.addShow("注册");
				break;
			case 3:
				System.out.println("感谢您的使用，安尼哟~");
				System.exit(0);
			
			default:
				System.out.println("您的操作不正确，请重新输入。");
			}
		}
	}
	
	public void loginShow() {
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户登录界面");
		System.out.println("===========================");	
		
		try {
			//以行为单位，读取输入的各个值，赋值给用户对象的各个属性
			System.out.println("请输入您的用户名：");	
			String name=br.readLine();
			System.out.println("请输入您的密码：");
			String password=br.readLine();
			//调用控制器中的doLogin方法，进行用户登录操作
			UserController uc=new UserController();
			UserVO user=uc.doLogin(name, password);
			if(user!=null) {
				System.out.println("登陆成功！！！");
				System.out.println("=============================");	
				//调用主界面
//				AdminFrame m=new AdminFrame(user);
//				m.loginSuccShow();
				//退出当前界面
				System.exit(0);
			
			}else {
				//登录失败，显示失败信息
				System.out.println("登录失败！！！");	
			}
			
		} catch (Exception e) {
			// 显示异常信息
			System.out.println(e.getMessage());	
		}
	}
	
//	public void addShow(String type) {
//		
//		//声明缓冲处理流对象，用于接收控制台输入的数据
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		if("注册".equals(type)) {
//			System.out.println("用户注册界面");
//			System.out.println("============================");	
//		}else {
//			
//		}
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
//			
//			System.out.println("请输入性别：");
//			user.setSEX(br.readLine());
//			System.out.println("请输入用户密码：");
//			user.setNAME(br.readLine());
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
//			System.out.println("请输入出生日期(yyyy-MM-dd)：");
//			user.setBIRTH(TypeUtils.StringToDate(br.readLine()));
//			//调用控制器中的doRegister方法，进行用户注册操作
//			UserController uc=new UserController();
//			
//			boolean insert=uc.doRegister(user);
//			//如果返回值为真，插入成功，显示成功信息，否则插入失败，显示失败信息
//			if (insert) {
//				if("注册".equals(type)) 
//					System.out.println("用户注册成功");
//				else
//					System.out.println("添加用户成功");
//			}else {
//				if ("注册".equals(type)) 
//					System.out.println("用户注册失败");
//				else 
//					System.out.println("添加用户失败");
//				 }
//	
//		} catch (DateException e) {
//			//显示异常信息
//			if ("注册".equals(type)) 
//				System.out.println("用户注册的时候出错了"+e.getMessage());
//			else 
//				System.out.println("添加用户的时候出错了"+e.getMessage());
//
//		}catch (Exception e) {
//			
//			if ("注册".equals(type)) 
//				System.out.println("用户注册的时候出错了"+e.getMessage());
//			else 
//				System.out.println("添加用户的时候出错了"+e.getMessage());
//
//		}
//		
	
	//}
	
	
	/**
	 * 查询页面
	 */
	public void searchShow() {
		
	};
	/**
	 * 修改页面
	 * @param type
	 * @param user
	 */
	public void updateShow(String type,UserVO user) {
		
	}

	@Override
	public void addShow(String type) {
		// TODO Auto-generated method stub
		
	};
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
