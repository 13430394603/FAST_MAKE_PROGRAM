package com.awt.service;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import com.awt.enuma.EventType;

/**
 * 
 * <b><b>
 * @author 威 
 * <br>
 */
/**
 * <b>文本服务类</b>
 * <p>
 * 描述:
 * <p>
 * 主要处理组件对象的事件逻辑
 * @author 威 
 * <br>2018年4月11日 下午5:34:26 
 * @see com.awt.service.ClickService
 * @see com.awt.service.Service
 * @since 1.0
 */
public class TextService extends ClickService implements TextListener{
	@Override
	protected void init(Object comp){
		super.init(comp);
	}
	protected void Changed(TextEvent e){
		
	}
	@Override
	public void textValueChanged(TextEvent e) {
		invoke(eventMap.get(EventType.TextType.CHANGE.toString()), e);
		Changed(e);
	}
}
