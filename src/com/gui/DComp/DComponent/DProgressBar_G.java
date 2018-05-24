package com.gui.DComp.DComponent;

import javax.swing.ImageIcon;

import com.gui.DComp.AbstractDComp.AbstractDProgressBar;
import com.gui.typeStyle.ProgressBar;

public class DProgressBar_G extends AbstractDProgressBar{
	public DProgressBar_G(){
		this(null);
	}
	public DProgressBar_G(ImageIcon image){
		comp = new ProgressBar(image);
		((ProgressBar) comp).setOpaque(false);
	}
}

