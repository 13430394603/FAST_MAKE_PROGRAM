package com.gui.util;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * <b>抽象拖动工具类</b>
 * <p>
 * 描述:<br>
 * 通过模板方法对拖动进行实现
 * @author 威 
 * <br>2018年5月1日 下午3:18:49 
 * @see
 * @since 1.0
 */
public abstract class AbstractDragUtil {
	/**
	 * 拖动
	 * <p>	 
	 * @param trigger		触发者组件
	 * @param Influencer	受影响者组件
	 * void
	 * @since 1.0
	 */
	public void setDragable(Object trigger, Object Influencer) {
		((java.awt.Component) trigger).addMouseListener(new MouseAdapter() {  
            public void mouseReleased(MouseEvent e) { 
                release(e);
            }
            public void mousePressed(MouseEvent e) {
                press(e);  
            }
            public void mouseEntered(MouseEvent e){
            	enter(e);  
            }
            public void mouseExited(MouseEvent e){
            	out(e);
            }
        }); 
        //拖动时当前的坐标减去鼠标按下去时的坐标，就是界面所要移动的向量。  
		((java.awt.Component) trigger).addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {  
			public void mouseDragged(java.awt.event.MouseEvent e) {  
				drag(Influencer, e);  
            }
        }); 
		
    }
	/**
	 * 触发组件的释放
	 * <p>	 
	 * @param trigger	触发对象
	 * @param e			MouseEvent对象
	 * void
	 * @since 1.0
	 */
	protected abstract void release(MouseEvent e);
	
	/**
	 * 触发组件的按压
	 * <p>	 
	 * @param trigger	触发对象
	 * @param e			MouseEvent对象
	 * void
	 * @since 1.0
	 */
	protected abstract void press(MouseEvent e);
	
	/**
	 * 鼠标进入触发组件区域
	 * <p>	 
	 * 默认鼠标为手型
	 * @param trigger	触发对象
	 * @param e			MouseEvent对象
	 * void
	 * @since 1.0
	 */
	protected void enter(MouseEvent e){
		((java.awt.Component) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * 鼠标离开触发区域
	 * <p>	
	 * 默认离开后恢复默认 
	 * @param trigger	触发对象
	 * @param e			MouseEvent对象
	 * void
	 * @since 1.0
	 */
	protected void out(MouseEvent e){
		((java.awt.Component) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	/**
	 * 这里用一句话描述这个方法的作用
	 * <p>	 
	 * @param Influencer	被触发对象
	 * @param e				MouseEvent e
	 * void	
	 * @since 1.0
	 */
	protected abstract void drag(Object Influencer, MouseEvent e); 
}
