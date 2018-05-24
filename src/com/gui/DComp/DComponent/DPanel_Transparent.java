package com.gui.DComp.DComponent;

import java.awt.Point;
import java.util.Map;

import javax.swing.ImageIcon;

import com.gui.DComp.AbstractDComp.AbstractContaienr;
import com.gui.typeStyle.DefaultPanel;

/**
 * <b>Panel组件 - 透明</b>
 * @author 威 
 * <br>2018年4月16日 下午8:00:11 
 * @see
 * @since 1.0
 */
public class DPanel_Transparent extends AbstractContaienr  {
	public DPanel_Transparent(Map<String, Object> context){this(context, null);}
	public DPanel_Transparent(Map<String, Object> context, ImageIcon image){
		this.context = context;
		comp = new DefaultPanel(image);
		((DefaultPanel) comp).setOpaque(false);
	}
	@Override
	public void setPadding(int x, int y){
		((DefaultPanel) comp).setPadding(x, y);
	}
	@Override
	public Point getPadding() {
		return ((DefaultPanel) comp).getPadding();
	}
	@Override
	public void setBackgroundImage(ImageIcon backgroundImage){
		((DefaultPanel) comp).setBackgroundImage(backgroundImage);
	}
}
