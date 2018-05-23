package com.awt.dealComponentImpl;

import java.util.List;

import com.awt.domain.DoMain;
import com.gui.DComp.DComp;
/**
 * <b>一句话描述该类</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年4月30日 上午11:27:17 
 * @see
 * @since 1.0
 */
public abstract class AbstractDealComponentCnt extends AbstractDealComponent {
	@Override
	public void dealComponent(DComp nowObj, Object containers, ReFun reFun){
		dealComponent1(nowObj, parseListType(containers), reFun);
	}
	@Override
	protected void dealComponent1(DComp nowObj, List<DoMain> containers, ReFun retest){ }
	/**
	 * 转换成List<DoMain>对象
	 * <p>	 
	 * @param object
	 * @return
	 * List<DoMain>
	 * @see
	 * @since 1.0
	 */
	@SuppressWarnings("unchecked")
	protected List<DoMain> parseListType(Object object){
		return (List<DoMain>) object;
	}
}