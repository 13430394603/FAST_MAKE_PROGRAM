package com.gui.DComp.DComponent;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
/**
 * <b>输入框 - 透明</b>
 * @author 威 
 * <br>2018年4月16日 下午8:38:20 
 * @see com.gui.DComp.DComponent.DText_G
 * @since 1.0
 */
public class DText_Transparent extends DText_G{
	public DText_Transparent(){
		this(null);
	}
	public DText_Transparent(String text){
		super(text);
		((JTextField) comp).setBorder(BorderFactory.createEmptyBorder()) ;
		((JTextField) comp).setOpaque(false) ;
	}
}
