/**
 * 
 */
package org.hjn.effectivejava.test1;

import java.awt.Color;

/**
 * @author 29586
 *�������������µ����
 *����equals�Ĵ�����
 */
//1.old version
//public class ColorPoint extends Point {
public class ColorPoint{
	//2.����취��������϶��Ǽ̳�
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
		//����ture
		result = p1.equals(p2);
		System.out.println(result);
		//����ture
		result = p2.equals(p3);
		System.out.println(result);
		//1.����false,Υ���˴����ԣ�
		//2.����true
		result = p1.equals(p3);
		System.out.println(result);
		
	}

}
