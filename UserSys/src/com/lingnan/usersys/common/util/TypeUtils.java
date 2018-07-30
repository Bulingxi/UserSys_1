package com.lingnan.usersys.common.util;

import java.util.Date;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.exception.EmailException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;


/**
 * ��װ����ת��
 * �ж��ַ����Ƿ�Ϊ��
 * ��֤�����ʽ�Ƿ�淶
 * @author 16485
 *
 */
public class TypeUtils {
	  /**
	   * �ж��Ƿ�Ϊ��
	   * @param str ��Ҫ�жϵ��ַ���
	   * @return
	   */
	public static boolean isEmpty(CharSequence str) {
		if(str==null||str.length()==0) 
			return true;
		else 
			return false;
	}
	

	    /**
	     * ���ã�������ת�����ַ���
	     * @param d 
	     *          ��ת�������ڶ���
	     * @return ��ʽ��֮����ַ���
	     */
	    public static String dateToString(Date d){
	    	String str=null;
	    	try {
	    		//����Ҫ��ʽ�������ڸ�ʽ
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//����format�����������ڸ�ʽ�����ַ���
				str=sdf.format(d);
			} catch (Exception e) {
				//���쳣��װ���Զ����쳣
				throw new DateException("����ת��Ϊ�ַ�������",e);
			}
	    	//����ת�����ֵ
	        return str;
	    }

	    /**
	     * ���ã���һ���ַ�����ʽ����Date���ڶ���
	     * @param s ������ַ���
	     * @return ���ڶ���
	     * @throws ParseException 
	     */
	    public static Date StringToDate(String str) {
	    	Date date=null;
	    	//����Ҫ��ʽ�������ڸ�ʽ
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	try {
	    		//����parse���������ַ���������ָ����ʽ����������
				date = sdf.parse(str);
			} catch (ParseException e) {
				//���쳣��װ���Զ����쳣
				throw new DateException("����ת��Ϊ�ַ�������",e);
			}
	    	return date;
	    }
	    /**
	     * ���������ʽ�Ƿ���ȷ
	     * @param str ���������
	     * @return ���ؼ�����
	     */
	   public static boolean isMail(String str){
	        try {
				String   check   =  str.replaceAll("^\\\\w+((-\\\\w+)|(\\\\.\\\\w+))*\\\\@[A-Za-z0-9]+((\\\\.|-)[A-Za-z0-9]+)*\\\\.[A-Za-z0-9]+$", "") ;   
				if(check.length()==0){   
				    return true;  
				}else{  
					System.out.println("�����ʽ����");
				    return false;
				}
			} catch (Exception e) {
				// ���쳣��װ���Զ����쳣
				throw new EmailException("�����ʽ����",e);
			}
			   
	    }


}
