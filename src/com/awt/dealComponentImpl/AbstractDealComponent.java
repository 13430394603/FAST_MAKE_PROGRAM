package com.awt.dealComponentImpl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.awt.control.AbstractControl_Basi;
import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.awt.domain.ServiceDoMain;
import com.awt.service.Service;
import com.awt.util.Print;
import com.awt.util.UtilBeanContext;
import com.bean.exception.BeanSupportException;
import com.bean.support.ReSetterGetter;
import com.gui.DComp.DComp;
/**
 * <b>一句话描述该类</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年4月30日 上午11:27:17 
 * @see
 * @since 1.0
 */
public abstract class AbstractDealComponent {
	protected ReSetterGetter reflectObject;
	/**
	 * 获取TagType.*Type.values 数组对象
	 * <p>	 
	 * 一个组件的所有type集<br>
	 * 例如：return (T[]) TagType.ButtonType.values();
	 * @return
	 * T[]
	 * @see
	 * @since 1.0
	 */
	protected abstract <T> T[] enumType();
	/**
	 * 获取对应的Service对象
	 * <p>	 
	 * 此处通过bean获取
	 * @return
	 * Service
	 * @see
	 * @since 1.0
	 */
	protected abstract Service service();
	/**
	 * 给eventMap事件集put相应的并且存在的事件
	 * <p>	
	 *  例如：putEventMap(reSetterGetter, eventMap, EventType.ClickType.values(), 
				MouseEvent.class);
	 * @param reSetterGetter	反射对象
	 * @param eventMap			事件集
	 * void
	 * @see #putEventMap(ReSetterGetter, Map, Object[], Class)
	 * @since 1.0
	 */
	protected abstract <T> void serviceEventMap(ReSetterGetter reSetterGetter, 
			Map<String, Method> eventMap);
	/**
	 * 将item转换成TagType.*Type对象并执行.getComponent方法获取组件
	 * <p>	
	 * 例如：((TagType.ButtonType) item).getComponent(domain)
	 * @param domain
	 * @param item
	 * @return 
	 * T
	 * @see com.awt.enuma.TagType
	 * @since 1.0
	 */
	protected abstract <T> T parseComp(DoMain domain, T item);
	/**
	 * 获取组件
	 * <p>	 
	 * @param domain		当前组件的模型对象
	 * @param control		Control对象
	 * @return
	 * DComp
	 * @since 1.0
	 */
	public <T> DComp getComponent(DoMain domain, AbstractControl_Basi control) {
		try {
			reflectObject = (ReSetterGetter) getBean("setGetObject");
			reflectObject.setObject(control);
		} catch (Exception e) {
			e.printStackTrace();
		}
		T[] lists = enumType();
		for(T item : lists){
			if(item.toString().equals(((BasiDoMain) domain).getType()))
				return dealService(domain, 
						(DComp) parseComp(domain, item), control);
		}
		Print.erro(this, "createButton", "createButton标签异常");
		return null;
	}
	public void dealService(DComp nowDComp, List<ServiceDoMain> serivices){
		for(ServiceDoMain service : serivices){
			try {
				Class<?> clazz = Class.forName(service.getClass_path());
				Service proSer = (Service) clazz.newInstance();
				proSer.setComponent(nowDComp);
				proSer.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * dealService 处理组件的service服务接口
	 * <p>	 
	 * @param domain
	 * @param component
	 * @param control
	 * @return
	 * DComp
	 * @see
	 * @since 1.0
	 */
	protected DComp dealService(DoMain domain, DComp component, AbstractControl_Basi control){
		BasiDoMain domain_ = (BasiDoMain) domain;
		ReSetterGetter reSetterGetter = createSetterGetter(domain_);
		Map<String, Method> eventMap = new HashMap<String, Method>();
		serviceEventMap(reSetterGetter, eventMap);
		if(eventMap.size() > 0) putService(component, eventMap, control);
		return component;
	}
	/**
	 * 填充子组件内部处理方法
	 * <p>	 
	 * 经过parseListType将Object转换成List对象<br>
	 * 容器容器组件特有的处理<br>
	 * @param nowObj		当前组件
	 * @param domains		DoMain集对象
	 * @param reFun			ReFun回调接口
	 * void
	 * @see #dealComponent(DComp, Object, ReFun)
	 * @see #parseListType(Object)
	 * @since 1.0
	 */
	protected abstract void dealComponent1(DComp nowObj, List<DoMain> domains, ReFun reFun);
	/**
	 * 处理子组件同意调用接口
	 * <p>	 
	 * 容器容器组件特有的处理<br>
	 * @param nowObj		当前组件
	 * @param domains		DoMain集对象
	 * @param reFun			ReFun回调接口
	 * void
	 * @see #dealComponent1(DComp, List, ReFun)
	 * @since 1.0
	 */
	public abstract void dealComponent(DComp nowObj, Object domains, ReFun reFun);
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
	protected void putService(DComp component, 
			Map<String, Method> eventMap, AbstractControl_Basi control) {
		Service service = service();
		service.setComponent(component);
		service.setControl(control);
		service.setEventMap(eventMap);
	}
	/**
	 * 创建一个ReSetterGetter对象
	 * <p>	 
	 * @param domain_
	 * @return
	 * ReSetterGetter	
	 * @since 1.0
	 */
	protected ReSetterGetter createSetterGetter(BasiDoMain domain_) {
		ReSetterGetter obj = new ReSetterGetter(); 
		try { 
			obj.setObject(domain_);
		} catch (BeanSupportException e) { 
			e.printStackTrace(); 
		}
		return obj;
	}
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
	protected void putFieldEventMap(Map<String, Method> map, String field, ReSetterGetter object, Class<?> typeParame){
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
	}
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
	protected <T> void  putEventMap(ReSetterGetter obj, 
			Map<String, Method> eventMap, 
			T[] types,
			Class<?> classType) {
		for(T type : types)
			putFieldEventMap(eventMap, type.toString(), obj, classType);
	}
}