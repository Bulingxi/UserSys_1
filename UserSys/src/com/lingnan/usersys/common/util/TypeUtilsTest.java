package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

public class TypeUtilsTest {

	@Test
	public void testIsEmpty() {
		boolean f=TypeUtils.isEmpty("");
		System.out.println("�пգ�"+f);;

	}

	@Test
	public void testDateToString() {
		Date date = new Date();
		String str = TypeUtils.dateToString(date);
		System.out.println("����ת�ַ�����"+str);
		
	}

	@Test
	public void testStringToDate() {
		Date d=TypeUtils.StringToDate("1994-02-05");
		System.out.println("�ַ���ת���ڣ�"+d);
	}

	@Test
	public void testIsMail() {
		boolean f=false;
		System.out.println( f=TypeUtils.isMail("wangxu198709@gmail.com"));
		
	}

}
