package com.awt.dealComponentImpl;

import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.util.Map;

import com.awt.domain.DoMain;
import com.awt.enuma.EventType;
import com.awt.enuma.TagType;
import com.awt.service.Service;
import com.bean.support.ReSetterGetter;
/**
 * <b>创建button组件</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年5月23日 下午8:54:36 
 * @see
 * @since 1.0
 */
public class CreateButton extends DealComponent {

	@SuppressWarnings("unchecked")
	protected <T> T[] enumType(){
		return (T[]) TagType.ButtonType.values();
	}
	
	protected Service service(){
		try {
			return (Service) getBean("clickService");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected <T> void serviceEventMap(ReSetterGetter reSetterGetter, 
			Map<String, Method> eventMap){
		putEventMap(reSetterGetter, 
				eventMap, 
				EventType.ClickType.values(), 
				MouseEvent.class);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T parseComp(DoMain domain, T item) {
		return (T) ((TagType.ButtonType) item).getComponent(domain);
	}
}
