package com.awt.control;

import java.awt.Button;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;

import com.awt.anlyxml.TestXML;
import com.awt.context.ProgramContext;
import com.awt.dealComponentImpl.AbstractDealComponent;
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
public abstract class AbstractControlEtc extends AbstractControl_Basi implements ActionListener{
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
		init();//初始化
		addActionListtener();//添加ActionListener
		execute();//初始化完成之后的操作
	}
	
	/**
	 * Control一切就绪执行此方法
	 * <p>	 
	 * void
	 * @since 1.0
	 */
	protected abstract void execute();
	
	/**
	 * Control类初始化 创建组件需在此处
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
	private List<ClickEventItem> list;
	//点击事件添加ActionListtener
	@SuppressWarnings("rawtypes")
	private void addActionListtener(){
		JButton bt1 = (JButton) getComponentByName("bt1");
		JButton bt2 = (JButton) getComponentByName("bt2");
		list = new ArrayList<>();
		list.add(new ClickEventItem(bt1, null));
		list.add(new ClickEventItem(bt2, null));
		list.forEach(item->{
			//（触及组件）--JButton,JComboBox,JMenuItem,JPasswordField
			//addActionListener只要以上方法才能调用因此需按需转换类型
			Component jComp = item.getComp();
			if(jComp instanceof JButton || jComp instanceof Button)
				((JButton) jComp).addActionListener(this);
			else if(jComp instanceof JComboBox)
				((JComboBox) jComp).addActionListener(this);
			else if(jComp instanceof JMenuItem)
				((JMenuItem) jComp).addActionListener(this);
			else if(jComp instanceof JPasswordField)
				((JPasswordField) jComp).addActionListener(this);
		});
	}
	//委托事件
	public void actionPerformed(ActionEvent e){
		System.out.println("void actionPerformed(ActionEvent e)");
		for(ClickEventItem b : list){
			if(e.getSource() == b.getComp()){
				System.out.println(b);
				//反射执行method
			}
		}
		/*if(e.getSource() == bt1)
			System.out.println("点击到名称为bt1的按钮");
		else if(e.getSource() == bt2)
			System.out.println("点击到名称为bt2的按钮");*/
		//一个标签有点击事件时，边记录下了该标签的元素，以及事件方法名；
		//一切就绪时对组件进行addActionListener 以及在actionPerformed中添加该类型的事件集
		/*
		 class ClickEventItem{
		 	Component comp;
		 	Method method;
		 }
		 //执行.addActionListener
		 ArrayList<ClickEventItem> list;
		 list.forEach(item->{
		 	item.getComp().addActionListener(this);
		 });
		 //需要遍历事件集
		 ArrayList<ClickEventItem> list;
		 list.forEach(item->{
		 	if(e.getSource() == item.getComp()){
		 		//那么就反射执行method}
		 });
		 
		 */
		
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
class ClickEventItem{
	Component comp;
 	Method method;
 	public ClickEventItem(Component comp, Method method){
 		this.comp = comp;
 		this.method = method;
 	}
	public Component getComp() {
		return comp;
	}
	public void setComp(Component comp) {
		this.comp = comp;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
 	
 }