package com.lingnan.usersys.usermgr.controller;

import java.util.Vector;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserController {
	//声明用户service接口对象，用于业务处理
	UserService userMgrService = UserServiceImpl.getInstance();
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO doLogin(String name,String password) {
		UserVO user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.login(name, password);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户登录时出错"+e.getMessage());
		}
		return user;
	}
	/**
	 * 用户注册、添加
	 * @param user
	 * @return flag
	 */
	public boolean doRegister(UserVO user) {
		boolean flag=false;
		
		try {
			//调用用户service接口中的addUser方法，进行用户注册/添加操作
			flag=userMgrService.addUser(user);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户注册时出错"+e.getMessage());
		}
		return flag;
	}
	
	public Vector<UserVO> doFindAllUser(){
		Vector<UserVO> user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.findAllUser();
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("查询数据时出错"+e.getMessage());
		}
		return user;
	}
	
	public UserVO dofindUserByid(int userid) {
		UserVO user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.findUserByid(userid);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("按用户编号查找时出错"+e.getMessage());
		}
		return user;
	}
	
	public Vector<UserVO> doFindUserByName(String name){
		Vector<UserVO> user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.findUserByName(name);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("查询数据时出错"+e.getMessage());
		}
		return user;
	}
	
	
	public boolean updateUser(UserVO user) {
		boolean flag=false;
		
		try {
			//调用用户service接口中的addUser方法，进行用户注册/添加操作
			flag=userMgrService.updateUser(user);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("更新用户时出错"+e.getMessage());
		}
		return flag;
	}
	
	
	public boolean deleteUser(int id) {
		boolean flag=false;
		
		try {
			//调用用户service接口中的addUser方法，进行用户注册/添加操作
			flag=userMgrService.deleteUser(id);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("更新用户时出错"+e.getMessage());
		}
		return flag;
	}
	
	public Vector<UserVO> findUsers(int pageNo,int pageSize){
		Vector<UserVO> user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.findUsers(pageNo, pageSize);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("查询数据时出错"+e.getMessage());
		}
		return user;
	}
	
	
	
	
	
	
}
