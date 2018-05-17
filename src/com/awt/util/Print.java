package com.awt.util;

public class Print {
	public static boolean ALLOW_PRINT = true;
	private final static String ALERT_MSG = "！ALERT！";
	private final static String ERROR_MSG = "？ERROR？";
	private final static String COMMON_MSG = "-COMMON-";
	public static void out(Object clazzObject, Object object){
		out(clazzObject.getClass(), null, object, COMMON_MSG);
	}
	public static void out(Object clazzObject, String methodName, Object object){
		out(clazzObject.getClass(), methodName, object, COMMON_MSG);
	}
	
	public static void erro(Object clazzObject, Object object){
		out(clazzObject.getClass(), null, object, ERROR_MSG);
	}
	public static void erro(Object clazzObject, String methodName, Object object){
		out(clazzObject.getClass(), methodName, object, ERROR_MSG);
	}
	
	public static void alert(Object clazzObject, Object object){
		out(clazzObject.getClass(), null, object, ALERT_MSG);
	}
	public static void alert(Object clazzObject, String methodName, Object object){
		out(clazzObject.getClass(), methodName, object, ALERT_MSG);
	}
	private static void out(Class<?> clazz, String methodName, Object object, String otherMsg){
		if(ALLOW_PRINT && otherMsg.equals(COMMON_MSG)){
			System.out.println(new StringBuilder("class=").
					append(clazz.getSimpleName()).
					append((methodName != null ? "; method="+methodName : "" )).
					append(":").
					append(otherMsg != null ? "[" + otherMsg + "]" : "").toString());
			System.out.println("    "+object);
		}
	}
}
