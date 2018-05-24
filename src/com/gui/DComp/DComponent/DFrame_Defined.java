package com.gui.DComp.DComponent;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import com.conf.log.impl.LogImpl;
import com.gui.DComp.DComp;
import com.gui.DComp.AbstractDComp.AbstractDFrame;
import com.gui.Exception.DCompPermitException;
import com.gui.typeStyle.DefaultFrame;
import com.gui.typeStyle.DefaultJLabel;
import com.gui.util.DragWinUtil;
import com.stream.Stream.Resource;
/**
 * <b>自定义窗口</b>
 * <p>
 * 描述:<br>
 * 顶部默认高度：34<br>
 * 窗口左内边距为6
 * 获取容器对象：<br>
 * 	获取Dframe-（name）
 * @author 威 
 * <br>2018年4月17日 下午9:54:09 
 * @see
 * @since 1.0
 */
public class DFrame_Defined extends AbstractDFrame {
	private JLayeredPane jLayeredPane;
	//图标
	private JLabel icon;
	private DComp tilteDComp, topFence;
	
	public DFrame_Defined() {
		this(null, null);
	}
	
	public DFrame_Defined(String title){
		this(null, title);
	}
	
	public DFrame_Defined(Map<String, Object> context) {
		this(context, null);
	}
	
	@SuppressWarnings("deprecation")
	public DFrame_Defined(Map<String, Object> context, String title) {
		this.context = context;
		comp = new DefaultFrame();
		((JFrame) comp).setUndecorated(true);
		((JFrame) comp).setVisible(true);
		try {
			File iconFile = Resource.getResource("img", "ProgramIcon.png");
			if(iconFile != null)
				((JFrame) comp).setIconImage(new ImageIcon(iconFile.toURL()).getImage());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void init(){
		//初始化jLayeredPane
		//创建内容区
		if(jLayeredPane == null) createLayer();
		
		//初始化背景
		setBackground();
				
		//初始化顶部
		createTopFence();
		
		DragWinUtil move = new DragWinUtil();
		move.setDragable(topFence.getComponent(), comp);
	}
	
	//初始化顶部
	@SuppressWarnings("deprecation")
	private void createTopFence() {
		int w = comp.getWidth();
		topFence = new DPanel_Transparent(context);
		topFence.setSize(w, 34);
		topFence.setMargin(0, 0);
		topFence.setPadding(4, 7);
		topFence.setDefiLayout("default_layout");
		
		//图标
		DComp iconDComp = new DLabel_Transparent();
		iconDComp.setSize(20, 20);
		iconDComp.setMargin(0, 0);
		icon = (JLabel) iconDComp.getComponent();
		
		//名称
		if(tilteDComp == null){
			tilteDComp = new DLabel_Transparent();
			tilteDComp.setMargin(20, 0);
		}
		
		//关闭按钮
		DComp closeDComp = new DButton_Transparent();
		closeDComp.setSize(20, 20);
		closeDComp.setMargin(w-10*1-20*1 , 0);
		//隐藏
		DComp hideDComp = new DButton_Transparent();
		hideDComp.setSize(20, 20);
		hideDComp.setMargin(w-8*2-20*2, 0);
		
		topFence.add("close", closeDComp);
		topFence.add("hide", hideDComp);
		topFence.add("title", tilteDComp);
		topFence.add("icon", iconDComp);
		
		try {
			File iconFile = Resource.getResource("img", "ProgramIconMin.png");
			if(iconFile != null)
				icon.setIcon(new ImageIcon(iconFile.toURL()));
		} catch (MalformedURLException e) {
			LogImpl.getInstance().log(com.conf.log.LOG.ERROR, e.getMessage());
			e.printStackTrace();
		}
		
		closeDComp.getComponent().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				((JFrame) comp).setVisible(false);
				System.exit(0);
			}
		});
		hideDComp.getComponent().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				((JFrame) comp).setExtendedState(JFrame.ICONIFIED);
			}
		});
		jLayeredPane.add(topFence.getComponent(), JLayeredPane.DRAG_LAYER);
	}
	
	@SuppressWarnings("deprecation")
	private void setBackground() {
		DefaultJLabel background = new DefaultJLabel();
		System.out.println("shuchu:" + ((JFrame) comp).getWidth());
		background.setSize(((JFrame) comp).getWidth(), ((JFrame) comp).getHeight());
		background.setLocation(0, 0);
		background.setPadding(0, 0);
		try {
			File backgroundFile = Resource.getResource("img", "ProgramBack.png");
			if(backgroundFile != null)
				background.setBackgroundImage(new ImageIcon(backgroundFile.toURL()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		jLayeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
		repait();
	}
	
	//初始化jLayeredPane
	//创建内容区
	private void createLayer(){
		jLayeredPane = new JLayeredPane();
		((JFrame) comp).setLayeredPane(jLayeredPane);		//将jLayeredPane设置进frame中
	}
	
	@Override
	public void setSize(int width, int height){
		super.setSize(width, height);
		init();
	}
	
	@Override
	public void setName(String key){
		if(key != null && !key.equals(""))
			super.setName(key);
	}
	
	@Override
	public void setLayer(DComp comp, int num){
		jLayeredPane.setLayer(comp.getComponent(), num);
	}
	
	@Override
	public void add(String key, DComp comp){
		add(key, comp, JLayeredPane.DEFAULT_LAYER);
		setLayer(comp, 5);
	}
	
	@Override
	public void add(String key, DComp comp, Object jLayer){
		comp.setParent(this);
		if(this.getDefiLayout() != null) this.getDefiLayout().location(comp);
		java.awt.Component comp_ = comp.getComponent();
		Point p = getPadding();
		com.gui.util.AboutLocationUtil.eleLocationOfAdd(comp_, p.x, p.y+34);
		if(key != null)
			if(!key.equals(""))
				context.put(key, comp);
		jLayeredPane.add(comp_, jLayer);
	}
	
	@Override
	public void setTitle(String title){
		if(tilteDComp == null)
			tilteDComp = new DLabel_Transparent();
		((JLabel) tilteDComp.getComponent()).setText(title);
	}
	
	@Override
	public void add(String key, DComp comp, int index){
		//不可用
		try {
			throw new DCompPermitException("不允许调用该方法");
		} catch (DCompPermitException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setIconImage(ImageIcon imageIcon) {
		if(imageIcon != null)
			((JFrame) comp).setIconImage(imageIcon.getImage());
		icon.setIcon(imageIcon);
	}
	
	/*@Override
	public void setPadding(int x, int y){
		System.out.println("padding:"+x+" "+y);
		super.setPadding(x, y+34);	//加上顶部34
	}*/
}
