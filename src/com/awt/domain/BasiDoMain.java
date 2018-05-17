package com.awt.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>任何组件<b>
 * @author 威 
 * <br>2018年4月10日 下午11:14:16 
 */
public class BasiDoMain extends DoMain{
	protected String type;
	protected String name;
	protected Integer width;
	protected Integer height;
	protected Integer margin_left;
	protected Integer margin_top;
	protected Integer padding_left;
	protected Integer padding_top;
	protected boolean visable;
	protected String src;
	
	protected List<ServiceDoMain> services;
	
	private String click;
	private String dbclick;
	private String mousedown;
	private String mouseup;
	private String mousemove;
	private String mouseout;
	
	protected String font_style;
	protected int font_size;
	protected String font_name;
	
	protected String value;
	
	public BasiDoMain(){
		type = "normal";
		width = 1;
		height = 1;
		margin_left = 0;
		margin_top = 0;
		padding_left = 0;
		padding_top = 0;
		visable = true;
		value = "";
		font_name = "宋体";
		font_size = 12;
		font_style = "plain";
		services = new ArrayList<ServiceDoMain>();
	}
	
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
	public String getDbclick() {
		return dbclick;
	}
	public void setDbclick(String dbclick) {
		this.dbclick = dbclick;
	}
	public String getMousedown() {
		return mousedown;
	}
	public void setMousedown(String mousedown) {
		this.mousedown = mousedown;
	}
	public String getMouseup() {
		return mouseup;
	}
	public void setMouseup(String mouseup) {
		this.mouseup = mouseup;
	}
	public String getMousemove() {
		return mousemove;
	}
	public void setMousemove(String mousemove) {
		this.mousemove = mousemove;
	}
	public String getMouseout() {
		return mouseout;
	}
	public void setMouseout(String mouseout) {
		this.mouseout = mouseout;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getMargin_left() {
		return margin_left;
	}
	public void setMargin_left(Integer margin_left) {
		this.margin_left = margin_left;
	}
	public Integer getMargin_top() {
		return margin_top;
	}
	public void setMargin_top(Integer margin_top) {
		this.margin_top = margin_top;
	}
	public void setMargin(Integer margin_left, Integer margin_top){
		this.margin_top = margin_top;
		this.margin_left = margin_left;
	}
	public void addService(ServiceDoMain service) {
		this.services.add(service);
	}
	public List<ServiceDoMain> getService() {
		return services;
	}
	
	public String getFont_style() {
		return font_style;
	}
	public void setFont_style(String font_style) {
		this.font_style = font_style;
	}
	public int getFont_size() {
		return font_size;
	}
	public void setFont_size(int font_size) {
		this.font_size = font_size;
	}
	public String getFont_name() {
		return font_name;
	}
	public void setFont_name(String font_name) {
		this.font_name = font_name;
	}
	public Integer getPadding_left() {
		return padding_left;
	}
	public void setPadding_left(Integer padding_left) {
		this.padding_left = padding_left;
	}
	public Integer getPadding_top() {
		return padding_top;
	}
	public void setPadding_top(Integer padding_top) {
		this.padding_top = padding_top;
	}
	
	public boolean isVisable() {
		return visable;
	}
	public void setVisable(boolean visable) {
		this.visable = visable;
	}

	protected void appendTo(StringBuilder sb){
		super.appendTo(sb);
		sb.append(" name=").append(this.name);
		appendItem(sb, "value", value);
		appendItem(sb, "type", type);
		appendItem(sb, "width", width);
		appendItem(sb, "height", height);
		appendItem(sb, "src", src);
		appendItem(sb, "margin", margin_left + " " +margin_top);
		appendItem(sb, "services", services);
		appendItem(sb, "font", font_name + " " + font_style + " " + font_size);
		appendItem(sb, "padding", padding_left + " " + padding_top);
		appendItem(sb, "visable", visable);
		if(click != null)
			appendItem(sb, "click", click);
		if(dbclick != null)
			appendItem(sb, "dbclick", dbclick);
		if(mousedown != null)
			appendItem(sb, "mousedown", mousedown);
		if(mouseup != null)
			appendItem(sb, "mouseup", mouseup);
		if(mousemove != null)
			appendItem(sb, "mousemove", mousemove);
		if(mouseout != null)
			appendItem(sb, "mouseout", mouseout);
	}
}
