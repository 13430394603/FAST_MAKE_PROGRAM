package com.awt.domain;
/**
 * 
 * Button标签实体类
 * @author 威 
 * <br>2018年4月12日 下午2:44:46 
 *
 */
public class ButtonDoMain extends BasiDoMain {
	private String icon_src;	//图标
	
	public ButtonDoMain(){
		super();
		icon_src = "";
	}
	
	public String getIcon_src() {
		return icon_src;
	}
	public void setIcon_src(String icon_src) {
		this.icon_src = icon_src;
	}
	protected void appendTo(StringBuilder sb){
		super.appendTo(sb);
		appendItem(sb, "icon_src", icon_src);
	}
}
