package com.lingnan.usersys.common.exception;


/**
 * 自定义DAO异常
 * @author 16485
 *
 */

public class DAOException extends RuntimeException {
/**
 * 默认构造方法
 */
	public DAOException(){
		
	}
	/**
	 * 构造方法
	 * @param arg0 异常的详细信息
	 */
	public DAOException (String arg0) {
		super(arg0);
	}
	/**
	 * 构造方法
	 * @param arg0 异常的原因
	 */
	public DAOException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg0  异常的详细信息
	 * @param arg1 异常的原因
	 */
	public DAOException(String arg0,Throwable arg1) {
		super(arg0,arg1);
	}
	
	
}
