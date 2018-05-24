package com.gui.typeStyle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DefaultJLabelEtc extends AbstaractDefaultLabel{
	private static final long serialVersionUID = 1L;

	public DefaultJLabelEtc(){
		super(null, null, 0);
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(java.awt.Color.gray);
		g2d.fillRoundRect(0, 0, 
				(int) this.getSize().getWidth(), 
				(int) this.getSize().getHeight(), 
				20, 20);
		g2d.dispose();
	}
}
