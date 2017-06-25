package org.hjn.effectivejava.test4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 29586
 *优先考虑泛型方法
 */
public class GenericFunction {

	public static <E> Set<E> union(Set<E> s1, Set<E> s2){
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> guys = new HashSet<String>(Arrays.asList("Tom","Dick","Harry"));
		Set<String> stooges = new HashSet<String>(Arrays.asList("Larry","Moe","Curly"));
		Set<String> aflCio = union(guys,stooges);
		
		System.out.println(aflCio);
	}

}
