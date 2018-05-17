package com.awt.dealComponentImpl;

import java.util.List;

import com.awt.domain.BasiDoMain;
import com.awt.domain.ButtonDoMain;
import com.awt.domain.ContainerDoMain;
import com.awt.domain.DoMain;
import com.awt.domain.LabelDoMain;
import com.awt.domain.RadioDoMain;
import com.awt.domain.TextAreaDoMain;
import com.awt.domain.TextDoMain;
import com.gui.DComp.DComp;
import com.gui.DComp.DCompContainer;
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
public abstract class DealComponentCnt extends AbstractDealComponentCnt {
	@Override
	public <T> void dealComponent(DComp nowObj, List<T> containers, ReFun reFun){
		for(T ctn : containers)
			((DCompContainer) nowObj).add(((BasiDoMain) ctn).getName(), reFun.reDo((DoMain) ctn));
	}
}