package com.gui.DComp.DComponent;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.gui.typeStyle.DefaultButton;
/**
 * <b>自定义ui</b>
 * @author 威 
 * <br>2018年4月17日 下午9:17:49 
 * @see
 * @since 1.0
 */
public class DButton_Transparent extends DButton_G{
	public DButton_Transparent(){
		this(null, null);
	}
	
	public DButton_Transparent(String text){
		this(text, null);
	}
	
	public DButton_Transparent(String text, Icon icon){
		comp = new DefaultButton(text, icon);
	}
	
	@Override
	public void setPadding(int x, int y) {
		try{
			((DefaultButton) comp).setPadding(x, y);
		}catch(NullPointerException e){
			((DefaultButton) comp).setPadding(0, 0);
		}
	}

	@Override
	public Point getPadding() {
		return ((DefaultButton) comp).getPadding();
	}
	@Override
	public void setBackgroundImage(ImageIcon backgroundImage){
		((DefaultButton) comp).setBackgroundImage(backgroundImage);
	}
}
