package com.gui.DComp.AbstractDComp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import com.gui.DComp.DComp;
import com.gui.Exception.DCompPermitException;
import com.gui.format.GuiEnum;
import com.gui.layout.Layout;
import com.gui.util.ColorUtil;
import com.gui.util.DeMensionExt;
import com.util.basi.Arithmetic;
import com.util.basi.Util;
/**
 * <b>组件抽象类基类</b>
 * @author 威 
 * <br>2018年4月17日 下午5:35:49 
 * @see com.gui.DComp.DComp
 * @since 1.0
 */
public abstract class AbstractDComp implements DComp {
	protected Component comp;
	private DComp parent;
	private Point paddingPoint;
	private DeMensionExt size;
	
	private boolean isRelativeSize = false;
	
	public void setRelativeSize(boolean bool){
		isRelativeSize = bool;
	}
	public boolean isRelativeSize(){
		return isRelativeSize;
	}
	
	public void setDefiLayout(String layoutName){
		//不可用
		try {
			throw new DCompPermitException("不允许调用该方法");
		} catch (DCompPermitException e) {
			e.printStackTrace();
		}
	}
	public Layout getDefiLayout(){
		//不可用
		try {
			throw new DCompPermitException("不允许调用该方法");
		} catch (DCompPermitException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public void setBorder(String borderColor, String borderSize){
		setBorder(ColorUtil.colorMap.get(borderColor), 
				Integer.valueOf(borderSize));
	}
	public void setBorder(Color borderColor, int borderSize){
		((JComponent) comp).setBorder(
				BorderFactory.createLineBorder(borderColor, borderSize));
	}
	
	public int getFontStyle(String fontStyle){
		GuiEnum.FontStyle[] types = GuiEnum.FontStyle.values();
		for(GuiEnum.FontStyle type : types)
		{
			if(fontStyle.equals(type.toString()))
				return type.getValue();
		}
		return 0;
	}
	public DComp getParent(){
		return parent;
	}
	public void setParent(DComp comp){
		System.out.println("设置父元素:"+comp + ",self:" + this);
		parent = comp;
		/*if(size != null) setLaySize();*/
	}
	@Override
	public void add(String key, DComp comp){
		//不可用
		try {
			throw new DCompPermitException("不允许调用该方法");
		} catch (DCompPermitException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void add(String key, DComp comp,  int index){
		//不可用
		try {
			throw new DCompPermitException("不允许调用该方法");
		} catch (DCompPermitException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setSize(int width, int height) {
		comp.setSize(width, height);
	}
	public void setLaySize(){
		System.out.println("进行延迟设置！" + size.getWidth() + size.getHeight());
		setSize(size.getWidth(), size.getHeight());
	}
	public void setSize(String width, String height){
		System.out.println("setSize:" + width + " " + height);
		Integer width_ = null, height_ = null;
		Arithmetic a = new Arithmetic();
		width_  = a.toValue(a.toPosifix(width));
		height_ = a.toValue(a.toPosifix(height));
		setSize(width_, height_);
	}
	
	public Dimension getSize(){
		return comp.getSize();
	}

	@Override
	public void setMargin(int x, int y) {
		comp.setLocation(x, y);
	}
	@Override
	public void setMargin(String x, String y){
		Arithmetic a = new Arithmetic();
		setMargin(a.toValue(a.toPosifix(x)), a.toValue(a.toPosifix(y)));
	}
	public Point getMargin(){
		return comp.getLocation();
	}

	@Override
	public void setPadding(int x, int y) {
		paddingPoint = new Point(x, y);
	}
	@Override
	public void setPadding(String x, String y){
		Arithmetic a = new Arithmetic();
		setPadding(a.toValue(a.toPosifix(x)), a.toValue(a.toPosifix(y)));
	}
	@Override
	public Point getPadding(){
		return paddingPoint;
	}

	@Override
	public void setFont(String fontName, String fontStyle, int size) {
		comp.setFont(new Font(fontName, getFontStyle(fontStyle), size));
	}
	public void setFont(String fontName, String fontStyle, String size) {
		setFont(fontName, fontStyle, Integer.valueOf(size));
	}

	@Override
	public void setColor(Color color) {
		
	}
	@Override
	public void setIcon(Icon icon) {
	}
	@Override
	public Component getComponent() {
		return comp;
	}
	@Override
	public void setBackgroundImage(ImageIcon backgroundImage){
		
	}
	@Override
	public ImageIcon getBackgroundImage(){
		return null;
	}
	@Override
	public void setVisible(boolean visible){
		comp.setVisible(visible);
	}
}
