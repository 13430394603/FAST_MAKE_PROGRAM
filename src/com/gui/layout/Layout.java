package com.gui.layout;

import java.awt.Point;

import com.gui.DComp.DComp;

public interface Layout {
	public void init(Point padding);
	public void location(DComp comp);
}
