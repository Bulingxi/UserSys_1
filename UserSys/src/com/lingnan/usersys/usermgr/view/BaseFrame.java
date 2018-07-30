package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

public interface BaseFrame {
	/**
	 * ҳ����ʾ
	 */
	public void show();
	/**
	 * �����û�ҳ����ʾ	
	 * @param type
	 */
	public void addShow(String type);
	/**
	 * ��ѯҳ��
	 */
	public void searchShow();
	/**
	 * �޸�ҳ��
	 * @param type
	 * @param user
	 */
	public void updateShow(String type,UserVO user) ;
		
	
	
}
