package com.gui.layout;

import java.awt.Point;

import com.gui.DComp.DComp;

public class DefaultLayout extends AbstractLayout implements Layout {
	@Override
	public void location(DComp comp) {
		Point p = comp.getMargin();
		int x = p.x + allowX;
		int y = p.y + allowY;
		comp.setMargin(x, y);
	}
}
