package com.gui.DComp.DComponent;

import javax.swing.BorderFactory;

import com.gui.DComp.AbstractDComp.AbstractTextArea;
import com.gui.typeStyle.DefaultTextArea;
/**
 * <b>JTextArea 一般组件</b>
 * <p>
 * 描述:<br>
 * 提供大小，自动提供滚动
 * @author 威 
 * <br>2018年4月29日 下午2:31:52 
 * @see com.gui.DComp.AbstractDComp.AbstractTextArea
 * @see com.gui.typeStyle.DefaultTextArea
 * @since 1.0
 */
public class DTextArea_G extends AbstractTextArea {
	public DTextArea_G(){
		this("");
	}
	public DTextArea_G(String text){
		comp = new DefaultTextArea(text);
		((DefaultTextArea) comp).setOpaque(false);
		((DefaultTextArea) comp).setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 0));
		((DefaultTextArea) comp).setVisible(true);
		((DefaultTextArea) comp).getViewport().setOpaque(false);
		((DefaultTextArea) comp).getVerticalScrollBar().setOpaque(false);
		((DefaultTextArea) comp).getHorizontalScrollBar().setOpaque(false);
	}
	@Override
	public void insert(String str, int i) {
		((DefaultTextArea) comp).insert(str, i);
	}
	@Override
	public void replace(String str, int start, int end) {
		((DefaultTextArea) comp).replace(str, start, end);
	}
	@Override
	public void append(String str) {
		((DefaultTextArea) comp).append(str);
	}
	@Override
	public void setEditable(boolean flag) {
		((DefaultTextArea) comp).setEditable(flag);
	}
	@Override
	public void setText(String text) {
		System.out.println("haha");
		((DefaultTextArea) comp).setText(text);
	}
	@Override
	public String getText() {
		System.out.println("haha");
		return ((DefaultTextArea) comp).getText();
	}
}
