package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

/**
 * ���ݿ⹤����
 * @author 16485
 *
 */

public class DBUtils {
/**
 * ��ȡ���ݿ����ӵķ���
 * @return ���ػ�ȡ�������ݿ�����
 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //ע����������
		
			conn= DriverManager.getConnection//��ȡ���ݿ�����
						("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "123321");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle�����������Ҳ����ˣ���һ���ǲ��Ƕ�Ӧ��jar��û�м��أ�");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("��ȡ���ݿ�����ʱ����SQL������");
			e.printStackTrace();
			}
		return conn;
	}
	/**
	 * ��������
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
		try {
			//���Զ��ύ�����ģʽ��Ϊ��
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// ���쳣��װ���Զ����쳣
			
		}
	}
	
	/**
	 * �ύ����
	 * @param conn
	 */
	public static void Commit(Connection conn) {
		try {
			//�ύ����
			conn.commit();
			//���Զ��ύ�����ģʽ��Ϊ��
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// ���쳣��װ���Զ����쳣
			
		}	
	}
	/**
	 * �ع�����
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			//�ع�����
			conn.rollback();
			//���Զ��ύ�����ģʽ��Ϊ��
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			//���쳣��װ���Զ����쳣
			
		}		
	}
	/**
	 * �ر����ݿ����
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs,Statement stmt) {
		
		
	try {
		//������������Ϊ�գ��رն���
		if(rs!=null) {
			rs.close();
		}
		//�����������Ϊ�գ��رն���
		if(stmt!=null) {
			stmt.close();
		}
	}
	catch (SQLException e) {
		//���쳣��װ���Զ����쳣
		
			}
		}
	
	/**
	 * �ر�����
	 * @param conn 
	 */
		public static void closeConnection(Connection conn) {
			
				try {
					if(conn!=null) {
					conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	}
	
}
