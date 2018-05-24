package com.gui.typeStyle;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;
/**
 * <b>自定义Label</b>
 * @author 威 
 * <br>2018年4月17日 下午7:30:43 
 * @see AbstaractDefaultLabel
 * @since 1.0
 */
public class DefaultJLabel extends AbstaractDefaultLabel{
	private static final long serialVersionUID = 4434320598768993651L;
	public DefaultJLabel(){
		this(null, null, 0);
	}
	public DefaultJLabel(String text){
		this(text, null, 0);
	}
	public DefaultJLabel(Icon icon, int alignment){
		this(null, icon, alignment);
	}
	public DefaultJLabel(String text, Icon icon, int alignment){
		super(text, icon, alignment);
		this.setSize(1, 1);
		this.setForeground(java.awt.Color.black);
		this.setFont(new Font("宋体", Font.PLAIN, 13));
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(backgroundImage != null){
			Image img = backgroundImage.getImage();
			g.drawImage(img, padding_left, padding_top,
		        		(this.getWidth() - (padding_left*2)),
		        		(this.getHeight() - (padding_top*2)),
		        		backgroundImage.getImageObserver());
		}
		if(this.getText() != null && !this.getText().equals("")){
			Font deaultFont=getFont();
			Rectangle2D fontRect = deaultFont.getStringBounds(
					this.getText(),((Graphics2D) g).getFontRenderContext());
			if(this.getWidth() == 1 && this.getHeight() == 1)
				this.setSize(((int) fontRect.getWidth()) + (padding_left == 0 ? 1 : padding_left)*2 + 4,
						((int) fontRect.getHeight()) + (padding_top == 0 ? 1 : padding_left)*2 + 4) ;
		}
	}
}
