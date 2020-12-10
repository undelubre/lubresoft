package var;

import org.apache.commons.lang3.BooleanUtils;

public class BooleanUtilExemplo {

/*	
	BooleanUtils.isNotTrue(null) --> verdadeiro
	BooleanUtils.isFalse(null) --> falso
	BooleanUtils.isFalse(Boolean.TRUE) --> falso
	BooleanUtils.isFalse(Boolean.FALSE) --> verdadeiro
*/
	public static void main(String[] args)
	{
		if(BooleanUtils.isNotTrue(null))
		{
			System.out.println("BooleanUtils.isNotTrue(null) --> verdadeiro");
		} else {
			System.out.println("BooleanUtils.isNotTrue(null) --> falso");
			
		}

		if(BooleanUtils.isFalse(null))
		{
			System.out.println("BooleanUtils.isFalse(null) --> verdadeiro");
		} else {
			System.out.println("BooleanUtils.isFalse(null) --> falso");
			
		}
		if(BooleanUtils.isFalse(Boolean.TRUE))
		{
			System.out.println("BooleanUtils.isFalse(Boolean.TRUE) --> verdadeiro");
		} else {
			System.out.println("BooleanUtils.isFalse(Boolean.TRUE) --> falso");
			
		}
		if(BooleanUtils.isFalse(Boolean.FALSE))
		{
			System.out.println("BooleanUtils.isFalse(Boolean.FALSE) --> verdadeiro");
		} else {
			System.out.println("BooleanUtils.isFalse(Boolean.FALSE) --> falso");
			
		}
		
	}


}
