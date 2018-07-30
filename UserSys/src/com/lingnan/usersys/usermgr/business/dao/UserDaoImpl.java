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
			System.out.println("编号： "+user.getUSERID()+" 姓名： "+user.getNAME()+" 年龄： "+user.getAGE()+" 出生日期： "+user.getBIRTH()+" "+user.getSEX()+" 密码： "+user.getPASSWORD()+" 权限： "+user.getSUPERUSER());
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
		return user;
	}

	/**
	 * 注册用户/添加用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
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
			System.out.println("编号： "+user.getUSERID()+" 姓名： "+user.getNAME()+" 年龄： "+user.getAGE()+" 出生日期： "+user.getBIRTH()+" "+user.getSEX()+" 密码： "+user.getPASSWORD()+" 权限： "+user.getSUPERUSER());
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("在插入用户的时候出错了，错误信息是:"+e.getMessage());
		}finally {
			   try {
				   if(prep!=null) {
				prep.close();
				prep=null;} 
			   } catch (SQLException e) {
				// 
				System.out.println("关闭语句时出错！"+e.getMessage());
				
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
	 * 查找最大id值
	 * @return 最大id值
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
