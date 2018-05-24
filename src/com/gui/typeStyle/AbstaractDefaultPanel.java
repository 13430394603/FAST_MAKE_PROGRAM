package com.gui.typeStyle;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * <b>自定义Panel抽象类</b>
 * @author 威 
 * <br>2018年4月17日 下午7:25:16 
 * @see javax.swing.JPanel
 * @since 1.0
 */
public class AbstaractDefaultPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	protected ImageIcon backgroundImage;
	protected int padding_left, padding_top;
	
	public AbstaractDefaultPanel(){this(null);}
	public AbstaractDefaultPanel(ImageIcon image){
		super();
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
