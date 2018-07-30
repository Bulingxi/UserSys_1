package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 数据库工具类
 * @author 16485
 *
 */

public class DBUtils {
/**
 * 获取数据库连接的方法
 * @return 返回获取到的数据库连接
 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //注册驱动程序
		
			conn= DriverManager.getConnection//获取数据库连接
						("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "123321");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle的驱动程序找不到了，看一看是不是对应的jar包没有加载？");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("获取数据库连接时出现SQL语句错误");
			e.printStackTrace();
			}
		return conn;
	}
	/**
	 * 开启事务
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
		try {
			//将自动提交事务的模式设为假
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// 将异常封装成自定义异常
			
		}
	}
	
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void Commit(Connection conn) {
		try {
			//提交事务
			conn.commit();
			//将自动提交事务的模式设为真
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// 将异常封装成自定义异常
			
		}	
	}
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			//回滚事务
			conn.rollback();
			//将自动提交事务的模式设为真
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			//将异常封装成自定义异常
			
		}		
	}
	/**
	 * 关闭数据库对象
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs,Statement stmt) {
		
		
	try {
		//如果结果集对象不为空，关闭对象
		if(rs!=null) {
			rs.close();
		}
		//如果声明对象不为空，关闭对象
		if(stmt!=null) {
			stmt.close();
		}
	}
	catch (SQLException e) {
		//将异常封装成自定义异常
		
			}
		}
	
	/**
	 * 关闭连接
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
