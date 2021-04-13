import com.tfc.dynamic_typing.IDynamicallyTypedClass;

import java.util.Arrays;

public class TestClassSRC implements IDynamicallyTypedClass {
	public static void main(String[] args) {
		TestClass obj = new TestClass();
		obj.a();
		obj.b();
		obj.b(4);
//		obj.b(4, 6);
		System.out.println(obj.b(4, 6L, "hi"));
	}
	
	public void a() {
		System.out.println("hi, this is being printed from method \"a\"");
	}
	
	@Override
	public Object fallbackMethod(String name, Object[] args) {
		System.out.println("Method with name: " + name + " and arguments: " + Arrays.toString(IDynamicallyTypedClass.toClassArray(args)) + " fell back to the fallback method");
		return null;
	}
	
	public void b() {
		System.out.println("hi, this is being printed from method \"b\"");
	}
	
	public void b(int a) {
		System.out.println("hi, this is being printed from method \"b\", provided integer is " + a);
	}
	
	public int b(int a, Object b, String c) { // here return type would be int in source code
		System.out.println("hi, this is being printed from method \"b\", provided integer is: " + a + ", provided object is: " + b + ", provided String is: \"" + c + "\"");
		return 5;
	}
}
