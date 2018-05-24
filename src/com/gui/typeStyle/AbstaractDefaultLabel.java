package com.gui.typeStyle;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * <b>自定义Label抽象类</b>
 * @author 威 
 * <br>2018年4月17日 下午7:31:05 
 * @see javax.swing.JLabel
 * @since 1.0
 */
public class AbstaractDefaultLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	protected ImageIcon backgroundImage;
	protected int padding_left, padding_top;
	
	public AbstaractDefaultLabel(){
		this(null, null, 0);
	}
	public AbstaractDefaultLabel(String text){
		this(text, null, 0);
	}
	public AbstaractDefaultLabel(Icon icon, int alignment){
		this(null, icon, alignment);
	}
	public AbstaractDefaultLabel(String text, Icon icon, int alignment){
		super(text, icon, alignment);
		this.setVisible(true);
		
	}

	public void setBackgroundImage(ImageIcon backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	public ImageIcon getBackgroundImage(){
		return this.backgroundImage;
	}
	public void setPadding(int padding_left, int padding_top){
		this.padding_left = padding_left;
		this.padding_top = padding_top;
	}
	public Point getPadding(){
		return new Point(this.padding_left, this.padding_top);
	}
}
