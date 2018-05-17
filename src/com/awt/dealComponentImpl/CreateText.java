package com.awt.dealComponentImpl;

import com.awt.control.AbstractControl_Basi;
import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.awt.enuma.TagType;
import com.awt.util.Print;
import com.gui.DComp.DComp;

public class CreateText extends DealComponent {
	@Override
	public DComp getComponent(DoMain domain, AbstractControl_Basi control){
		TagType.TextType[] lists = TagType.TextType.values();
		for(TagType.TextType item : lists) {
			if(item.toString().equals(((BasiDoMain) domain).getType()))
				return control.createTextService(domain, 
						item.getComponent(domain));
		}
		Print.erro(this, "createText", "createText标签异常");
		return null;
	}
}
