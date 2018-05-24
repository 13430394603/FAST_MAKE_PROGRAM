package com.gui.format;

import java.awt.Point;
import java.awt.Toolkit;

import com.awt.domain.BasiDoMain;
import com.awt.domain.DoMain;
import com.gui.DComp.DComp;

import com.awt.domain.ProgramDoMain;

/**
 * <b>Guienum集中管理接口</b>
 * <p>
 * 描述:<br>
 * 含有Label组件和Button组件显示的格式
 * @author 威 
 * <br>2018年4月16日 上午11:41:41 
 * @see
 * @since 1.0
 */
public interface GuiEnum {
	/**
	 * <b>Label组件和Button组件显示的格式</b>
	 * @author 威 
	 * <br>2018年4月16日 上午11:41:03 
	 * @see
	 * @since 1.0
	 */
	public enum AlignType{
		CENTER{
			public String toString(){
				return "center";
			}
			public int getValue(){
				return 0;
			}
		}, LEFT{
			public String toString(){
				return "left";
			}
			public int getValue(){
				return 2;
			}
		}, RIGHT{
			public String toString(){
				return "right";
			}
			public int getValue(){
				return 4;
			}
		};
		
		public String toString(){
			return "center";
		}
		public int getValue(){
			return 0;
		}
	}
	/**
	 * <b>字体样式</b>
	 * @author 威 
	 * <br>2018年4月16日 下午8:13:59 
	 * @see
	 * @since 1.0
	 */
	public enum FontStyle{
		
		//粗体字体
		BOLD{
			public String toString(){
				return "bold";
			}
			public int getValue(){
				return 1;
			}
		},
		//斜体字体
		ITALIC{
			public String toString(){
				return "italic";
			}
			public int getValue(){
				return 2;
			}
		},
		//一般字体
		PLAIN{
			public String toString(){
				return "plain";
			}
			public int getValue(){
				return 0;
			}
		};
		public String toString(){
			return "plain";
		}
		public int getValue(){
			return 0;
		}
	}
	/**
	 * <b>获取程序窗口所在的特定位置坐标</b>
	 * <p>
	 * 描述:<br>
	 * 
	 * @author 威 
	 * <br>2018年4月19日 下午6:15:39 
	 * @see
	 * @since 1.0
	 */
	public enum LocationUtil {
		CENTER{
			public Point getPoint(int width, int height){
				int defaultWidth = Toolkit.getDefaultToolkit().getScreenSize().width; 
			    int defaultHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
			    return new Point(((defaultWidth - width)/2), ((defaultHeight - height)/2));
			}
		},RIGHT{
			public Point getPoint(int width, int height){
				int defaultWidth = Toolkit.getDefaultToolkit().getScreenSize().width; 
			    int defaultHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
			    return new Point((defaultWidth - width), (defaultHeight - height));
			}
		};
		public Point getPoint(int width, int height){return null;}
	}
	/**
	 * <b>相对于父元素的size值</b>
	 * <p>
	 * 描述:<br>
	 * PARENT 	适应父元素去减掉padding值 获取元素的width，height相对于父元素的值
	 * DEFAULT 	默认是父元素的0.5倍
	 * @author 威 
	 * <br>2018年5月24日 上午11:39:11 
	 * @see 
	 * @since 1.0
	 */
	public enum RelativeSize{
		PARENT{
			public String toString(){
				return "parent";
			}
			public int getWidthVal(DoMain parent){
				int initLeft = (int) (parent instanceof ProgramDoMain
						? ((ProgramDoMain) parent).getInitPadding().x
						: 0);
				Integer width = 
						Integer.parseInt(((BasiDoMain) parent).getWidth()) 
						+ initLeft;
				Integer padding_left = 
						Integer.parseInt(((BasiDoMain) parent).getPadding_left()) ;
				return width - padding_left*2;
			}
			public int getHeightVal(DoMain parent){
				int initTop = (int) (parent instanceof ProgramDoMain
						? ((ProgramDoMain) parent).getInitPadding().y
						: 0);
				Integer height = 
						Integer.parseInt(((BasiDoMain) parent).getHeight()) - initTop;
				Integer padding_top = 
						Integer.parseInt(((BasiDoMain) parent).getPadding_top());
				return height - padding_top*2;
			}
		},HALF_PARENT{
			public String toString(){
				return "half_parent";
			}
			public int getWidthVal(DoMain parent){
				Integer width = Integer.parseInt(((BasiDoMain) parent).getWidth());
				Integer padding_left = Integer.parseInt(((BasiDoMain) parent).getPadding_left());
				return (int) ((width - padding_left*2)*0.5);
			}
			public int getHeightVal(DoMain parent){
				Integer height = 
						Integer.parseInt(((BasiDoMain) parent).getHeight());
				Integer padding_top = 
						Integer.parseInt(((BasiDoMain) parent).getPadding_top());
				return (int) ((height - padding_top*2)*0.5);
			}
		};
		@Override
		public String toString(){
			return "";
		}
		public int getWidthVal(DoMain parent){
			return 0;
		}
		public int getHeightVal(DoMain parent){
			return 0;
		}
	}
}
