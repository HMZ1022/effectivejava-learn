/**
 * 
 */
package org.hjn.effectivejava.test3;

import java.util.ArrayList;

/**
 * @author 29586
 *2.字符串连接使用StringBuilder
 */
public class Statement {

	public String statement(){
		String s[] = {"aaa","ddd","ffff","eeeee"}; 
		StringBuilder b = new StringBuilder();
		for(int i = 0;i<4; i++){
			b.append(s[i]);
		}
		return b.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement st = new Statement();
		String s = st.statement();
		System.out.println(s);
		
	}

}
