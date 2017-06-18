/**
 * 
 */
package org.hjn.effectivejava.test1;

/**
 * @author 29586
 *2.�������������µ����
 *����equals�Ĵ�����
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


