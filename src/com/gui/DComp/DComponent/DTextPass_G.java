package com.gui.DComp.DComponent;
import java.awt.Font;

import javax.swing.JPasswordField;

import com.gui.DComp.AbstractDComp.AbstractDComp;
/**
 * <b>密码输入框 - 一般</b>
 * @author 威 
 * <br>2018年4月16日 下午8:39:20 
 * @see
 * @since 1.0
 */
public class DTextPass_G extends AbstractDComp {
	public DTextPass_G(){
		this(null);
	}
	public DTextPass_G(String text){
		comp = new JPasswordField(text);
		comp.setFont(new Font("微软雅黑",Font.PLAIN,13)) ;
		comp.setVisible(true);
	}
}
