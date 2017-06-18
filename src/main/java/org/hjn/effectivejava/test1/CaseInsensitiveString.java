/**
 * 
 */
package org.hjn.effectivejava.test1;

/**
 * @author 29586
 * 1.ʵ�����ִ�Сд���ַ���
 * ����equals�����ĶԳ���
 * 4.ʵ��comparable�ӿ�
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
		//1.����취��ȥ����String���͵Ĳ���
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
		//1������true
		result = cis.equals(s);
		System.out.println(result);
		//1��String��equals������δ���ִ�Сд����˷���false Υ���˶Գ���ԭ��
		result = s.equals(cis);
		System.out.println(result);
		//4,����compareTo����
		int i = 0;
		CaseInsensitiveString cis2 = new CaseInsensitiveString("compare");
		i = cis2.compareTo(cis);
		System.out.println(i);
	}

}
