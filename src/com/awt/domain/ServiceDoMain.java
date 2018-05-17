package com.awt.domain;
/**
 * <b>service标签实体类对象</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年4月28日 下午4:06:01 
 * @see
 * @since 1.0
 */
public class ServiceDoMain extends DoMain{
	private String class_path;

	public String getClass_path() {
		return class_path;
	}

	public void setClass_path(String class_path) {
		this.class_path = class_path;
	}
	@Override
	public void appendTo(StringBuilder sb){
		appendItem(sb, "class_path", class_path);
	}
}