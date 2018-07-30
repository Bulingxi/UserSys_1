package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.common.exception.DAOException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

public  class UserDaoImpl implements UserDao {

	private Connection conn;
	
	/**
	 * ���췽��
	 * @param conn ���ݿ�����
	 */
	public  UserDaoImpl(Connection conn) {
		this.conn=conn;
	}
	
	/**
	 * �û���¼
	 * @param user �û���Ϣ
	 * @return �û���Ϣ
	 */
	public UserVO login(String name, String password) {
		//���������������������ڱ������ݿ��ѯ���
		ResultSet rs = null;
		//����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
		//�����û�����ı���
		UserVO user=null;
		
		try {
			//�������Ӷ����preparestatement�ķ������õ���Ԥ������󣬸�ֵ��Ԥ����������
			prep=conn.prepareStatement("select * from z_user where NAME=? and PASSWORD=? ");
			//�������������setxxx������������ֵ
			prep.setString(1, name);
			prep.setString(2, password);
			//����Ԥ��������executeQuery������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
			rs=prep.executeQuery();
			//�����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ���������
			if(rs.next()) {
				//�����µ��û����󣬸�ֵ���û��������
				user=new UserVO();
				
				user.setUSERID(rs.getInt("userid"));
				user.setNAME(rs.getString("name"));
				user.setAGE(rs.getInt("age"));
				user.setBIRTH(rs.getDate("birth"));
				user.setSEX(rs.getString("sex"));
				user.setPASSWORD(rs.getString("password"));
				user.setSUPERUSER(rs.getInt("superuser"));
			System.out.println(" "+user.getUSERID()+" "+user.getNAME()+" "+user.getPASSWORD());
			}
			//��������쳣������쳣��Ϣ
		} catch (SQLException e) {
			System.out.println("�ڲ����û���ʱ������ˣ�������Ϣ��:"+e.getMessage());
			//���쳣��װ���Զ����쳣
			throw new DAOException("��¼ʱ��ѯ���ݳ���",e);
		}finally {
			//�������ݿ⹤���࣬�رս�����������������
			DBUtils.closeStatement(rs, prep);
		}
	/**
	 * 
	 */
		return user;
	}

	/**
	 * ע���û�/����û�
	 * @param user �û���Ϣ
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean addUser(UserVO user) {
		
				

		
		
		
		
		
		return false;
	}

	
	/**
	 * �������idֵ
	 * @return ���idֵ
	 */
	public int findMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
