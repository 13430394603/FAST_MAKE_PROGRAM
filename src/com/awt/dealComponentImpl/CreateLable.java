package com.awt.dealComponentImpl;

import com.awt.control.AbstractControl_Basi;
import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.awt.enuma.TagType;
import com.awt.util.Print;
import com.gui.DComp.DComp;

public class CreateLable extends DealComponent {
	@Override
	public DComp getComponent(DoMain domain, AbstractControl_Basi control){
		TagType.LabelType[] lists = TagType.LabelType.values();
		for(TagType.LabelType item : lists){
			if(item.toString().equals(((BasiDoMain) domain).getType()))
				return control.createClickService(domain, 
						item.getComponent(domain));
		}
		Print.erro(this, "createLabel", "createLabel标签异常");
		return null;
	}

}
