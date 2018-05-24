package com.gui.util;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * <b>滚动的拖动工具类</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年5月1日 下午3:24:28 
 * @see
 * @since 1.0
 */
public class DragScrollBarUtil extends AbstractDragUtil {
	private int preMarginTop;
	private int outCntHeight;
	
	public DragScrollBarUtil(){
		
	}
	/**
	 * 设置外容器的高
	 * <p>	 
	 * @param outCntHeight
	 * void
	 * @since 1.0
	 */
	public void init(int outCntHeight){
		this.outCntHeight = outCntHeight;
	}

	@Override
	protected void release(MouseEvent e) {
		
	}

	@Override
	protected void press(MouseEvent e) {
		preMarginTop = e.getY();
	}

	@Override
	protected void drag(Object Influencer, MouseEvent e) {
		Component tirComp = (Component) e.getSource();
		Component InfluencerComp = (Component) Influencer;
		Point tirCompPoint = tirComp.getLocation();
		int y = tirCompPoint.y + (e.getY() - preMarginTop);
		int maxMarginTop = outCntHeight - tirComp.getHeight();
		if(y >= 0 && y <= maxMarginTop){
			tirComp.setLocation((int) tirCompPoint.getX(), y);
			int InfluencerCompMarginTop = (int) ((double) y/outCntHeight*InfluencerComp.getHeight());
			InfluencerComp.setLocation(
					(int) InfluencerComp.getLocation().getX(), 
					-InfluencerCompMarginTop);
		}
	}
}
