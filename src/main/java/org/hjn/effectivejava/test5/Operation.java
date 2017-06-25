/**
 * 
 */
package org.hjn.effectivejava.test5;

/**
 * @author 29586
 *2.��ö������������һ�������apply������
 *�����ض��ڳ������������У�
 *�þ���ķ�������ÿ�������ĳ��󷽷���
 *�����constant-specific method implementation
 */
public enum Operation {

	PLUS("+"){
		double apply(double x, double y){return x + y;}
	},
	MINUS("-"){
		double apply(double x,double y) {return x + y;}
	},
	TIMES("*"){
		double apply(double x,double y){ return x + y;}
	},
	DIVIDE("/"){
		double apply(double x,double y){ return x + y;}
	};
	
	private final String symbol;
	Operation(String symbol){ this.symbol = symbol;}
	@Override
	public String toString(){
		return symbol;
	}
	//���󷽷�
	abstract double apply(double x,double y);
}
