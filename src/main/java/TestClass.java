import com.tfc.dynamic_typing.IDynamicallyTypedClass;

import java.util.Arrays;

public class TestClass implements IDynamicallyTypedClass { // replace the return type "Object" with "void" if you want what the source code would be
	public Object __a$internalCall(Object[] args) {
		if (args.length == 0) {
			return a();
		} else {
			return fallbackMethod("a", args);
		}
	}
	
	public Object __b$internalCall(Object[] args) {
		if (args.length == 0) {
			return b();
		} else if (args.length == 1 && args[0] instanceof Integer) {
			return b((int) args[0]);
		} else if (args.length == 3 && args[0] instanceof Integer && args[2] instanceof String) {
			return b((int) args[0], args[1], (String) args[2]);
		} else {
			return fallbackMethod("b", args);
		}
	}
	
	public static void main(String[] args) {
		IDynamicallyTypedClass obj = new TestClass();
		DynamicTypingUtils.dynamicallyExec_TestClass$method_a(obj, new Object[]{}); // source line would be obj.a();
		DynamicTypingUtils.dynamicallyExec_TestClass$method_b(obj, new Object[]{}); // source line would be obj.b();
		DynamicTypingUtils.dynamicallyExec_TestClass$method_b(obj, new Object[]{4}); // source line would be obj.b(4);
		DynamicTypingUtils.dynamicallyExec_TestClass$method_b(obj, new Object[]{4, 6}); // source line would be obj.b(4, 6);
		System.out.println(DynamicTypingUtils.dynamicallyExec_TestClass$method_b(obj, new Object[]{4, 6L, "hi"})); // source line would be obj.b(4, 6L, "hi");
	}
	
	public Object a() {
		System.out.println("hi, this is being printed from method \"a\"");
		return null; // voids would return null
	}
	
	@Override
	public Object fallbackMethod(String name, Object[] args) {
		System.out.println("Method with name: " + name + " and arguments: " + Arrays.toString(IDynamicallyTypedClass.toClassArray(args)) + " fell back to the fallback method");
		return null;
	}
	
	public Object b() {
		System.out.println("hi, this is being printed from method \"b\"");
		return null;
	}
	
	public Object b(int a) {
		System.out.println("hi, this is being printed from method \"b\", provided integer is " + a);
		return null;
	}
	
	public Object b(int a, Object b, String c) { // here return type would be int in source code
		System.out.println("hi, this is being printed from method \"b\", provided integer is: " + a + ", provided object is: " + b + ", provided String is: \"" + c + "\"");
		return 5;
	}
}
