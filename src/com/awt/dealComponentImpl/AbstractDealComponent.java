package com.awt.dealComponentImpl;

import java.util.List;

import com.awt.control.AbstractControl_Basi;
import com.awt.domain.DoMain;
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
public abstract class AbstractDealComponent {
	public abstract DComp getComponent(DoMain domain, AbstractControl_Basi control);
	public void dealService(DComp nowDComp, List<ServiceDoMain> serivices){
		for(ServiceDoMain service : serivices){
			try {
				Class<?> clazz = Class.forName(service.getClass_path());
				Service proSer = (Service) clazz.newInstance();
				proSer.setComponent(nowDComp);
				proSer.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	protected abstract <T> void dealComponent(DComp nowObj, List<T> containers, ReFun retest);
	public abstract void dealContainer(DComp nowObj, Object containers, ReFun reFun);
	public abstract void dealButton(DComp nowObj, Object containers, ReFun reFun);
	public abstract void dealLabel(DComp nowObj, Object containers, ReFun reFun);
	public abstract void dealText(DComp nowObj, Object containers, ReFun reFun);
	public abstract void dealTextarea(DComp nowObj, Object containers, ReFun reFun);
	public abstract void dealRadio(DComp nowObj, Object containers, ReFun reFun);
}