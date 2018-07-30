package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
			System.out.println("��ţ� "+user.getUSERID()+" ������ "+user.getNAME()+" ���䣺 "+user.getAGE()+" �������ڣ� "+user.getBIRTH()+" "+user.getSEX()+" ���룺 "+user.getPASSWORD()+" Ȩ�ޣ� "+user.getSUPERUSER());
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
		return user;
	}

	/**
	 * ע���û�/����û�
	 * @param user �û���Ϣ
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean addUser(UserVO user) {
		
		if(user!=null) {
			boolean flag= false;
			PreparedStatement prep = null;
			int result = -1;
		try {
			prep=conn.prepareStatement("insert into z_user values(?,?,?,?,?,?,?");
			prep.setInt(1, user.getUSERID());
			prep.setString(2, user.getNAME());
			prep.setInt(3, user.getAGE());
			prep.setDate(4, (Date) user.getBIRTH());
			prep.setString(5, user.getSEX());
			prep.setString(6, user.getPASSWORD());
			prep.setInt(7, user.getSUPERUSER());
			
			prep.executeUpdate();
			System.out.println("��ţ� "+user.getUSERID()+" ������ "+user.getNAME()+" ���䣺 "+user.getAGE()+" �������ڣ� "+user.getBIRTH()+" "+user.getSEX()+" ���룺 "+user.getPASSWORD()+" Ȩ�ޣ� "+user.getSUPERUSER());
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("�ڲ����û���ʱ������ˣ�������Ϣ��:"+e.getMessage());
		}finally {
			   try {
				   if(prep!=null) {
				prep.close();
				prep=null;} 
			   } catch (SQLException e) {
				// 
				System.out.println("�ر����ʱ����"+e.getMessage());
				
			       }
			   
			   }
		}
		
		return true;
	}

//	public Vector<UserVO> findAllUser() {
//		
//		
//		
//		
//		
//		
//		
//		return ;
//	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * �������idֵ
	 * @return ���idֵ
	 */
	public int findMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<UserVO> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
