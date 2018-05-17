package com.awt.dealComponentImpl;

import java.util.List;

import com.awt.domain.ButtonDoMain;
import com.awt.domain.ContainerDoMain;
import com.awt.domain.LabelDoMain;
import com.awt.domain.RadioDoMain;
import com.awt.domain.TextAreaDoMain;
import com.awt.domain.TextDoMain;
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
	protected <T> void dealComponent(DComp nowObj, List<T> containers, ReFun retest){ }
	@SuppressWarnings("unchecked")
	public void dealContainer(DComp nowObj, Object containers, ReFun reFun){
		dealComponent(nowObj, (List<ContainerDoMain>) containers, reFun);
	}
	@SuppressWarnings("unchecked")
	public void dealButton(DComp nowObj, Object containers, ReFun reFun){
		dealComponent(nowObj, (List<ButtonDoMain>) containers, reFun);
	}@SuppressWarnings("unchecked")
	public void dealLabel(DComp nowObj, Object containers, ReFun reFun){
		dealComponent(nowObj, (List<LabelDoMain>) containers, reFun);
	}
	@SuppressWarnings("unchecked")
	public void dealText(DComp nowObj, Object containers, ReFun reFun){
		dealComponent(nowObj, (List<TextDoMain>) containers, reFun);
	}
	@SuppressWarnings("unchecked")
	public void dealTextarea(DComp nowObj, Object containers, ReFun reFun){
		dealComponent(nowObj, (List<TextAreaDoMain>) containers, reFun);
	}
	@SuppressWarnings("unchecked")
	public void dealRadio(DComp nowObj, Object containers, ReFun reFun){
		dealComponent(nowObj, (List<RadioDoMain>) containers, reFun);
	}
}