package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * �û��û�����Ȩ�޷�Ϊ��ͨ�û��͹���Ա
 * @author 16485
 *
 */
public class AdminFrame extends NomalFrame {
	/**
	 * �������Ĺ����������ڳ�ʼ��user����
	 * @param user
	 */
	public AdminFrame(UserVO user) {
		super(user);
	}

	public void loginSuccShow() {
		System.out.println("                 ��ӭ��½������                         ");
		System.out.println();
		System.out.println("=============================");
		System.out.println();
		System.out.println(uu.getNAME()+"   ���ã�");
		System.out.println("����Ȩ���ǣ�"+uu.getSUPERUSER());
		System.out.println();
		if(uu.getSUPERUSER()==1) {
			this.show();
		}else {
			new NomalFrame(uu).show();
		}	
		
	}
	/**
	 * ����Ա���ܽ���
	 */
	public void show() {
		//�������崦�����������ڽ��տ���̨���������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			//���ܽ���
			System.out.println("����û�-----------------------1");
			System.out.println("ɾ���û�-----------------------2");
			System.out.println("�޸��û�-----------------------3");
			System.out.println("��ѯ�û�-----------------------4");
			System.out.println("�����˳�-----------------------5");
			int i =0;
			
			while(true) {
				try {
					//��ȡ�û��������ѡ������֣�ͬʱת��Ϊint��
					i=Integer.parseInt(br.readLine());
					//�жϸ�ѭ����������һ��������iֵ�ж�
					break;
				} catch (Exception e) {
					//�����쳣ʱ����ʾ������Ϣ������������
					System.out.println("�������ֻ������1~5֮�������");
				}
			}
			/*
			 * �ж��û�����ֵ�����ֵΪ1�������û�����û�����
			 * ֵΪ2������ɾ������
			 * ֵΪ3�������޸Ĳ���
			 * ֵΪ4�����в�ѯ����
			 * �˳���ѯ
			 */
		switch (i) {
		case 1:
			this.addShow("���");
			break;
		case 2:
			deleteShow();
			break;
		case 3:
			this.updateShow("�޸�", uu);
			break;
		case 4:
			this.searchShow();
			break;
		case 5:
			System.out.println("��л����ʹ�ã�����Ӵ~");
			System.exit(0);
		default:
			System.out.println("���Ĳ�������ȷ�����������롣");
		}
	
		}
	
		
	}
	
	private void deleteShow() {
		//�������崦�����������ڽ��տ���̨���������
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner input =new Scanner(System.in);	
		//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
		System.out.println("�������û���ţ�");
		try {
			UserVO user=new UserVO();
			 int id= input.nextInt();
			//user.setUSERID(Integer.parseInt(br.readLine()));
			//���ÿ������е�doLogin�����������û���¼����
			UserController uc=new UserController();
			boolean delete=uc.deleteUser(id);
			if(delete) {
				System.out.println("ɾ���û��ɹ���");
			}else {
				System.out.println("ɾ���û�ʧ�ܣ�");
			}
		} catch (Exception e) {
			System.out.println("ɾ���û���ʱ�������"+e.getMessage());
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
			
			//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
			System.out.println("�������û���ţ�");
			user.setUSERID(Integer.parseInt(br.readLine()));
			System.out.println("�������û�����");
			user.setNAME(br.readLine());
			System.out.println("���������䣺");
			user.setAGE(Integer.parseInt(br.readLine()));

			System.out.println("�������Ա�");
			user.setSEX(br.readLine());
			System.out.println("�������û����룺");
			user.setPASSWORD(br.readLine());
			System.out.println("������Ȩ�ޣ�");
			user.setSUPERUSER(Integer.parseInt(br.readLine()));
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
			//���ÿ������е�updateUser�����������û�ע�����
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
			//��ʾ�쳣��Ϣ
			if ("�޸�".equals(type)) 
				System.out.println("����ͨ�û����޸��û���ʱ�������"+e.getMessage());
			else 
				System.out.println("�޸��û���ʱ�������"+e.getMessage());

		}
	}	
	/**
	 * ����û�
	 */
	public void addShow(String type) {
		
		//�������崦�����������ڽ��տ���̨���������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if("���".equals(type)) {
			System.out.println("============================");
			System.out.println();
			System.out.println("            ����û�����                     ");
			System.out.println();
			System.out.println("============================");
		}else {
			
		}
		
		try {
			//ʵ�����û�����
			UserVO user=new UserVO();
			//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
			System.out.println("�������û���ţ�");
			user.setUSERID(Integer.parseInt(br.readLine()));
			System.out.println("�������û�����");
			user.setNAME(br.readLine());
			System.out.println("���������䣺");
			user.setAGE(Integer.parseInt(br.readLine()));
			
			System.out.println("�������Ա�");
			user.setSEX(br.readLine());
			System.out.println("�������û����룺");
			user.setPASSWORD(br.readLine());
			System.out.println("������Ȩ�ޣ�");
			user.setSUPERUSER(Integer.parseInt(br.readLine()));
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
			
			boolean insert=uc.doRegister(user);
			//�������ֵΪ�棬����ɹ�����ʾ�ɹ���Ϣ���������ʧ�ܣ���ʾʧ����Ϣ
			if (insert) {
				if("���".equals(type)) 
					System.out.println("����û��ɹ�");
				else
					System.out.println("����û��ɹ�");
			}else {
				if ("���".equals(type)) 
					System.out.println("����û�ʧ��");
				else 
					System.out.println("�û�ע��ʧ��");
				 }
	
		} catch (DateException e) {
			//��ʾ�쳣��Ϣ
			if ("���".equals(type)) 
				System.out.println("����û���ʱ�������"+e.getMessage());
			else 
				System.out.println("�û�ע���ʱ�������"+e.getMessage());

		}catch (Exception e) {
			//��ʾ�쳣��Ϣ
			if ("���".equals(type)) 
				System.out.println("����û���ʱ�������"+e.getMessage());
			else 
				System.out.println("�û�ע���ʱ�������"+e.getMessage());

		}
	}
	
	
	/**
	 * ��ѯҳ��
	 */
	public void searchShow() {
		//��ѯ���ܽ���
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("==============================");
				System.out.println();
				System.out.println("                   ��ѯ�û�����                     ");
				System.out.println();
				System.out.println("==============================");
				
				while(true) {
				System.out.println("��ѯ�����û���Ϣ------------------1");
				System.out.println("���û���Ų����û�-----------------2");
				System.out.println("���û����������û�-----------------3");
				System.out.println("��ҳ�ź�ҳ���С��ѯ----------------4");
				System.out.println("�˳���ѯ-------------------------5");
				int i =0;
					
				while(true) {
					try {
						//��ȡ�û��������ѡ������֣�ͬʱת��Ϊint��
						i=Integer.parseInt(br.readLine());
						//�жϸ�ѭ����������һ��������iֵ�ж�
						break;
				} catch (Exception e) {
					//�����쳣ʱ����ʾ������Ϣ������������
						System.out.println("�������ֻ������1~5֮�������");
					}
				}
			 /*
			  * ֵΪ1�����в��������û���Ϣ
			  * ֵΪ2�����а��û���Ų�ѯ
			  * ֵΪ3�����а��û�������ѯ
			  * ֵΪ4����ҳ�Ų�ѯ
			  * ֵΪ5���˳���ѯ
			  */
				switch (i) {
				case 1:
					findAllUserShow();
					break;
				case 2:
					findUserByIdShow();
					break;
				case 3:
					findUserByNameShow();
					break;
				case 4:
					findUsersShow();
					break;
				case 5:
					show();
					System.out.println();
//					System.exit(0);
				default:
					System.out.println("���Ĳ�������ȷ�����������롣");
				}		
			}
		}
	
	/**
	 * ��ѯ�����û�����
	 */
	public void findAllUserShow() {
		Vector< UserVO> v = new Vector<UserVO>();
		UserController uc=new UserController();
		v=uc.doFindAllUser();
		
		for(UserVO user:v) {
			System.out.println(user.getUSERID()+"   "+user.getNAME()+"   "+user.getAGE()+"   "+user.getBIRTH()+"   "+user.getSEX()+"   "+user.getPASSWORD()+"   "+user.getSUPERUSER());
		    System.out.println("����������������������������������������������������������������������������������������������");
		}	
	}
	/**
	 * ���û���Ų�ѯ����
	 */
	public void findUserByIdShow() {
		//�������崦�����������ڽ��տ���̨���������
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner input =new Scanner(System.in);	
			//ʵ�����û�����
			UserVO user=new UserVO();
			//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
			System.out.println("�������û���ţ�");			
			int userid=input.nextInt();
			System.out.println("����ѯ����Ϣ���£�");
			//���ÿ������е�updateUser�����������û�ע�����
			UserController uc=new UserController();
			uc.dofindUserByid(userid);
		
	}
	
	/**
	 * ���û�������ѯ����
	 */
	public void findUserByNameShow() {
		Scanner input =new Scanner(System.in);	
		//ʵ�����û�����
		UserVO user=new UserVO();
		//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
		System.out.println("�������û�������");
		String name =input.nextLine();
		System.out.println("����ѯ����Ϣ���£�");
		//���ÿ������е�updateUser�����������û�ע�����
		UserController uc=new UserController();
		uc.doFindUserByName(name);
	}
	/**
	 * ��ҳ�Ų�ѯ����
	 */
	public void findUsersShow() {
		Scanner input =new Scanner(System.in);	
		//ʵ�����û�����
		UserVO user=new UserVO();
		//��ȡ����ĸ���ֵ����ֵ���û�����ĸ�������
		System.out.println("������ҳ�ţ�");
		int pagenum=input.nextInt();
		System.out.println("������ҳ���С��ÿҳ���û���������");
		int pagesize=input.nextInt();
		System.out.println("����ѯ����Ϣ���£�");
		System.out.println();
		//���ÿ������е�updateUser�����������û�ע�����
		UserController uc=new UserController();
		uc.findUsers(pagenum, pagesize);
	}
	
	
}
