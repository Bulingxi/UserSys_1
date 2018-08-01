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
	 * @param name �û���Ϣ
	 * @param password ����
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
				user.setMAIL(rs.getString("mail"));
				user.setPASSWORD(rs.getString("password"));
				user.setSUPERUSER(rs.getInt("superuser"));
//				System.out.println("��ţ� "+user.getUSERID());
//				System.out.println("������ "+user.getNAME());
//				System.out.println("���䣺 "+user.getAGE());
//				System.out.println("�������ڣ� "+user.getBIRTH());
//				System.out.println("�Ա� "+user.getSEX());
//				System.out.println("���䣺 "+user.getMAIL());
//				System.out.println("���룺 "+user.getPASSWORD());
//				System.out.println("Ȩ�ޣ� "+user.getSUPERUSER());
				System.out.println();
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
		boolean flag= false;
		if(user!=null) {
			
			PreparedStatement prep = null;
			int result = -1;
		try {
			prep=conn.prepareStatement("insert into z_user values(?,?,?,?,?,?,?,?)");
			prep.setInt(1, user.getUSERID());
			prep.setString(2, user.getNAME());
			prep.setInt(3, user.getAGE());
			prep.setDate(4, new java.sql.Date(user.getBIRTH().getTime()));
			prep.setString(5, user.getSEX());
			prep.setString(6, user.getMAIL());
			prep.setString(7, user.getPASSWORD());
			prep.setInt(8, user.getSUPERUSER());
			
			result=prep.executeUpdate();
			System.out.println("��ţ� "+user.getUSERID());
			System.out.println("������ "+user.getNAME());
			System.out.println("���䣺 "+user.getAGE());
			System.out.println("�������ڣ� "+user.getBIRTH());
			System.out.println("�Ա� "+user.getSEX());
			System.out.println("���䣺 "+user.getMAIL());
			System.out.println("���룺 "+user.getPASSWORD());
			System.out.println("Ȩ�ޣ� "+user.getSUPERUSER());
			if(result>0) {
				return true;
			}else {
				return false;
			}
			
			
		} catch (SQLException e) {
			
			System.out.println("�ڲ����û���ʱ������ˣ�������Ϣ��:"+e.getMessage());
			throw new DAOException("������û���ʱ�������",e);
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
/**
 * ���������û���Ϣ
 */
	public Vector<UserVO> findAllUser() {
		Vector<UserVO> v= new Vector<UserVO>();
		PreparedStatement prep = null;
		ResultSet rs= null;
		 
		try {
			prep=conn.prepareStatement("select * from z_user");
			
			rs=prep.executeQuery();
			//�����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ���������
			while(rs.next()) {
				//�����µ��û����󣬸�ֵ���û��������
				UserVO user=new UserVO();
				
				user.setUSERID(rs.getInt("userid"));
				user.setNAME(rs.getString("name"));
				user.setAGE(rs.getInt("age"));
				user.setBIRTH(rs.getDate("birth"));
				user.setSEX(rs.getString("sex"));
				user.setMAIL(rs.getString("mail"));
				user.setPASSWORD(rs.getString("password"));
				user.setSUPERUSER(rs.getInt("superuser"));
				v.add(user);
//				System.out.println("��ţ� "+user.getUSERID());
//				System.out.println("������ "+user.getNAME());
//				System.out.println("���䣺 "+user.getAGE());
//				System.out.println("�������ڣ� "+user.getBIRTH());
//				System.out.println("�Ա� "+user.getSEX());
//				System.out.println("���䣺 "+user.getMAIL());
//				System.out.println("���룺 "+user.getPASSWORD());
//				System.out.println("Ȩ�ޣ� "+user.getSUPERUSER());	
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
		return v;
	}
	
	
	
	
	
	
	/**
	 * �������idֵ
	 * @return ���idֵ
	 */
	public int findMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ���û���Ų�ѯ
	 */
	public UserVO findUserByid(int userid) {
		//���������������������ڱ������ݿ��ѯ���
		ResultSet rs = null;
		//����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
		//�����û�����ı���
		UserVO user=null;
		
		try {
			//�������Ӷ����preparestatement�ķ������õ���Ԥ������󣬸�ֵ��Ԥ����������
			prep=conn.prepareStatement("select * from z_user where USERID=?");
			//�������������setxxx������������ֵ
			prep.setInt(1, userid);
			
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
				user.setMAIL(rs.getString("mail"));
				user.setPASSWORD(rs.getString("password"));
				user.setSUPERUSER(rs.getInt("superuser"));
				System.out.println("��ţ� "+user.getUSERID());
				System.out.println("������ "+user.getNAME());
				System.out.println("���䣺 "+user.getAGE());
				System.out.println("�������ڣ� "+user.getBIRTH());
				System.out.println("�Ա� "+user.getSEX());
				System.out.println("���䣺 "+user.getMAIL());
				System.out.println("���룺 "+user.getPASSWORD());
				System.out.println("Ȩ�ޣ� "+user.getSUPERUSER());		
				System.out.println();
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
	 * ���û���Ϣ��ѯ
	 */
	public Vector<UserVO> findUserByName(String name) {
		Vector<UserVO> v= new Vector<UserVO>();
		PreparedStatement prep = null;
		ResultSet rs= null;
		 
		try {
			prep=conn.prepareStatement("select * from z_user where NAME=?");
			prep.setString(1, name);
			rs=prep.executeQuery();
			//�����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ���������
			while(rs.next()) {
				//�����µ��û����󣬸�ֵ���û��������
				UserVO user=new UserVO();
				
				user.setUSERID(rs.getInt("userid"));
				user.setNAME(rs.getString("name"));
				user.setAGE(rs.getInt("age"));
				user.setBIRTH(rs.getDate("birth"));
				user.setSEX(rs.getString("sex"));
				user.setMAIL(rs.getString("mail"));
				user.setPASSWORD(rs.getString("password"));
				user.setSUPERUSER(rs.getInt("superuser"));
				v.add(user);
				System.out.println("��ţ� "+user.getUSERID());
				System.out.println("������ "+user.getNAME());
				System.out.println("���䣺 "+user.getAGE());
				System.out.println("�������ڣ� "+user.getBIRTH());
				System.out.println("�Ա� "+user.getSEX());
				System.out.println("���䣺 "+user.getMAIL());
				System.out.println("���룺 "+user.getPASSWORD());
				System.out.println("Ȩ�ޣ� "+user.getSUPERUSER());	
				System.out.println();
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
		return v;
				
	}

	/**
	 * �޸��û���Ϣ
	 */
	public boolean updateUser(UserVO user) {
		boolean flag=false;
		PreparedStatement prep = null;
		ResultSet rs= null;

		try {
			prep=conn.prepareStatement("update z_user set NAME=?,AGE=?,BIRTH=?,SEX=?,MAIL=?,PASSWORD=?,SUPERUSER=? where USERID=?");

			prep.setInt(8, user.getUSERID());
			prep.setString(1, user.getNAME());
			prep.setInt(2, user.getAGE());
			prep.setDate(3, new java.sql.Date(user.getBIRTH().getTime()));
			prep.setString(4, user.getSEX());
			prep.setString(5, user.getMAIL());
			prep.setString(6, user.getPASSWORD());
			prep.setInt(7, user.getSUPERUSER());
			prep.executeUpdate();
			flag=true;
			//��������쳣������쳣��Ϣ
		} catch (SQLException e) {
			System.out.println("�ڸ����û���ʱ������ˣ�������Ϣ��:"+e.getMessage());
			//���쳣��װ���Զ����쳣
			throw new DAOException("�����û���Ϣ����",e);
		}finally {
			//�������ݿ⹤���࣬�رս�����������������
			DBUtils.closeStatement(rs, prep);
		}
		return flag;
	}

	/**
	 * ɾ���û���Ϣ
	 */
	public boolean deleteUser(int id) {
		boolean flag = false;
		PreparedStatement prep = null;
		ResultSet rs=null;
		try {
			prep=conn.prepareStatement("delete from Z_USER where USERID='"+id+"'");
			
			rs=prep.executeQuery();
			flag = true;
		} catch (SQLException e) {
			System.out.println("SQL���������");
			throw new DAOException("����SQL���ʱ���ִ���",e);
		}finally {
			//�������ݿ⹤���࣬�رս�����������������
			DBUtils.closeStatement(rs, prep);
		} 
				
		return flag;
	}

	@Override
	public Vector<UserVO> findAllVaild() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����ҳ��ѯ
	 */
	public Vector<UserVO> findUsers(int pageNo, int pageSize) {
		Vector<UserVO> v= new Vector<UserVO>();
		PreparedStatement prep = null;
		ResultSet rs= null;
		 
		try {
			prep=conn.prepareStatement("select b.* from (select ROWNUM rn,Z_USER.* from Z_USER where ROWNUM<='"+pageNo+"'*'"+pageSize+"')b where rn>('"+pageNo+"'-1)*'"+pageSize+"'");
			
			rs=prep.executeQuery();
			//�����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ���������
			while(rs.next()) {
				//�����µ��û����󣬸�ֵ���û��������
				UserVO user=new UserVO();
				
				user.setUSERID(rs.getInt("userid"));
				user.setNAME(rs.getString("name"));
				user.setAGE(rs.getInt("age"));
				user.setBIRTH(rs.getDate("birth"));
				user.setSEX(rs.getString("sex"));
				user.setMAIL(rs.getString("mail"));
				user.setPASSWORD(rs.getString("password"));
				user.setSUPERUSER(rs.getInt("superuser"));
				v.add(user);
				System.out.println("��ţ� "+user.getUSERID());
				System.out.println("������ "+user.getNAME());
				System.out.println("���䣺 "+user.getAGE());
				System.out.println("�������ڣ� "+user.getBIRTH());
				System.out.println("�Ա� "+user.getSEX());
				System.out.println("���䣺 "+user.getMAIL());
				System.out.println("���룺 "+user.getPASSWORD());
				System.out.println("Ȩ�ޣ� "+user.getSUPERUSER());					
				System.out.println("����������������������������������������������������");
				System.out.println();
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
		return v;
				
	}

	@Override
	public int getRecordCount() {
		
		return 0;
	}


	
}
