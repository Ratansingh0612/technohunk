package com;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.synergisitic.it.util.DateUtils;

/**
 * 
 * @author yyyySS
 * eee
 * dddddddd
 * edfd
 * .......................................
 *
 */
public class Client{
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String sysdate= DateUtils.getCurrentDate();
		sysdate=DateUtils.getDateOfClass(sysdate);
		String currentDate=sysdate;
			   String currentSystemDate=sysdate;
			    // currentDate="2014-08-20";
				 String[] classDates=new String[7];
				 String dateTokens[]=currentDate.split("-");
				 Calendar xmas = new GregorianCalendar(Integer.parseInt(dateTokens[0]),Integer.parseInt(dateTokens[1])-1, Integer.parseInt(dateTokens[2]));
				  int currentDay = xmas.get(Calendar.DAY_OF_WEEK); // 6=Friday
				    
				 //int currentDay=DateUtils.findTodayDay();
				// int currentDay=4;
				 if(currentDay==1) { //When current day is Sunday
					 for(int pnext=6,start=0;pnext>=1;pnext--,start++) {
						 classDates[start]=DateUtils.previousDate(currentDate, pnext+1);
					 }
				 }else  if(currentDay==7) { //when current day is saturday
					 classDates[5]=currentDate;
					 for(int pnext=5,start=0;pnext>=1;pnext--,start++) {
						 classDates[start]=DateUtils.previousDate(currentDate, pnext);
					 }
				 }else {
					 int pDaysFromNow=currentDay-2;
					 int nDaysFromNow=6-currentDay;
					 classDates[currentDay-2]=currentDate;
				 
					 for(int pnext=0;pnext<pDaysFromNow;pnext++) {
						 classDates[currentDay-2-(pnext+1)]=DateUtils.previousDate(currentDate, pnext+1);
					 }
				 
					 for(int dnext=0;dnext<nDaysFromNow;dnext++) {
						 classDates[currentDay-2+dnext+1]=DateUtils.nextDate(currentDate, dnext+1);
					 }
				 }
				 
				 for(String s:classDates){
					 System.out.println(s);
				 }
	}
}