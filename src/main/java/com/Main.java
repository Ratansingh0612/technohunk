package com;

enum Element {
	EARTH, WIND, FIRE {
		 public String info() {
			return "Hot";
		}
	};
	public String info() {
		return "element";
	}
}

public class Main {
	public static void main(String[] args) {
		String element=Element.EARTH.info();
		System.out.println(element);
	}
}
