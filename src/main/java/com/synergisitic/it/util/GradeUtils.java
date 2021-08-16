package com.synergisitic.it.util;

import java.util.Random;

/**
 * 
 * @author nagendra.yadav
 * @since 17-Aug-2018
 *
 */
public class GradeUtils {
	
	
	public static int genRandom(){
			Random r = new Random();
			int low = 5;
			int high = 15;
			int result = r.nextInt(high-low) + low;
			return result;
			//System.out.println(result);
	}

	/**
	 * Method which is used to compute 
	 * the grade as per test cases passed by the system!
	 * @param totalTestCases
	 * @param passTests
	 * @return
	 */
	public static String computeGrade(int totalTestCases,int passTests){
		double percentage = ((double)passTests*100)/totalTestCases;
	    long result = Math.round(percentage);
	    String grade="UN";
	    if(result==100){
	    	//grade=CPGradeConstant.EXCELLENT;
	    	grade=(result-genRandom())+"";
	    }else if(result<100 && result>=80){
	    	//grade=CPGradeConstant.GOOD;
	    	grade=(result-genRandom()-2)+"";
	    }else if(result<80 && result>=70){
	    	//grade=CPGradeConstant.ABOVE_AVERAGE;
	    	grade=(result-genRandom()-2)+"";
	    }else if(result<70 && result>=50){
	    	//grade=CPGradeConstant.AVERAGE;
	    	grade=(result-genRandom()-5)+"";
	    }else{
	    	//grade=CPGradeConstant.BELOW_AVERAGE;
	    	result=35;
	    	grade=(result-genRandom())+"";
	    }
	    return grade;
	}
}
