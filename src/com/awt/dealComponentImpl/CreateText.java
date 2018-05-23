package com.awt.dealComponentImpl;

import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.util.Map;

import javax.swing.event.ChangeEvent;

import com.awt.domain.DoMain;
import com.awt.enuma.EventType;
import com.awt.enuma.TagType;
import com.awt.service.Service;
import com.bean.support.ReSetterGetter;

public class CreateText extends DealComponent {
	@SuppressWarnings("unchecked")
	protected <T> T[] enumType(){
		return (T[]) TagType.TextType.values();
	}
	
	protected Service service(){
		try {
			return (Service) getBean("textService");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected <T> void serviceEventMap(ReSetterGetter reSetterGetter, 
			Map<String, Method> eventMap){
		putEventMap(reSetterGetter, 
				eventMap, 
				EventType.TextType.values(), 
				ChangeEvent.class);
		putEventMap(reSetterGetter, 
				eventMap, 
				EventType.ClickType.values(), 
				MouseEvent.class);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T parseComp(DoMain domain, T item) {
		return (T) ((TagType.TextType) item).getComponent(domain);
	}
}
