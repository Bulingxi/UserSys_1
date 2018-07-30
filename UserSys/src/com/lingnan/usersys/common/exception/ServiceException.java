package com.lingnan.usersys.common.exception;
/**
 * 自定义Service异常
 * @author 16485
 *
 */
public class ServiceException extends RuntimeException {
/**
 * 默认构造方法
 */
	public ServiceException() {
		
	}
	/**
	 * 构造方法
	 * @param arg0 异常的详细信息
	 */
	public ServiceException(String arg0) {
		super(arg0);
	}
	/**
	 * 
	 * @param arg0 异常的产生原因
	 */
	public ServiceException(Throwable arg0) {
		super(arg0);
	}
	/**
	 * 
	 * @param arg0 异常的详细信息
	 * @param arg1 异常的产生原因
	 */
	public ServiceException(String arg0, Throwable arg1) {
		super(arg0,arg1);
	}
	
	
}
