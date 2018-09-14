package com.awt.domain;
/**
 * <b>所有domain对象的父类</b>
 * <p>
 * 描述:
 * <p>
 * toString()获取的是默认格式的输出
 * <p>
 * appendTo(StringBuilder sb) 会拼接toString输出， 一般只需要在appendTo中添加输出项即可
 * <p>
 * appendItem(StringBuilder sb, String itemName, Object itemObj) 生成一个标准的输出项
 * <p>
 * 专注于处理toString输出对象
 * @author 威 
 * <br>2018年4月12日 下午2:46:20 
 * @since 1.0
 */
public class DoMain {
	/**
	 * 拼接属性到toString
	 * <p>	 
	 * @param sb toString方法中的StringBuilder对象
	 * void
	 * @see #toString()
	 * @see #appendItem(StringBuilder, String, Object)
	 * @since
	 */
	protected void appendTo(StringBuilder sb){
		
	}
	/**
	 * 输出该对象的字符串表示
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[").append(this.getClass().getSimpleName()).append("={");
		appendTo(sBuilder);
		sBuilder.append("}").append("]");
		return sBuilder.toString();
	}
	/**
	 * 生成一个属性的toString拼接项
	 * <p>	 
	 * @param sb		StringBuilder对象
	 * @param fieldName	属性名称
	 * @param field		属性值
	 * void
	 * @see #appendTo(StringBuilder) 
	 * @since
	 */
	protected void appendItem(StringBuilder sb, String fieldName, Object fieldVal){
		sb.append(fieldName).append("=").append(fieldVal).append("; ");
	}
}
