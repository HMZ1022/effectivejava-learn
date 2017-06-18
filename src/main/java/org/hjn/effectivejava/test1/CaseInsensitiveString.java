/**
 * 
 */
package org.hjn.effectivejava.test1;

/**
 * @author 29586
 * 1.实现区分大小写的字符串
 * 体现equals方法的对称性
 * 4.实现comparable接口
 */
public  class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
	private final String s;
	
	public CaseInsensitiveString(String s){
		if(s==null){
			throw new NullPointerException();
		}
		this.s=s;
	}
	//
	@Override
	public boolean equals(Object o){
		if(o instanceof CaseInsensitiveString){
			return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
	    }
		//1.解决办法，去掉对String类型的操作
//		if(o instanceof String){
//			return s.equalsIgnoreCase((String) o);
//		}
		return false;
	}
	
	public int compareTo(CaseInsensitiveString cis){
		return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean result = true;
		//1	
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String s = "polish";
		//1。返回true
		result = cis.equals(s);
		System.out.println(result);
		//1。String的equals方法并未区分大小写，因此返回false 违反了对称性原则
		result = s.equals(cis);
		System.out.println(result);
		//4,调用compareTo函数
		int i = 0;
		CaseInsensitiveString cis2 = new CaseInsensitiveString("compare");
		i = cis2.compareTo(cis);
		System.out.println(i);
	}

}
