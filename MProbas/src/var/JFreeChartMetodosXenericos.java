package var;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriod;

public class JFreeChartMetodosXenericos {

	
	public void proba1(){
		
		Calendar currentCalendar = new GregorianCalendar();
		currentCalendar.setTimeInMillis(System.currentTimeMillis());
		
		Minute minute = new Minute(currentCalendar.getTime());
		
		Map<Integer, Map<Minute, Integer>> m = new HashMap<Integer, Map<Minute,Integer>>();
		insertOrUpdate(m, 1, minute, 7);
		insertOrUpdate(m, 1, minute, 7);
		insertOrUpdate(m, 2, minute, 9);
		
		for (Integer i : m.keySet()) {
			System.out.println(" ---> "+minute+" --> "+m.get(i));
			for (Minute minuteee : m.get(i).keySet()) {
				System.out.println(" --------> "+minute+" --> "+m.get(i).get(minuteee));
			}
		}
		
		Calendar currentCalendar2 = new GregorianCalendar();
		currentCalendar2.setTimeInMillis(System.currentTimeMillis());
		
		Minute minute2 = new Minute(currentCalendar2.getTime());
		Hour hour = minute2.getHour();
		
		Map<Integer, Map<Hour, Integer>> m2 = new HashMap<Integer, Map<Hour,Integer>>();
		insertOrUpdate(m2, 1, hour, 7);
		insertOrUpdate(m2, 1, hour, 7);
		insertOrUpdate(m2, 2, hour, 9);
		
		for (Integer i : m2.keySet()) {
			System.out.println(" ---> "+minute2+" --> "+m2.get(i));
			for (Hour hourrr : m2.get(i).keySet()) {
				System.out.println(" --------> "+minute2+" --> "+m2.get(i).get(hourrr));
			}
		}
		
	}
	
	private<T extends RegularTimePeriod> Map<Integer, Map<T, Integer>> insertOrUpdate(Map<Integer, Map<T, Integer>> map, 
			Integer key1, T key2, Integer value){
		
		
		if(map.get(key1) != null){
			
			if(map.get(key1).get(key2) != null){
				Integer newValue = value + map.get(key1).get(key2);
				
				map.get(key1).put(key2, newValue);
			}else{
				map.get(key1).put(key2, value);
			}
			
		}else{
			Map<T, Integer> newMap2 = new HashMap<T, Integer>();
			newMap2.put(key2, value);
			
			map.put(key1, newMap2);
		}
		
		return map;
	}
	
	public static void main(String args[]){
		
		JFreeChartMetodosXenericos proba = new JFreeChartMetodosXenericos();
		
		proba.proba1();
	}
}