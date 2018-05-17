package com.awt.service;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.awt.enuma.EventType;

/**
 * <b>点击服务类</b>
 * <p>
 * 描述:
 * <p>
 * 主要处理组件对象的点击事件逻辑
 * @author 威 
 * <br>2018年4月13日 下午10:35:03 
 * @see com.awt.service.Service
 * @since 1.0
 */
public class ClickService extends Service {
	public void clicked(MouseEvent e){
		
	}
	public void pressed(MouseEvent e){
		
	}
	public void released(MouseEvent e){
		
	}
	public void entered(MouseEvent e){
		
	}
	public void exited(MouseEvent e){
		
	}
	@Override
	protected void init(Object comp){
		((Component) comp).addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				invoke(eventMap.get(EventType.ClickType.CLICK.toString()), e);
				clicked(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				invoke(eventMap.get(EventType.ClickType.MOUSEDOWN.toString()), e);
				pressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				invoke(eventMap.get(EventType.ClickType.MOUSEUP.toString()), e);
				released(e);}
			@Override
			public void mouseEntered(MouseEvent e) {
				invoke(eventMap.get(EventType.ClickType.MOUSEMOVE.toString()), e);
				entered(e);}
			@Override
			public void mouseExited(MouseEvent e) {
				invoke(eventMap.get(EventType.ClickType.MOUSEOUT.toString()), e);
				exited(e);}
		});	
	}
}
