package com.awt.dealComponentImpl;

import java.util.List;

import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
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
	protected void dealComponent1(DComp nowObj, List<DoMain> containers, ReFun reFun){ 
		for(DoMain ctn : containers)
			((DCompContainer) nowObj).add(((BasiDoMain) ctn).getName(), reFun.reDo(ctn));
	}
}