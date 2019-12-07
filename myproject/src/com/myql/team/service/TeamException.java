package com.myql.team.service;
/**
 *
 * @project name:myproject03
 * @class name:TeamException
 * @description: 自定义异常类
 * @author: malin
 * @creation time:2019年11月26日下午10:45:57
 * @version
 */
public class TeamException extends Exception{
	static final long serialVersionUID = -3387514229948L;
	
	public TeamException() {
		super();
	}
	
	public TeamException(String msg) {
		super(msg);
	}
}
