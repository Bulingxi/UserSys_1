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
	 * �û���¼
	 * @param name �û�����
	 * @param password �û�����
	 * @return
	 */
	public UserVO login(String name,String password);
	
	/**
	 * ע���û�/����û�
	 * @param user �û���Ϣ
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean addUser(UserVO user) ;
		/**
		 * �������idֵ
		 * @return ���idֵ
		 */
	public int findMaxId();
	/**
	 * ���������û���Ϣ
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findAllUser();
		
	
}
