package com.gui.typeStyle;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * <b>自定义按钮抽象类</b>
 * @author 威 
 * <br>2018年4月17日 下午7:26:57 
 * @see javax.swing.JButton
 * @since 1.0
 */
public class AbstaractDefaultButton extends JButton { 
	private static final long serialVersionUID = 1L;
	protected ImageIcon backgroundImage;
	protected int padding_left, padding_top;
	
	AbstaractDefaultButton(){
		this(null, null);
	}
	AbstaractDefaultButton(String text){
		this(text, null);
	}
	AbstaractDefaultButton(String text, Icon icon){
		super(text, icon);
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
