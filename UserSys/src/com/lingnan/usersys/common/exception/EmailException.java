package com.lingnan.usersys.common.exception;
/**
 * �Զ���email�쳣
 * @author 16485
 *
 */
public class EmailException extends ServiceException {
	/**
	 * Ĭ�Ϲ��췽��
	 */
		public EmailException() {
			
		}
		/**
		 * ���췽��
		 * @param arg0 �쳣����ϸ��Ϣ
		 */
		public EmailException(String arg0) {
			super(arg0);
		}
		/**
		 * 
		 * @param arg0 �쳣�Ĳ���ԭ��
		 */
		public EmailException(Throwable arg0) {
			super(arg0);
		}
		/**
		 * 
		 * @param arg0 �쳣����ϸ��Ϣ
		 * @param arg1 �쳣�Ĳ���ԭ��
		 */
		public EmailException(String arg0, Throwable arg1) {
			super(arg0,arg1);
		}
}
