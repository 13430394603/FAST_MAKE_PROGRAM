package com.awt.domain;

import java.util.ArrayList;
import java.util.List;

import com.awt.util.Arithmetic;
import com.awt.util.Util;

/**
 * <b>任何组件<b>
 * @author 威 
 * <br>2018年4月10日 下午11:14:16 
 */
public class BasiDoMain extends DoMain{
	protected String layout;
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	protected String type;
	protected String name;
	protected String width;
	protected String height;
	protected String size;				//复合对象
	public void setSize(String fields){
		String[] arr =  Util.getArrFields(fields, 2);
		setWidth(Arithmetic.toPosifixStr(arr[0]));
		setHeight(Arithmetic.toPosifixStr(arr[1]));
	}
	protected String margin_left;
	protected String margin_top;
	protected String margin;			//复合对象
	public void setMargin(String fields){
		String[] arr =  Util.getArrFields(fields, 2);
		setMargin_left(arr[0]);
		setMargin_top(arr[1]);
	}
	protected String padding_left;
	protected String padding_top;
	protected String padding;			//复合对象
	public void setPadding(String fields){
		String[] arr =  Util.getArrFields(fields, 2);
		setPadding_left(arr[0]);
		setPadding_top(arr[1]);
	}
	protected boolean visable;
	protected boolean hasBorder;
	protected String src;
	
	protected List<ServiceDoMain> services;
	
	private String click;
	private String dbclick;
	private String mousedown;
	private String mouseup;
	private String mousemove;
	private String mouseout;
	
	protected String font_style;
	protected String font_size;
	protected String font_name;
	protected String font; 			//复合对象
	public void setFont(String fields){
		String[] arr =  Util.getArrFields(fields, 3);
		setFont_name(arr[0]);
		setFont_style(arr[1]);
		setFont_size(arr[2]);
	}
	
	
	protected String border_color;
	protected String border_size;
	protected String border;		//复合对象
	public void setBorder(String fields){
		hasBorder = true;
		String[] arr =  Util.getArrFields(fields, 2);
		setBorder_color(arr[0]);
		setBorder_size(arr[1]);
	}
	public String getBorder_color() {
		return border_color;
	}

	public void setBorder_color(String border_color) {
		this.border_color = border_color;
	}

	public String getBorder_size() {
		return border_size;
	}

	public void setBorder_size(String border_size) {
		this.border_size = border_size;
	}
	
	protected String value;
	
	public BasiDoMain(){
		type 			= "normal";
		width 			= "1";
		height 			= "1";
		margin_left 	= "0";
		margin_top 		= "0";
		padding_left 	= "0";
		padding_top 	= "0";
		visable 		= true;
		value 			= "";
		font_name 		= "宋体";
		font_size 		= "12";
		font_style 		= "plain";
		services 		= new ArrayList<ServiceDoMain>();
		hasBorder 		= false;
		layout			= "default_layout";
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
	public String getWidth() {
		return width;
	}
	public  void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public  void setHeight(String height) {
		this.height = height;
	}
	public String getMargin_left() {
		return margin_left;
	}
	public  void setMargin_left(String margin_left) {
		this.margin_left = margin_left;
	}
	public String getMargin_top() {
		return margin_top;
	}
	public  void setMargin_top(String margin_top) {
		this.margin_top = margin_top;
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
	public String getFont_size() {
		return font_size;
	}
	public void setFont_size(String font_size) {
		this.font_size = font_size;
	}
	public String getFont_name() {
		return font_name;
	}
	public void setFont_name(String font_name) {
		this.font_name = font_name;
	}
	
	public String getPadding_left() {
		return padding_left;
	}
	public  void setPadding_left(String padding_left) {
		this.padding_left = padding_left;
	}
	
	public String getPadding_top() {
		return padding_top;
	}
	public  void setPadding_top(String padding_top) {
		this.padding_top = padding_top;
	}
	
	public boolean isVisable() {
		return visable;
	}
	public void setVisable(boolean visable) {
		this.visable = visable;
	}
	public static void main(String[] args){
		
 	}

	public boolean isHasBorder() {
		return hasBorder;
	}
	public void setHasBorder(boolean hasBorder) {
		this.hasBorder = hasBorder;
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
