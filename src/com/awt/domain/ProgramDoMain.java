package com.awt.domain;
/**
 * <b>Program标签实体类 整个程序主要实体对象<b>
 * @author 威 
 * <br>2018年4月1日 下午8:13:51 
 */
public class ProgramDoMain extends WinEventDoMain{
	private String title;

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
