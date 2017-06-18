/**
 * 
 */
package org.hjn.effectivejava.test1;

/**
 * @author 29586
 *2.在子类中增加新的组件
 *体现equals的传递性
 */
public class Point {

	private final int x;
	private final int y;
	
	public Point(int x,int y){
	 this.x = x;
	 this.y = y;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Point)){
		    return false;
		}
		Point p = (Point) o;
		return p.x == x && p.y == y;
	}

}


