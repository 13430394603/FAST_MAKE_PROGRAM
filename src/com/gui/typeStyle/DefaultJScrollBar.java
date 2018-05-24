package com.gui.typeStyle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class DefaultJScrollBar extends AbstaractDefaultLabel {
	private static final long serialVersionUID = 1L;
	
	public DefaultJScrollBar(){
		super();
		this.setSize(0, 0);
	}
	
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(java.awt.Color.gray);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);  /*使线条圆滑*/
		g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 5, 5);
	}
}

