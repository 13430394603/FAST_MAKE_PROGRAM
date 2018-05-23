package com.awt.control;

/*import java.util.List;

import com.awt.anlyxml.TestXML;
import com.awt.context.ProgramContext;
import com.awt.domain.BasiDoMain;
import com.awt.domain.ButtonDoMain;
import com.awt.domain.ContainerDoMain;
import com.awt.domain.ContainerBasiDoMain;
import com.awt.domain.DoMain;
import com.awt.domain.LabelDoMain;
import com.awt.domain.Navig;
import com.awt.domain.ProgramDoMain;
import com.awt.domain.RadioDoMain;
import com.awt.domain.ServiceDoMain;
import com.awt.domain.TextAreaDoMain;
import com.awt.domain.TextDoMain;
import com.awt.enuma.TagType;
import com.awt.service.ProgramService;
import com.awt.util.Print;
import com.bean.exception.BeanSupportException;
import com.bean.support.ReSetterGetter;
import com.gui.DComp.DComp;
import com.gui.DComp.DCompContainer;*/

/**
 * <b>抽象控制类 基类</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年4月15日 下午7:44:41 
 * @see
 * @since 1.0
 */
public abstract class AbstractControl extends AbstractControl_Basi {
	/*private final String FRAME_TAG_NAME = "program";
	private final String CONTAINER_TAG_NAME = "container";
	private final String BUTTON_TAG_NAME = "button";
	private final String LABEL_TAG_NAME = "label";
	private final String TEXT_TAG_NAME = "text";
	private final String SERVER_TAG_NAME = "service";
	private final String TEXTAREA_TAG_NAME = "textarea";
	private final String RADIO_TAG_NAME = "radio";*/
	
	/*private TestXML test;*/
	
	/*protected AbstractControl(){
		reflectObject = new ReSetterGetter();
		try {
			reflectObject.setObject(this);
		} catch (BeanSupportException e) {
			e.printStackTrace();
		}
		init();
		execute();
	}*/
	
	/**
	 * Control类启动
	 * <p>	 
	 * void
	 * @since 1.0
	 */
	/*protected abstract void execute();*/
	
	/**
	 * Control类初始化
	 * <p>	 
	 * void
	 * @see
	 * @since 1.0
	 */
	/*protected void init(){
		test = new TestXML();
		//获取当前控制类的名称处理首字母小写当作配置文件的名称创建TestXML
		String className = this.getClass().getSimpleName();
		try {
			test.configureOfClassPath(className.substring(0, 1).toLowerCase()+className.substring(1)+".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProgramDoMain p = (ProgramDoMain) test.doStart();
		ProgramContext.getContext().put(p.getName(), ((DComp) dealXml(p, test.getNavig())).getComponent());
	}*/
	
	/**
	 * 自定义导航对象
	 * <p>	 
	 * @param navig
	 * void
	 * @see com.awt.anlyxml.TestXML
	 * @see com.awt.anlyxml.TestXML#setNavig(Navig)
	 * @since 1.0
	 */
	/*public void setNavig(Navig navig){
		test.setNavig(navig);
	}*/
	
	/**
	 * 
	 * <p>	 
	 * @param domain			xml根元素DoMain对象
	 * @param navig				开头为xml根元素的导航对象
	 * @return
	 * Object
	 * @see #dealJPanels(DComp, List, Navig)
	 * @see #dealButton(DComp, List, Navig)
	 * @see #dealLabel(DComp, List, Navig)
	 * @see #dealText(DComp, List, Navig)
	 * @see #dealService(DComp, List)
	 * @since 1.0
	 */
	/*protected DComp dealXml(DoMain domain, Navig navig){
		Print.out(this, "dealXml", "导航名称："+navig.name);
		DComp nowObj = createDComp(navig.name, domain);
		List<Navig> navigs = navig.next;
		if(navigs != null && nowObj != null){
			for(Navig navig_ : navigs){
				switch(navig_.name){
					case CONTAINER_TAG_NAME : 
						dealJPanels(nowObj, ((ContainerBasiDoMain) domain).getContainer() , navig_); 
						break;
					case BUTTON_TAG_NAME : 
						dealButton(nowObj, ((ContainerBasiDoMain) domain).getButton(), navig_); 
						break;
					case LABEL_TAG_NAME : 
						dealLabel(nowObj, ((ContainerBasiDoMain) domain).getLabel(), navig_); 
						break;
					case TEXT_TAG_NAME : 
						dealText(nowObj, ((ContainerBasiDoMain) domain).getText(), navig_);
						break;
					case TEXTAREA_TAG_NAME : 
						dealTextArea(nowObj, ((ContainerBasiDoMain) domain).getTextarea(), navig_); 
						break;
					case RADIO_TAG_NAME : 
						dealRadio(nowObj, ((ContainerBasiDoMain) domain).getRadio(), navig_);
						break;
					case SERVER_TAG_NAME : 
						dealService(nowObj, ((BasiDoMain) domain).getService()); 
						break;
					default: Print.erro(this, "dealXml", "异常");
				}
			}
		}
		return nowObj;
	}*/
 
	//创建组件封装对象
	/*protected DComp createDComp(String name, DoMain domain){
		DComp nowObj = null;
		switch(name){
			case FRAME_TAG_NAME :
				nowObj = createFrame(domain);
				createProgramService(domain, nowObj);
				break;
			case CONTAINER_TAG_NAME :
				nowObj = createJPanel(domain);
				createClickService(domain, nowObj);
				break;
			case BUTTON_TAG_NAME :
				nowObj = createButton(domain);
				createClickService(domain, nowObj);
				break;
			case LABEL_TAG_NAME :
				nowObj = createLabel(domain);
				createClickService(domain, nowObj);
				break;
			case TEXT_TAG_NAME :
				nowObj = createText(domain);
				createTextService(domain, nowObj);
				break;
			case TEXTAREA_TAG_NAME :
				nowObj = createTextArea(domain);
				createClickService(domain, nowObj);
				break;
			case RADIO_TAG_NAME :
				nowObj = createRadio(domain);
				createClickService(domain, nowObj);
				break;
			default: Print.erro(this, "createDComp", "异常");
		}
		return nowObj;
	}
 
	private DComp createRadio(DoMain domain) {
		TagType.RadioType[] radios = TagType.RadioType.values();
		for(TagType.RadioType radio : radios){
			if(radio.toString().equals(((BasiDoMain) domain).getType())){
				return radio.getComponent(domain);
			}
		}
		return null;
	}

	private DComp createTextArea(DoMain domain) {
		TagType.TextAreaType[] types = TagType.TextAreaType.values();
		for(TagType.TextAreaType type : types){
			if(type.toString().equals(((BasiDoMain) domain).getType())){
				return type.getComponent(domain);
			}
		}
		return null;
	}

	protected DComp createFrame(DoMain domain){
		TagType.WindowType[] wins = TagType.WindowType.values();
		for(TagType.WindowType win : wins){
			Print.out(this,
					"createFrame",
					win.toString() + " - " + ((BasiDoMain) domain).getType());
			if(win.toString().equals(((BasiDoMain) domain).getType())){
				Print.out(this, "createFrame", "获取Frame对象");
				return win.getComponent(domain);
			}
		}
		Print.erro(this, "createFrame", "createFrame标签异常");
		return null;
	}
	protected DComp createJPanel(DoMain domain){
		TagType.ContainerType[] lists = TagType.ContainerType.values();
		for(TagType.ContainerType item : lists){
			if(item.toString().equals(((BasiDoMain) domain).getType()))
				return item.getComponent(domain);
		}
		Print.erro(this, "createJPanel", "createJPanel标签异常");
		return null;
	}
	protected DComp createButton(DoMain domain){
		TagType.ButtonType[] lists = TagType.ButtonType.values();
		for(TagType.ButtonType item : lists){
			if(item.toString().equals(((BasiDoMain) domain).getType()))
				return item.getComponent(domain);
		}
		Print.erro(this,
				"createButton",
				"createButton标签异常");
		return null;
	}
	protected DComp createLabel(DoMain domain){
		TagType.LabelType[] lists = TagType.LabelType.values();
		for(TagType.LabelType item : lists){
			if(item.toString().equals(((BasiDoMain) domain).getType()))
				return item.getComponent(domain);
		}
		Print.erro(this,
				"createLabel",
				"createLabel标签异常");
		return null;
	}
	protected DComp createText(DoMain domain){
		TagType.TextType[] lists = TagType.TextType.values();
		for(TagType.TextType item : lists){
			if(item.toString().equals(((BasiDoMain) domain).getType()))
				return item.getComponent(domain);
		}
		Print.erro(this,
				"createText",
				"createText标签异常");
		return null;
	}
	
	protected void dealJPanels(DComp nowObj, List<ContainerDoMain> containers, Navig n){
		for(ContainerDoMain ctn : containers)
			((DCompContainer) nowObj).add(ctn.getName(), dealXml(ctn, n));
	}
	protected void dealButton(DComp nowObj, List<ButtonDoMain> buttons, Navig n){
		for(ButtonDoMain bt : buttons)
			((DCompContainer) nowObj).add(bt.getName(), dealXml(bt, n));
	}
	protected void dealLabel(DComp nowObj, List<LabelDoMain> labels, Navig n){
		for(LabelDoMain lb : labels)
			((DCompContainer) nowObj).add(lb.getName(), dealXml(lb, n));
	}
	protected void dealText(DComp nowObj, List<TextDoMain> texts, Navig n){
		for(TextDoMain t : texts)
			((DCompContainer) nowObj).add(t.getName(), dealXml(t, n));
	}
	protected void dealTextArea(DComp nowObj, List<TextAreaDoMain> domains, Navig n){
		for(TextAreaDoMain domain : domains)
			((DCompContainer) nowObj).add(domain.getName(), dealXml(domain, n));
	}
	protected void dealRadio(DComp nowObj, List<RadioDoMain> domains, Navig n){
		for(RadioDoMain domain : domains)
			((DCompContainer) nowObj).add(domain.getName(), dealXml(domain, n));
	}
	protected void dealService(DComp nowObj, List<ServiceDoMain> serivices){
		for(ServiceDoMain service : serivices){
			try {
				Class<?> clazz = Class.forName(service.getClass_path());
				com.awt.service.Service proSer = (ProgramService) clazz.newInstance();
				proSer.setComponent(nowObj);
				proSer.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	protected Object getComponentByName(String name){
		return ProgramContext.getContext().get(name);
	}*/
}