package datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatasProbas {

	final static SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");// 2001-07-04T12:08:56.235-0700
	final static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");// 2001-07-04T12:08:56-07:00

	public static void main(final String args[]) {
		final String d0 = "2019-09-08T22:00:00.000+0000";
		final String d1 = "2019-09-09T00:00:00+02:00";

		Date date0 = null;
		Date date1 = null;

		//		date0 = new Date(Date.parse(d0));
		//		date1 = new Date(Date.parse(d0));
		try {
			date0 = sdf0.parse(d0);
			date1 = sdf1.parse(d1);
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("date0= " + date0);
		System.out.println("date1= " + date1);

		System.out.println("date0.equals(date1)= " + date0.equals(date1));
		System.out.println("date0.equals(date1)= " + date0.getDay());

	}
}
