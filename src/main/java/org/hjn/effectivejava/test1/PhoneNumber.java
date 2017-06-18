/**
 * 
 */
package org.hjn.effectivejava.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 29586
 *3.重写equals方法时一定要重写hashcode保证相等的对象拥有相等的散列码
 *规则如下：
 *1.boolean类型：计算(f?1:0)
 *2.byte char short int类型：计算int(f)
 *3.long类型：计算(int)(f^(f>>>32))
 *4.float类型：计算Float.floatToIntBits(f)
 *5.double类型：计算Double.doubleToLongBits(f),然后重复3
 */
public class PhoneNumber {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;

	public PhoneNumber(int areaCode,int prefix,int lineNumber){
		rangeCheck(areaCode,999,"area Code");
		rangeCheck(prefix,999,"prefix");
		rangeCheck(lineNumber,999,"line Number");
		this.areaCode = (short)areaCode;
		this.prefix = (short)prefix;
		this.lineNumber = (short)lineNumber;
	}
	
	private static void rangeCheck(int arg,int max,String name){
		
		if(arg < 0 || arg > max){
			throw new IllegalArgumentException(name+":"+arg);
		}
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		if(!(o instanceof PhoneNumber)){
			return false;
		}
		PhoneNumber  pn = (PhoneNumber) o;
		return pn.areaCode == areaCode &&
				pn.prefix == prefix &&
				pn.lineNumber == lineNumber;
	}
	//使用31是因为它可以用移位和减法来代替乘法，会有更好的性能
	@Override
	public int hashCode(){
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<PhoneNumber,String> m = new HashMap<PhoneNumber,String>();
		
		m.put(new PhoneNumber(707, 867,539),"hejingning");
		//不重写Hashcode会返回null
		String str = m.get(new PhoneNumber(707, 867,539));
		System.out.println(str);
	}

}
