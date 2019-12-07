package com.myql.team.junit;

import org.junit.Test;

import com.myql.team.domain.Employee;
import com.myql.team.service.NameListService;
import com.myql.team.service.TeamException;
/**
 * 
 *
 * @project name:myproject03
 * @class name:NameListServiceTest
 * @description: ��NameListService��Ĳ���
 * @author: malin
 * @creation time:2019��11��26������11:26:52
 * @version
 */
public class NameListServiceTest {
	
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i<employees.length; i++) {
			System.out.println(employees[i]);
		}
	}
	
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 1;
		id =10;//����
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
