package testEtc;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTextField;

import com.awt.annotation.Control;
import com.awt.control.AbstractControlEtc;
import com.gui.DComp.DComp;
import com.gui.DComp.DComponent.DProgressBar_G;
import com.gui.typeStyle.DefaultTextArea;
import com.stream.Stream.Resource;
/**
 * <b>cutJar界面类</b>
 * <p>
 * @author 威
 * <br>2018年4月29日 下午5:42:12
 * @see com.awt.control.AbstractControl
 * @since 1.0
 */
/*@Control*/
public class TestEtc extends AbstractControlEtc{
	private boolean selectFlag;		//选择默认
	private JTextField jrePath;		//jre目录
	private JTextField jarName;		//jar路径
	private JTextField cutName;		//要剪切的包名称
	private DefaultTextArea showInfo;		//显示信息文本框，不可输入
	private DProgressBar_G bar;
	
	public TestEtc(){
		super();
		selectFlag = true;
	}
	
	@Override
	protected void execute() {
		System.out.println("start program!");
		jrePath = (JTextField) getComponentByName("jrePathText");
		jarName = (JTextField) getComponentByName("jarName");
		cutName = ((JTextField) getComponentByName("cutNameText"));
		showInfo = (DefaultTextArea) getComponentByName("showInfo");
		
		String imgPath = Resource.getResourceToString("img", "4444444.png");
		ImageIcon img = new ImageIcon(imgPath);
		bar = new DProgressBar_G(img);
		DComp comp =  (DComp) getDCompByName("progressbar");
		comp.add("", bar);
		bar.setMargin(0, 0);
		bar.setOrigSize(450, 6);
		bar.slideTo(430);
		
		int num = 0;
		while(true){
			try {
				num++;
				showInfo.append(".");
				showInfo.append("\r\n");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void selectRadio(MouseEvent e){
		selectFlag = selectFlag ? false : true;
		cutName.setEnabled(selectFlag);
	}
	
	//按钮操作事件
	public void reset(MouseEvent e){
		jrePath.setText("");
		jarName.setText("");
		cutName.setText("");
	}
	public void doStart(MouseEvent e){
		System.out.println("start");
	}
	public void selectJrePath(MouseEvent e){
		System.out.println("selectJrePath");
	}
	public void selectJarPath(MouseEvent e){
		System.out.println("selectJarPath");
	}
}
