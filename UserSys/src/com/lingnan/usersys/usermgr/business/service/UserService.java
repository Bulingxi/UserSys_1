package com.lingnan.usersys.usermgr.business.service;

import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

public interface UserService extends BaseDao{
	/**
	 * �û���¼
	 * @param name �û�����
	 * @param password �û�����
	 * @return ��¼���
	 */
	public UserVO login(String name,String password) ;
	/**
	 * ע���û�/����û�
	 * @param user �û���Ϣ
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean addUser(UserVO user);
	/**
	 * ���������û�
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findAllUser();
		/**
		 * ����Ų����û���Ϣ
		 * @param userid
		 * @return �û���Ϣ
		 */
	public UserVO findUserByid(int userid);
	/**
	 * �����������û���Ϣ
	 * @param name
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findUserByName(String name) ;
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return ���½��
	 */
	public boolean updateUser(UserVO user);
	/**
	 * ɾ���û�
	 * @param id
	 * @return ɾ�����
	 */
	public boolean deleteUser(int id) ;
	/**
	 * ��ҳ�Ų���
	 * @param pageNo
	 * @param pageSize
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findUsers(int pageNo,int pageSize);
	
}
