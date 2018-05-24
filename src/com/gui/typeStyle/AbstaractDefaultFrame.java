package com.gui.typeStyle;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 * <b>自定义Frame抽象类</b>
 * @author 威 
 * <br>2018年4月17日 下午7:31:38 
 * @see
 * @since 1.0
 */
public class AbstaractDefaultFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	protected ImageIcon backgroundImage;
	protected int padding_left, padding_top;
	
	public AbstaractDefaultFrame(){super();}
	public AbstaractDefaultFrame(String title){
		super(title);
	}
	public AbstaractDefaultFrame(String title, ImageIcon image){
		super(title);
		this.backgroundImage = image;
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
