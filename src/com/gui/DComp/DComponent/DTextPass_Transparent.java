package com.gui.DComp.DComponent;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
/**
 * <b>密码输入框 - 透明</b>
 * @author 威 
 * <br>2018年4月16日 下午8:42:44 
 * @see
 * @since 1.0
 */
public class DTextPass_Transparent extends DTextPass_G {
	public DTextPass_Transparent(){
		this(null);
	}
	public DTextPass_Transparent(String text){
		super(text);
		((JPasswordField) comp).setBorder(BorderFactory.createEmptyBorder());
		((JPasswordField) comp).setOpaque(false);
	}
}
