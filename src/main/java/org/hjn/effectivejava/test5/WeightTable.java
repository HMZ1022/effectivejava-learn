/**
 * 
 */
package org.hjn.effectivejava.test5;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 29586
 *调用枚举类型，打印某物体在地球上的质量，以及在所有八颗行星上的质量
 */
public class WeightTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.Planet
		double earthWeight = Double.parseDouble("69999");
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		
		for(Planet p :Planet.values()){//返回值数组
			System.out.printf("Weight on %s is %f%n",p,p.surfaceWeight(mass));
		}
		
		//2.Operation
		double x = 2;
		double y = 3;
		
		double result = Operation.PLUS.apply(x, y);
		
		System.out.println(result);
		
		//5.Herb
		Herb[] garden ={new Herb("aa",Herb.Type.ANNUAL),new Herb("bb",Herb.Type.BIENNIAL)};
		
		Map<Herb.Type,Set<Herb>> herbsByType = new EnumMap<Herb.Type,Set<Herb>>(Herb.Type.class);
		
		for(Herb.Type t : Herb.Type.values()){
			herbsByType.put(t,new HashSet<Herb>());
		}
		for(Herb h : garden){
			herbsByType.get(h.type).add(h);
		}
		System.out.println(herbsByType);
		
		//6
		double x2 = Double.parseDouble("51");
		double y2 = Double.parseDouble("66");
		test(ExtendedOperation.class,x,y);
	}
	
	private static <T extends Enum<T> & Operation2> void test(Class<T> opSet,double x,double y){
		for(Operation2 op : opSet.getEnumConstants()){
			System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x, y));
		}
	}

}
