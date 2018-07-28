package com.gui.layout;

import com.gui.DComp.DComp;

public class HoriLineLayout extends AbstractLayout implements Layout{
	@Override
	public void location(DComp comp) {
		Integer temp = (int) comp.getMargin().getX();
		comp.setMargin(allowX+(int) comp.getMargin().getX(), 
				allowY+(int) comp.getMargin().getY());
		allowX += (int) comp.getSize().getWidth() + temp;
		
		
	}
}
interface DoRun{
	void execute();
}
