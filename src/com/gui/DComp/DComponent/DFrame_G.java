package com.gui.DComp.DComponent;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;

import javax.swing.ImageIcon;

import com.gui.DComp.AbstractDComp.AbstractDFrame;
import com.gui.typeStyle.DefaultFrame;

public class DFrame_G extends AbstractDFrame {
	public DFrame_G() {
		this(null, null);
	}
	public DFrame_G(String title) {
		this(null, title);
	}
	public DFrame_G(Map<String, Object> context) {
		this(context, null);
	}
	@SuppressWarnings("deprecation")
	public DFrame_G(Map<String, Object> context, String title) {
		this.context = context;
		comp = new DefaultFrame();
		comp.setVisible(true);
		try {
			File file = com.stream.Stream.Resource.getResource(
					"img", "ProgramIcon.png");
			if(file != null)
			((DefaultFrame) comp).setIconImage(
					new ImageIcon(file.toURL()).getImage());
		} catch (MalformedURLException e) {
			com.conf.log.impl.LogImpl.getInstance().log(
					com.conf.log.LOG.ERROR, e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void setPadding(int x, int y) {
		((DefaultFrame) comp).setPadding(x, y);
	}
	
	@Override
	public void setIconImage(ImageIcon imageIcon) {
		if(imageIcon != null)
			((DefaultFrame) comp).setIconImage(imageIcon.getImage());
	}
}
