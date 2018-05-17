package com.awt.exception;
/**
 * <b>获取导航对象时,错误</b>
 * <p>
 * 描述:
 * <p>
 * 获取导航对象时，xml文本可能错误 - 创建导航标签时扫描xml文档时因文档不规范错误
 * @author 威 
 * <br>2018年4月10日 下午8:45:34  
 * @since 1.0
 */
public class NavigError extends Exception {

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = -2309163949917729475L;

	public NavigError(String msg){
		super(msg);
	}
}
