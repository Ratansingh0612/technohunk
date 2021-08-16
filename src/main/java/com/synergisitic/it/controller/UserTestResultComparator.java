package com.synergisitic.it.controller;

import java.util.Comparator;

import com.synergisitic.it.web.form.UserForm;

public class UserTestResultComparator implements Comparator<UserForm>{

	@Override
	public int compare(UserForm o1, UserForm o2) {
		//System.out.println(o1);
		//System.out.println(o2);
		int status=0;
		 if(o1.getTechTestStatus()!=null && o2.getTechTestStatus()!=null) {
			     status= o1.getTechTestStatus().compareTo(o2.getTechTestStatus());
			     if(status==0){
			    	 if(o1.getScore()!=null && o2.getScore()!=null) {
			    	  double fscore=Double.parseDouble(o1.getScore()!=null?o1.getScore():"0");
			    	  double sscore=Double.parseDouble(o2.getScore()!=null?o2.getScore():"0");
			    	  if(fscore>sscore){
			    		 status=-1; 
			    	  }else if(fscore<sscore){
			    		  status=1;
			    	  }else{
			    		  status=0;
			    	  }
			    	 }
			    	 return status;
			     }
		 }
		return status;
	}

}
