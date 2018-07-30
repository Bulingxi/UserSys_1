package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;
	/**
	 * �����û���¼��ע�����
	 * @author 16485
	 *
	 */
public class IndexFrame implements BaseFrame {
	/**
	 * �û���¼��ע�����
	 */
	public void show() {
		//�������崦�����������ڽ��տ���̨���������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			//�û���¼ע�����
			System.out.println("��ӭʹ��Buling���û�����ϵͳ *00*");
			System.out.println("============================");
			System.out.println("��ѡ������Ҫ�Ĺ��ܣ�");
			System.out.println("�û���¼---------------------1");
			System.out.println("�û�ע��---------------------2");
			System.out.println("�˳�����---------------------3");
			int i=0;
			
			while(true) {
				
					try {
						//��ȡ�û��������ѡ������֣�ͬʱת��Ϊint��
						i=Integer.parseInt(br.readLine());
						//�жϸ�ѭ����������һ��������iֵ�ж�
						break;
					}catch (Exception e) {
						//�����˲��У���ʾ������Ϣ������������
						System.out.println("�������ֻ������1~3������");
						System.out.println("����������");
					}				
			}
			/*
			 * �ж��û�����ֵ�����ֵΪ1�������û���½����
			 * ֵΪ2������ע�����
			 * ֵΪ3���˳�ϵͳ
			 */
			switch (i) {
			case 1:
				this.loginShow();
				break;
			case 2:
				this.addShow("ע��");
				break;
			case 3:
				System.out.println("��л����ʹ�ã�����Ӵ~");
				System.exit(0);
			
			default:
				System.out.println("���Ĳ�������ȷ�����������롣");
			}
		}
	}
	
	public void loginShow() {
		//�������崦�����������ڽ��տ���̨���������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�û���¼����");
		System.out.println("===========================");	
		
		try {
			//����Ϊ��λ����ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
			System.out.println("�����������û�����");	
			String name=br.readLine();
			System.out.println("�������������룺");
			String password=br.readLine();
			//���ÿ������е�doLogin�����������û���¼����
			UserController uc=new UserController();
			UserVO user=uc.doLogin(name, password);
			if(user!=null) {
				System.out.println("��½�ɹ�������");
				System.out.println("=============================");	
				//����������
//				AdminFrame m=new AdminFrame(user);
//				m.loginSuccShow();
				//�˳���ǰ����
				System.exit(0);
			
			}else {
				//��¼ʧ�ܣ���ʾʧ����Ϣ
				System.out.println("��¼ʧ�ܣ�����");	
			}
			
		} catch (Exception e) {
			// ��ʾ�쳣��Ϣ
			System.out.println(e.getMessage());	
		}
	}
	
//	public void addShow(String type) {
//		
//		//�������崦�����������ڽ��տ���̨���������
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		if("ע��".equals(type)) {
//			System.out.println("�û�ע�����");
//			System.out.println("============================");	
//		}else {
//			
//		}
//		
//		try {
//			//ʵ�����û�����
//			UserVO user=new UserVO();
//			//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
//			System.out.println("�������û���ţ�");
//			user.setUSERID(Integer.parseInt(br.readLine()));
//			System.out.println("�������û�����");
//			user.setNAME(br.readLine());
//			System.out.println("���������䣺");
//			user.setAGE(Integer.parseInt(br.readLine()));
//			
//			System.out.println("�������Ա�");
//			user.setSEX(br.readLine());
//			System.out.println("�������û����룺");
//			user.setNAME(br.readLine());
//			System.out.println("������Ȩ�ޣ�");
//			user.setSUPERUSER(Integer.parseInt(br.readLine()));
//			while(true) {
//				System.out.println("���������䣺");
//				String email=br.readLine();
//				if(TypeUtils.isMail(email)) {
//					user.setMAIL(email);
//					break;
//				}
//			}
//			System.out.println("�������������(yyyy-MM-dd)��");
//			user.setBIRTH(TypeUtils.StringToDate(br.readLine()));
//			//���ÿ������е�doRegister�����������û�ע�����
//			UserController uc=new UserController();
//			
//			boolean insert=uc.doRegister(user);
//			//�������ֵΪ�棬����ɹ�����ʾ�ɹ���Ϣ���������ʧ�ܣ���ʾʧ����Ϣ
//			if (insert) {
//				if("ע��".equals(type)) 
//					System.out.println("�û�ע��ɹ�");
//				else
//					System.out.println("����û��ɹ�");
//			}else {
//				if ("ע��".equals(type)) 
//					System.out.println("�û�ע��ʧ��");
//				else 
//					System.out.println("����û�ʧ��");
//				 }
//	
//		} catch (DateException e) {
//			//��ʾ�쳣��Ϣ
//			if ("ע��".equals(type)) 
//				System.out.println("�û�ע���ʱ�������"+e.getMessage());
//			else 
//				System.out.println("����û���ʱ�������"+e.getMessage());
//
//		}catch (Exception e) {
//			
//			if ("ע��".equals(type)) 
//				System.out.println("�û�ע���ʱ�������"+e.getMessage());
//			else 
//				System.out.println("����û���ʱ�������"+e.getMessage());
//
//		}
//		
	
	//}
	
	
	/**
	 * ��ѯҳ��
	 */
	public void searchShow() {
		
	};
	/**
	 * �޸�ҳ��
	 * @param type
	 * @param user
	 */
	public void updateShow(String type,UserVO user) {
		
	}

	@Override
	public void addShow(String type) {
		// TODO Auto-generated method stub
		
	};
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
