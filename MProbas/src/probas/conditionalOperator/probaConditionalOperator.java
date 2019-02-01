package probas.conditionalOperator;

public class probaConditionalOperator {

	
	
	public static void main(String[] args){
		
		System.out.println("-------------- INI ----------------");
		
		Integer i0 = Integer.valueOf(9999);
		
		Integer result0 = true ? i0 : 0;
		
		System.out.println("result0= "+result0);
		
		System.out.println("-----------------------------------");
		try{
			Integer i1 = null;
			
			Integer result1 = true ? i1 : 0;
			
			System.out.println("result1= "+result1);
			
		} catch(Exception e) {
			System.out.println("Falla: Integer result1 = true ? i1 : 0; [con Integer i1 = null;] - e= "+e);
		}
		System.out.println("-----------------------------------");
		
		try{
			Integer i2 = null;
			
			Integer result2 = false ? 0 : i2;
			
			System.out.println("result2= "+result2);
			
		} catch (Exception e) {
			System.out.println("Falla: Integer result2 = false ? 0 : i2; [Integer i2 = null;] - e= "+e);
		}
		
		System.out.println("-----------------------------------");
		
		Integer i3 = null;
		
		Integer result3 = true ? 0 : i3;
		
		System.out.println("result3= "+result3);
		
		System.out.println("-----------------------------------");
		
		Integer i4 = null;
		
		Integer result4 = false ? i4 : 0;
		
		System.out.println("result4= "+result4);
		
		System.out.println("-----------------------------------");
		
		Integer i5 = null;
		
		Integer result5 = true ? i5 : Integer.valueOf(0);
		
		System.out.println("result5= "+result5);

		System.out.println("-----------------------------------");
		Integer i6 = null;
		
		Integer result6 = false ? Integer.valueOf(0) : i6;
		
		System.out.println("result6= "+result6);

		System.out.println("-------------- FIN ----------------");
		
	}
}
