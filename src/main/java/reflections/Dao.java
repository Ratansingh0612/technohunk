package reflections;

import java.util.Arrays;

public class Dao {

	public void Method2(String[] params) {
		System.out.println("_@_@_@Nagendra!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(Arrays.asList(params));
	}
	
	public void Method1(int[] params) {
		System.out.println("_@_@_@Nagendra!!!!!!!!!!!!!!!!!!!!!!!!!");
		for(int x:params){
			System.out.print(x+" ");
		}
	}

}
