package com.tfc.dynamic_typing;

import java.util.Arrays;

public interface IDynamicallyTypedClass {
	default Object fallbackMethod(String name, Object[] args) {
		throw new RuntimeException("Method " + name + " with args: " + Arrays.toString(toClassArray(args)));
	}
	
	static Class[] toClassArray(Object[] args) {
		Class[] classes = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			classes[i] = args[i].getClass();
		}
		return classes;
	}
}
