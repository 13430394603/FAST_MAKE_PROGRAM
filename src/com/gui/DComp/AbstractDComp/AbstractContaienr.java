package com.gui.DComp.AbstractDComp;

import java.awt.Component;
import java.awt.Container;
import java.util.Map;

import com.gui.DComp.DComp;
import com.gui.DComp.DCompContainer;
import com.gui.layout.DefaultLayout;
import com.gui.layout.HoriLineLayout;
import com.gui.layout.Layout;
import com.gui.layout.VertLineLayout;


/**
 * <b>组件容器类基类</b>
 * @author 威 
 * <br>2018年4月17日 下午5:36:29 
 * @see com.gui.DComp.AbstractDComp
 * @see com.gui.DComp.DCompContainer
 * @since 1.0
 */
public abstract class AbstractContaienr extends AbstractDComp implements DCompContainer {
	protected Map<String, Object> context;
	
	private Layout layout;
	/**
	 * 自定义layout
	 * <p>	 
	 * @param layoutName
	 * void
	 * @see
	 * @since 1.0
	 */
	public void setDefiLayout(String layoutName){
		switch(layoutName){
			case "default_layout" :
				this.layout = new DefaultLayout();
				break;
			case "vertline_layout" :
				this.layout = new VertLineLayout(); 
				break;
			case "horiline_layout" :
				this.layout = new HoriLineLayout();
				break;
			default:
				System.err.println("setDefiLayout异常："+layoutName);
		}
		if(layout != null){
			layout.init(this.getPadding());
		}
		
	}
	/**
	 * 自定义layout
	 * <p>	 
	 * @return
	 * Layout
	 * @see
	 * @since 1.0
	 */
	public Layout getDefiLayout(){
		return this.layout;
	}
	
	@Override
	public void remove(Component comp) {
		((Container) this.comp).remove(comp);
	}

	@Override
	public void removeAll() {
		((Container) comp).removeAll();
	}
	@Override
	public void repait() {
		((Container) comp).repaint();
	}
	@Override
	public void add(String key, DComp comp){
		comp.setParent(this);
		if(layout != null) layout.location(comp);
		((Container) this.comp).add(comp.getComponent());
		if(key != null && !key.equals(""))
			context.put(key, comp);
	}
	@Override
	public void add(String key, DComp comp, int index){
		comp.setParent(this);
		if(layout != null) layout.location(comp);
		((Container) this.comp).add(comp.getComponent(), index);
		if(key != null && !key.equals(""))
			context.put(key, comp);
	}
	@Override
	public void setName(String key){
		if(key != null && !key.equals(""))
			context.put(key, this);
	}
	@Override
	public void setContext(Map<String, Object> context){
		this.context = context;
	}
	@Override
	public Map<String, Object> getContext(){
		return context;
	}
}
