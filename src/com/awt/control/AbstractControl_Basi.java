package com.awt.control;

import javax.swing.JComponent;

import com.awt.context.ProgramContext;
import com.awt.util.UtilBeanContext;
import com.bean.support.ReSetterGetter;
import com.gui.DComp.DComp;
/**
 * <b>调用特定的方法给标签对象添加特定事件</b>
 * <p>
 * 描述:<br>
 * 创建事件服务类<br>
 * 读取标签中的事件，创建特定的服务类
 * 
 * 升级:<br>
 * 新的方法名(DoMain domain, DComp component)
 * 通过putEventMap向service—map注入method对象
 * @author 威 
 * <br>2018年4月15日 下午6:57:32
 * @see AbstractControl_Basi
 * @since 1.0
 */
public abstract class AbstractControl_Basi{
	protected ReSetterGetter reflectObject;
	
	/**
	 * 添加窗口事件
	 * <p>	
	 * 读取标签属性创建窗口服务类 
	 * @param domain
	 * @param component
	 * void
	 * @see #putFieldEventMap(Map, String, ReSetterGetter, Class)
	 * @see #createSetterGetter(BasiDoMain)
	 * @since 1.0
	 */
	/*public DComp createProgramService(DoMain domain, DComp component){
		WinEventDoMain program = (WinEventDoMain) domain;
		
		ReSetterGetter obj = createSetterGetter(program);
		
		Map<String, Method> eventMap = new HashMap<String, Method>();
		putEventMap(obj, 
				eventMap, 
				EventType.WindowType.values(), 
				WindowEvent.class);
		if(eventMap.size() > 0){
			try{
				putService("programService", component, eventMap);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return component;
	}*/

	/**
	 * 给组件put一个service服务对象
	 * <p>	 
	 * @param beanId		bean对象管理id
	 * @param component		组件
	 * @param eventMap		事件集
	 * @throws Exception
	 * void
	 * @see
	 * @since 1.0
	 */
	/*protected void putService(String beanId, DComp component, 
			Map<String, Method> eventMap) throws Exception {
		Service service = (Service) getBean(beanId);
		service.setComponent(component);
		service.setControl(this);
		service.setEventMap(eventMap);
	}*/
	
	/**
	 * 读取标签属性创建点击服务类
	 * <p>	 
	 * @param domain
	 * @param component
	 * void
	 * @see #putClickEventMap(Object, Map)
	 * @since 1.0
	 */
	/*public DComp createClickService(DoMain domain, DComp component){
		BasiDoMain domain_ = (BasiDoMain) domain;
		
		ReSetterGetter reSetterGetter = createSetterGetter(domain_);
		
		Map<String, Method> eventMap = new HashMap<String, Method>();
		putEventMap(reSetterGetter, 
				eventMap, 
				EventType.ClickType.values(), 
				MouseEvent.class);
		if(eventMap.size() > 0){
			try{
				putService("clickService", component, eventMap);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return component;
	}*/
	
	/**
	 * 读取标签属性创建文本服务类
	 * <p>	 
	 * 调用putClickEventMap向text元素追加点击方法
	 * @param domain
	 * @param component
	 * void
	 * @see #putFieldEventMap(Map, String, ReSetterGetter, Class)
	 * @see #putClickEventMap(BasiDoMain, Map)
	 * @since 1.0
	 */
	/*public DComp createTextService(DoMain domain, DComp component){
		TextDoMain domain_ = (TextDoMain) domain;
		
		ReSetterGetter obj = createSetterGetter(domain_);
		
		Map<String, Method> eventMap = new HashMap<String, Method>();
		putEventMap(obj, 
				eventMap, 
				EventType.TextType.values(), 
				ChangeEvent.class);
		putEventMap(obj, 
				eventMap, 
				EventType.ClickType.values(), 
				MouseEvent.class);
		if(eventMap.size() > 0){
			try {
				putService("textService", component, eventMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return component;
	}*/
	
	/**
	 * 向map中注入一个项
	 * <p>	 
	 * 通过domain对象获取 事件在control中的方法名称
	 * 通过反射获取control中的方法的对象
	 * 将方法对象装入map中
	 * @param map			service中的eventMap集合对象
	 * @param field			service中的特定事件属性
	 * @param object		ReSetterGetter对象，用当前domain对象创建的
	 * @param typeParame	控制类中某一方法的参数类型class<?>对象，通过此值反射获取对应的方法
	 * void
	 * @see com.bean.support.ReSetterGetter#getMethod(String, Class)
	 * @see com.bean.support.ReSetterGetter#getProperty(String)
	 * @since 1.0
	 */
	/*protected void putFieldEventMap(Map<String, Method> map, String field, ReSetterGetter object, Class<?> typeParame){
		try {
			String methodName = (String) object.getProperty(field);
			if(methodName != null){
				Print.out(this, "putEventMap", methodName);
				if(!methodName.equals(""))
					map.put(field, reflectObject.getMethod(methodName, typeParame));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * 将DoMain对象中的数据注入eventMap中 
	 * <p>	 
	 * 针对于ClickService注入<br>
	 * 
	 * @param object		DoMain对象或者ReSetterGetter对象
	 * @param eventMap		Map<String, Method> key：事件句柄，value：要执行的事件Method对象
	 * void
	 * @see #createSetterGetter(BasiDoMain)
	 * @since 1.0
	 */
	/*protected <T> void  putEventMap(ReSetterGetter obj, 
			Map<String, Method> eventMap, 
			T[] types,
			Class<?> classType) {
		for(T type : types){
			putFieldEventMap(eventMap, type.toString(), obj, classType);
		}
	}*/
	
	/**
	 * 创建一个ReSetterGetter对象
	 * <p>	 
	 * @param domain_
	 * @return
	 * ReSetterGetter	
	 * @since 1.0
	 */
	/*protected ReSetterGetter createSetterGetter(BasiDoMain domain_) {
		ReSetterGetter obj = new ReSetterGetter(); 
		try { 
			obj.setObject(domain_);
		} catch (BeanSupportException e) { 
			e.printStackTrace(); 
		}
		return obj;
	}*/
	
	/**
	 * 通过id以bean的方式创建对象
	 * <p>
	 * @param id
	 * @return
	 * @throws Exception
	 * Object
	 * @see com.awt.util.UtilBeanContext
	 * @since 1.0
	 */
	protected Object getBean(String id) throws Exception{
		return UtilBeanContext.getBean(id);
	}
	
	/**
	 * 通过名称获取组件
	 * <p>	 
	 * @param name 	组件名称
	 * @return
	 * Object
	 * @see com.awt.context.ProgramContext#getContext()
	 * @since 1.0
	 */
	protected Object getComponentByName(String name){
		return ProgramContext.getContext().get(name);
	}
	
	/**
	 * 向指定名称的容器添加组件
	 * <p>	 
	 * @param parentCompName	容器名称
	 * @param comp				组件对象
	 * @return
	 * JComponent
	 * @see #getComponentByName(String)
	 * @since 1.0
	 */
	protected JComponent add(String parentCompName, JComponent comp){
		return (JComponent) ((JComponent) getComponentByName(parentCompName)).add(comp);
	}
	
	/**
	 * 将一个组件添加进ProgramContext
	 * <p>	 
	 * 重载 {@link #put(String, DComp)}
	 * @param name
	 * @param comp
	 * void
	 * @see com.awt.context.ProgramContext#getContext()
	 * @since 1.0
	 */
	protected void put(String name, JComponent comp){
		ProgramContext.getContext().put(name, comp);
	}
	
	/**
	 * 将一个组件添加进ProgramContext
	 * <p>	 
	 * 重载 {@link #put(String, JComponent)}
	 * @param name
	 * @param comp   DComp组件对象
	 * void
	 * @see com.awt.context.ProgramContext#getContext()
	 * @since 1.0
	 */
	protected void put(String name, DComp comp){
		ProgramContext.getContext().put(name, comp.getComponent());
	}
	
}
