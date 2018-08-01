package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDaoImpl;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class NomalFrame extends IndexFrame{
	//�û�����
	UserVO uu = null;
	/**
	 * �������Ĺ��������û���ʼ��user����
	 * @param user
	 */
	public NomalFrame(UserVO user) {
		this.uu=user;
	}
	
	/**
	 * �����û�����Ĳ�������Ͳ������
	 */
	public void show() {
		//�������崦�����������ڽ��տ���̨���������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("��ѡ�����¹��ܣ�");
			System.out.println("�޸��Լ�����Ϣ-----------------1");
			System.out.println("��ѯ�Լ�����Ϣ-----------------2");
			System.out.println("�����˳�----------------------3");
			int i =0;
			
			while(true) {
				try {
					i=Integer.parseInt(br.readLine());
					break;
				} catch (Exception e) {
					System.out.println("�������ֻ������1~3֮�������");
				}
			}
			/*
			 * ֵΪ1���޸Ĳ���
			 * ֵΪ2����ѯ������Ϣ����
			 * ֵΪ3���˳�����
			 */
			switch (i) {
			case 1:
				this.updateShow("�޸�",uu);
				break;
			case 2:
				this.searchShow();
				break;
			case 3:
				System.out.println("��л��ʹ�ñ����~~");
				System.exit(0);
				break;
			default:
				System.out.println("����������ֲ���ȷ��ֻ������1~3֮������֣�����������");
				break;
			}
		
		}

	}
	
	/**
	 * �޸�ҳ��
	 * @param type
	 * @param user
	 */
	public void updateShow(String type,UserVO user) {

		//�������崦�����������ڽ��տ���̨���������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			//ʵ�����û�����
			
			user.setUSERID(user.getUSERID());
			//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
//			System.out.println("�������û���ţ�");
//			user.setUSERID(Integer.parseInt(br.readLine()));
			System.out.println("�������û�����");
			user.setNAME(br.readLine());
			System.out.println("���������䣺");
			user.setAGE(Integer.parseInt(br.readLine()));

			System.out.println("�������Ա�");
			user.setSEX(br.readLine());
			System.out.println("�������û����룺");
			user.setPASSWORD(br.readLine());
//			System.out.println("������Ȩ�ޣ�");
//			user.setSUPERUSER(Integer.parseInt(br.readLine()));
			while(true) {
				System.out.println("���������䣺");
				String email=br.readLine();
				if(TypeUtils.isMail(email)) {
					user.setMAIL(email);
					break;
				}
			}
			System.out.println("�������������(yyyy-MM-dd)��");
			user.setBIRTH(TypeUtils.StringToDate(br.readLine()));
			//���ÿ������е�doRegister�����������û�ע�����
			UserController uc=new UserController();
			
			boolean update=uc.updateUser(user);
			//�������ֵΪ�棬����ɹ�����ʾ�ɹ���Ϣ���������ʧ�ܣ���ʾʧ����Ϣ
			if (update) {
				if("�޸�".equals(type)) 
					System.out.println("�û��޸ĳɹ�");
				else
					System.out.println("�޸��û��ɹ�");
			}else {
				if ("�޸�".equals(type)) 
					System.out.println("�û��޸�ʧ��");
				else 
					System.out.println("�޸��û�ʧ��");
				 }
	
		} catch (DateException e) {
			//��ʾ�쳣��Ϣ
			if ("�޸�".equals(type)) 
				System.out.println("����ͨ�û����޸��û���ʱ�������"+e.getMessage());
			else 
				System.out.println("�޸��û���ʱ�������"+e.getMessage());

		}catch (Exception e) {
			
			if ("�޸�".equals(type)) 
				System.out.println("����ͨ�û����޸��û���ʱ�������"+e.getMessage());
			else 
				System.out.println("�޸��û���ʱ�������"+e.getMessage());

		}
	}	
	/**
	 * ��ѯ�Լ�����Ϣ����
	 */
	public void searchShow() {
		UserDaoImpl u=new UserDaoImpl(DBUtils.getConnection());
		UserVO user=new UserVO();
		System.out.println("������Ϣ���£�");
		System.out.println();
		user=u.findUserByid(uu.getUSERID());
		System.out.println();
	}
	
	
	
	
	
}
