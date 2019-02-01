package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AccesPrivateStatic {
	
	
	public static void main(String[] args){
		Class clazz = ClaseConVariablePrivadaFinalStatica.class;
		
		Field field = null;
		
		try {					
			
			field = clazz.getDeclaredField("STATIC_PRIVATE");
			field.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			System.out.println("o actual valor de STATIC_PRIVATE= "+field.get(null));
			
			System.out.println("cambiando o valor de STATIC_PRIVATE= 300");
			field.set(null, 300);

			
			ClaseConVariablePrivadaFinalStatica clase = new ClaseConVariablePrivadaFinalStatica(2);
			System.out.println(clase.toString());
//			
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
