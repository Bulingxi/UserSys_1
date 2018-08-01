package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 用户用户管理：权限分为普通用户和管理员
 * @author 16485
 *
 */
public class AdminFrame extends NomalFrame {
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user
	 */
	public AdminFrame(UserVO user) {
		super(user);
	}

	public void loginSuccShow() {
		System.out.println("                 欢迎登陆主窗体                         ");
		System.out.println();
		System.out.println("=============================");
		System.out.println();
		System.out.println(uu.getNAME()+"   您好：");
		System.out.println("您的权限是："+uu.getSUPERUSER());
		System.out.println();
		if(uu.getSUPERUSER()==1) {
			this.show();
		}else {
			new NomalFrame(uu).show();
		}	
		
	}
	/**
	 * 管理员功能界面
	 */
	public void show() {
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			//功能界面
			System.out.println("添加用户-----------------------1");
			System.out.println("删除用户-----------------------2");
			System.out.println("修改用户-----------------------3");
			System.out.println("查询用户-----------------------4");
			System.out.println("程序退出-----------------------5");
			int i =0;
			
			while(true) {
				try {
					//读取用户输入操作选项的数字，同时转换为int型
					i=Integer.parseInt(br.readLine());
					//中断该循环，进行下一步操作：i值判断
					break;
				} catch (Exception e) {
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1~5之间的数字");
				}
			}
			/*
			 * 判断用户输入值，如果值为1，进行用户添加用户功能
			 * 值为2，进行删除操作
			 * 值为3，进行修改操作
			 * 值为4，进行查询操作
			 * 退出查询
			 */
		switch (i) {
		case 1:
			this.addShow("添加");
			break;
		case 2:
			deleteShow();
			break;
		case 3:
			this.updateShow("修改", uu);
			break;
		case 4:
			this.searchShow();
			break;
		case 5:
			System.out.println("感谢您的使用，安尼哟~");
			System.exit(0);
		default:
			System.out.println("您的操作不正确，请重新输入。");
		}
	
		}
	
		
	}
	
	private void deleteShow() {
		//声明缓冲处理流对象，用于接收控制台输入的数据
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner input =new Scanner(System.in);	
		//读取输入的各个值，赋值给用户对象的各个属性
		System.out.println("请输入用户编号：");
		try {
			UserVO user=new UserVO();
			 int id= input.nextInt();
			//user.setUSERID(Integer.parseInt(br.readLine()));
			//调用控制器中的doLogin方法，进行用户登录操作
			UserController uc=new UserController();
			boolean delete=uc.deleteUser(id);
			if(delete) {
				System.out.println("删除用户成功！");
			}else {
				System.out.println("删除用户失败！");
			}
		} catch (Exception e) {
			System.out.println("删除用户的时候出错了"+e.getMessage());
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
			
			//读取输入的各个值，赋值给用户对象的各个属性
			System.out.println("请输入用户编号：");
			user.setUSERID(Integer.parseInt(br.readLine()));
			System.out.println("请输入用户名：");
			user.setNAME(br.readLine());
			System.out.println("请输入年龄：");
			user.setAGE(Integer.parseInt(br.readLine()));

			System.out.println("请输入性别：");
			user.setSEX(br.readLine());
			System.out.println("请输入用户密码：");
			user.setPASSWORD(br.readLine());
			System.out.println("请输入权限：");
			user.setSUPERUSER(Integer.parseInt(br.readLine()));
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
			//调用控制器中的updateUser方法，进行用户注册操作
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
			//显示异常信息
			if ("修改".equals(type)) 
				System.out.println("（普通用户）修改用户的时候出错了"+e.getMessage());
			else 
				System.out.println("修改用户的时候出错了"+e.getMessage());

		}
	}	
	/**
	 * 添加用户
	 */
	public void addShow(String type) {
		
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if("添加".equals(type)) {
			System.out.println("============================");
			System.out.println();
			System.out.println("            添加用户界面                     ");
			System.out.println();
			System.out.println("============================");
		}else {
			
		}
		
		try {
			//实例化用户对象
			UserVO user=new UserVO();
			//读取输入的各个值，赋值给用户对象的各个属性
			System.out.println("请输入用户编号：");
			user.setUSERID(Integer.parseInt(br.readLine()));
			System.out.println("请输入用户名：");
			user.setNAME(br.readLine());
			System.out.println("请输入年龄：");
			user.setAGE(Integer.parseInt(br.readLine()));
			
			System.out.println("请输入性别：");
			user.setSEX(br.readLine());
			System.out.println("请输入用户密码：");
			user.setPASSWORD(br.readLine());
			System.out.println("请输入权限：");
			user.setSUPERUSER(Integer.parseInt(br.readLine()));
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
			
			boolean insert=uc.doRegister(user);
			//如果返回值为真，插入成功，显示成功信息，否则插入失败，显示失败信息
			if (insert) {
				if("添加".equals(type)) 
					System.out.println("添加用户成功");
				else
					System.out.println("添加用户成功");
			}else {
				if ("添加".equals(type)) 
					System.out.println("添加用户失败");
				else 
					System.out.println("用户注册失败");
				 }
	
		} catch (DateException e) {
			//显示异常信息
			if ("添加".equals(type)) 
				System.out.println("添加用户的时候出错了"+e.getMessage());
			else 
				System.out.println("用户注册的时候出错了"+e.getMessage());

		}catch (Exception e) {
			//显示异常信息
			if ("添加".equals(type)) 
				System.out.println("添加用户的时候出错了"+e.getMessage());
			else 
				System.out.println("用户注册的时候出错了"+e.getMessage());

		}
	}
	
	
	/**
	 * 查询页面
	 */
	public void searchShow() {
		//查询功能界面
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("==============================");
				System.out.println();
				System.out.println("                   查询用户界面                     ");
				System.out.println();
				System.out.println("==============================");
				
				while(true) {
				System.out.println("查询所有用户信息------------------1");
				System.out.println("按用户编号查找用户-----------------2");
				System.out.println("按用户姓名查找用户-----------------3");
				System.out.println("按页号和页面大小查询----------------4");
				System.out.println("退出查询-------------------------5");
				int i =0;
					
				while(true) {
					try {
						//读取用户输入操作选项的数字，同时转换为int型
						i=Integer.parseInt(br.readLine());
						//中断该循环，进行下一步操作：i值判断
						break;
				} catch (Exception e) {
					//出现异常时，提示错误信息，再重新输入
						System.out.println("输入错误，只能输入1~5之间的数字");
					}
				}
			 /*
			  * 值为1，进行查找所有用户信息
			  * 值为2，进行按用户编号查询
			  * 值为3，进行按用户姓名查询
			  * 值为4，按页号查询
			  * 值为5，退出查询
			  */
				switch (i) {
				case 1:
					findAllUserShow();
					break;
				case 2:
					findUserByIdShow();
					break;
				case 3:
					findUserByNameShow();
					break;
				case 4:
					findUsersShow();
					break;
				case 5:
					show();
					System.out.println();
//					System.exit(0);
				default:
					System.out.println("您的操作不正确，请重新输入。");
				}		
			}
		}
	
	/**
	 * 查询所有用户界面
	 */
	public void findAllUserShow() {
		Vector< UserVO> v = new Vector<UserVO>();
		UserController uc=new UserController();
		v=uc.doFindAllUser();
		
		for(UserVO user:v) {
			System.out.println(user.getUSERID()+"   "+user.getNAME()+"   "+user.getAGE()+"   "+user.getBIRTH()+"   "+user.getSEX()+"   "+user.getPASSWORD()+"   "+user.getSUPERUSER());
		    System.out.println("———————————————————————————————————————————————");
		}	
	}
	/**
	 * 按用户编号查询界面
	 */
	public void findUserByIdShow() {
		//声明缓冲处理流对象，用于接收控制台输入的数据
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner input =new Scanner(System.in);	
			//实例化用户对象
			UserVO user=new UserVO();
			//读取输入的各个值，赋值给用户对象的各个属性
			System.out.println("请输入用户编号：");			
			int userid=input.nextInt();
			System.out.println("您查询的信息如下：");
			//调用控制器中的updateUser方法，进行用户注册操作
			UserController uc=new UserController();
			uc.dofindUserByid(userid);
		
	}
	
	/**
	 * 按用户姓名查询界面
	 */
	public void findUserByNameShow() {
		Scanner input =new Scanner(System.in);	
		//实例化用户对象
		UserVO user=new UserVO();
		//读取输入的各个值，赋值给用户对象的各个属性
		System.out.println("请输入用户姓名：");
		String name =input.nextLine();
		System.out.println("您查询的信息如下：");
		//调用控制器中的updateUser方法，进行用户注册操作
		UserController uc=new UserController();
		uc.doFindUserByName(name);
	}
	/**
	 * 按页号查询界面
	 */
	public void findUsersShow() {
		Scanner input =new Scanner(System.in);	
		//实例化用户对象
		UserVO user=new UserVO();
		//读取输入的各个值，赋值给用户对象的各个属性
		System.out.println("请输入页号：");
		int pagenum=input.nextInt();
		System.out.println("请输入页面大小（每页的用户个数）：");
		int pagesize=input.nextInt();
		System.out.println("您查询的信息如下：");
		System.out.println();
		//调用控制器中的updateUser方法，进行用户注册操作
		UserController uc=new UserController();
		uc.findUsers(pagenum, pagesize);
	}
	
	
}
