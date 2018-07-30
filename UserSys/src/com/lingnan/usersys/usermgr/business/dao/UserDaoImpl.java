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
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public  UserDaoImpl(Connection conn) {
		this.conn=conn;
	}
	
	/**
	 * 用户登录
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public UserVO login(String name, String password) {
		//声明结果及对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
		//声明用户对象的变量
		UserVO user=null;
		
		try {
			//调用连接对象的preparestatement的方法，得到的预编译对象，赋值给预编译对象变量
			prep=conn.prepareStatement("select * from z_user where NAME=? and PASSWORD=? ");
			//调用与编译对象的setxxx方法，给？赋值
			prep.setString(1, name);
			prep.setString(2, password);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs=prep.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			if(rs.next()) {
				//创建新的用户对象，赋值给用户对象变量
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
			//如果出现异常，输出异常信息
		} catch (SQLException e) {
			System.out.println("在插入用户的时候出错了，错误信息是:"+e.getMessage());
			//将异常封装成自定义异常
			throw new DAOException("登录时查询数据出错",e);
		}finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, prep);
		}
	/**
	 * 
	 */
		return user;
	}

	/**
	 * 注册用户/添加用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean addUser(UserVO user) {
		
				

		
		
		
		
		
		return false;
	}

	
	/**
	 * 查找最大id值
	 * @return 最大id值
	 */
	public int findMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
