package com.gui.DComp.DComponent;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

import com.gui.DComp.AbstractDComp.AbstractDComp;
import com.gui.util.GuiUtilFactory;
/**
 * <b>原始UI</b>
 * @author 威 
 * <br>2018年4月17日 下午9:18:25 
 * @see
 * @since 1.0
 */
public class DLabel_G extends AbstractDComp{
	public DLabel_G(){
		this(null, null, "left");
	}
	public DLabel_G(String text){
		this(text, null, "left");
	}
	public DLabel_G(Icon icon, String alignment){
		this(null, icon, alignment);
	}
	public DLabel_G(String text, Icon icon, String alignment){
		comp = new JLabel(text, icon, GuiUtilFactory.getAlignVal(alignment));
		comp.setFont(new Font("微软雅黑",Font.PLAIN,13)) ;
		comp.setVisible(true);
	}
	
	
	@Override
	public void setIcon(Icon icon) {
		((JLabel) comp).setIcon(icon);
	}
}
