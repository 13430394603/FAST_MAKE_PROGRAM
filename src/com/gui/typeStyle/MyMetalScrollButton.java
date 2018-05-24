package com.gui.typeStyle;

import java.awt.Graphics;

import javax.swing.plaf.metal.MetalScrollButton;
/**
 * <b>滚动条的附加按钮</b>
 * <p>
 * 描述:<br><br>
 * 判断：<br>
 * 四个位置的按钮<br>
 * getDirection() == NORTH<br>
 * getDirection() == SOUTH<br>
 * getDirection() == EAST<br>
 * getDirection() == WEST<br>
 * 
 * 作用：<br>
 * 此处隐藏附加按钮的绘制，在组件中不会显示出来
 * @author 威 
 * <br>2018年5月2日 下午2:34:00 
 * @see javax.swing.plaf.metal.MetalScrollButton
 * @since 1.0
 */
public class MyMetalScrollButton extends MetalScrollButton{
	private static final long serialVersionUID = 1L;
	public MyMetalScrollButton(int direction, int width, boolean freeStanding) {
		super(direction, width, freeStanding);
	}
	@Override
	public void paint( Graphics g){
		g.dispose();
		System.out.println("MyMetalScrollButton---paint");
	}
}
