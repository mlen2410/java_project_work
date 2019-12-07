package com.myql.team.view;

import java.util.*;

/**
 * 
 *
 * @project name:myproject03
 * @class name:TSUtility
 * @description:��Ŀ���ṩ��TUStility.java�࣬�����������ʵ�ּ��̷��ʡ�
 * @author: malin
 * @creation time:2019��11��24������3:54:08
 * @version
 */

public class TSUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * @description: �÷�����ȡ���̣�����û����롮1��~��4���е������ַ����򷽷����ء�����ֵΪ�û�������
	 * @return
	 */
	public static char readMenuSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1,false);
			c=str.charAt(0);
			if(c!='1' && c!='2' && c!='3' && c!='4') {
				System.out.print("ѡ��������������룺");
			}else break;
		}
		return c;
	}

	/**
	 *
	 * @description:�÷�����ʾ���ȴ���ֱ���û����س����󷵻ء�
	 * @author: malin
	 * @creation time:2019��11��24������4:14:51
	 */
	public static void readReturn() {
		System.out.println("�����������...");
		readKeyBoard(100, true);
	}
	
	/**
	 *
	 * @description: �÷����Ӽ��̶���һ�����Ȳ�����2λ����������������Ϊ�����ķ���ֵ��
	 * @author: malin
	 * @creation time:2019��11��24������4:25:43
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
				System.out.println("��������������������룺");
			}
		}
		return n;	
	}

	/**
	 *
	 * @description: �Ӽ��̶�ȡ��Y����N������������Ϊ�����ķ���ֵ��
	 * @author: malin
	 * @creation time:2019��11��24������4:30:52
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
				System.out.println("ѡ��������������룺");
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
				System.out.println("���볤�ȣ�������"+limit +"���������������룺");
				continue;
			}break;
		}
		return line;
	}
}
