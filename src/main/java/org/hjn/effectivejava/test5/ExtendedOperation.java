/**
 * 
 */
package org.hjn.effectivejava.test5;

/**
 * @author 29586
 *6.用接口模拟可伸缩的枚举
 */
public enum ExtendedOperation implements Operation2{

	EXP("^"){
		public double apply(double x,double y){
			return Math.pow(x, y);
		}
	},
	REMAINDER("%"){
		public double apply(double x,double y){
			return x%y;
		}
	};
	
	private final String symbol;
	ExtendedOperation(String symbol){
		this.symbol = symbol;
	}
	
	@Override
	public String toString(){
		return symbol;
	}
}
