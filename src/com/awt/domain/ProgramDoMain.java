package com.awt.domain;

import java.awt.Point;

/**
 * <b>Program标签实体类 整个程序主要实体对象<b>
 * @author 威 
 * <br>2018年4月1日 下午8:13:51 
 */
public class ProgramDoMain extends WinEventDoMain{
	private String title;
	/**
	 * 初始padding，例如顶部导航条所占位置 
	 * 此处默认适应define窗口的所占位置 
	 */
	private Point initPaddingPoint = new Point(0, 34);

	public void setInitPadding(String left, String top){
		initPaddingPoint.x = Integer.parseInt(left);
		initPaddingPoint.y = Integer.parseInt(top);
	}
	public Point getInitPadding(){
		return initPaddingPoint;
	}
	
	public ProgramDoMain(){
		super();
		title = "";
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	protected void appendTo(StringBuilder sb){
		super.appendTo(sb);
		appendItem(sb, "title", this.title);
	}		
}
