package com.lingnan.usersys.usermgr.business.service;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

public interface UserService extends BaseDao{

	public UserVO login(String name,String password) ;
	
	
		
	
		
}
