package com.awt.domain;

/**
 * 
 * Label标签实体类
 * @author 威 
 * <br>2018年4月12日 下午2:44:46 
 *
 */
public class LabelDoMain extends BasiDoMain{ 
	private String text_align;		//align
	private String icon_src;		//图标
	
	public LabelDoMain(){
		super();
		text_align = "center";
		icon_src = "";
	}
	
	public String getIcon_src() {
		return icon_src;
	}
	public void setIcon_src(String icon_src) {
		this.icon_src = icon_src;
	}
	public String getText_align() {
		return text_align;
	}
	public void setText_align(String text_align) {
		this.text_align = text_align;
	}
	protected void appendTo(StringBuilder sb){
		super.appendTo(sb);
		appendItem(sb, "text_align", text_align);
		appendItem(sb, "icon_src", icon_src);
	}
}	
