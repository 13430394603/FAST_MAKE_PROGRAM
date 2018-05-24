package com.gui.layout;

import java.awt.Point;

import com.gui.DComp.DComp;

public class AbstractLayout implements Layout {
	protected Integer allowY;
	protected Integer allowX;
	@Override
	public void location(DComp comp) {
	}

	@Override
	public void init(Point padding) {
		allowX 	= padding.x;
		allowY 	= padding.y;
	}
}
