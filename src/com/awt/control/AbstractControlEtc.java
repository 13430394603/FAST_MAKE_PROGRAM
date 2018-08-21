package com.awt.control;

import java.util.List;

import com.awt.anlyxml.TestXML;
import com.awt.context.ProgramContext;
import com.awt.dealComponentImpl.AbstractDealComponent;
import com.awt.dealComponentImpl.ReFun;
import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.awt.domain.Navig;
import com.awt.domain.ProgramDoMain;
import com.awt.util.Print;
import com.bean.support.ReSetterGetter;
import com.gui.DComp.DComp;
import com.gui.DComp.DFrame;

/**
 * <b>抽象控制类 基类</b>
 * <p>
 * 新增描述:<br>
 * 是AbstractControl对象的扩展版本<br>
 * dealXml改为dealDoMain<br>
 * 进一步解耦，提升扩展能力<br>
 * <br>
 * 基本描述:<br>
 * @author 威 
 * <br>2018年4月30日 下午2:59:00  
 * @see com.awt.control.AbstractControl_Basi
 * @since 2.0
 */
public abstract class AbstractControlEtc extends AbstractControl_Basi {
	private TestXML test;
	private String frameName;
	
	protected AbstractControlEtc(){
		try {
			reflectObject = (ReSetterGetter) getBean("setGetObject");
			System.out.println("本对象-"+this);
			reflectObject.setObject(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
		execute();
	}
	
	/**
	 * Control一切就绪执行此方法
	 * <p>	 
	 * void
	 * @since 1.0
	 */
	protected abstract void execute();
	
	/**
	 * Control类初始化
	 * <p>	 
	 * void
	 * @see
	 * @since 1.0
	 */
	protected void init(){
		test = new TestXML();
		//获取当前控制类的名称处理首字母小写当作配置文件的名称创建TestXML
		String className = this.getClass().getSimpleName();
		try {
			test.configureOfClassPath(className.substring(0, 1).toLowerCase()+className.substring(1)+".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProgramDoMain p = (ProgramDoMain) test.doStart();
		frameName = p.getName();
		ProgramContext.getContext().put(p.getName(), ((DComp) dealDoMain(p, test.getNavig())).getComponent());
	}
	
	/**
	 * 自定义导航对象
	 * <p>	 
	 * @param navig
	 * void
	 * @see com.awt.anlyxml.TestXML
	 * @see com.awt.anlyxml.TestXML#setNavig(Navig)
	 * @since 1.0
	 */
	public void setNavig(Navig navig){
		test.setNavig(navig);
	}
	
	/**
	 * 解析domain对象并生成视图
	 * <p>	 
	 * 描述：<br>
	 * 先创建相对于子元素来说的根元素，通过DealComponent<br>
	 * 对next导航对象进行解析生成子组件 - 判断如果是service就单独进行操作，否则统一处理<br>
	 * 	1、反射获取对应的处理方法对子组件进行创建<br>
	 * 	2、通过一个ReFun对象对本方法进行递归逐层生成组件
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
	protected DComp dealDoMain(DoMain domain, Navig navig){
		Print.out(this, "dealXml", "导航名称："+navig.name);
		DComp nowObj = null;
		try {
			AbstractDealComponent dealObj = (AbstractDealComponent) getBean("create_"+navig.name);
			nowObj = dealObj.getComponent(domain, this);
			List<Navig> navigs = navig.next;
			if(navigs != null && nowObj != null){
				ReSetterGetter setGetDoMain = (ReSetterGetter) getBean("setGetObject");
				setGetDoMain.setObject(domain);
				for(Navig navig_ : navigs){
					if(!navig_.name.equals("service")){
						dealObj.dealComponent(nowObj,
							setGetDoMain.getProperty(navig_.name), 
							ctn -> {return dealDoMain(ctn, navig_);});
					}else
						dealObj.dealService(nowObj, ((BasiDoMain) domain).getService());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nowObj;
	}
	public void add(String key, DComp comp, Object jLayer){
		DFrame frame = (DFrame) this.getDCompByName(frameName);
		frame.add(key, comp, jLayer);
	}
	public void add(String key, DComp comp){
		DFrame frame = (DFrame) this.getDCompByName(frameName);
		frame.add(key, comp);
	}
	public void add(String key, DComp comp, int index){
		DFrame frame = (DFrame) this.getDCompByName(frameName);
		frame.add(key, comp, index);
	}
}