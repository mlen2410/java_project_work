package com.myql.team.service;
/**
 * 
 *
 * @project name:myproject03
 * @class name:Status
 * @description: 表示员工的状态
 * @author: malin
 * @creation time:2019年11月24日下午5:36:34
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
