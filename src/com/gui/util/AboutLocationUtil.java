package com.gui.util;

import java.awt.Point;

/**
 * <b>关于定位的工具类、支持类</b>
 * @author 威 
 * <br>2018年4月19日 下午6:12:10 
 * @see
 * @since 1.0
 */
public class AboutLocationUtil {
	/**
	 * 添加元素时通过padding值对元素进行定位
	 * <p>	 
	 * @param comp
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void eleLocationOfAdd(java.awt.Component comp, int paddingLeft, int paddingTop) {
		Point p = comp.getLocation();
		int x = p.x + paddingLeft;
		int y = p.y + paddingTop;
		comp.setLocation(x, y);
	}
}
