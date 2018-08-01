package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.util.Vector;

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
			
			Connection conn=null;
			UserVO user=null;
			
			try {
				//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
				conn=DBUtils.getConnection();
				//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
				UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
				//�������ݿ⹤�����beginTransaction��������������
				DBUtils.beginTransaction(conn);
				//����dao�е�login���������е�½�����������ֵ����¼�������
				user=userMgrDao.login(name, password);
				//�������ݿ⹤�����е�commit�������ύ����
				DBUtils.Commit(conn);
			} catch (DAOException e) {
				// ���Զ����쳣���׳�
				throw e;
			}catch (Exception e) {
				DBUtils.rollback(conn);
				//���쳣��װ���Զ����쳣���׳�
				throw new ServiceException("�û���¼����",e);
			}finally {
				DBUtils.closeConnection(conn);
			}
		//�����û���¼���
			return user;
		}
		
		
		public boolean addUser(UserVO user) {
			
			boolean flag=false;
			Connection conn=null;
			
			
			try {
				//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
				conn=DBUtils.getConnection();
				//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
				UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
				//�������ݿ⹤�����beginTransaction��������������
				DBUtils.beginTransaction(conn);
				//����dao�е�addUser���������е�½�����������ֵ����¼�������
				flag=userMgrDao.addUser(user);
				//�������ݿ⹤�����е�commit�������ύ����
				DBUtils.Commit(conn);
			} catch (DAOException e) {
				// ���Զ����쳣���׳�
				throw e;
			}catch (Exception e) {
				DBUtils.rollback(conn);
				//���쳣��װ���Զ����쳣���׳�
				throw new ServiceException("�û�ע��ʧ��",e);
			}finally {
				DBUtils.closeConnection(conn);
			}

			return flag;
			
		}
		@Override
		public Vector<UserVO> findAllUser() {

			Connection conn=null;
			Vector<UserVO> v=null;
			
			try {
				//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
				conn=DBUtils.getConnection();
				//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
				UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
				//�������ݿ⹤�����beginTransaction��������������
				DBUtils.beginTransaction(conn);
				//����dao�е�login���������е�½�����������ֵ����¼�������
				v=userMgrDao.findAllUser();
				//�������ݿ⹤�����е�commit�������ύ����
				DBUtils.Commit(conn);
			} catch (DAOException e) {
				// ���Զ����쳣���׳�
				throw e;
			}catch (Exception e) {
				DBUtils.rollback(conn);
				//���쳣��װ���Զ����쳣���׳�
				throw new ServiceException("��¼ʱ��ѯ���ݳ���",e);
			}finally {
				DBUtils.closeConnection(conn);
			}
		//�����û���¼���
			return v;
		}
		
		
		/**
		 * �����û���Ϣ
		 * @param user
		 * @return ���½��
		 */
	public boolean updateUser(UserVO user) {
		boolean flag=false;
		Connection conn=null;
		
		
		try {
			//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//�������ݿ⹤�����beginTransaction��������������
			DBUtils.beginTransaction(conn);
			//����dao�е�addUser���������е�½�����������ֵ����¼�������
			flag=userMgrDao.updateUser(user);
			//�������ݿ⹤�����е�commit�������ύ����
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// ���Զ����쳣���׳�
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("�û�ע��ʧ��",e);
		}finally {
			DBUtils.closeConnection(conn);
		}

		return flag;
	}
		/**
		 * ɾ���û���Ϣ
		 */
	public boolean deleteUser(int id) {
		boolean flag=false;
		Connection conn=null;
		
		
		try {
			//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//�������ݿ⹤�����beginTransaction��������������
			DBUtils.beginTransaction(conn);
			//����dao�е�addUser���������е�½�����������ֵ����¼�������
			flag=userMgrDao.deleteUser(id);
			//�������ݿ⹤�����е�commit�������ύ����
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// ���Զ����쳣���׳�
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("�û�ע��ʧ��",e);
		}finally {
			DBUtils.closeConnection(conn);
		}

		return flag;
	}
	/**
	 * ����Ų�ѯ
	 */
	public UserVO findUserByid(int userid) {
		Connection conn=null;
		UserVO user=null;
		
		try {
			//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//�������ݿ⹤�����beginTransaction��������������
			DBUtils.beginTransaction(conn);
			//����dao�е�login���������е�½�����������ֵ����¼�������
			user=userMgrDao.findUserByid(userid);
			//�������ݿ⹤�����е�commit�������ύ����
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// ���Զ����쳣���׳�
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("����Ų�ѯ�û�����",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
	//�����û���¼���
		return user;
	}
	/**
	 * ����������
	 */
	public Vector<UserVO> findUserByName(String name) {
		Connection conn=null;
		Vector<UserVO> v=null;
		
		try {
			//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//�������ݿ⹤�����beginTransaction��������������
			DBUtils.beginTransaction(conn);
			//����dao�е�login���������е�½�����������ֵ����¼�������
			v=userMgrDao.findUserByName(name);
			//�������ݿ⹤�����е�commit�������ύ����
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// ���Զ����쳣���׳�
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("��������ѯ���ݳ���",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
	//�����û���¼���
		return v;
	}
	/**
	 * ��ҳ�Ų�ѯ
	 */
	public Vector<UserVO> findUsers(int pageNo, int pageSize) {
		Connection conn=null;
		Vector<UserVO> v=null;
		
		try {
			//�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//�������ݿ⹤�����beginTransaction��������������
			DBUtils.beginTransaction(conn);
			//����dao�е�login���������е�½�����������ֵ����¼�������
			v=userMgrDao.findUsers(pageNo, pageSize);
			//�������ݿ⹤�����е�commit�������ύ����
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// ���Զ����쳣���׳�
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("��ҳ�Ų�ѯ���ݳ���",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
	//�����û���¼���
		return v;
	}
		
		
		
		
		
	
}
