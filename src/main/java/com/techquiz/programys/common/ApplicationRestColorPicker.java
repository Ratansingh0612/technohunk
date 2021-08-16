package com.techquiz.programys.common;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRestColorPicker {

	private static List<String> colorList=new ArrayList<String>();
	
	public static List<String> getColorList(){
		
		colorList.add("#ff6666");
		colorList.add("#ffb3ff");
		colorList.add("#ecc6c6");
		colorList.add("#b3b3ff");
		colorList.add("#ffff99");
		colorList.add("#ccffcc");
		colorList.add("#99ccff");
		colorList.add("#b3ffff");
		colorList.add("#c2d6d6");
		colorList.add("#ffc6b3");
		colorList.add("#ffe6b3");
		colorList.add("#b3e6cc");
		colorList.add("#c2c2d6");
		colorList.add("#ffccff");
		colorList.add("#b94646");
		colorList.add("#ffb3b3");
		colorList.add("#9f6060");
		colorList.add("#c63939");
		colorList.add("#99ffcc");
		colorList.add("#80dfff");
		return colorList;
	}
}
