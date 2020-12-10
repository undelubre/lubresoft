package datas;

import java.sql.Timestamp;
import java.util.Calendar;

public class CalendarVar {

	

public static void main(String[] args)
{
	Calendar c = Calendar.getInstance();
	c.add(Calendar.DAY_OF_YEAR, -9);
	Timestamp tms0 = new Timestamp(c.getTimeInMillis());
	
	c = Calendar.getInstance();
	c.add(Calendar.DAY_OF_MONTH, -9);
	Timestamp tms1 = new Timestamp(c.getTimeInMillis());
	c = Calendar.getInstance();
	
	c.add(Calendar.DAY_OF_WEEK, -9);
	Timestamp tms2 = new Timestamp(c.getTimeInMillis());
	
	c.add(Calendar.DAY_OF_WEEK_IN_MONTH, -9);
	Timestamp tms3 = new Timestamp(c.getTimeInMillis());

	System.out.println("Calendar.DAY_OF_YEAR, -9: "+tms0);
	System.out.println("Calendar.DAY_OF_MONTH, -9: "+tms1);
	System.out.println("Calendar.DAY_OF_WEEK, -9: "+tms2);
	System.out.println("Calendar.DAY_OF_WEEK_IN_MONTH, -9: "+tms3);
}

}
