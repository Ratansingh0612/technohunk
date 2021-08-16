package com.synergisitic.it.web.form;

import java.util.Comparator;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class GuestUserFromComparator implements Comparator<GuestUserForm> {

	@Override
	public int compare(GuestUserForm o1, GuestUserForm o2) {
		int p=0;
		if(o2!=null){
			p=o2.getDoe().compareTo(o1.getDoe());	
		}
		return p;
	}

}
