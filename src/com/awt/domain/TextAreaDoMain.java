package com.awt.domain;
/**
 * <b>textArea 组件实体类</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年4月29日 下午3:15:08 
 * @see
 * @since 1.0
 */
public class TextAreaDoMain extends BasiDoMain {
	protected boolean editable;
	
	public TextAreaDoMain(){
		super();
		editable = true;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	@Override
	protected void appendTo(StringBuilder sb){
		sb.append("editable=").append(editable);
	}
}
