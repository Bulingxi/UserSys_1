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
	 * @return 登录结果
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
		/**
		 * 按用户编号查找用户信息
		 * @param userid
		 * @return 用户信息
		 */
	public UserVO findUserByid(int userid);
	/**
	 * 根据用户名查找用户
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
	public boolean deleteUser(int id);
	/**
	 * 查询有效用户
	 * @return 用户信息
	 */
	public Vector<UserVO> findAllVaild();
	/**
	 * 获取指定页用户
	 * @param pageNo 页号
	 * @param pageSize 页面大小
	 * @return 用户信息
	 */
	public Vector<UserVO> findUsers(int pageNo,int pageSize);
	/**
	 * 获取记录数量
	 * @return 数量
	 */
	public int getRecordCount();
	
	
	
	
	
}
