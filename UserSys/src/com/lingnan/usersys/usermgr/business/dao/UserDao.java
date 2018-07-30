package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 
 * @author 16485
 *
 */
public interface UserDao extends BaseDao {
	/**
	 * 用户登录
	 * @param name 用户姓名
	 * @param password 用户密码
	 * @return
	 */
	public UserVO login(String name,String password);
	
	/**
	 * 注册用户/添加用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean addUser(UserVO user) ;
		/**
		 * 查找最大id值
		 * @return 最大id值
		 */
	public int findMaxId();
	/**
	 * 查找所有用户信息
	 * @return 用户信息
	 */
	public Vector<UserVO> findAllUser();
		
	
}
