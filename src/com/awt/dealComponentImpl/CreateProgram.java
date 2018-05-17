package com.awt.dealComponentImpl;

import java.lang.reflect.Method;

import com.awt.control.AbstractControl_Basi;
import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.awt.enuma.TagType;
import com.awt.util.Print;
import com.gui.DComp.DComp;

public class CreateProgram extends DealComponentCnt {
	@Override
	public DComp getComponent(DoMain domain, AbstractControl_Basi control) {
		TagType.WindowType[] wins = TagType.WindowType.values();
		for(TagType.WindowType win : wins){
			Print.out(this,
					"createFrame",
					win.toString() + " - " + ((BasiDoMain) domain).getType());
			if(win.toString().equals(((BasiDoMain) domain).getType())){
				Print.out(this, "createFrame", "获取Frame对象");
				return control.createProgramService(domain, 
						win.getComponent(domain));
			}
		}
		Print.erro(this, "createFrame", "createFrame标签异常");
		return null;
	}
	public static void main(String[] args){
		Class<?> beanClass = CreateProgram.class;
		Method method = null;
		try {
			method =  beanClass.getDeclaredMethod("dealContainer", DComp.class, Object.class, ReFun.class);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("本方法没有，继续。。。");
			for(Method method_ : beanClass.getMethods()){
				if(method_.getName().equals("dealContainer")){
					System.out.println("找到");
					method = method_;
					break;
				}
			}
		}
		System.out.println(method.getName());
	}
	
}
