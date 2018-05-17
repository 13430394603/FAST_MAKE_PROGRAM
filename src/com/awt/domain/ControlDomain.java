package com.awt.domain;
/**
 * <b>标注信息 实体类对象</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年4月20日 下午5:38:59 
 * @see
 * @since 1.0
 */
public class ControlDomain extends DoMain {
	private int priority;
	private Class<?> clazz;
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	@Override
	public void appendTo(StringBuilder sb){
		sb.append("priority=").append(priority);
		appendItem(sb, "clazz", clazz);
	}
}
