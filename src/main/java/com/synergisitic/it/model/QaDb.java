package com.synergisitic.it.model;

import java.util.ArrayList;
import java.util.List;

public class QaDb {
	

		public static List<String> getTechnologyList() {
			List<String> techList = new ArrayList<String>();
			techList.add("-- Select a technology --");
			techList.add("Core Java");
			techList.add("Spring MVC");
			techList.add("Hibernate");
			techList.add("Oracle");
			
			return techList;
		}
		
		public static List<String> optionList(String specimen) {
			List<String> optionList = new ArrayList<String>();

			if (specimen.equals("Core Java")) {
				optionList.add("a");
				optionList.add("b");
				optionList.add("c");
			} else if (specimen.equals("Spring")) {
				optionList.add("a");
				optionList.add("b");
				optionList.add("c");
			} else if (specimen.equals("Hibernate")) {
				optionList.add("a");
				optionList.add("b");
				optionList.add("c");
			} else if (specimen.equals("Oracle")) {
				optionList.add("a");
				optionList.add("b");
				optionList.add("c");
			} 
			return optionList;
		}
		
		
		
		
		
		
		
		
}
