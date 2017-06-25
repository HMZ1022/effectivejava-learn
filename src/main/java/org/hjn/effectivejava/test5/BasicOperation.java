/**
 * 
 */
package org.hjn.effectivejava.test5;

/**
 * @author 29586
 *
 */
public enum BasicOperation  implements Operation2{

	PLUS("+"){
		public double apply(double x,double y){
			return x + y;
		}
	},
	MINUS("-"){
		public double apply(double x,double y){
			return x-y;
		}
	},
	TIMES("*"){
		public double apply(double x,double y){
			return x*y;
		}
	},
	DIVIDE("/"){
		public double apply(double x,double y){
			return x/y;
		}
	};
	
	private final String symbol;
	
	BasicOperation(String symbol){
		this.symbol = symbol;
	}
	
	@Override
	public String toString(){
		return symbol;
	}
}
