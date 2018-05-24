package com.gui.typeStyle;

import java.awt.Point;

import javax.swing.ImageIcon;
/**
 * <b>自定义Frame类</b>
 * <br>
 * 对add方法的修改增加内边距
 * @author 威 
 * <br>2018年4月17日 下午7:34:03 
 * @see
 * @since 1.0
 */
public class DefaultFrameUnBorder extends DefaultFrame {
	private static final long serialVersionUID = 1L;
	
	public DefaultFrameUnBorder(){this(null, null);}
	public DefaultFrameUnBorder(String title){
		this(title, null);
	}
	public DefaultFrameUnBorder(String title, ImageIcon image){
		super(title, image);
	}
	/**
	 * 添加元素时对元素进行定位
	 * <p>	 
	 * @param comp
	 * void
	 * @see
	 * @since 1.0
	 */
	protected void eleLocationOfAdd(java.awt.Component comp) {
		Point p = comp.getLocation();
		int x = p.x + padding_left;
		int y = p.y + padding_top;
		comp.setLocation(x, y);
	}
}
