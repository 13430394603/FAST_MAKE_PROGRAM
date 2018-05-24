package com.gui.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * <b>输出一个类的构造方法和成员方法</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年4月16日 下午7:50:51 
 * @see
 * @since 1.0
 */
public class ClassInformation {
	//===========================================================
	//========= 获取类所有信息包括父类（属性、构造、方法、内部类、接口）  ==========
	//===========================================================
	/**
	 * 获取类的所有信息
	 * <p>	 
	 * （属性、构造、方法、内部类、接口）<br>
	 * 包括父类
	 * @param clazz
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void getClassInfor(Class<?> clazz){
		getClassInfor(clazz, 0);
	}
	protected static void getClassInfor(Class<?> clazz, int space){
		Class<?> clazzProxy = clazz;
		System.out.println(getSpace(space)+"----------------- "+clazz.getName()+" -----------------");
		getDclareFields(space, clazzProxy);
		getDclareConstructors(space, clazzProxy);
		getDclareMehods(space, clazzProxy);
		getDclareInclass(space, clazzProxy);
		getDclareInterfaces(space, clazzProxy);
		System.out.println(getSpace(space+1)+"*superClass:");
		Class<?> cl = clazzProxy.getSuperclass();
		if(cl != null)
			getClassInfor(cl, space+1);
	}
	
	//===========================================================
	//=================== 获取类的接口类信息包括父类  ====================
	//===========================================================
	/**
	 * 获取类的接口类信息
	 * <p>	 
	 * 包括父类
	 * @param clazzProxy
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void getClassInterfaces(Class<?> clazzProxy){
		getClassInterfaces(0, clazzProxy);
	}
	protected static void getClassInterfaces(int space, Class<?> clazzProxy){
		System.out.println(getSpace(space)+"---------------- "+clazzProxy.getName()+" ---------------");
		getDclareInterfaces(space, clazzProxy);
		Class<?> clazz = clazzProxy.getSuperclass();
		if(clazz != null)
			getClassInterfaces(space+1, clazz);
	}
	protected static void getDclareInterfaces(int space, Class<?> clazzProxy) {
		System.out.println(getSpace(space+1)+"*interface:");
		for(Class<?> cla : clazzProxy.getInterfaces()){
			System.out.println(getSpace(space+2)+cla.getName());
		}
	}
	
	//===========================================================
	//=================== 获取类的内部类信息包括父类  ====================
	//===========================================================
	/**
	 * 获取类的内部类信息
	 * <p>	 
	 * 包括父类 
	 * @param clazzProxy
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void getClassInclass(Class<?> clazzProxy){
		getClassInclass(0, clazzProxy);
	}
	protected static void getClassInclass(int space, Class<?> clazzProxy){
		System.out.println(getSpace(space)+"---------------- "+clazzProxy.getName()+" ---------------");
		getDclareInclass(space, clazzProxy);
		Class<?> clazz = clazzProxy.getSuperclass();
		if(clazz != null)
			getClassInclass(space+1, clazz);
	}
	protected static void getDclareInclass(int space, Class<?> clazzProxy) {
		System.out.println(getSpace(space+1)+"*in_clazzs:");
		//内部类
		for(Class<?> cla : clazzProxy.getDeclaredClasses()){
			System.out.println(getSpace(space+2)+cla.getName());
		}
	}
	
	//===========================================================
	//==================== 获取类的属性信息包括父类  =====================
	//===========================================================
	/**
	 * 获取类的属性信息
	 * <p>	 
	 * 包括父类
	 * @param clazzProxy
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void getClassFieldsInfor(Class<?> clazzProxy){
		getClassFieldsInfor(0, clazzProxy);
	}
	protected static void getClassFieldsInfor(int space, Class<?> clazzProxy){
		System.out.println(getSpace(space)+"---------------- "+clazzProxy.getName()+" ---------------");
		getDclareFields(space, clazzProxy);
		Class<?> clazz = clazzProxy.getSuperclass();
		if(clazz != null)
			getClassFieldsInfor(space+1, clazz);
	}
	protected static void getDclareFields(int space, Class<?> clazzProxy) {
		System.out.println(getSpace(space+1)+"*fileds:");
		for(Field field : clazzProxy.getFields()){
			StringBuilder fieldString = new StringBuilder() ;
			fieldString.append(field.getType()).append(" ").append(field.getName());
			System.out.println(getSpace(space+2)+fieldString);
		}
	}
	
	//===========================================================
	//==================== 获取类的构造信息包括父类  =====================
	//===========================================================
	/**
	 * 获取类的构造信息
	 * <p>	 
	 * 包括父类
	 * @param clazzProxy
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void getClassConstructorsInfor(Class<?> clazzProxy){
		getClassConstructorsInfor(0, clazzProxy);
	}
	protected static void getClassConstructorsInfor(int space, Class<?> clazzProxy){
		System.out.println(getSpace(space)+"---------------- "+clazzProxy.getName()+" ---------------");
		getDclareConstructors(space, clazzProxy);
		Class<?> clazz = clazzProxy.getSuperclass();
		if(clazz != null)
			getClassConstructorsInfor(space+1, clazz);
	}
	@SuppressWarnings("rawtypes")
	protected static void getDclareConstructors(int space, Class<?> clazzProxy) {
		System.out.println(getSpace(space+1)+"*constroctors:");
		for(Constructor constructor : clazzProxy.getConstructors()){
			StringBuilder sb = new StringBuilder() ;
			sb.append(clazzProxy.getSimpleName() + "(");
			Class<?>[] parameterTypes = constructor.getParameterTypes() ;
			for(Class parameterType : parameterTypes){
				sb.append(parameterType.getSimpleName() + ",");
			}
			if(parameterTypes != null & parameterTypes.length != 0)
				sb.deleteCharAt(sb.length()-1);
			sb.append(")");
			System.out.println(getSpace(space+2)+sb.toString());
		}
	}
	
	//===========================================================
	//===================== 获取方法信息包括父类 =======================
	//===========================================================
	/**
	 * 获取方法信息
	 * <p>	
	 * 包括父类 
	 * @param clazzProxy
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void getClassMethodsInfor(Class<?> clazzProxy){
		getClassMethodsInfor(0, clazzProxy);
	}
	
	protected static void getClassMethodsInfor(int space, Class<?> clazzProxy){
		System.out.println(getSpace(space)+"---------------- "+clazzProxy.getName()+" ---------------");
		getDclareMehods(space, clazzProxy);
		Class<?> clazz = clazzProxy.getSuperclass();
		if(clazz != null)
			getClassMethodsInfor(space+1, clazz);
	}
	@SuppressWarnings("rawtypes")
	protected static void getDclareMehods(int space, Class<?> clazzProxy) {
		System.out.println(getSpace(space+1)+"*methods:");
		for(Method method : clazzProxy.getDeclaredMethods()){
			StringBuilder sb = new StringBuilder() ;
			sb.append(method.getName() + "(");
			Class<?>[] parameterTypes = method.getParameterTypes() ;
			for(Class parameterType : parameterTypes){
				sb.append(parameterType.getSimpleName() + ",");
			}
			if(parameterTypes != null & parameterTypes.length != 0)
				sb.deleteCharAt(sb.length()-1);
			sb.append(")");
			System.out.println(getSpace(space+2)+sb.toString());
		}
	}
	/**
	 * 获取空格
	 * <p>	 
	 * @param space
	 * @return
	 * String
	 * @see
	 * @since 1.0
	 */
	private static String getSpace(int space){
		String sb = "    ";
		for(int i = 0; i < space+1; i ++){
			sb += "    ";
		}
		return sb;
	}
}
