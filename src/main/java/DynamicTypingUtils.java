import com.tfc.dynamic_typing.DynamicMethodContainer;
import com.tfc.dynamic_typing.IDynamicallyTypedClass;
import com.tfc.dynamic_typing.exceptions.IllegalDynamicArgumentException;

import java.util.HashMap;

public class DynamicTypingUtils {
	private static DynamicMethodContainer TestClassContainer = null;
	
	private static HashMap<Class<?>, DynamicMethodContainer> containers = new HashMap<>(); // ideally this'd be a faster map then a hashmap, but idk how to program a faster map nor do I know if java has a faster one which is out of the box, ready to use built in
	
	public static boolean checkHasMethod(Class<?> clazz, String name, Object[] args) {
		if (!containers.containsKey(clazz)) containers.put(clazz, new DynamicMethodContainer(clazz));
		return containers.get(clazz).containsMethod(args, name);
	}
	
	public static Object dynamicallyExec_TestClass$method_a(Object obj, Object[] args) {
		if (obj instanceof IDynamicallyTypedClass) {
			if (TestClassContainer == null) TestClassContainer = new DynamicMethodContainer(TestClass.class);
			if (TestClassContainer.containsMethod(args, "a"))
				return ((TestClass) obj).__a$internalCall(args); // this but without the cast
			else return ((IDynamicallyTypedClass) obj).fallbackMethod("a", args);
		} else if (checkHasMethod(obj.getClass(), "a", args)) return ((TestClass) obj).a(); // this but without cast
		throw new IllegalDynamicArgumentException("Cannot call method a on " + obj.getClass() + " as it is not dynamically typed and does not have a matching method");
	}
	
	public static Object dynamicallyExec_TestClass$method_b(Object obj, Object[] args) {
		if (obj instanceof IDynamicallyTypedClass) {
			if (TestClassContainer == null) TestClassContainer = new DynamicMethodContainer(TestClass.class);
			if (TestClassContainer.containsMethod(args, "b"))
				return ((TestClass) obj).__b$internalCall(args); // this but without the cast
			else return ((IDynamicallyTypedClass) obj).fallbackMethod("b", args);
		} else if (checkHasMethod(obj.getClass(), "b", args)) {
			if (args.length == 0) return ((TestClass) obj).b(); // this but without the cast
			else if (args.length == 1 && args[0] instanceof Integer)
				return ((TestClass) obj).b((Integer) args[0]); // this but without the cast
			else if (args.length == 3 && args[0] instanceof Integer && args[2] instanceof String)
				return ((TestClass) obj).b((Integer) args[0], args[1], (String) args[2]); // this but without the cast
		}
		throw new IllegalDynamicArgumentException("Cannot call method b on " + obj.getClass() + " as it is not dynamically typed and does not have a matching method");
	}
}
