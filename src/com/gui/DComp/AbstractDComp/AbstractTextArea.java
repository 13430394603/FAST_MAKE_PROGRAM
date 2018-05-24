package com.gui.DComp.AbstractDComp;

/**
 * <b>TextArea 抽象类</b>
 * <p>
 * 描述:<br>
 * 提供大小，自动提供滚动
 * @author 威 
 * <br>2018年4月29日 下午2:28:26 
 * @see com.gui.DComp.AbstractDComp.AbstractDComp
 * @since 1.0
 */
public abstract class AbstractTextArea extends AbstractDComp {
	//插入
	public abstract void insert(String str, int i);
	//替换
	public abstract void replace(String str, int start, int end);
	//追加
	public abstract void append(String str);
	//是否可编辑
	public abstract void setEditable(boolean flag);
	//设置文本值
	public abstract void setText(String text);
	
	public abstract String getText();
}
