package com.myql.team.service;

import com.myql.team.domain.Architect;
import com.myql.team.domain.Designer;
import com.myql.team.domain.Employee;
import com.myql.team.domain.Programmer;

/**
 * 
 *
 * @project name:myproject03
 * @class name:TeamService
 * @description: ���ڿ����Ŷӳ�Ա�Ĺ�����ӡ�ɾ���ȡ�
 * @author: malin
 * @creation time:2019��11��27������7:56:43
 * @version
 */
public class TeamService {
	
	private static int counter=1; //��member��ֵʹ��
	private final int MAX_MEMBER = 5;//���ƿ����Ŷӵ�����
	private Programmer[] team = new Programmer[MAX_MEMBER];//���濪���Ŷӳ�Ա
	private int total;//��¼�����Ŷ���ʵ�ʵ�����
	
	public TeamService() {
		super();
	}
	
	/**
	 * @description: ��ȡ�����Ŷ��е����г�Ա
	 * @return
	 */
	public Programmer[] getTeam() {
		
		Programmer[] team = new Programmer[total];
		for(int i = 0;i<team.length;i++) {
			team[i]= this.team[i];
		}
		return team;
	}
	
	/**
	 * @description: ��ָ����Ա����ӵ������Ŷ���
	 * @param e
	 * @throws TeamException 
	 */
	public void addMember(Employee e) throws TeamException {
		//��Ա�������޷����
		if(total>=MAX_MEMBER) {
			throw new TeamException("��Ա�������޷����");
		}
		//�ó�Ա���ǿ�����Ա���޷����
		if(!(e instanceof Programmer)) {
			throw new TeamException("�ó�Ա���ǿ�����Ա���޷����");
		}
		//�ó�Ա���ڱ������Ŷ���
		if(isExist(e)) {
			throw new TeamException("�ó�Ա���ڱ������Ŷ���");
		}
		//��Ա������ĳ�Ŷӳ�Ա
		//��Ա�������ݼ٣��޷����
		Programmer p = (Programmer)e;//һ���������ClassCastException
		if(p.getStatus().getNAME().equals("BUSY")) {
			throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
		}else if(p.getStatus().getNAME().equals("VOCATION")){
			throw new TeamException("��Ա�������ݼ٣��޷����");
		}
		
		//�Ŷ������ֻ����һ���ܹ�ʦ
		//�Ŷ������ֻ������������Ա
		//�Ŷ������ֻ������������Ա
		
		//��ȡteam���г�Ա�мܹ�ʦ�����ʦ������Ա������
		int numOfArch = 0,numOfDes = 0,numOfpro = 0;
		for(int i=0;i<total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else if(team[i] instanceof Programmer) {
				numOfpro++;
			}
		}
		
		
		if(p instanceof Architect) {
			if(numOfArch >=1) {
				throw new TeamException("�Ŷ������ֻ����һ���ܹ�ʦ");
			}
		}else if(p instanceof Designer) {
			if(numOfDes >=2) {
				throw new TeamException("�Ŷ������ֻ������������Ա");
			}
		}else if(p instanceof Programmer) {
			if(numOfDes >=3) {
				throw new TeamException("�Ŷ������ֻ������������Ա");
			}
		}
		
		//��p����e����ӵ����е�team��
		team[total++]=p;
		//p�����Ը�ֵ
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}
	/**
	 * @description: �ж�ָ����Ա���Ƿ��Ѿ����������еĿ����Ŷ���
	 * @param e
	 * @return
	 */
	private boolean isExist(Employee e) {
		for(int i =0;i<total;i++) {
			if(team[i].getId()==e.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @description: ���Ŷ���ɾ����Ա
	 * @param memberId
	 * @throws TeamException 
	 */
	public void removeMember(int memberId) throws TeamException {
		int i =0;
		for(;i<total;i++) {
			if(team[i].getMemberId()==memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		
		//δ�ҵ�ָ��memberId�����
	   if(i==total) {
		    throw new TeamException("�Ҳ���ָ����memberId��Ա����ɾ��ʧ��");
		}
		
		//��һ��Ԫ�ظ���ǰһ��Ԫ�أ�ʵ��ɾ������
		for(int j =i+1;j<total;j++) {
			team[j-1]=team[j];
		}
		team[total-1]=null;
		total--;
		//��
		//team[--total]=null;
		
	}
}
