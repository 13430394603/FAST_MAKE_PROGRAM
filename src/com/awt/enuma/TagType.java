package com.awt.enuma;

import java.net.MalformedURLException;

import javax.swing.ImageIcon;

import com.awt.context.ProgramContext;
import com.awt.domain.ButtonDoMain;
import com.awt.domain.ContainerDoMain;
import com.awt.domain.DoMain;
import com.awt.domain.LabelDoMain;
import com.awt.domain.ProgramDoMain;
import com.awt.domain.RadioDoMain;
import com.awt.domain.TextAreaDoMain;
import com.awt.domain.TextDoMain;
import com.gui.DComp.DButton_G;
import com.gui.DComp.DButton_Transparent;
import com.gui.DComp.DComp;
import com.gui.DComp.DCompContainer;
import com.gui.DComp.DFrame;
import com.gui.DComp.DFrame_Defined;
import com.gui.DComp.DFrame_G;
import com.gui.DComp.DLabel_G;
import com.gui.DComp.DLabel_Transparent;
import com.gui.DComp.DPanel_Transparent;
import com.gui.DComp.DRadio;
import com.gui.DComp.DTextArea_G;
import com.gui.DComp.DTextPass_G;
import com.gui.DComp.DTextPass_Transparent;
import com.gui.DComp.DText_G;
import com.gui.DComp.DText_Transparent;
import com.stream.Stream.Resource;
/**
 * <b>管理标签类型的接口</b>
 * <p>
 * 描述:
 * <p>
 * xml中的类型信息和此类类型信息对比获取对应的组件对象
 * @author 威 
 * <br>2018年4月13日 下午10:06:50 
 * @see
 * @since 1.0
 */
public interface TagType{
	/**
	 * <b>窗口标签类型</b>
	 * <p>
	 * 描述:
	 * <p>
	 * 调用toString方法获得该类型标签句柄
	 * <p>
	 * 调用getComponent获取该句柄对应的组件对象
	 * @author 威 
	 * <br>2018年4月13日 下午10:07:42 
	 * @see
	 * @since 1.0
	 */
	public enum WindowType{
		WINDOW_1{
			public String toString() {
				return "definedwin";
			}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				DFrame frame = new DFrame_Defined(ProgramContext.getContext());
				ProgramDoMain domain_ = (ProgramDoMain) domain;
				frame.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				frame.setName(domain_.getName());
				frame.setSize(domain_.getWidth(), domain_.getHeight());
				frame.setTitle(domain_.getTitle());
				frame.setPadding(domain_.getPadding_left(), domain_.getPadding_top());
				try {
					frame.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return frame;
			}
		},
		WINDOW_2{
			public String toString(){
				return "normal";}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				DFrame comp = new DFrame_G(ProgramContext.getContext());
				ProgramDoMain domain_ = (ProgramDoMain) domain;
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				comp.setName(domain_.getName());
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setTitle(domain_.getTitle());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setPadding(domain_.getPadding_left(), domain_.getPadding_top());
				try {
					comp.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return comp;
			}
		};
		public String toString(){
			return null;}
		public DComp getComponent(DoMain domain){
			return null;
		}
		
	}
	/**
	 * <b>容器标签类型</b>
	 * <p>
	 * 描述:
	 * <p>
	 * 调用toString方法获得该类型标签句柄
	 * <p>
	 * 调用getComponent获取该句柄对应的组件对象
	 * @author 威 
	 * <br>2018年4月13日 下午10:07:42 
	 * @see
	 * @since 1.0
	 */
	public enum ContainerType{
		CONTAINER_1{
			public String toString(){
				return "normal";}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				ContainerDoMain domain_ = (ContainerDoMain) domain;
				DCompContainer comp = new DPanel_Transparent(ProgramContext.getContext());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				comp.setName(domain_.getName());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setPadding(domain_.getPadding_left(), domain_.getPadding_top());
				try {
					comp.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return comp;
			}
		};
		public String toString(){
			return null;}
		public DComp getComponent(DoMain domain){
			return null;}
	}
	/**
	 * <b>按钮标签类型</b>
	 * <p>
	 * 描述:
	 * <p>
	 * 调用toString方法获得该类型标签句柄
	 * <p>
	 * 调用getComponent获取该句柄对应的组件对象
	 * @author 威 
	 * <br>2018年4月13日 下午10:07:42 
	 * @see
	 * @since 1.0
	 */
	public enum ButtonType{
		BUTTON_1{
			public String toString() {
				return "transparent";
			}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				ButtonDoMain domain_ = (ButtonDoMain) domain; 
				DComp comp = null;
				try {
					comp = new DButton_Transparent(domain_.getValue(),
							new ImageIcon(Resource.getResource(domain_.getIcon_src()).toURL()));
				} catch (MalformedURLException e1) {
					com.awt.util.Print.alert(this, "getComponent", "生成DButton_Transparent组件时异常");
					e1.printStackTrace();
				}
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setPadding(domain_.getPadding_left(), domain_.getHeight());
				try {
					comp.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return comp;
			}
		},
		BUTTON_2{
			public String toString() {
				return "normal";
			}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				ButtonDoMain domain_ = (ButtonDoMain) domain; 
				DComp comp = null;
				try {
					comp = new DButton_G(domain_.getValue(),
							new ImageIcon(Resource.getResource(domain_.getIcon_src()).toURL()));
				} catch (MalformedURLException e1) {
					com.awt.util.Print.alert(this, "", "生成DButton_Transparent组件时异常");
					e1.printStackTrace();
				}
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setPadding(domain_.getPadding_left(), domain_.getHeight());
				try {
					comp.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return comp;
			}
		};
		public String toString(){
			return null;}
		public DComp getComponent(DoMain domain){
			return null;}
	}
	/**
	 * <b>label标签类类</b>
	 * <p>
	 * 描述:
	 * <p>
	 * 调用toString方法获得该类型标签句柄
	 * <p>
	 * 调用getComponent获取该句柄对应的组件对象
	 * @author 威 
	 * <br>2018年4月13日 下午10:07:42 
	 * @see
	 * @since 1.0
	 */
	public enum LabelType{
		LABEL_1{
			public String toString() {
				return "transparent";
			}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				LabelDoMain domain_ = (LabelDoMain) domain; 
				DComp comp = null;
				try {
					comp = new DLabel_Transparent(domain_.getValue(),
							new ImageIcon(Resource.getResource(domain_.getIcon_src()).toURL()),
							domain_.getText_align());
				} catch (MalformedURLException e1) {
					com.awt.util.Print.alert(this, "getComponent", "生成DLabel_Transparent组件时异常");
					e1.printStackTrace();
				}
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setPadding(domain_.getPadding_left(), domain_.getHeight());
				
				try {
					comp.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return comp;
			}
		},
		LABEL_2{
			public String toString(){
				return "normal";
			}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				LabelDoMain domain_ = (LabelDoMain) domain; 
				DComp comp = null;
				try {
					comp = new DLabel_G(domain_.getValue(),
							new ImageIcon(Resource.getResource(domain_.getIcon_src()).toURL()),
							domain_.getText_align());
				} catch (MalformedURLException e1) {
					com.awt.util.Print.alert(this, "getComponent", "生成DLabel_G组件时异常");
					e1.printStackTrace();
				}		
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setPadding(domain_.getPadding_left(), domain_.getHeight());
				try {
					comp.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return comp;
			}
		};
		public String toString(){
			return null;}
		public DComp getComponent(DoMain domain){
			return null;}
	}
	/**
	 * <b>文本标签类型</b>
	 * <p>
	 * 描述:
	 * <p>
	 * 调用toString方法获得该类型标签句柄
	 * <p>
	 * 调用getComponent获取该句柄对应的组件对象
	 * @author 威 
	 * <br>2018年4月13日 下午10:07:42 
	 * @see
	 * @since 1.0
	 */
	public enum TextType {
		TEXT_1{
			public String toString() {
				return "transparent";
			}
			public DComp getComponent(DoMain domain){
				TextDoMain domain_ = (TextDoMain) domain; 
				DComp comp = new DText_Transparent(domain_.getValue());
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				return comp;
			}
		},
		TEXT_2{
			public String toString(){
				return "normal";}
			public DComp getComponent(DoMain domain){
				TextDoMain domain_ = (TextDoMain) domain; 
				DComp comp = new DText_G(domain_.getValue());
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				return comp;
			}
		},
		TEXT_3{
			public String toString() {
				return "pass_transparent";
			}
			public DComp getComponent(DoMain domain){
				TextDoMain domain_ = (TextDoMain) domain; 
				DComp comp = new DTextPass_Transparent(domain_.getValue());
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				return comp;
			}
		},
		TEXT_4{
			public String toString(){
				return "pass_normal";}
			public DComp getComponent(DoMain domain){
				TextDoMain domain_ = (TextDoMain) domain; 
				DComp comp = new DTextPass_G(domain_.getValue());
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				return comp;
			}
		};
		public String toString(){
			return null;}
		public DComp getComponent(DoMain domain){
			return null;}
	}
	public enum TextAreaType{
		TextArea_1{
			public String toString() {
				return "normal";
			}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				TextAreaDoMain domain_ = (TextAreaDoMain) domain; 
				DTextArea_G comp = new DTextArea_G(domain_.getValue());
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setEditable(domain_.isEditable());
				comp.setVisible(domain_.isVisable());
				try {
					comp.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return comp;
			}
		};
		public String toString(){
			return null;}
		public DComp getComponent(DoMain domain){
			return null;}
	}
	public enum RadioType{
		Radio_1{
			public String toString() {
				return "normal";
			}
			@SuppressWarnings("deprecation")
			public DComp getComponent(DoMain domain){
				RadioDoMain domain_ = (RadioDoMain) domain; 
				DRadio comp = new DRadio(domain_.getValue());
				comp.setSize(domain_.getWidth(), domain_.getHeight());
				comp.setMargin(domain_.getMargin_left(), domain_.getMargin_top());
				comp.setFont(domain_.getFont_name(), domain_.getFont_style(), domain_.getFont_size());
				comp.setVisible(domain_.isVisable());
				try {
					comp.setBackgroundImage(new ImageIcon(Resource.getResource(domain_.getSrc()).toURL()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return comp;
			}
		};
		public String toString(){
			return null;}
		public DComp getComponent(DoMain domain){
			return null;}
	}
	/**
	 * <b>获取标签的名称句柄</b>
	 * <p>
	 * 描述:
	 * <p>
	 * @author 威 
	 * <br>2018年4月13日 下午9:52:37 
	 * @see
	 * @since
	 */
	public enum TagName {
		FRAME_TAG_NAME{
			public String toString(){
				return "program";
			}
		},CONTAINER_TAG_NAME{
			public String toString(){
				return "container";
			}
		},LABEL_TAG_NAME{
			public String toString(){
				return "label";
			}
		},TEXT_TAG_NAME{
			public String toString(){
				return "text";
			}
		},BUTTON_TAG_NAME{
			public String toString(){
				return "button";
			}
		},SERVER_TAG_NAME{
			public String toString(){
				return "service";
			}
		};
		public String toString(){
			return null;
		}
	}
}