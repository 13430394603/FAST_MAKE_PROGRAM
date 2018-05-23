package com.awt.dealComponentImpl;

import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.util.Map;

import com.awt.domain.DoMain;
import com.awt.enuma.EventType;
import com.awt.enuma.TagType;
import com.awt.service.Service;
import com.bean.support.ReSetterGetter;

public class CreateProgram extends DealComponentCnt {
	@SuppressWarnings("unchecked")
	@Override
	protected <T> T[] enumType() {
		return (T[]) TagType.WindowType.values();
	}

	@Override
	protected Service service() {
		try {
			return (Service) getBean("programService");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected <T> void serviceEventMap(ReSetterGetter reSetterGetter, Map<String, Method> eventMap) {
		putEventMap(reSetterGetter, 
				eventMap, 
				EventType.WindowType.values(), 
				MouseEvent.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> T parseComp(DoMain domain, T item) {
		return (T) ((TagType.WindowType) item).getComponent(domain);
	}
	
}
