package com.awt.test;

import java.lang.reflect.Method;
import java.util.List;

import com.awt.dealComponentImpl.CreateProgram;
import com.gui.DComp.DComp;

public class Test4 {
	private static Class<?> beanClass;
	public static void main(String[] arsg){
		beanClass = CreateProgram.class;
		System.out.println(getMethod1("dealComponent", 
				DComp.class, List.class, 
				com.awt.dealComponentImpl.ReFun.class));
	}
	
	public static Method getMethod(String methodName, Class<?>... typeParame){
		Method method = null;
		try {
			method = beanClass.getDeclaredMethod(methodName, typeParame);
		} catch (NoSuchMethodException | SecurityException e) {
			for(Method method_ : beanClass.getMethods()){
				System.out.println(method_.getName());
				if(method_.getName().equals(methodName)){
					System.out.println("找到");
					method = method_;
				}
			}
		}
		return method;
	}
	public static Method getMethod1(String methodName, Class<?>... typeParame){
		try {
			return beanClass.getDeclaredMethod(methodName, typeParame);
		} catch (NoSuchMethodException | SecurityException e) {
			for(Method method_ : beanClass.getMethods()){
				if(method_.getName().equals(methodName))
					return method_;
			}
		}
		return null;
	}
}
