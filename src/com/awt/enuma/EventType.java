package com.awt.enuma;
/**
 * <b>各种事件enum接口  集中管理</b>
 * <p>
 * 描述:
 * <p>
 * 其中编写着所有事件的enum，想要获取事件句柄，从中取
 * @author 威 
 * <br>2018年4月13日 下午10:21:00 
 * @see
 * @since 1.0
 */
public interface EventType {
	/**
	 * <b>点击事件enum类</b>
	 * @author 威 
	 * <br>2018年4月13日 下午10:21:10 
	 * @see
	 * @since 1.0
	 */
	public enum ClickType{
		CLICK{
			public String toString(){
				return "click";
			}
		},DBCLICK{
			public String toString(){
				return "dbclick";
			}
		},MOUSEDOWN{
			public String toString(){
				return "mousedown";
			}
		},MOUSEUP{
			public String toString(){
				return "mouseup";
			}
		},MOUSEMOVE{
			public String toString(){
				return "mousemove";
			}
		},MOUSEOUT{
			public String toString(){
				return "mouseout";
			}
		};
		public String toString(){
			return null;
		}
	}
	/**
	 * <b>文本事件enum类</b>
	 * @author 威 
	 * <br>2018年4月13日 下午10:21:15 
	 * @see
	 * @since 1.0
	 */
	public enum TextType{
		CHANGE{
			public String toString(){
				return "change";
			}
		};
		public String toString(){
			return null;
		}
	}
	/**
	 * <b>窗口事件enum类</b>
	 * @author 威 
	 * <br>2018年4月13日 下午10:21:19 
	 * @see
	 * @since 1.0
	 */
	public enum WindowType{
		ONLOAD{
			public String toString(){
				return "onload";
			}
		},CLOSE{
			public String toString(){
				return "close";
			}
		},FOCUS{
			public String toString(){
				return "focus";
			}
		},BLUR{
			public String toString(){
				return "blur";
			}
		},HIDE{
			public String toString(){
				return "hide";
			}
		},OPEN{
			public String toString(){
				return "open";
			}
		};
		public String toString(){
			return null;
		}
	}
	
}
