package com.awt.context;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * <b>装载整个程序对象<b>
 * @author 威 
 * <br>2018年4月11日 下午5:42:44 
 *
 */
public class ProgramContext {
	private static Map<String, Object> componentContext = new HashMap<String, Object>();
	private static Map<String, Object> sessionContext = new HashMap<String, Object>();
	public static Map<String, Object> getContext() {
		return componentContext;
	}
	public static Map<String, Object> getSession(){
		return sessionContext;
	}
}
