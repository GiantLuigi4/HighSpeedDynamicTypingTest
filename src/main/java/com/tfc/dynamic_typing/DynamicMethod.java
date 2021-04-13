package com.tfc.dynamic_typing;

import java.util.Arrays;
import java.util.Objects;

public class DynamicMethod {
	public final Class[] args;
	public final String name;
	
	public DynamicMethod(Class[] args, String name) {
		this.args = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			if (args[i].getName().equals("int")) this.args[i] = Integer.class;
			else if (args[i].getName().equals("long")) this.args[i] = Long.class;
			else if (args[i].getName().equals("byte")) this.args[i] = Byte.class;
			else if (args[i].getName().equals("boolean")) this.args[i] = Boolean.class;
			else if (args[i].getName().equals("short")) this.args[i] = Short.class;
			else if (args[i].getName().equals("double")) this.args[i] = Double.class;
			else if (args[i].getName().equals("float")) this.args[i] = Float.class;
			else this.args[i] = args[i];
		}
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "DynamicMethod{" +
				"args=" + Arrays.toString(args) +
				", name='" + name + '\'' +
				'}';
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof DynamicMethod)) return false;
		if (((DynamicMethod) obj).args.length != this.args.length) return false;
		if (!((DynamicMethod) obj).name.equals(name)) {
			return false;
		}
		for (int i = 0; i < args.length; i++) {
			if (!args[i].isAssignableFrom(((DynamicMethod) obj).args[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = Objects.hash(name);
		result = 31 * result + Arrays.hashCode(args);
		return result;
	}
	
	public boolean isApplicable(Object[] args, String name) {
		if (!name.equals(this.name)) return false;
		if (args.length != this.args.length) return false;
		for (int i = 0; i < args.length; i++) {
			if (!this.args[i].isInstance(args[i])) {
				return false;
			}
		}
		return true;
	}
}
