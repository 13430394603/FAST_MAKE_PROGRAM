package com.gui.DComp.AbstractDComp;

import com.gui.typeStyle.ProgressBar;
/**
 * <b>进度条组件</b>
 * @author 威 
 * <br>2018年4月30日 下午6:18:33 
 * @see
 * @since 1.0
 */
public class AbstractDProgressBar extends AbstractDComp  {
	/**
	 * 进度条本身大小
	 * <p>	 
	 * @param width
	 * @param height
	 * void
	 * @see
	 * @since 1.0
	 */
	public void setOrigSize(int width, int height){
		((ProgressBar) comp).setOrigSize(width, height);
	}
	/**
	 * 进度条本身宽
	 * <p>	 
	 * @return
	 * int
	 * @see
	 * @since 1.0
	 */
	public int getOrigWidth(){
		return ((ProgressBar) comp).getOrigWidth();
	}
	/**
	 *  进度条本身高
	 * <p>	 
	 * @return
	 * int
	 * @see
	 * @since 1.0
	 */
	public int getOrigHeight(){
		return ((ProgressBar) comp).getOrigHeight();
	}
	/**
	 * 设置进度条进度为0
	 * <p>	 
	 * void
	 * @see
	 * @since 1.0
	 */
	public void slideInit(){
		((ProgressBar) comp).setSize(0, 0);
	}
	/**
	 * 设置进度条进度
	 * <p>	 
	 * @param val	进度值
	 * void
	 * @see
	 * @since 1.0
	 */
	public void slideTo(int val){
		((ProgressBar) comp).setSize(val, 
				((ProgressBar) comp).getOrigHeight());
	}
}

