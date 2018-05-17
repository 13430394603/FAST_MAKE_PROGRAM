package com.awt.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.awt.control.AbstractControl;
import com.awt.control.AbstractControl_Basi;
import com.gui.DComp.DComp;

/**
 * <b>处理组件对象事件逻辑基础父类</b>
 * @author 威 
 * <br>2018年4月11日 下午5:34:38 
 * @see com.awt.service.TextService
 * @see com.awt.service.ClickService
 * @see com.awt.service.ProgramService
 * @since 1.0
 */
public class Service {
	/**
	 * 控制对象
	 */
	protected AbstractControl_Basi control;
	/**
	 * 对应事件method对象集
	 */
	protected Map<String, Method> eventMap = new HashMap<String, Method>();
	/**
	 * 
	 */
	protected Object component;
	
	protected void init(Object comp){ }
	public void setComponent(DComp component){
		this.component = component.getComponent();
		if(this.component != null)
			init(component.getComponent());
	}
	
	public AbstractControl_Basi getControl() {
		return control;
	}
	public void setControl(AbstractControl_Basi control) {
		this.control = control;
	}
	
	public Map<String, Method> getEventMap() {
		return eventMap;
	}
	
	public void setEventMap(Map<String, Method> eventMap){
		this.eventMap.putAll(eventMap);
	}
	
	public void addEventMap(String key, Method method) {
		this.eventMap.put(key, method);
	}
	public Object getComponent(){
		return component;
	}
	/**
	 * 反射调用含有事件逻辑的Method对象
	 * <p>
	 * @param method
	 * @param e
	 * void
	 * @see #eventMap
	 * @see #init(Object)
	 * @since 1.0
	 */
	public void invoke(Method method, Object e){
		if(method != null){
			try {
				method.invoke(control, e);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void execute(){}
}
