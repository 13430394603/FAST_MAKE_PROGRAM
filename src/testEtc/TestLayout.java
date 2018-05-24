package testEtc;

import com.awt.annotation.Control;
import com.awt.control.AbstractControlEtc;
@Control
public class TestLayout extends AbstractControlEtc{
	public TestLayout(){
		super();
	}

	@Override
	protected void execute() {
		System.out.println("启动!");
	}
}
