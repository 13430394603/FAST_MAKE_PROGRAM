package com.awt.dealComponentImpl;

import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.util.Map;

import com.awt.control.AbstractControl_Basi;
import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.awt.enuma.EventType;
import com.awt.enuma.TagType;
import com.awt.service.Service;
import com.awt.util.Print;
import com.bean.support.ReSetterGetter;
import com.gui.DComp.DComp;

public class CreateLable extends DealComponent {
	@SuppressWarnings("unchecked")
	@Override
	protected <T> T[] enumType() {
		return (T[]) TagType.LabelType.values();
	}

	@Override
	protected Service service() {
		try {
			return (Service) getBean("clickService");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected <T> void serviceEventMap(ReSetterGetter reSetterGetter, Map<String, Method> eventMap) {
		putEventMap(reSetterGetter, 
				eventMap, 
				EventType.ClickType.values(), 
				MouseEvent.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> T parseComp(DoMain domain, T item) {
		return (T) ((TagType.LabelType) item).getComponent(domain);
	}
}
