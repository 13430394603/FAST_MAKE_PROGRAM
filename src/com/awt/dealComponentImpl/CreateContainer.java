package com.awt.dealComponentImpl;

import com.awt.control.AbstractControl_Basi;
import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.awt.enuma.TagType;
import com.awt.util.Print;
import com.gui.DComp.DComp;

public class CreateContainer extends DealComponentCnt {
	@Override
	public DComp getComponent(DoMain domain, AbstractControl_Basi control) {
		TagType.ContainerType[] lists = TagType.ContainerType.values();
		for(TagType.ContainerType item : lists){
			if(item.toString().equals(((BasiDoMain) domain).getType()))
				return control.createClickService(domain, 
						item.getComponent(domain));
		}
		Print.erro(this, "createJPanel", "createJPanel标签异常");
		return null;
	}
}
