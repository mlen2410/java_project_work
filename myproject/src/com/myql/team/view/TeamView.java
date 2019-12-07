package com.myql.team.view;

import com.myql.team.domain.Employee;
import com.myql.team.domain.Programmer;
import com.myql.team.service.NameListService;
import com.myql.team.service.TeamException;
import com.myql.team.service.TeamService;

/**
 * 
 *
 * @project name:myproject03
 * @class name:TeamView
 * @description:
 * @author: malin
 * @creation time:2019��11��27������10:20:37
 * @version
 */
public class TeamView {
	
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {
		
		boolean loopFlag=true;
		char menu = 0;
		while(loopFlag) {
			if(menu !='1') {
				listAllEmployees();
			}
			
			System.out.println("1-�Ŷ��б�  2-����Ŷӳ�Ա  3-ɾ���Ŷӳ�Ա  4-�˳�  ����ѡ��1-4����");
			menu = TSUtility.readMenuSelection();
			switch(menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
				
			case '4':
				System.out.println("ȷ���Ƿ��˳���Y/N����");
				char isExit=TSUtility.readConfirmSelection();
				if(isExit=='Y') {
					loopFlag=false;
				}
				break;
			}
			
		}
		
	}
	
	/**
	 * @description: ��ʾ���е�Ա����Ϣ
	 * 
	 */
	private void listAllEmployees() {
		//System.out.println("��ʾ��˾���е�Ա����Ϣ");
		
		System.out.println("**************************************�����Ŷӵ������**********************************\n");
		Employee[] employees = listSvc.getAllEmployees();
		if(employees == null || employees.length==0) {
			System.out.println("��˾��û���κ�Ա����Ϣ��");
		}else {
			System.out.println("ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");
			
			for(int i=0;i<employees.length;i++) {
				System.out.println(employees[i]);
			}
		}		
		System.out.println("************************************************************************************");
	}
	
	
	private void getTeam() {
		//System.out.println("�鿴�����Ŷ����");
		
		System.out.println("**************************************�Ŷӳ�Ա�б�**********************************\n");
		Programmer[] team = teamSvc.getTeam();
		if(team == null || team.length==0) {
			System.out.println("�����Ŷ�Ŀǰ��û����Ա��");
		}else {
			System.out.println("TID/ID\t����\t����\t����\tְλ\t����\t��Ʊ\n");
			
			for(int i= 0;i<team.length;i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}
		
		System.out.println("************************************************************************************");	
	}
	
	private void addMember() {
		//System.out.println("����Ŷӳ�Ա");
		
		System.out.println("**************************************����Ŷӳ�Ա**********************************\n");
		System.out.print("������Ҫ��ӵ�Ա��ID��");
		int id = TSUtility.readInt();
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("��ӳɹ�");
		} catch (TeamException e) {
			
			System.out.println("���ʧ�ܣ�ԭ��"+e.getMessage());
		}
		
		//���س�������...
		TSUtility.readReturn();
		System.out.println("************************************************************************************");	
	}
	
	private void deleteMember() {
		//System.out.println("ɾ���Ŷӳ�Ա");
		System.out.println("**************************************ɾ���Ŷӳ�Ա**********************************\n");
		
		System.out.print("������Ҫɾ��Ա����TID��");
		int memberId = TSUtility.readInt();
		
		System.out.println("ȷ���Ƿ�ɾ����Y/N����");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete == 'N') {
			return ;
		}
		
		try {
			teamSvc.removeMember(memberId);
		} catch (TeamException e) {
			System.out.println("ɾ��ʧ�ܣ�ԭ��"+e.getMessage());
		}
		//�����������...
		TSUtility.readReturn();
		
		System.out.println("************************************************************************************");
	}
	
	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
	
}
