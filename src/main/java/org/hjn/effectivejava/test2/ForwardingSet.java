/**
 * 
 */
package org.hjn.effectivejava.test2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 29586
 *3.在现有类中增加一个私有域，引用现有类的一个实例（复合）
 *新类中每个实例方法都可以调用被包含的现有类实例中对应的方法，并返回它的结果（转发）
 */
public class ForwardingSet<E> implements Set<E> {
	private final Set<E> s;
	
	public ForwardingSet(Set<E> s){
		this.s = s;
	}
	public void clear(){
		s.clear();
	}
	public boolean contains(Object o){
		return s.contains(o);
	}
	
	public boolean isEmpty(){
		return s.isEmpty();
	}
	
	public int size(){
		return s.size();
	}
   
	public Iterator<E> iterator(){
		return s.iterator();
	}
	
	public boolean add(E e){
		return s.add(e);
	}
	
	public boolean remove(Object o){
		return s.remove(o);
	}
	
	public boolean containsAll(Collection<?> c){
		return s.containsAll(c);
	}
	
	public boolean addAll(Collection<? extends E> c){
		return s.addAll(c);
	}
	
	public boolean retainAll(Collection<?> c){
		return s.retainAll(c);
	}
	
	public Object[] toArray(){
		return s.toArray();
	}
	
	public <T> T[] toArray(T[] a){
		return s.toArray(a);
	}
	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}
	
	@Override
	public boolean equals(Object o){
		return s.equals(o);
	}
	
	@Override
	public int hashCode(){
		return s.hashCode();
	}
	
	@Override
	public String toString(){
	   return s.toString();	
	}
	

}
