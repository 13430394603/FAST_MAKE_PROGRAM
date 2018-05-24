package com.gui.DComp;

import java.awt.Component;
import java.util.Map;

import com.gui.layout.Layout;

/**
 * <b>JPanel 组件容器<b>
 * @author 威 
 * <br>2018年3月28日 下午8:11:58 
 */
public interface DCompContainer extends DComp{
	public void setName(String key);
	public void add(String key, DComp comp);
	public void add(String key, DComp comp, int index);
	public void remove(Component comp);
	public void removeAll();
	public void repait();
	public void setContext(Map<String, Object> context);
	public Map<String, Object> getContext();
	public void setDefiLayout(String layoutName);
	public Layout getDefiLayout();
}

