package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DAOException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserServiceImpl implements UserService{
/**
 * �û�service��ʵ����������ڲ�����Ψһ��ʵ��
 */
	private static UserService userService=new UserServiceImpl() ;
	/**
	 * ���췽��˽�л���private
	 */
	private  UserServiceImpl() {
		
	}
	/**
	 * ȡ���û�serviceʵ��
	 * �ṩ������ʵķ���
	 * @return ʵ������
	 */
	public static UserService getInstance() {
		return userService;
	}
	
		/**
		 * �û���¼
		 * @param name �û���
		 * @param password ����
		 * @return �û���Ϣ
		 */
		public UserVO login(String name, String password) {
			// TODO Auto-generated method stub
			Connection conn=null;
			UserVO user=null;
			
			try {
				//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
				conn=DBUtils.getConnection();
				//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
				UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
				//����dao�е�login���������е�½�����������ֵ����¼�������
				user=userMgrDao.login(name, password);
			} catch (DAOException e) {
				// ���Զ����쳣���׳�
				throw e;
			}catch (Exception e) {
				//���쳣��װ���Զ����쳣���׳�
				throw new ServiceException("�û���¼����",e);
			}finally {
				DBUtils.closeConnection(conn);
			}
		//�����û���¼���
			return user;
		}
	
}
