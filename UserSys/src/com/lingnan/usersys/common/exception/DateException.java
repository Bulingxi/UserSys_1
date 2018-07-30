package com.lingnan.usersys.common.exception;

/**
 * 自定义date异常
 * @author 16485
 *
 */
public class DateException extends ServiceException{

	/**
	 * 默认构造方法
	 */
		public DateException() {
			
		}
		/**
		 * 构造方法
		 * @param arg0 异常的详细信息
		 */
		public DateException(String arg0) {
			super(arg0);
		}
		/**
		 * 
		 * @param arg0 异常的产生原因
		 */
		public DateException(Throwable arg0) {
			super(arg0);
		}
		/**
		 * 
		 * @param arg0 异常的详细信息
		 * @param arg1 异常的产生原因
		 */
		public DateException(String arg0, Throwable arg1) {
			super(arg0,arg1);
		}
		
}
