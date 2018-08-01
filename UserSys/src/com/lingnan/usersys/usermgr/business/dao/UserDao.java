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
	 * @return ��¼���
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
		/**
		 * ���û���Ų����û���Ϣ
		 * @param userid
		 * @return �û���Ϣ
		 */
	public UserVO findUserByid(int userid);
	/**
	 * �����û��������û�
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
	public boolean deleteUser(int id);
	/**
	 * ��ѯ��Ч�û�
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findAllVaild();
	/**
	 * ��ȡָ��ҳ�û�
	 * @param pageNo ҳ��
	 * @param pageSize ҳ���С
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findUsers(int pageNo,int pageSize);
	/**
	 * ��ȡ��¼����
	 * @return ����
	 */
	public int getRecordCount();
	
	
	
	
	
}
