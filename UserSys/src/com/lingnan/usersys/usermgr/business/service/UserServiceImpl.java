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
 * 用户service类实例，在类的内部创建唯一的实例
 */
	private static UserService userService=new UserServiceImpl() ;
	/**
	 * 构造方法私有化，private
	 */
	private  UserServiceImpl() {
		
	}
	/**
	 * 取得用户service实例
	 * 提供对外访问的方法
	 * @return 实例对象
	 */
	public static UserService getInstance() {
		return userService;
	}
	
		/**
		 * 用户登录
		 * @param name 用户名
		 * @param password 密码
		 * @return 用户信息
		 */
		public UserVO login(String name, String password) {
			
			Connection conn=null;
			UserVO user=null;
			
			try {
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn=DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				//调用dao中的login方法，进行登陆操作，结果赋值给登录结果变量
				user=userMgrDao.login(name, password);
				//调用数据库工具类中的commit方法，提交事务
				DBUtils.Commit(conn);
			} catch (DAOException e) {
				// 将自定义异常并抛出
				throw e;
			}catch (Exception e) {
				DBUtils.rollback(conn);
				//将异常封装成自定义异常并抛出
				throw new ServiceException("用户登录错误",e);
			}finally {
				DBUtils.closeConnection(conn);
			}
		//返回用户登录结果
			return user;
		}
		
		
		public boolean addUser(UserVO user) {
			
			boolean flag=false;
			Connection conn=null;
			
			
			try {
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn=DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				//调用dao中的addUser方法，进行登陆操作，结果赋值给登录结果变量
				flag=userMgrDao.addUser(user);
				//调用数据库工具类中的commit方法，提交事务
				DBUtils.Commit(conn);
			} catch (DAOException e) {
				// 将自定义异常并抛出
				throw e;
			}catch (Exception e) {
				DBUtils.rollback(conn);
				//将异常封装成自定义异常并抛出
				throw new ServiceException("用户注册失败",e);
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
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn=DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				//调用dao中的login方法，进行登陆操作，结果赋值给登录结果变量
				v=userMgrDao.findAllUser();
				//调用数据库工具类中的commit方法，提交事务
				DBUtils.Commit(conn);
			} catch (DAOException e) {
				// 将自定义异常并抛出
				throw e;
			}catch (Exception e) {
				DBUtils.rollback(conn);
				//将异常封装成自定义异常并抛出
				throw new ServiceException("登录时查询数据出错",e);
			}finally {
				DBUtils.closeConnection(conn);
			}
		//返回用户登录结果
			return v;
		}
		
		
		/**
		 * 更新用户信息
		 * @param user
		 * @return 更新结果
		 */
	public boolean updateUser(UserVO user) {
		boolean flag=false;
		Connection conn=null;
		
		
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的addUser方法，进行登陆操作，结果赋值给登录结果变量
			flag=userMgrDao.updateUser(user);
			//调用数据库工具类中的commit方法，提交事务
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// 将自定义异常并抛出
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//将异常封装成自定义异常并抛出
			throw new ServiceException("用户注册失败",e);
		}finally {
			DBUtils.closeConnection(conn);
		}

		return flag;
	}
		/**
		 * 删除用户信息
		 */
	public boolean deleteUser(int id) {
		boolean flag=false;
		Connection conn=null;
		
		
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的addUser方法，进行登陆操作，结果赋值给登录结果变量
			flag=userMgrDao.deleteUser(id);
			//调用数据库工具类中的commit方法，提交事务
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// 将自定义异常并抛出
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//将异常封装成自定义异常并抛出
			throw new ServiceException("用户注册失败",e);
		}finally {
			DBUtils.closeConnection(conn);
		}

		return flag;
	}
	/**
	 * 按编号查询
	 */
	public UserVO findUserByid(int userid) {
		Connection conn=null;
		UserVO user=null;
		
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的login方法，进行登陆操作，结果赋值给登录结果变量
			user=userMgrDao.findUserByid(userid);
			//调用数据库工具类中的commit方法，提交事务
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// 将自定义异常并抛出
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//将异常封装成自定义异常并抛出
			throw new ServiceException("按编号查询用户错误",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
	//返回用户登录结果
		return user;
	}
	/**
	 * 按姓名查找
	 */
	public Vector<UserVO> findUserByName(String name) {
		Connection conn=null;
		Vector<UserVO> v=null;
		
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的login方法，进行登陆操作，结果赋值给登录结果变量
			v=userMgrDao.findUserByName(name);
			//调用数据库工具类中的commit方法，提交事务
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// 将自定义异常并抛出
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//将异常封装成自定义异常并抛出
			throw new ServiceException("按姓名查询数据出错",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
	//返回用户登录结果
		return v;
	}
	/**
	 * 按页号查询
	 */
	public Vector<UserVO> findUsers(int pageNo, int pageSize) {
		Connection conn=null;
		Vector<UserVO> v=null;
		
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的login方法，进行登陆操作，结果赋值给登录结果变量
			v=userMgrDao.findUsers(pageNo, pageSize);
			//调用数据库工具类中的commit方法，提交事务
			DBUtils.Commit(conn);
		} catch (DAOException e) {
			// 将自定义异常并抛出
			throw e;
		}catch (Exception e) {
			DBUtils.rollback(conn);
			//将异常封装成自定义异常并抛出
			throw new ServiceException("按页号查询数据出错",e);
		}finally {
			DBUtils.closeConnection(conn);
		}
	//返回用户登录结果
		return v;
	}
		
		
		
		
		
	
}
