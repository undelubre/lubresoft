package formatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
 * 
 *  %[argument_index$][flags][width][.precision]conversion
 * 
 * 
 * */
public class Formateando {
	
	
	public static void main(String[] args){
		
		
		Calendar cal = new Calendar.Builder().build();
		SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(formateador.format(dateobj));
		System.out.println(df.format(dateobj));
		
		System.out.println("\n----------------------------------------------------------------------\n");
		
		String sDecimal00 = "999";
		String sDecimal00F = sDecimal00.format("%010d", Integer.parseInt(sDecimal00));

		String sDecimal01 = "-999";
		String sDecimal01F = sDecimal00.format("%0 10d", Integer.parseInt(sDecimal00));

		String sDecimal02 = "-999";
		String sDecimal02F = sDecimal00.format("%0+10d", Integer.parseInt(sDecimal00));

		String sDecimal03 = "-999";
		String sDecimal03F = sDecimal00.format("%0,(10d", Integer.parseInt(sDecimal00));

		String sDecimal04 = "-999";
		String sDecimal04F = sDecimal00.format("%-(10d", Integer.parseInt(sDecimal00));
		
		String sDecimal05 = "-999";
		String sDecimal05F = sDecimal00.format("%10d", Integer.parseInt(sDecimal00));
		
		System.out.println("formateando "+sDecimal00+" --> "+sDecimal00F);
		System.out.println("formateando "+sDecimal01+" --> "+sDecimal01F);
		System.out.println("formateando "+sDecimal02+" --> "+sDecimal02F);
		System.out.println("formateando "+sDecimal03+" --> "+sDecimal03F);
		System.out.println("formateando "+sDecimal04+" --> "+sDecimal04F);
		System.out.println("formateando "+sDecimal05+" --> "+sDecimal05F);
	}
}
