package com.awt.domain;
/**
 * <b>JFrame的特定domain</b>
 * <p>
 * 描述:
 * <p>
 * @author 威 
 * <br>2018年4月13日 下午1:52:34 
 * @see
 * @since
 */
public class WinEventDoMain extends ContainerBasiDoMain{
	private String onload;
	private String close;
	private String focus;
	private String blur;
	private String hide;
	private String open;
	
	public WinEventDoMain(){
		super();
	}
	
	public String getOnload() {
		return onload;
	}
	public void setOnload(String onload) {
		this.onload = onload;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getFocus() {
		return focus;
	}
	public void setFocus(String focus) {
		this.focus = focus;
	}
	public String getBlur() {
		return blur;
	}
	public void setBlur(String blur) {
		this.blur = blur;
	}
	public String getHide() {
		return hide;
	}
	public void setHide(String hide) {
		this.hide = hide;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	@Override
	protected void appendTo(StringBuilder sb){
		super.appendTo(sb);
		if(onload != null)
			appendItem(sb, "onload", onload);
		if(close != null)
			appendItem(sb, "close", close);
		if(focus != null)
			appendItem(sb, "focus", focus);
		if(blur != null)
			appendItem(sb, "blur", blur);
		if(hide != null)
			appendItem(sb, "hide", hide);
		if(open != null)
			appendItem(sb, "open", open);
	}
}
