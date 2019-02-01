package var;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IterateSet {

	private static void recorreKeySet(){
		
		Map<Short, String> m = new HashMap<Short, String>();
		
		m.put((short)1, "uno");
		m.put((short)2, "dos");
		m.put((short)3, "tres");
		m.put((short)4, "cuatro");
		m.put((short)5, "cinco");
		
		Set<Short> set = m.keySet();

		for (Short s : set) {
			System.out.println(s+",");
		}
		
				
				
		
		
	}
	
	
	public static void main(String[] args) {
		recorreKeySet();
	}
}
