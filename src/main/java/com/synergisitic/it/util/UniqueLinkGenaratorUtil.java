package com.synergisitic.it.util;

import java.util.Date;
import java.util.UUID;

public class UniqueLinkGenaratorUtil {
	/**
	 * 
	 * @param baseUrl
	 * @return
	 */
	static public String findUniqueCuid() {
		UUID uuid=UUID.randomUUID();
		String randomId= uuid.toString();
		System.out.println(randomId);
		Date date=new Date();
		long time=date.getTime();
		System.out.println(time);
		String finalId=time+"-"+ randomId;
		return finalId;
	}
	

}
