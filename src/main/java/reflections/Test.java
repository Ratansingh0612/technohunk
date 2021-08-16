package reflections;

import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws Exception {
		Class classToCall = Class.forName("reflections.Dao");
		String[] argu = { "1", "2","Nagendra" };
		int[] intarr = { 1, 2,5,8};
		Method methodToExecute = classToCall.getDeclaredMethod("Method1", new Class[] {int[].class});
		methodToExecute.invoke(classToCall.newInstance(), new Object[] { intarr });

	}

}
