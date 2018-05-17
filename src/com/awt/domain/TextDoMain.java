package com.awt.domain;
/**
 * 
 * Text标签实体类
 * @author 威 
 * <br>2018年4月12日 下午2:44:46 
 *
 */
public class TextDoMain extends BasiDoMain{
	private String change;

	public TextDoMain(){
		super();
	}
	
	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}
	@Override
	public void appendTo(StringBuilder sb){
		if(change != null)
			appendItem(sb, "change", change);
	}
}
