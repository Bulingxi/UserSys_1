package com.lingnan.usersys.common.exception;

/**
 * �Զ���date�쳣
 * @author 16485
 *
 */
public class DateException extends ServiceException{

	/**
	 * Ĭ�Ϲ��췽��
	 */
		public DateException() {
			
		}
		/**
		 * ���췽��
		 * @param arg0 �쳣����ϸ��Ϣ
		 */
		public DateException(String arg0) {
			super(arg0);
		}
		/**
		 * 
		 * @param arg0 �쳣�Ĳ���ԭ��
		 */
		public DateException(Throwable arg0) {
			super(arg0);
		}
		/**
		 * 
		 * @param arg0 �쳣����ϸ��Ϣ
		 * @param arg1 �쳣�Ĳ���ԭ��
		 */
		public DateException(String arg0, Throwable arg1) {
			super(arg0,arg1);
		}
		
}
