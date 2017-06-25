/**
 * 
 */
package org.hjn.effectivejava.test5;

/**
 * @author 29586
 *2.在枚举类型中声明一个抽象的apply方法，
 *并在特定于常量的类主体中，
 *用具体的方法覆盖每个常量的抽象方法。
 *这叫做constant-specific method implementation
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
	//抽象方法
	abstract double apply(double x,double y);
}
