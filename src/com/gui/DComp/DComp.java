package com.gui.DComp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.gui.layout.Layout;


/**
 * <b>D系列界面组件的基类</b>
 * <p>
 * 描述:
 * <p>
 * @author 威 
 * <br>2018年4月12日 下午5:24:53 
 * @see
 * @since
 */
public interface DComp{
	public void setDefiLayout(String layoutName);
	public Layout getDefiLayout();
	
	public void setRelativeSize(boolean bool);
	public boolean isRelativeSize();
	
	public void setBorder(String borderColor, String borderSize);
	public void setBorder(Color borderColor, int borderSize);
	public DComp getParent();
	public void setParent(DComp comp);
	/**
	 * 设置组件大小
	 * <p> 
	 * @param width			宽度
	 * @param height		高度
	 * void
	 * @since 1.0
	 */
	public void setSize(int width, int height);
	public void setSize(String width, String height);
	public void setLaySize();	//延迟设置
	
	public Dimension getSize();
	/**
	 * 设置组件位置
	 * <p>	 
	 * @param x		距离左边
	 * @param y		距离顶部
	 * void
	 * @since 1.0
	 */
	public void setMargin(int x, int y);
	public void setMargin(String x, String y);
	public Point getMargin();
	/**
	 * 内边距
	 * <p>	 
	 * @param x		距离内部左边
	 * @param y		距离内部顶部
	 * void
	 * @since 1.0
	 */
	public void setPadding(int x, int y);
	public void setPadding(String x, String y);
	/**
	 * 设置字体
	 * <p>	 
	 * @param fontName		字体名称
	 * @param fontStyle		样式值 - Font.
	 * @param size			
	 * void
	 * @since 1.0
	 */
	public Point getPadding();
	
	public void setBackgroundImage(ImageIcon backgroundImage);
	
	public ImageIcon getBackgroundImage();
	
	public void setFont(String fontName, String fontStyle, int size);
	public void setFont(String fontName, String fontStyle, String size);
	/**
	 * 设置字体颜色 
	 * @param color
	 * void
	 * @since 1.0
	 */
	public void setColor(Color color);
	/**
	 * 设置背景
	 * <p>	 
	 * @param icon
	 * void
	 * @since 1.0
	 */
	public void setIcon(Icon icon);
	/**
	 * 获取当前对象java.awt/swing组件对象
	 * <p>	 
	 * @return
	 * java.awt.Component
	 * @see
	 * @since 1.0
	 */
	public java.awt.Component getComponent();
	/**
	 * 获取字体样式的值 
	 * @param fontStyle
	 * @return
	 * int			GuiEnum.FontStyle.getValue()
	 * @since 1.0
	 */
	int getFontStyle(String fontStyle);
	
	public void add(String key, DComp comp);

	public void add(String key, DComp comp,  int index);
	
	public void setVisible(boolean visible);
}
