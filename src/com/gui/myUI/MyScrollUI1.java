package com.gui.myUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;

import com.gui.typeStyle.MyMetalScrollButton;
/**
 * <b>重新定义滚动条的样式UI对象</b>
 * <p>
 * 描述:<br>
 * 改变了DecreaseButton<br>
 * 改变了paintThumb为自定义样式<br>
 * 覆盖了paintTrack为一个空方法<br>
 * @author 威 
 * <br>2018年5月2日 下午2:37:16 
 * @see 
 * @see com.gui.typeStyle.MyMetalScrollButton
 * @since 1.0
 */
public class MyScrollUI1 extends MetalScrollBarUI{
	/** Returns the view that represents the decrease view. */
	@Override
	protected JButton createDecreaseButton( int orientation )
    {
		return new MyMetalScrollButton(orientation, 6, true);
    }

    /** Returns the view that represents the increase view. */
	@Override
	protected JButton createIncreaseButton( int orientation )
    {
    	return new MyMetalScrollButton(orientation, 6, true);
    }
	@Override
	public void paint(Graphics g,JComponent c){
		//只影响Track和Thumb
		super.paint(g, c);
	}
	//比较基本，没有不显示
	@Override
	protected void paintDecreaseHighlight(Graphics g){
		//绘制影响全局 -- 没有，组件会是空白
		super.paintDecreaseHighlight(g);
	}
	@Override
	protected void paintIncreaseHighlight(Graphics g){
		//绘制影响全局 -- 没有，组件会是空白
		super.paintIncreaseHighlight(g);
	}
	//移动条的绘制
	@Override
	protected void paintThumb(Graphics g,JComponent c,Rectangle rt){
		/*super.paintThumb(g, c, rt);*/
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(java.awt.Color.gray);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);  /*使线条圆滑*/
		System.out.println(rt);
		g2d.fillRoundRect(rt.x, rt.y, (int) rt.getWidth(), (int) rt.getHeight(), 5, 5);
		g2d.dispose();
	}
	@Override
	protected void paintTrack(Graphics g,JComponent c,Rectangle rt){
		//画轨道
		//super.paintTrack(g, c, rt);
	}	
}
