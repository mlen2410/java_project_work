package com.myql.team.domain;
//��ӡ��
public class Printer implements Equipment{
	
	private String name;//�����ͺ�
	private String type;//��������
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 
	 */
	public Printer() {
		super();
	}
	
	/**
	 * @param name
	 * @param type
	 */
	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	@Override
	public String getDescription() {
		return name+"(" + type +")";
	}
	
	
	

}
