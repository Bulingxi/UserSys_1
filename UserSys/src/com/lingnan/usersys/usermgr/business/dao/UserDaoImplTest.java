package com.lingnan.usersys.usermgr.business.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void testLogin() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		UserVO user=null;
		System.out.println(user=u.login("JACK", "666666"));
		
		
	}

}
