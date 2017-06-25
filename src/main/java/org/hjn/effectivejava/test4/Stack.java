/**
 * 
 */
package org.hjn.effectivejava.test4;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author 29586
 *利用泛型实现简单的堆栈
 *定义类型时优先考虑泛型
 */
public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	//在确保程序是安全的情况下可以使用该注解最小范围的消除警告
	@SuppressWarnings("unchecked")
	public Stack(){
		
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
		
	}
	
	public void push(E e){
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop(){
		if(size == 0){
			throw new EmptyStackException();
		}
		
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	
	private void ensureCapacity(){
		if(elements.length == size){
			elements = Arrays.copyOf(elements,2 * size + 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Stack<String> stack = new Stack<String>();
     for(String arg : args){
    	 stack.push(arg);
     }
     while(!stack.isEmpty()){
    	 System.out.println(stack.pop().toUpperCase());
     }
	}

}
