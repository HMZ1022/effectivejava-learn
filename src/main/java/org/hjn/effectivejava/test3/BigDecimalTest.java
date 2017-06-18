/**
 * 
 */
package org.hjn.effectivejava.test3;

import java.math.BigDecimal;

/**
 * @author 29586
 *1.���о�ȷ����ʱ����ʹ��float ��double
 *����BigDecimal �� int ,long ��������ֵ��С������
 */
public class BigDecimalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		final BigDecimal TEN_CENTS = new BigDecimal(".10");
		
		int itemsBought = 0;
		BigDecimal funds = new BigDecimal("1.00");
		for(BigDecimal price = TEN_CENTS; funds.compareTo(price)>=0; price = price.add(TEN_CENTS)){
			itemsBought++;
			funds = funds.subtract(price);
		}
		System.out.println(itemsBought + "items bought");
		System.out.println("Money left over:" + funds+ "cents");
		
	}

}
