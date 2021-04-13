package com.tfc.dynamic_typing;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class DynamicMethodContainer {
	ArrayList<DynamicMethod> methods = new ArrayList<>();
	String className;
	
	public DynamicMethodContainer(Class<?> clazz) {
		for (Method method : clazz.getMethods()) {
			methods.add(new DynamicMethod(method.getParameterTypes(), method.getName()));
		}
	}
	
	public boolean containsMethod(Class[] args, String name) {
		return methods.contains(new DynamicMethod(args, name));
	}
	
	public boolean containsMethod(Object[] args, String name) {
		for (DynamicMethod method : methods) {
			if (method.isApplicable(args, name)) {
				return true;
			}
		}
		return false;
	}
}
