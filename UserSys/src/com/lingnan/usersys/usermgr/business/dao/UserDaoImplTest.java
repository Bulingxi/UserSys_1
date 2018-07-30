package com.lingnan.usersys.usermgr.business.dao;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void testLogin() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		UserVO user=new UserVO();
		System.out.println(user=u.login("JACK", "666666"));

	}
	
//	public void testaddUser() {
//		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
//		UserVO user= new UserVO();
//		System.out.println(u.addUser(user));
//		
//	}
	
	
	

}
