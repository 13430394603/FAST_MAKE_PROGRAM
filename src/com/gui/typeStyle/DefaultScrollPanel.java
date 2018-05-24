package com.gui.typeStyle;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;

import com.gui.util.AboutLocationUtil;
import com.gui.util.DragScrollBarUtil;
import com.stream.Stream.Resource;

/**
 * <b>容器对象 - 外容器</b>
 * <p>
 * 描述:<br>
 * 1、能够自动扩容产生滚动条<br>
 * 2、当前只提供垂直滚动<br>
 * 3、自动从上往下布局<br>
 * 
 * 其他:<br>
 * 1、水平<br>
 * horizontal<br>
 * 2、垂直<br>
 * vertical<br>
 * @author 威 
 * <br>2018年5月1日 上午10:51:20 
 * @see com.gui.typeStyle.DefaultPanel
 * @since 1.0
 */
public class DefaultScrollPanel extends DefaultPanel {
	private static final long serialVersionUID = 1L;
	private DefaultPanel in_cnt;		//内容器
	private DefaultJLabelEtc vertical;	//垂直滚动条
	private DragScrollBarUtil draw;		//滚动条拖动工具类
	private int nowMarginTop;			//当前内容器允许组件添加的高度位置
	private int maxHeight;				//当前内容的高度
	
	public DefaultScrollPanel(){
		this(null);}
	public DefaultScrollPanel(ImageIcon image){
		super(image);
		
		nowMarginTop = 0;
		
		in_cnt = new DefaultPanel();
		super.add(in_cnt);
		
		vertical = new DefaultJLabelEtc();	//滚动条组件
		draw = new DragScrollBarUtil();		//滚动条拖动工具类
		draw.setDragable(vertical, in_cnt);	
		super.add(vertical);
		
		this.addMouseWheelListener(new MouseWheelListener(){
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int moveVal = e.getWheelRotation();
				Point in_cntPoint = in_cnt.getLocation();
				int height = ((Component) e.getSource()).getHeight();
				if(moveVal > 0) {
					if(in_cntPoint.y < 0)
						setWhell(moveVal, in_cntPoint, height);
					else 
						vertical.setLocation(vertical.getLocation().x, 0);
				} else {
					if(in_cntPoint.y > height - maxHeight)
						setWhell(moveVal, in_cntPoint, height);
					else 
						vertical.setLocation(vertical.getLocation().x, (height-vertical.getHeight()));
				}
			}
		});
	}
	/**
	 * 移动到
	 * <p>	 
	 * @param val	移动值
	 * void
	 * @see
	 * @since 1.0
	 */
	public void slideTo(int val){
		
	}
	/**
	 * 移动到顶部
	 * <p>	 
	 * void
	 * @see
	 * @since 1.0
	 */
	public void slideTop(){
		in_cnt.setLocation(in_cnt.getLocation().x, 0);
		vertical.setLocation(vertical.getLocation().x, 0);
	}
	/**
	 * 移动到底部
	 * <p>	 
	 * void
	 * @see
	 * @since 1.0
	 */
	public void slideBom(){
		in_cnt.setLocation(in_cnt.getLocation().x, this.getHeight() - in_cnt.getHeight());
		vertical.setLocation(vertical.getLocation().x, 
				in_cnt.getHeight() - vertical.getHeight());
	}
	
	/**
	 * 设置外容器的大小<br>
	 * 间接设置垂直滚动的大小、位置<br>
	 * 间接设置内容器大小<br>
	 * 滚动的拖动工具类，参数设置 <br>
	 * @see java.awt.Component#setSize(int, int)
	 */
	public void setSize(int width, int height){
		super.setSize(width, height);
		in_cnt.setSize(width-6, height);
		maxHeight = height;
		draw.init(height);
		vertical.setSize(6, height);
		vertical.setVisible(false);	
		vertical.setLocation(width-vertical.getWidth(), 0);
	}
	/**
	 * 将指定组件添加到此容器的给定位置上。<br>
	 * 通过deal方法对组件进行自动布局<br>
	 * @see #deal(Component)
	 * @see com.gui.typeStyle.DefaultPanel#add(java.awt.Component)
	 */
	@Override
	public Component add(java.awt.Component comp){
		AboutLocationUtil.eleLocationOfAdd(comp,
				padding_left,
				padding_top+nowMarginTop);
		deal(comp);
		in_cnt.add(comp);
		return comp;
	}
	/**
	 * 将指定组件添加到此容器的给定位置上。<br>
	 * 通过deal方法对组件进行自动布局<br>
	 * @see #deal(Component)
	 * @see com.gui.typeStyle.DefaultPanel#add(java.awt.Component, int)
	 */
	@Override
	public Component add(Component comp, int index) {
		AboutLocationUtil.eleLocationOfAdd(comp,
				padding_left,
				padding_top+nowMarginTop);
		deal(comp);
		//index -1为最底层
		//super.add(comp); 默认index 1层 
		in_cnt.add(comp, index);
		return comp;
	}
	/**
	 * 这里用一句话描述这个方法的作用
	 * <p>	
	 * 给新增的组件定位
	 * 更新滚动条 
	 * @param comp	添加的组件
	 * void
	 * @see #add(Component)
	 * @see #add(Component, int)
	 * @since 1.0
	 */
	protected void deal(Component comp) {
		nowMarginTop += comp.getHeight();
		if(nowMarginTop > maxHeight){
			//给新增的组件定位
			maxHeight = nowMarginTop;
			in_cnt.setSize(in_cnt.getWidth(), maxHeight);
			in_cnt.repaint();
			
			//更新滚动条
			double percen = ((double) this.getHeight())/maxHeight;
			int height = (int) (percen*this.getHeight()) ;
			vertical.setSize(6, height);
			vertical.setVisible(true);
			vertical.repaint();
		}
	}
	/**
	 * 设置滚动
	 * <p>	 
	 * @param moveVal		鼠标滑轮移动偏量
	 * @param in_cntPoint	内容器Margin
	 * @param height		外容器高
	 * void
	 * @since 1.0
	 */
	private void setWhell(int moveVal, Point in_cntPoint, int height) {
		int scrollTop = (int) ((((double) -in_cntPoint.y)/in_cnt.getHeight())*height);
		vertical.setLocation(vertical.getLocation().x, scrollTop);
		in_cnt.setLocation(in_cntPoint.x, in_cntPoint.y+moveVal*10);
	}
}

