package com.gui.DComp.DComponent;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JButton;

import com.gui.DComp.AbstractDComp.AbstractDComp;
import com.gui.Exception.DCompPermitException;
/**
 * <b>一般ui</b>
 * @author 威 
 * <br>2018年4月17日 下午9:17:34 
 * @see
 * @since 1.0
 */
public class DButton_G extends AbstractDComp{
	public DButton_G(){
		this(null, null);
	}
	public DButton_G(String text){
		this(text, null);
	}
	public DButton_G(String text, Icon icon){
		comp = new JButton(text, icon);
	}
	
	@Override
	public void setPadding(int x, int y) {
		//暂时不可用
		try {
			throw new DCompPermitException("不允许调用该方法");
		} catch (DCompPermitException e) {
			e.printStackTrace();
		}
	}
	public void setIcon(Icon icon){
		((JButton) comp).setIcon(icon);
	}
	@Override
	public Point getPadding() {
		try {
			throw new DCompPermitException("不允许调用该方法");
		} catch (DCompPermitException e) {
			e.printStackTrace();
		}
		return null;
	}
}
