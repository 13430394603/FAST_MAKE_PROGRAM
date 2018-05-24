package com.gui.DComp.AbstractDComp;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JFrame;

import com.gui.DComp.DComp;
import com.gui.DComp.DFrame;
import com.gui.Exception.DCompPermitException;
import com.gui.format.GuiEnum;
import com.gui.util.DeMensionExt;
import com.util.basi.Arithmetic;
import com.util.basi.Util;


/**
 * <b>DFrame抽象类基类</b>
 * @author 威 
 * <br>2018年4月17日 下午5:58:02 
 * @see com.gui.DComp.AbstractDComp.AbstractContaienr
 * @see com.gui.DComp.DFrame
 * @since 1.0
 */
public abstract class AbstractDFrame extends AbstractContaienr implements DFrame {
	/**
	 * 适用于DFrame_Defined
	 * @see com.gui.DComp.DFrame#add(java.lang.String, com.gui.DComp.DComp, java.lang.Object)
	 */
	@Override
	public void setLayer(DComp comp, int num){
		
	}
	/**
	 * 适用于DFrame_Defined
	 * @see com.gui.DComp.DFrame#add(java.lang.String, com.gui.DComp.DComp, java.lang.Object)
	 */
	@Override
	public void add(String key, DComp comp, Object jLayer){
		
	}
	@Override
	public void setTitle(String title){
		((JFrame) comp).setTitle(title);
	}
	
	private int paddingLeft;
	private int paddingTop;
	@Override
	public void setPadding(int x, int y) {
		this.paddingLeft = x;
		this.paddingTop = y;
	}
	@Override
	public Point getPadding() {
		return new Point(paddingLeft, paddingTop);
	}
	@Override
	public void setIcon(Icon icon) {
		//不可用
		try {
			throw new DCompPermitException("不允许调用该方法");
		} catch (DCompPermitException e) {
			e.printStackTrace();
		}		
	}
}
