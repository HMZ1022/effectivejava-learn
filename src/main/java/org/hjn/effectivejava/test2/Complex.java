/**
 * 
 */
package org.hjn.effectivejava.test2;

import org.hjn.effectivejava.test1.PhoneNumber;
import org.hjn.effectivejava.test1.Point;

/**
 * @author 29586
 *2.ʹ�ɱ�����С��  
 *i.ʹ��final
 *ii.ʹ�þ�̬����
 *ʵ�ָ���ʵ�����鲿�ķ��ʷ����Լ��Ӽ��˳�����
 */
//i ʹ��final
//public final class Complex {
//ii ʹ�þ�̬����
public class Complex {
	private final double re;
	private final double im;
    
	//i ʹ��final
//	public Complex(double re,double im){
//		this.re = re;
//		this.im = im;
//	}
	
	//ii ʹ�þ�̬����
	private Complex(double re,double im){
		this.re = re;
		this.im = im;
	}
	
	public static Complex valueOf(double re,double im){
		return new Complex(re,im);
	}
	//ii�����ṩ�����̬������ʵ�ֲ�ͬ�ĳ�ʼ��
	public static Complex valueOfPolar(double r,double theta){
		return new Complex(r*Math.cos(theta),r*Math.sin(theta));
	}
	
	public double realPart() {return re;}
	public double imaginaryPart() {return im;}
	
	public Complex add(Complex c){
		//�����µ�Complexʵ�����������޸����ʵ��
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
