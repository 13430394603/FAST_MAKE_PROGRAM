package com.awt.dealComponentImpl;

import java.util.List;

import com.awt.domain.ServiceDoMain;
import com.awt.service.Service;
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
public abstract class DealComponent extends AbstractDealComponent {
	
	protected <T> void dealComponent(DComp nowObj, List<T> containers, ReFun retest){}
	public void dealContainer(DComp nowObj, Object containers, ReFun reFun){}
	public void dealButton(DComp nowObj, Object containers, ReFun reFun){}
	public void dealLabel(DComp nowObj, Object containers, ReFun reFun){}
	public void dealText(DComp nowObj, Object containers, ReFun reFun){}
	public void dealTextarea(DComp nowObj, Object containers, ReFun reFun){}
	public void dealRadio(DComp nowObj, Object containers, ReFun reFun){}
}


