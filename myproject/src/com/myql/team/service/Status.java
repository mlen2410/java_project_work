package com.myql.team.service;
/**
 * 
 *
 * @project name:myproject03
 * @class name:Status
 * @description: ��ʾԱ����״̬
 * @author: malin
 * @creation time:2019��11��24������5:36:34
 * @version
 */
public class Status {
	
	private final String NAME;
	
	private Status(String name) {
		this.NAME = name;
	}
	
	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");

	public String getNAME() {
		return NAME;
	}
	
	@Override
		public String toString() {
			return NAME;
	    }
}
