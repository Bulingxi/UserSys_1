package com.lingnan.usersys.usermgr.controller;

import java.util.Vector;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserController {
	//�����û�service�ӿڶ�������ҵ����
	UserService userMgrService = UserServiceImpl.getInstance();
	/**
	 * �û���¼
	 * @param name �û���
	 * @param password ����
	 * @return �û���Ϣ
	 */
	public UserVO doLogin(String name,String password) {
		UserVO user = null;
		try {
			//�����û�service�ӿ��е�login�����������û���¼����
			user=userMgrService.login(name, password);
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println("�û���¼ʱ����"+e.getMessage());
		}
		return user;
	}
	/**
	 * �û�ע�ᡢ���
	 * @param user
	 * @return flag
	 */
	public boolean doRegister(UserVO user) {
		boolean flag=false;
		
		try {
			//�����û�service�ӿ��е�addUser�����������û�ע��/��Ӳ���
			flag=userMgrService.addUser(user);
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println("�û�ע��ʱ����"+e.getMessage());
		}
		return flag;
	}
	
	public Vector<UserVO> doFindAllUser(){
		Vector<UserVO> user = null;
		try {
			//�����û�service�ӿ��е�login�����������û���¼����
			user=userMgrService.findAllUser();
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println("��ѯ����ʱ����"+e.getMessage());
		}
		return user;
	}
	
	public UserVO dofindUserByid(int userid) {
		UserVO user = null;
		try {
			//�����û�service�ӿ��е�login�����������û���¼����
			user=userMgrService.findUserByid(userid);
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println("���û���Ų���ʱ����"+e.getMessage());
		}
		return user;
	}
	
	public Vector<UserVO> doFindUserByName(String name){
		Vector<UserVO> user = null;
		try {
			//�����û�service�ӿ��е�login�����������û���¼����
			user=userMgrService.findUserByName(name);
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println("��ѯ����ʱ����"+e.getMessage());
		}
		return user;
	}
	
	
	public boolean updateUser(UserVO user) {
		boolean flag=false;
		
		try {
			//�����û�service�ӿ��е�addUser�����������û�ע��/��Ӳ���
			flag=userMgrService.updateUser(user);
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println("�����û�ʱ����"+e.getMessage());
		}
		return flag;
	}
	
	
	public boolean deleteUser(int id) {
		boolean flag=false;
		
		try {
			//�����û�service�ӿ��е�addUser�����������û�ע��/��Ӳ���
			flag=userMgrService.deleteUser(id);
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println("�����û�ʱ����"+e.getMessage());
		}
		return flag;
	}
	
	public Vector<UserVO> findUsers(int pageNo,int pageSize){
		Vector<UserVO> user = null;
		try {
			//�����û�service�ӿ��е�login�����������û���¼����
			user=userMgrService.findUsers(pageNo, pageSize);
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println("��ѯ����ʱ����"+e.getMessage());
		}
		return user;
	}
	
	
	
	
	
	
}
