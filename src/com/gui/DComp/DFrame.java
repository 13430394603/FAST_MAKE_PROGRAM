package com.gui.DComp;

import javax.swing.ImageIcon;

/**
 * 
 * <b>基层 接口 为D开头系列Frame组件的最底层<b>
 * @author 威 
 * <br>2018年3月25日 下午10:54:02 
 *
 */
public interface DFrame extends DCompContainer {
	public void setLayer(DComp comp, int num);
	public void add(String key, DComp comp, Object jLayer);
	public void setTitle(String title);
	public void setIconImage(ImageIcon icon);
}
