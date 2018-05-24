package com.gui.typeStyle;

import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.gui.util.AboutLocationUtil;
/**
 * <b>自定义Frame类</b>
 * <br>
 * 对add方法的修改增加内边距
 * @author 威 
 * <br>2018年4月17日 下午7:34:03 
 * @see
 * @since 1.0
 */
public class DefaultFrame extends AbstaractDefaultFrame {
	private static final long serialVersionUID = 1L;
	
	public DefaultFrame(){this(null, null);}
	public DefaultFrame(String title){
		this(title, null);
	}
	public DefaultFrame(String title, ImageIcon image){
		super(title, image);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setForeground(java.awt.Color.black);
		this.setFont(new Font("宋体", Font.PLAIN, 13));
	}
	
	@Override
	public Component add(java.awt.Component comp){
		/*AboutLocationUtil.eleLocationOfAdd(comp,
				padding_left,
				padding_top);*/
		super.add(comp);
		return comp;
	}
	//将指定组件添加到此容器的给定位置上。
	@Override
	public Component add(Component comp, int index) {
		/*AboutLocationUtil.eleLocationOfAdd(comp,
				padding_left,
				padding_top);*/
		//index -1为最底层
		//super.add(comp); 默认index 1层 
		super.add(comp, index);
		return comp;
	}
}
