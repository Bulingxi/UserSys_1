package com.lingnan.usersys.common.exception;


/**
 * �Զ���DAO�쳣
 * @author 16485
 *
 */

public class DAOException extends RuntimeException {
/**
 * Ĭ�Ϲ��췽��
 */
	public DAOException(){
		
	}
	/**
	 * ���췽��
	 * @param arg0 �쳣����ϸ��Ϣ
	 */
	public DAOException (String arg0) {
		super(arg0);
	}
	/**
	 * ���췽��
	 * @param arg0 �쳣��ԭ��
	 */
	public DAOException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * ���췽��
	 * @param arg0  �쳣����ϸ��Ϣ
	 * @param arg1 �쳣��ԭ��
	 */
	public DAOException(String arg0,Throwable arg1) {
		super(arg0,arg1);
	}
	
	
}
