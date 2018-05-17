package com.awt.service;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.awt.enuma.EventType;
/**
 * <b>窗口服务类</b>
 * <p>
 * 描述:
 * <p>
 * 主要处理组件对象的窗口事件逻辑
 * @author 威 
 * <br>2018年4月13日 下午10:33:36
 * @see com.awt.service.Service
 * @since 1.0
 */
public class ProgramService extends Service {
	
	/**
	 * 
	 * 关闭时 
	 * @see
	 * void
	 *
	 */
	protected void destroy(WindowEvent e){}
	/**
	 * 
	 * 激活时
	 * @see
	 * void
	 *
	 */
	protected void activated(WindowEvent e){}
	/**
	 * 
	 * 从最小化恢复
	 * @see
	 * void
	 *
	 */
	protected void deiconified(WindowEvent e){}
	/**
	 * 
	 * 窗口最小化
	 * @see
	 * void
	 *
	 */
	protected void Iconified(WindowEvent e){}
	/**
	 * 
	 * 失去焦点 
	 * @see
	 * void
	 *
	 */
	protected void deactivated(WindowEvent e){}
	@Override
	protected void init(Object comp){
		((JFrame) comp).addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				invoke(eventMap.get(EventType.WindowType.CLOSE.toString()), e);
				destroy(e);}
			public void windowClosed(WindowEvent e){
				invoke(eventMap.get(EventType.WindowType.CLOSE.toString()), e);
				destroy(e);}
			public void windowActivated(WindowEvent e){
				invoke(eventMap.get(EventType.WindowType.FOCUS.toString()), e);
				activated(e);}
			public void windowDeactivated(WindowEvent e){
				invoke(eventMap.get(EventType.WindowType.BLUR.toString()), e);
				deactivated(e);}
			public void windowIconified(WindowEvent e){
				invoke(eventMap.get(EventType.WindowType.HIDE.toString()), e);
				Iconified(e);}
			public void windowDeiconified(WindowEvent e){
				invoke(eventMap.get(EventType.WindowType.OPEN.toString()), e);
				deiconified(e);}
		});
	}
}
