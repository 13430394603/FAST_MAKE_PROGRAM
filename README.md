# FAST_MAKE_PROGRAM
该文件用于记录FAST_MAKE_PROGRAM桌面程序开发架包，通过配置文件配置一个界面，并通过继承一个Control类来生成对应配置文件的界面。
****

|Author|威|
|:---:|:---
|E-mail|chenJiWey@163.com

****

# 目的
* 架包的目的是加快桌面程序的开发的速度、界面参数集中管理、界面与逻辑分开处理，降低依赖有效解耦。

# 使用说明
1).控制类的创建示例：
```Java
@Control
public class TestFrame extends AbstractControlEtc{
	public TestFrame(){
		super();
	}
	@Override
	protected void execute() {
		System.out.println("启动!");
	}
}
```
2).xml文件
命名方式--界面控制类需与xml文件名命名处理xml首字母小写其余相同
例子：
```xml
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
```
3).img（根目录img文件）
	ProgramBack.png	程序背景
	ProgramIcon.png	菜单栏图标
	ProgramIconMin.png	界面小图标
4).com.awt.annotation
	@Control(priority<默认为5,区间0-10>) 	界面控制类注解  
5).com.awt.core
	Core  				启动类--加载注解为@Control的控制类
6).com.awt.control（生成界面，所有界面都需继承控制类）
	AbstractControlEtc 		扩展控制类 
7).com.awt.context.ProgramContext
	获取ContextMap对象，通过这个Map可获取xml文件中有属性name的组件

# 配置文件标签语法
>program::container | button | text | label | radio | textarea 
>>container::button | text | label | radio | textarea | container
>>>button::
>>>text::
>>>label::
>>>radio::
>>>textarea:: 

# 更新
### 18/5/24 
|描述|详细
|:----|:------|
|添加了复合属性|`[size="width height"]` <br>
			`[border="borderColor lineSize"]` <br>
			`[borderColor:gray|green|black|blue|cyan|pink|red|orange|yellow|lightGray]` <br>
		  	`[font="fontName fontStyle fontSize"]` <br>
	  		`[padding="left top"]` <br>
		  	`[margin="left top"]`
|可以使用表达式|size padding margin 中的数字可以使用数学表达式--例如：120*2 <br>
	  		com.awt.util.Arithmetic转换数学表达式
			
|相对父元素字段或值|size 属性值可以使用特殊字段parent<适应父容器> /half_parent<相对于父容器的一半>
|容器增加布局属性`[layout]`|default_layout			无布局 <br>
	  		vertline_layout		垂直流线布局 <br>
	  		horiline_layout		水平流线布局 <br>
	  		新增包结构： <br>
	  		com.gui.layout <br>
	  			Layout.java <br>
	  				AbstractLayout.java <br>
	  					DefaultLayout.java <br>
	  					VertLineLayout.java <br>
	  					HoriLineLayout.java
|将此类com.awt.context.ProgramContext所存的组件值从Component换成了DComp对象|意味着界面控制类所操作的组件为DComp对象--有利于组建的定位处理
|核心类的优化，便于扩展|优化AbstractControl_Basi、AbstractControlEtc <br>
	  			将service的处理分离到com.awt.dealComponentImpl包中的类处理，便于扩展 <br>
        			新增功能接口（在控制类中向程序窗口添加元素） <br>
        				add(String key, DComp comp, Object jLayer) <br>
        				add(String key, DComp comp) <br>
        				add(String key, DComp comp, int index) <br>

# 开发
`目的`
***
1、加快开发的速度。
2、界面参数集中管理。
3、界面与逻辑分开处理，降低依赖有效解耦。

`程序运行过程`
***
1、启动Core。
2、加载标注有@Control并且继承Control_Basi类的界面对象。
3、并按照优先级实例化界面对象。
4、实例化的界面对象会扫描对应的配置文件创建gui组件并添加相应的事件。
5、完成页面的初始化。
6、销毁

`架包扩展说明`
***
1. 标签扩展
	1).com.awt.enuma.TagType增加内部类enum类--实现对组件的创建
	2).com.awt.domain包中以BasiDoMain为父类增加标签对应的实体对象，承载标签属性
    	3).com.awt.dealComponentImpl分别以DealComponent、DealComponentCnt为父类增加处理对象
      	4).负责组件创建(调用 com.awt.enuma.TagType获取组件对象)和创建服务对象（组件事件对象）	
	5).在配置文件中增加配置（systemConf.systemConf.xml）
		增加<bean id="组件标签名称" class="com.awt.domain.组件DoMain类名"> </bean>
		增加<bean id="create_组件标签名称" 
		class="com.awt.dealComponentImpl.组件处理对象类名"></bean>
2. service扩展（负责组件事件的创建）
	1).com.awt.domain包中以Service为父类增加对应的服务类
	2).在配置文件中增加配置（systemConf.systemConf.xml）
		<bean id="service名称" class="com.awt.service.服务类名"></bean>
      	   
	七、已有标签说明：
		1. 属性名称定义与解释
			type		标签组件类型
			width		元素宽度
			height		元素高度
			size		组件大小符合对象 -- <width height>
			margin_left	左外边距
			margin_top	上外边距
			margin		外边距符合对象 -- <margin_left margin_top>
			padding_left	左内边距 -- 通常用于容器标签属性
			padding_top 	上内边距 -- 通常用于容器标签属性
			padding		内边距符合对象 -- <padding_left padding_top>
			name		context中的key值，不给则不添加进context
          		font_style 	字体样式
          			[bold|italic|plain]
          		font_name	字体名称
          		font_size	字体大小
          		font 		字体符合对象 -- <font_style font_name font_size>
          		title		程序窗口名称 -- 为program标签特有属性
          		src		背景
          		icon_src	图标
          		value		文本值
          		editable	是否可编辑 -- 用于textarea标签
       		
		2.事件的定义与解释
			1)点击事件
				click		点击
				dbclick		双击
				mousedown		释放
				mouseup		按下
				mousemove		鼠标在元素内滑过
				mouseout		鼠标滑出
			2)窗口事件
				close		关闭	
				focus		获取焦点
				blur			失去焦点
				hide			隐藏
				open			隐藏--》唤醒
			3)文本事件
				change		变化事件
		
		3.组件特定的属性与解释	
			program::[type=[normal|definedwin]] [title] [padding] [margin] [size] [layout]
			
			container::[type=[normal|progressbar|autocnt|textarea] [padding] [margin] [size]
			[layout]
			progressbar（未实现）
			autocnt(有滚动条容器，未实现)
			textarea(文本编辑，未实现)
			
			Button::[type=[normal|transparent]] [value] [padding] [margin] [size] [src]
			[icon_src]
			特殊：type=transparent时添加不了图片
			
			label::[type=[normal|transparent]] [value] [padding] [margin] [size]
			
			radio::[type=[normal]] [value] [margin] [size]
			
			textarea::[type=[normal]] [value] [editable] [margin] [size]
			
			progressbar::[type] [orig_width] [orig_height] [slide_to] [src] [margin] [size]
	
        
