package com.gui.util;

import com.gui.format.GuiEnum;
/**
 * <b>工厂类 - 提供工具接口</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年4月20日 上午11:29:53 
 * @see
 * @since 1.0
 */
public class GuiUtilFactory {
	/**
	 * 根据padding设置定位
	 * <p>	 
	 * @param comp
	 * @param paddingLeft
	 * @param paddingTop
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void eleLocationOfAdd(java.awt.Component comp, int paddingLeft, int paddingTop){
		AboutLocationUtil.eleLocationOfAdd(comp, paddingLeft, paddingTop);
	}
	/**
	 * 设置拖动
	 * <p>	 
	 * @param trigger
	 * @param Influencer
	 * void
	 * @see
	 * @since 1.0
	 */
	public static void setDragable(Object trigger, Object Influencer){
		new DragWinUtil().setDragable(trigger, Influencer);
	}
	/**
	 * 获取alignment的值
	 * <p>	 
	 * @param alignment
	 * @return
	 * int
	 * @see
	 * @since 1.0
	 */
	public static int getAlignVal(String alignment){
		GuiEnum.AlignType[] types = GuiEnum.AlignType.values();
		for(GuiEnum.AlignType type : types)
		{
			if(alignment.equals(type.toString()))
				return type.getValue();
		}
		return 0;
	}
}
