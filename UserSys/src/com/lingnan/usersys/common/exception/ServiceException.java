package com.lingnan.usersys.common.exception;
/**
 * �Զ���Service�쳣
 * @author 16485
 *
 */
public class ServiceException extends RuntimeException {
/**
 * Ĭ�Ϲ��췽��
 */
	public ServiceException() {
		
	}
	/**
	 * ���췽��
	 * @param arg0 �쳣����ϸ��Ϣ
	 */
	public ServiceException(String arg0) {
		super(arg0);
	}
	/**
	 * 
	 * @param arg0 �쳣�Ĳ���ԭ��
	 */
	public ServiceException(Throwable arg0) {
		super(arg0);
	}
	/**
	 * 
	 * @param arg0 �쳣����ϸ��Ϣ
	 * @param arg1 �쳣�Ĳ���ԭ��
	 */
	public ServiceException(String arg0, Throwable arg1) {
		super(arg0,arg1);
	}
	
	
}
