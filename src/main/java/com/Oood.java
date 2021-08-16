package com;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Oood {
 public static void main(String[] args) {
	  SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
	  ///
	     Calendar cal = Calendar.getInstance(); // creates calendar
	     Date cuDate=new Date();
	     System.out.println(dt.format(cuDate));
	    cal.setTime(new Date()); // sets calendar time/date
	    cal.add(Calendar.HOUR_OF_DAY, 48); // adds one hour
	   // returns new date object, one hour in the future
	    System.out.println(dt.format(cal.getTime()));
}
}
