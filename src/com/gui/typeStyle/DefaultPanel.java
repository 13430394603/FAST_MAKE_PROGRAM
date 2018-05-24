package com.gui.typeStyle;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.gui.util.AboutLocationUtil;
/**
 * <b>JPanel自定义paintComponent方法</b>
 * @author 威 
 * <br>2018年4月16日 下午9:11:24 
 * @see AbstaractDefaultPanel
 * @since 1.0
 */
public class DefaultPanel extends AbstaractDefaultPanel{
	private static final long serialVersionUID = 1L;
	
	public DefaultPanel(){this(null);}
	public DefaultPanel(ImageIcon image){
		super(image);
		this.setForeground(java.awt.Color.black);
		this.setFont(new Font("宋体", Font.PLAIN, 13)) ;
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);
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
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(backgroundImage != null){
			Image img = backgroundImage.getImage(); 
			g.drawImage(img, padding_left, padding_top,
		        		(this.getWidth() - (padding_left*2)),
		        		(this.getHeight() - (padding_top*2)),
		        		backgroundImage.getImageObserver());
		}
	}
}
