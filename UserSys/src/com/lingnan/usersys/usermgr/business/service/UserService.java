package com.lingnan.usersys.usermgr.business.service;

import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

public interface UserService extends BaseDao{
	/**
	 * 用户登录
	 * @param name 用户姓名
	 * @param password 用户密码
	 * @return 登录结果
	 */
	public UserVO login(String name,String password) ;
	/**
	 * 注册用户/添加用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean addUser(UserVO user);
	/**
	 * 查找所有用户
	 * @return 用户信息
	 */
	public Vector<UserVO> findAllUser();
		/**
		 * 按编号查找用户信息
		 * @param userid
		 * @return 用户信息
		 */
	public UserVO findUserByid(int userid);
	/**
	 * 按姓名查找用户信息
	 * @param name
	 * @return 用户信息
	 */
	public Vector<UserVO> findUserByName(String name) ;
	/**
	 * 更新用户信息
	 * @param user
	 * @return 更新结果
	 */
	public boolean updateUser(UserVO user);
	/**
	 * 删除用户
	 * @param id
	 * @return 删除结果
	 */
	public boolean deleteUser(int id) ;
	/**
	 * 按页号查找
	 * @param pageNo
	 * @param pageSize
	 * @return 用户信息
	 */
	public Vector<UserVO> findUsers(int pageNo,int pageSize);
	
}
