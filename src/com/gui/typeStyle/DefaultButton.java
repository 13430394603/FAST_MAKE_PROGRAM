package com.gui.typeStyle;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.Icon;

/**
 * <b>最基本的Button类 可基于此扩展</b>
 * @author 威 
 * <br>2017年10月6日 下午4:27:50 
 * @see AbstaractDefaultButton
 * @since
 */
public class DefaultButton extends AbstaractDefaultButton{
	private static final long serialVersionUID = 1L;
	private String state="normal";		//事件状态
	
	public DefaultButton() {
		this(null, null);
	}
	public DefaultButton(String text){
		this(text, null);
		
	}
	public DefaultButton(String text, Icon icon){
		super(text, icon);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE,0)); /*设置才能消除原来的边框*/
		this.setFocusable(false);
		this.setForeground(java.awt.Color.black);
		this.setFont(new Font("宋体", Font.PLAIN, 13));
		this.setOpaque(false);           //背景为透明
        this.setContentAreaFilled(false); // 这一句非常重要, 否则父类还会绘制按钮的区域.
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setVisible(true);
        this.setSize(1, 1);
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if(this.getText() != null && !this.getText().equals("")){
			Font deaultFont=getFont();
			Rectangle2D fontRect = deaultFont.getStringBounds(
					this.getText(),g2d.getFontRenderContext());
			if(this.getWidth() == 1 && this.getHeight() == 1)
				this.setSize(((int) fontRect.getWidth()) + (padding_left == 0 ? 1 : padding_left)*2 + 4,
						((int) fontRect.getHeight()) + (padding_top == 0 ? 1 : padding_left)*2 + 4) ;
		}
		if(backgroundImage != null){
			Image img = backgroundImage.getImage();
			g.drawImage(img, padding_left, padding_top,
		        		(this.getWidth() - (padding_left*2)),
		        		(this.getHeight() - (padding_top*2)),
		        		backgroundImage.getImageObserver());
		}
		if(state.equals("normal")){
		}else if(state.equals("focused")){
			Shape s=new RoundRectangle2D.
					Double(0.0, 0.0, this.getWidth()-1, this.getHeight()-1, 10.0, 10.0);  /*后两个值为矩形圆角的度*/
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);  /*使线条圆滑*/
			//FocusBackground
			g2d.setColor(new Color(180, 180, 182));
			g2d.draw(s);
		}
		g2d.dispose();
		/*待升级部分*/
		/*else if(state.equals("pressed")){
			
		}else if(state.equals("released")){
			
		}*/
		addMouseListener(new MouseAdapter() {  
	        public void mouseEntered(MouseEvent e) { 
	            state = "focused";  
	            repaint();  
	        }
	        public void mouseExited(MouseEvent e) { 
	            state = "normal";  
	            repaint();  
	        }   
	        /*待升级部分*/
	        /*public void mousePressed(MouseEvent e) {   
	            state = "pressed";  
	            repaint();  
	        }  
	        public void mouseReleased(MouseEvent e) { 
	            state = "released";  
	            repaint();  
	        }  */
	    });
	} 
}
