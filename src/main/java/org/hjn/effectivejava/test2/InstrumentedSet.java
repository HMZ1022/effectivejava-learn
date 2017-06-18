/**
 * 
 */
package org.hjn.effectivejava.test2;

import java.util.Collection;
import java.util.Set;

/**
 * @author 29586
 *3.对这个例子有些困惑
 */
//FIXME 为什么这里依然使用了继承？
public class InstrumentedSet<E> extends ForwardingSet<E> {

	private int addCount = 0;
	
	public InstrumentedSet(Set<E> s){
		super(s);
	}
	
	@Override
	public boolean add(E e){
		addCount++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c){
		addCount += c.size();
		return super.addAll(c);
	}
	
	public int getAddCount(){
		return addCount;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
