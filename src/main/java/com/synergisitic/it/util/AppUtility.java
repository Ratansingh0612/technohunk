package com.synergisitic.it.util;

import java.util.Random;

/**
 * 
 * @author nagendra
 * @since 26-Aug-2018
 */
public class AppUtility {
	
	/**
	 * 
	 * @return 9 digit unique employee code
	 * Randomly for all the consultants
	 */
	public static  String empCodeGen9Digit(){
		Random random=new Random();
		String empid=String.format("%09d", random.nextInt(1000000000));
		return empid;
	}

}
