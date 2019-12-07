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
 * @description: 关于开发团队成员的管理：添加、删除等。
 * @author: malin
 * @creation time:2019年11月27日下午7:56:43
 * @version
 */
public class TeamService {
	
	private static int counter=1; //给member赋值使用
	private final int MAX_MEMBER = 5;//限制开发团队的人数
	private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
	private int total;//记录开发团队中实际的人数
	
	public TeamService() {
		super();
	}
	
	/**
	 * @description: 获取开发团队中的所有成员
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
	 * @description: 将指定的员工添加到开发团队中
	 * @param e
	 * @throws TeamException 
	 */
	public void addMember(Employee e) throws TeamException {
		//成员已满，无法添加
		if(total>=MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		//该成员不是开发人员，无法添加
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		//该成员已在本开发团队中
		if(isExist(e)) {
			throw new TeamException("该成员已在本开发团队中");
		}
		//该员工已是某团队成员
		//该员工正在休假，无法添加
		Programmer p = (Programmer)e;//一定不会出现ClassCastException
		if(p.getStatus().getNAME().equals("BUSY")) {
			throw new TeamException("该员工已是某团队成员");
		}else if(p.getStatus().getNAME().equals("VOCATION")){
			throw new TeamException("该员工正在休假，无法添加");
		}
		
		//团队中最多只能有一名架构师
		//团队中最多只能有两名程序员
		//团队中最多只能有三名程序员
		
		//获取team已有成员中架构师、设计师、程序员的人数
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
				throw new TeamException("团队中最多只能有一名架构师");
			}
		}else if(p instanceof Designer) {
			if(numOfDes >=2) {
				throw new TeamException("团队中最多只能有两名程序员");
			}
		}else if(p instanceof Programmer) {
			if(numOfDes >=3) {
				throw new TeamException("团队中最多只能有三名程序员");
			}
		}
		
		//将p（或e）添加到现有的team中
		team[total++]=p;
		//p的属性赋值
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}
	/**
	 * @description: 判断指定的员工是否已经存在于所有的开发团队中
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
	 * @description: 从团队中删除成员
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
		
		//未找到指定memberId的情况
	   if(i==total) {
		    throw new TeamException("找不到指定的memberId的员工，删除失败");
		}
		
		//后一个元素覆盖前一个元素，实现删除操作
		for(int j =i+1;j<total;j++) {
			team[j-1]=team[j];
		}
		team[total-1]=null;
		total--;
		//或：
		//team[--total]=null;
		
	}
}
