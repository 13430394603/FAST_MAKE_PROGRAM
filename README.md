# FAST_MAKE_PROGRAM
桌面程序开发架包

    目的：加快桌面程序的开发的速度、界面参数集中管理、界面与逻辑分开处理，降低依赖有效解耦。
    
              过程：
        	1、启动Core。
        	2、加载标注有@Control并且继承Control_Basi类的界面对象。
        	3、并按照优先级实例化界面对象。
        	4、实例化的界面对象会扫描对应的配置文件创建gui组件并添加相应的事件。
        	5、完成页面的加载。
        	
	目的：
     	1、加快开发的速度。
        	2、界面参数集中管理。
        	3、界面与逻辑分开处理，降低依赖有效解耦。
        	
	使用说明：
		控制类的创建示例：
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
		xml文件
			命名方式--界面控制类需与xml文件名命名处理xml首字母小写其余相同
			例子：
			<program name="mainFrame2"
			 type="definedwin" 
			 size="240*2 385" 
			 title="cutJar" 
			 padding="10 10"
			 layout="vertline_layout">
				<container type="normal" 
						size="200*2 50"
						border="black 1"
						layout="horiline_layout">
					<button type="transparent" size="50 parent"></button>
					<button type="transparent" size="50 parent"></button>
					<button type="transparent" size="50 parent"></button>
					<button type="transparent" size="50 parent"></button>
				</container>
				<container type="normal" 
						size="parent 50"
						border="black 1"
						margin="1*10 0">
					<button type="transparent" size="default 20"></button>
				</container>
				<container type="normal" 
						size="parent 50"
						border="black 1"
						margin="0 0">
					<button type="transparent" size="default 20"></button>
				</container>
			</program>
		img（根目录img文件）
			ProgramBack.png	程序背景
			ProgramIcon.png	菜单栏图标
			ProgramIconMin.png	界面小图标
		com.awt.annotation
			@Control(priority<默认为5,区间0-10>) 	界面控制类注解  
		com.awt.core
			Core  				启动类--加载注解为@Control的控制类
		com.awt.control（生成界面，所有界面都需继承控制类）
			AbstractControlEtc 		扩展控制类 
	标签语法：
		program::container | button | text | label | radio | textarea | service（事件服务）
        	container::button | text | label | radio | textarea | service（事件服务）
       	button::service
       	text::service
     	label::service
       	radio::service
      	textarea::service  
	更新    
		18/5/24 
		1、添加了符合属性
			[size="width height"] 
			[border="borderColor lineSize"]
			[borderColor:gray|green|black|blue|cyan|pink|red|orange|yellow|lightGray]
		  	[font="fontName fontStyle fontSize"]
	  		[padding="left top"]
		  	[margin="left top"]
	  	2、可以使用表达式
	  		size padding margin 中的数字可以使用数学表达式--例如：120*2
	  		com.awt.util.Arithmetic转换数学表达式
	  	3、容器增加布局属性[layout]
	  		default_layout		无布局
	  		vertline_layout		垂直流线布局
	  		horiline_layout		水平流线布局
	  		新增包结构：
	  		com.gui.layout
	  			Layout.java
	  				AbstractLayout.java
	  					DefaultLayout.java
	  					VertLineLayout.java
	  					HoriLineLayout.java
	  	4、核心类的优化，便于扩展
	  		4 1、优化AbstractControl_Basi--将service的处理分离到
	  		com.awt.dealComponentImpl包中的类处理，便于扩展
        
	扩展
         	1. 标签扩展
         		com.awt.enuma.TagType增加内部类enum类--实现对组件的创建
            	com.awt.domain包中以BasiDoMain为父类增加标签对应的实体对象，承载标签属性
            	com.awt.dealComponentImpl分别以DealComponent、DealComponentCnt为父类增加处理对象
            		负责组件创建(调用 com.awt.enuma.TagType获取组件对象)和创建服务对象（组件事件对象）	
			在配置文件中增加配置（systemConf.systemConf.xml）
				增加<bean id="组件标签名称" class="com.awt.domain.组件DoMain类名"> </bean>
				增加<bean id="create_组件标签名称" 						class="com.awt.dealComponentImpl.组件处理对象类名"></bean>
         	2. service扩展（负责组件事件的创建）
			com.awt.domain包中以Service为父类增加对应的服务类
			在配置文件中增加配置（systemConf.systemConf.xml）
			<bean id="service名称" class="com.awt.service.服务类名"></bean>	   
			      	   
	已有标签说明：
            1. 所有组件共同属性：{
                type / width(元素宽度) / margin_left(距离) / margin_top(距离) / height(元素高度) 
                / name(context中的key值，不给则不添加进context) / font_style[bold|italic|plain](字体样式) 
                /	font_name(字体名称) /	font_size(字体大小) 		
            }			
            2. 容器组件：
                2.1. Program
                    描述：一个window窗口
                    属性: {
                        type[normal|definedwin](组件类型) / padding_left(内边距) / padding_top(内边距) / title(标题)
                    }
                    事件：{
                        onload（可以废弃，当前Control类的execute方法就是onload）/ close / focus / blur / hide / open
                    }

                2.2. Container
                    描述：一个容器
                    属性： {
                        type[normal|progressbar（未实现）|autocnt(有滚动条容器，未实现)|textarea(文本编辑，未实现)] / padding_left 
                        / padding_top / src
                    }
                    等待处理增加标签type：wincontainer
            3. 一般组件：
                3.1. Button
                    描述：按钮组件
                    属性: {
                        type[normal|transparent] / value / padding_left / padding_top / src / icon_src(图标)
                    }
                    事件：{
                        click / dbclick / mousedown / mouseup / mousemove / mouseout
                    }
                    特殊：type:transparent时添加不了图片
                3.2. Label
                    描述：label 显示组件
                    属性: {
                        type[normal|transparent] / value(文本值) / padding_left / padding_top / src / icon_src / text_align[left|center|right]
                    }
                    事件：{
                        click / dbclick / mousedown / mouseup / mousemove / mouseout
                    }
                3.3. Text
                    描述：输入框
                    属性:{
                        type[normal|transparent|pass_transparent|pass_normal] / value
                    } 
                    事件：{
                        click / dbclick / mousedown / mouseup / mousemove / mouseout / change
                    }

                3.4. radio
                    描述：选择
                    属性：{
                        type[normal] / value
                    }
                    事件：{
                        click / dbclick / mousedown / mouseup / mousemove / mouseout 
                    }
                3.5. textarea:
                    -------------------------------------------------------------------------------
                    描述：文本框
                    -------------------------------------------------------------------------------
                    属性：{
                        type[normal] / value / editable(是否可编辑)
                    } 
                    事件：{
                        click / dbclick / mousedown / mouseup / mousemove / mouseout / change
                    }
                3.6. progressbar:
                    描述：进度条
                    属性：{
                        type / orig_width(原始宽) / orig_height(原始高度) / slide_to(滑动到) / src
                    }
        
