package com.awt.util;

import com.Bean.core.BeanConfigure;
import com.Bean.core.BeanContext;

/**
 * 
 * <b>只需要输入id获取bean对象<b>
 * @author 威 
 * <br>2018年4月1日 下午4:32:22 
 *
 */
public class UtilBeanContext {
	private static BeanContext context;
	static {
		try {
			context = BeanConfigure.configure("systemConf/systemConf.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public static Object getBean(String id) throws Exception{
		return context.getBean(id);
	}
}
