package reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
	
	public void method1(String str1, String str2) {
	        System.out.println(str1 +" "+ str2);
	}
    public void method1(String str, int number) {
        System.out.println(str + number);
    }

    public void method1(String str) {
        System.out.println(str);
    }

    public void method1() {
        System.out.println("helloworld");
    }
    
    public void method1(int[] arr,int num) {
    	System.out.println("_@_@_@Nagendra! Arra!!!!!!!!!!!!!!!!!!!!!!!!");
		for(int x:arr){
			System.out.print(x+" ");
		}
        System.out.println("num = "+num);
    }

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, IllegalArgumentException,
            InvocationTargetException {
        // Step 1) Make an object array and store the parameters that you wish
        // to pass it.
        //Object[] obj = {};// for method1()
        // Object[] obj={"hello"}; for method1(String str)
        // Object[] obj={"hello",1}; for method1(String str,int number)
        // Step 2) Create a class array which will hold the signature of the
        // method being called.
		int[] intarr = { 1, 2,5,8};
        Object[] obj = {intarr,1};
        Class<?> params[] = new Class[obj.length];
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] instanceof Integer) {
                params[i] = Integer.TYPE;
            } else if (obj[i] instanceof String) {
                params[i] = String.class;
            }else if (obj[i] instanceof int[]) {
                params[i] = int[].class;
            }
            // you can do additional checks for other data types if you want.
        }

        String methoName = "method1"; // methodname to be invoked
        String className = "reflections.ReflectionTest";// Class name
        Class<?> cls = Class.forName(className);
        Object _instance = cls.newInstance();
        Method myMethod = cls.getDeclaredMethod(methoName, params);
        myMethod.invoke(_instance, obj);
    }
}