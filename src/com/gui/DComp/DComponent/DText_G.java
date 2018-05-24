package com.gui.DComp.DComponent;
import java.awt.Font;
import javax.swing.JTextField;

import com.gui.DComp.AbstractDComp.AbstractDComp;
/**
 * <b>输入框组件 - 一般</b>
 * <p>
 * 描述:<br>
 * @author 威 
 * <br>2018年4月16日 下午8:36:46 
 * @see com.gui.DComp.AbstractDComp.AbstractDComp
 * @since 1.0
 */
public class DText_G extends AbstractDComp {
	public DText_G(){
		this(null);
	}
	public DText_G(String text){
		comp = new JTextField(text);
		comp.setFont(new Font("微软雅黑",Font.PLAIN,13)) ;
		comp.setVisible(true);
	}
}
