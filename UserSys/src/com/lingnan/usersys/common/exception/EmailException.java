package com.lingnan.usersys.common.exception;
/**
 * 自定义email异常
 * @author 16485
 *
 */
public class EmailException extends ServiceException {
	/**
	 * 默认构造方法
	 */
		public EmailException() {
			
		}
		/**
		 * 构造方法
		 * @param arg0 异常的详细信息
		 */
		public EmailException(String arg0) {
			super(arg0);
		}
		/**
		 * 
		 * @param arg0 异常的产生原因
		 */
		public EmailException(Throwable arg0) {
			super(arg0);
		}
		/**
		 * 
		 * @param arg0 异常的详细信息
		 * @param arg1 异常的产生原因
		 */
		public EmailException(String arg0, Throwable arg1) {
			super(arg0,arg1);
		}
}
