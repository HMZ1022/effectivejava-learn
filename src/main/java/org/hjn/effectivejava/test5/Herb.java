/**
 * 
 */
package org.hjn.effectivejava.test5;

/**
 * @author 29586
 *5.用EnumMap代替序数索引
 */
public class Herb{

	public enum Type {ANNUAL,PERENNIAL,BIENNIAL}
	
	private final String name;
	public final Type type;
	
	Herb(String name,Type type){
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
