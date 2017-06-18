/**
 * 
 */
package org.hjn.effectivejava.test2;

import org.hjn.effectivejava.test1.PhoneNumber;
import org.hjn.effectivejava.test1.Point;

/**
 * @author 29586
 *2.使可变性最小化  
 *i.使用final
 *ii.使用静态工厂
 *实现复数实部和虚部的访问方法以及加减乘除运算
 */
//i 使用final
//public final class Complex {
//ii 使用静态工厂
public class Complex {
	private final double re;
	private final double im;
    
	//i 使用final
//	public Complex(double re,double im){
//		this.re = re;
//		this.im = im;
//	}
	
	//ii 使用静态工厂
	private Complex(double re,double im){
		this.re = re;
		this.im = im;
	}
	
	public static Complex valueOf(double re,double im){
		return new Complex(re,im);
	}
	//ii可以提供多个静态工厂以实现不同的初始化
	public static Complex valueOfPolar(double r,double theta){
		return new Complex(r*Math.cos(theta),r*Math.sin(theta));
	}
	
	public double realPart() {return re;}
	public double imaginaryPart() {return im;}
	
	public Complex add(Complex c){
		//返回新的Complex实例，而不是修改这个实例
		return new Complex(re + c.re,im + c.im);
	}
	
	public Complex subtract(Complex c){
		return new Complex(re - c.re,im - c.im);
	}
	
	public Complex multiply(Complex c){
		return new Complex(re * c.re - im*c.im,re * c.re + im*c.im);
	}
	
	public Complex divide(Complex c){
		double tmp = c.re*c.re+c.im*c.im;
		return new Complex((re * c.re + im*c.im)/tmp,(re * c.re - im*c.im)/tmp);
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		if(!(o instanceof Complex)){
			return false;
		}
		Complex  c = (Complex) o;
		return Double.compare(re, c.re) == 0 &&  Double.compare(im, c.im) == 0;
	}
	
	@Override
	public int hashCode(){
		int result = 17 + hashDouble(re);
		result = 31 * result + hashDouble(im);
		return result;
	}
	
	private int hashDouble(double val){
		long longBits = Double.doubleToLongBits(re);
		return (int)(longBits^(longBits >>> 32));
	}
	
	@Override
	public String toString(){
		return "(" + re + " + " + im + "i)";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex cp ;
		cp = Complex.valueOf(1, 2);
		System.out.println("valueOf:"+cp);
		cp = Complex.valueOfPolar(1,2);
		System.out.println("valueOfPolar:"+cp);
	}

}
