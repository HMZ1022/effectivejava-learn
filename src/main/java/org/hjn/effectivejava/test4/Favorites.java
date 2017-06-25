/**
 * 
 */
package org.hjn.effectivejava.test4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 29586
*类型安全的异构容器
 */
public class Favorites {
	private Map<Class<?>,Object> favorites = new HashMap<Class<?>,Object>();
	
	public <T> void putFavorite(Class<T> type , T instance){
		if(type == null){
			throw new NullPointerException("Type is null");
			
		}
		
		//favorites.put(type,instance);
		//避免破坏键值约定
		favorites.put(type,type.cast(instance));
		
	}
	public <T> T getFavorite(Class<T> type){
		return type.cast(favorites.get(type));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Favorites f = new Favorites();
		f.putFavorite(String.class, "java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);
		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		Class<?> favoriteClass = f.getFavorite(Class.class);
		System.out.printf("%s,%x,%s%n",favoriteString,favoriteInteger,favoriteClass.getName());
	}

}
