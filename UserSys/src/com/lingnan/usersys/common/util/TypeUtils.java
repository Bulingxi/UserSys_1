package com.lingnan.usersys.common.util;

import java.util.Date;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.exception.EmailException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;


/**
 * 封装日期转换
 * 判断字符串是否为空
 * 验证邮箱格式是否规范
 * @author 16485
 *
 */
public class TypeUtils {
	  /**
	   * 判断是否为空
	   * @param str 需要判断的字符串
	   * @return
	   */
	public static boolean isEmpty(CharSequence str) {
		if(str==null||str.length()==0) 
			return true;
		else 
			return false;
	}
	

	    /**
	     * 作用：把日期转换成字符串
	     * @param d 
	     *          被转换的日期对象
	     * @return 格式化之后的字符串
	     */
	    public static String dateToString(Date d){
	    	String str=null;
	    	try {
	    		//设置要格式化的日期格式
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//调用format方法，将日期格式化成字符串
				str=sdf.format(d);
			} catch (Exception e) {
				//将异常封装成自定义异常
				throw new DateException("日期转换为字符串出错",e);
			}
	    	//返回转换后的值
	        return str;
	    }

	    /**
	     * 作用：把一个字符串格式化成Date日期对象
	     * @param s 输入的字符串
	     * @return 日期对象
	     * @throws ParseException 
	     */
	    public static Date StringToDate(String str) {
	    	Date date=null;
	    	//设置要格式化的日期格式
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	try {
	    		//调用parse方法，将字符串解析成指定格式的日期类型
				date = sdf.parse(str);
			} catch (ParseException e) {
				//将异常封装成自定义异常
				throw new DateException("日期转换为字符串出错",e);
			}
	    	return date;
	    }
	    /**
	     * 检验邮箱格式是否正确
	     * @param str 传入的邮箱
	     * @return 返回检验结果
	     */
	   public static boolean isMail(String str){
	        try {
				String   check   =  str.replaceAll("^\\\\w+((-\\\\w+)|(\\\\.\\\\w+))*\\\\@[A-Za-z0-9]+((\\\\.|-)[A-Za-z0-9]+)*\\\\.[A-Za-z0-9]+$", "") ;   
				if(check.length()==0){   
				    return true;  
				}else{  
					System.out.println("邮箱格式错误");
				    return false;
				}
			} catch (Exception e) {
				// 将异常封装成自定义异常
				throw new EmailException("邮箱格式错误",e);
			}
			   
	    }


}
