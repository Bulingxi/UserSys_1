package com.lingnan.usersys.usermgr.controller;

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
	

	
	
	
}
