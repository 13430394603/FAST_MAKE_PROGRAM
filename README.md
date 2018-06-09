# FAST_MAKE_PROGRAM
该文件用于记录FAST_MAKE_PROGRAM桌面程序开发架包，通过配置文件配置一个界面，并通过继承一个Control类来生成对应配置文件的界面。
****

|Author|威|
|:---:|:---
|E-mail|chenJiWey@163.com

[![Author](https://travis-ci.org/iluwatar/java-design-patterns.svg?branch=master)]()

****

# 目录
* [引言](#引言) <br>
* [使用说明](#使用说明) <br>
	* 控制类的创建示例 <br>
	* xml文件的配置 <br>
	* img（根目录img文件） <br>
	* 界面类注解@Control <br>
	* 启动类 <br>
	* 核心控制类 <br>
	* 上下文对象 <br>
* [配置文件标签](#配置文件标签) <br>
	* 标签语法树 <br>
	* 标签属性说明 <br>
		* 所有标签 <br>
		* program <br>
		* container <br>
		* Button <br>
		* label <br>
		* radio <br>
		* textarea <br>
		* progressbar <br>
	* 事件 <br>
		* 点击事件 <br>
		* 窗口事件 <br>
		* 文本事件 <br>
* [更新](#更新) <br>
* [开发](#开发) <br>
	* 目的 <br>
	* 程序运行过程 <br>
	* 架包扩展说明 <br>
		* 标签扩展 <br>
		* service扩展 <br>

# 引言
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
2).xml文件的配置
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
3).img（根目录img文件） <br>

> ProgramBack.png	程序背景 <br>
> ProgramIcon.png	菜单栏图标 <br>
> ProgramIconMin.png	界面小图标 <br>

4).界面类注解@Control <br>

> com.awt.annotation.@Control(priority<默认为5,区间0-10>) 	界面控制类注解  <br>

5).启动类 <br>

> com.awt.core.Core  				启动类--加载注解为@Control的控制类 <br>

6).核心控制类 <br>

> 生成界面，所有界面都需继承控制类 <br>
> com.awt.control.AbstractControlEtc 		扩展控制类 <br>

7).上下文对象 <br>

> 获取com.awt.context.ProgramContext.ContextMap对象，通过这个Map可获取xml文件中有属性name的组件<br>

# 配置文件标签
`标签语法树`
***
>program
>>container
>>>container <br>
>>>button <br>
>>>text <br>
>>>label <br>
>>>radio <br>
>>>textarea <br>

`标签属性说明`
***
`所有标签`

|attr_name|desc|values
|:---:|------|------
|type|标签组件类型|默认nomal
|size|组件大小复合对象|`<width height>`数字/数学表达式
|margin|外边距复合对象|`<margin_left margin_top>`数字/数学表达式
|padding|内边距复合对象|`<padding_left padding_top>`数字/数学表达式
|name|context中的key值，不给则不添加进context|字符串
|font_style|字体样式|`<bold/italic/plain>`
|font_name|字体名称|字体名称
|font_size|字体大小|整数
|font|字体复合对象|`<font_style font_name font_size>`
|title|程序窗口名称 -- program标签特有属性|字符串
|src|背景|相对根目录的路径
|icon_src|图标|相对根目录的路径
|value|文本值|字符串
|editable|是否可编辑 -- 用于textarea标签|true/false

`program`

|attr_name|desc
|:---:|------
|type|normal/definedwin
|title|程序名称
|layout|

`container`

|attr_name|desc
|:---:|------
|type|normal/progressbar（未实现）/autocnt(有滚动条容器，未实现)/textarea(文本编辑，未实现)
|layout|

`Button`

|attr_name|desc
|:---:|------
|type|normal/transparent（此属性添加不了背景图片）
|value|文本值
|src|背景
|icon_src|图标

`label`

|attr_name|desc
|:---:|------
|type|normal/transparent
|value|文本值

`radio`

|attr_name|desc
|:---:|------
|type|normal
|value|文本值
		
`textarea`

|attr_name|desc
|:---:|------
|type|normal
|value|文本值
|editable|是否可编辑，值为true/false

`progressbar`

|attr_name|desc
|:---:|------
|type|
|orig_width|原始
|orig_height|原始 
|slide_to|滑动到

`事件`
***
`点击事件`

|事件名称|描述
|:---|:---
|click|点击
|dbclick|双击
|mousedown|释放
|mouseup|按下
|mousemove|鼠标在元素内滑过
|mouseout|鼠标滑出
			
`窗口事件`

|事件名称|描述
|:---|:---
|close|关闭
|focus|获取焦点
|blur|失去焦点
|hide|隐藏
|open|隐藏--》唤醒

`文本事件`

|事件名称|描述
|:---|:---
|change|变化事件
						
				
# 更新
-----------------------------------------
### 18/5/24 
|描述|详细
|:----|:------|
|添加了复合属性|`[size="width height"]` <br>`[border="borderColor lineSize"]` <br>`[borderColor:gray/green/black/blue/cyan/pink/red/orange/yellow/lightGray]` <br>`[font="fontName fontStyle fontSize"]` <br>`[padding="left top"]` <br>`[margin="left top"]`
|可以使用表达式|size padding margin 中的数字可以使用数学表达式--例如：120*2 <br>com.awt.util.Arithmetic转换数学表达式		
|相对父元素字段或值|size 属性值可以使用特殊字段parent<适应父容器> /half_parent<相对于父容器的一半>
|容器增加布局属性`[layout]`|default_layout无布局 <br>vertline_layout垂直流线布局 <br>horiline_layout水平流线布局 <br>新增包结构： <br>com.gui.layout <br>-Layout.java <br>--AbstractLayout.java <br>---DefaultLayout.java <br>---VertLineLayout.java <br>---HoriLineLayout.java
|将此类com.awt.context.ProgramContext所存的组件值从Component换成了DComp对象|意味着界面控制类所操作的组件为DComp对象--有利于组建的定位处理
|核心类的优化，便于扩展|优化AbstractControl_Basi、AbstractControlEtc <br>将service的处理分离到com.awt.dealComponentImpl包中的类处理，便于扩展 <br>新增功能接口（在控制类中向程序窗口添加元素） <br>	add(String key, DComp comp, Object jLayer) <br>	add(String key, DComp comp) <br>	add(String key, DComp comp, int index) <br>
-----------------------------------------

# 开发
`目的`
***
1、加快开发的速度。
2、界面参数集中管理。
3、界面与逻辑分开处理，降低依赖有效解耦。

`程序运行过程`
***
1、启动Core。<br>
2、加载标注有@Control并且继承Control_Basi类的界面对象。<br>
3、并按照优先级实例化界面对象。<br>
4、实例化的界面对象会扫描对应的配置文件创建gui组件并添加相应的事件。<br>
5、完成页面的初始化。<br>
6、销毁。<br>

`架包扩展说明`
***
1. 标签扩展 <br>
	1).com.awt.enuma.TagType增加内部类enum类--实现对组件的创建 <br> 
	2).com.awt.domain包中以BasiDoMain为父类增加标签对应的实体对象，承载标签属性 <br>
    	3).com.awt.dealComponentImpl分别以DealComponent、DealComponentCnt为父类增加处理对象 <br>
      	4).负责组件创建(调用 com.awt.enuma.TagType获取组件对象)和创建服务对象（组件事件对象） <br>	
	5).在配置文件中增加配置（systemConf.systemConf.xml） <br>
		增加<bean id="组件标签名称" class="com.awt.domain.组件DoMain类名"> </bean> <br>
		增加<bean id="create_组件标签名称"  <br>
		class="com.awt.dealComponentImpl.组件处理对象类名"></bean> <br>
2. service扩展（负责组件事件的创建） <br>
	1).com.awt.domain包中以Service为父类增加对应的服务类 <br>
	2).在配置文件中增加配置（systemConf.systemConf.xml） <br> 
		<bean id="service名称" class="com.awt.service.服务类名"></bean> <br>
