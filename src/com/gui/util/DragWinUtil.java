package com.gui.util;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * <b>拖动工具类</b>
 * @author 威 
 * <br>2017年9月5日 下午7:11:39
 * @since 1.0
 */
public class DragWinUtil extends AbstractDragUtil {
	private Point pre_point;	//上一次的位置
	
	protected void release(MouseEvent e) {}
	protected void press(MouseEvent e) {
        pre_point = new Point(e.getX(), e.getY());// 得到按下去的位置  
	}
	protected void drag(Object Influencer, MouseEvent e) {
		Component comp = (Component) Influencer;
		Point compPoint = comp.getLocation();
		int x = compPoint.x + e.getX() - pre_point.x;
		int y = compPoint.y + e.getY() - pre_point.y;
        comp.setLocation(x, y);   
	}
}
