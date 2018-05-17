package com.awt.exception;

/**
 * <b>创建组件的时候异常</b>
 * @author 威 
 * <br>2018年4月28日 下午3:45:52 
 * @see com.awt.enuma.TagType
 * @since 1.0
 */
public class CreateComponentException extends Exception {
	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = 1L;
	public CreateComponentException(String msg){
		super(msg);
	}
}
