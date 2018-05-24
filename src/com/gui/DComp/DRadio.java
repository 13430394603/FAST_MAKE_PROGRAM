package com.gui.DComp;

import java.awt.Font;

import javax.swing.JRadioButton;

import com.gui.DComp.AbstractDComp.AbstractDComp;

public class DRadio extends AbstractDComp {
	
	public DRadio(){ this("");}
	public DRadio(String text){
		comp = new JRadioButton(text);
		((JRadioButton) comp).setOpaque(false);
		comp.setSize(20,20);
		comp.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		comp.setFocusable(false);
		comp.setVisible(true);
	}
}
