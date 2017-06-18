/**
 * 
 */
package org.hjn.effectivejava.test2;

/**
 * @author 29586
 *1.共有类中使用访问方法而非公有域
 */
public class Point {
	private  double x;
	private  double y;
	
	public Point(double x,double y){
	 this.x = x;
	 this.y = y;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(1,2);
		double x=0;
		double y=0;
		
		x= p.getX();
		y = p.getY();
	    System.out.println("x:" + x + "y:" + y);
	    
		p.setX(3);
		p.setY(4);
		
		x= p.getX();
		y = p.getY();
		System.out.println("x:" + x + "y:" + y);
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}

}
