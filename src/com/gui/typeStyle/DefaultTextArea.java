package com.gui.typeStyle;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * <b>自定义JScrollPane</b>
 * @author 威 
 * <br>2018年4月28日 下午7:30:43 
 * @see javax.swing.JScrollPane
 * @since 1.0
 */
public class DefaultTextArea extends JScrollPane{
	private static final long serialVersionUID = 4434320598768993651L;
	private JTextArea areaComp;
	public DefaultTextArea(String text){
		super();
		areaComp = new JTextArea(text);
		areaComp.setVisible(true);
		areaComp.setOpaque(false);
		areaComp.setLineWrap(true);
		areaComp.repaint();
		this.setViewportView(areaComp);
		
		//新增
		//this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		this.addMouseWheelListener(new MouseWheelListener(){
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println(areaComp.getLocation());
			}
		});
	}
	public void insert(String str, int i){
		areaComp.insert(str, i);
	}
	public void replace(String str, int start, int end){
		areaComp.replaceRange(str, start, end);
	}
	public void append(String str){
		areaComp.append(str);
	}
	public void setEditable(boolean flag){
		areaComp.setEditable(flag);
	}
	public void setText(String text){
		System.out.println("haha2");
		areaComp.setText(text);
	}
	public String getText(){
		return areaComp.getText();
	}
}
