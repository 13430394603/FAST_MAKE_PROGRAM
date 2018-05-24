package com.gui.DComp.DComponent;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.gui.typeStyle.AbstaractDefaultLabel;
import com.gui.typeStyle.DefaultJLabel;
import com.gui.util.GuiUtilFactory;

public class DLabel_Transparent extends DLabel_G {
	
	
	public DLabel_Transparent(){
		this(null, null, "left");
	}
	public DLabel_Transparent(String text){
		this(text, null, "left");
	}
	public DLabel_Transparent(Icon icon, String alignment){
		this(null, icon, alignment);
	}
	public DLabel_Transparent(String text, Icon icon, String alignment){
		comp = new DefaultJLabel(text, icon, GuiUtilFactory.getAlignVal(alignment));
	}
	@Override
	public void setPadding(int x, int y){
		((DefaultJLabel) comp).setPadding(x, y);
	}
	@Override
	public Point getPadding() {
		return ((AbstaractDefaultLabel) comp).getPadding();
	}
	@Override
	public void setBackgroundImage(ImageIcon backgroundImage){
		((DefaultJLabel) comp).setBackgroundImage(backgroundImage);
	}
	
}
