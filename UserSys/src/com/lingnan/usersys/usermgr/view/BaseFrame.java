package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

public interface BaseFrame {
	/**
	 * 页面显示
	 */
	public void show();
	/**
	 * 增加用户页面显示	
	 * @param type
	 */
	public void addShow(String type);
	/**
	 * 查询页面
	 */
	public void searchShow();
	/**
	 * 修改页面
	 * @param type
	 * @param user
	 */
	public void updateShow(String type,UserVO user) ;
		
	
	
}
