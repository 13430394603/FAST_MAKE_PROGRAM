package com.awt.dealComponentImpl;

import com.awt.control.AbstractControl_Basi;
import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.awt.enuma.TagType;
import com.awt.util.Print;
import com.gui.DComp.DComp;

public class CreateTextarea extends DealComponent {
	@Override
	public DComp getComponent(DoMain domain, AbstractControl_Basi control){
		TagType.TextAreaType[] types = TagType.TextAreaType.values();
		for(TagType.TextAreaType type : types){
			if(type.toString().equals(((BasiDoMain) domain).getType())){
				return control.createClickService(domain, 
						type.getComponent(domain));
			}
		}
		Print.erro(this, "CreateTextarea", "创建Textarea标签异常");
		return null;
	}
}
