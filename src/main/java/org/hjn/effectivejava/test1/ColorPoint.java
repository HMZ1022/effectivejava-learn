/**
 * 
 */
package org.hjn.effectivejava.test1;

import java.awt.Color;

/**
 * @author 29586
 *在子类中增加新的组件
 *体现equals的传递性
 */
//1.old version
//public class ColorPoint extends Point {
public class ColorPoint{
	//2.解决办法：采用组合而非继承
	private final Color color;
	private final Point point;
	
    public ColorPoint(int x,int y,Color color){
    	//1.old version
//    	super(x,y);
//    	this.color = color;
    	
    	if(color == null){
    		throw new NullPointerException();
    	}
    	
    	point = new Point(x,y);
    	this.color = color;
    }
    //1.old version
//    @Override
//    public boolean equals(Object o){
//    	if(!(o instanceof ColorPoint)){
//    		return false;
//    	}
//    	
//    	return super.equals(o) && ((ColorPoint) o).color == color;
//    }
    
    //2
    @Override
    public boolean equals(Object o){
    	if(!(o instanceof ColorPoint)){
    		return false;
    	}
    	ColorPoint cp = (ColorPoint) o;
    	return cp.point.equals(point) && cp.color.equals(color);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = true;
		
		ColorPoint p1 = new ColorPoint(1,2,Color.RED);
		Point p2 = new Point(1,2);
		ColorPoint p3 = new ColorPoint(1,2,Color.BLUE);
		//返回ture
		result = p1.equals(p2);
		System.out.println(result);
		//返回ture
		result = p2.equals(p3);
		System.out.println(result);
		//1.返回false,违反了传递性，
		//2.返回true
		result = p1.equals(p3);
		System.out.println(result);
		
	}

}
