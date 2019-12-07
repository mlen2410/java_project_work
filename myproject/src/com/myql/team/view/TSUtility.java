package com.myql.team.view;

import java.util.*;

/**
 * 
 *
 * @project name:myproject03
 * @class name:TSUtility
 * @description:项目中提供了TUStility.java类，可用来方便地实现键盘访问。
 * @author: malin
 * @creation time:2019年11月24日下午3:54:08
 * @version
 */

public class TSUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * @description: 该方法读取键盘，如果用户键入‘1’~‘4’中的任意字符，则方法返回。返回值为用户键入字
	 * @return
	 */
	public static char readMenuSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1,false);
			c=str.charAt(0);
			if(c!='1' && c!='2' && c!='3' && c!='4') {
				System.out.print("选择错误，请重新输入：");
			}else break;
		}
		return c;
	}

	/**
	 *
	 * @description:该方法提示并等待，直到用户按回车键后返回。
	 * @author: malin
	 * @creation time:2019年11月24日下午4:14:51
	 */
	public static void readReturn() {
		System.out.println("按任意键继续...");
		readKeyBoard(100, true);
	}
	
	/**
	 *
	 * @description: 该方法从键盘读入一个长度不超过2位的整数，并将其作为方法的返回值。
	 * @author: malin
	 * @creation time:2019年11月24日下午4:25:43
	 * @version
	 */
	public static int readInt() {
		int n;
		for(;;) {
			String str=readKeyBoard(2, false);
			try {
				n=Integer.parseInt(str);
				break;
			}catch(NumberFormatException e){
				System.out.println("数字输入错误，请重新输入：");
			}
		}
		return n;	
	}

	/**
	 *
	 * @description: 从键盘读取‘Y’或‘N’，并将其作为方法的返回值。
	 * @author: malin
	 * @creation time:2019年11月24日下午4:30:52
	 * @version
	 */
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1, false).toUpperCase();
			c=str.charAt(0);
			if(c =='Y'|| c=='N') {
				break;
			}else {
				System.out.println("选择错误，请重新输入：");
			}
		}
		return c;
	}
	
	

	private static String readKeyBoard(int limit, boolean blankReturn) {
		
		String line ="";
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.length() == 0) {
				if(blankReturn)
					return line;
				else continue;
			}
			if(line.length()<1 || line.length()>limit) {
				System.out.println("输入长度（不大于"+limit +"）错误，请重新输入：");
				continue;
			}break;
		}
		return line;
	}
}
