package com.gui.Exception;
/**
 * <b>许可异常</b>
 * <p>
 * 描述:<br>
 * 有一些方法，父类有但是子类继承类了，并且子类不支持该方法就会返回此异常，即不允许调用
 * @author 威 
 * <br>2018年4月19日 下午5:57:35 
 * @see
 * @since 1.0
 */
public class DCompPermitException extends Exception {
	private static final long serialVersionUID = 1L;
	public DCompPermitException(String msg){
		super(msg);
	}
}
