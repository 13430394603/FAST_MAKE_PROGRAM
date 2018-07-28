package testEtc;

import com.awt.annotation.Control;
import com.awt.control.AbstractControlEtc;
/**
 * <b>布局页面测试</b>
 * <p>
 * 描述:<br>
 * DefaultLayout	无
 * HoriLineLayout	水平
 * VertLineLayout	垂直
 * @author 威 
 * <br>2018年6月27日 下午8:57:19 
 * @see
 * @since 1.0
 */
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
