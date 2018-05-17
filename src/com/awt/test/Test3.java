package com.awt.test;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test3 {
	private static Map<String, Class<?>> clazzMap = new HashMap<String, Class<?>>();
	
	public static void main(String[] args) {
		clazzMap.put("4", Integer.class);
		Integer o = 12;
		
		System.out.println(o.getClass().getTypeParameters().length);
		/*List<type> list = new ArrayList<type>();
		Type*/
		
		
		new Test3();
	}
}
