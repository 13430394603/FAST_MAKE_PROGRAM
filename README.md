# FAST_MAKE_PROGRAM
桌面程序模拟安卓配置文件快速开发架包

    目的：加快桌面程序的开发的速度、界面参数集中管理、界面与逻辑分开处理，降低依赖有效解耦。
    
    过程：
        1、启动Core。
        2、加载标注有@Control并且继承Control_Basi类的界面对象。
        3、并按照优先级实例化界面对象。
        4、实例化的界面对象会扫描对应的配置文件创建gui组件并添加相应的事件。
        5、完成页面的加载。
    优点：
        1、加快开发的速度。
        2、界面参数集中管理。
        3、界面与逻辑分开处理，降低依赖有效解耦。
  
    使用说明：
        API说明：
            com.awt.core.Core  启动类
             
        标签语法：
            program::container | button | text | label | radio | textarea | service（事件服务）
            container::button | text | label | radio | textarea | service（事件服务）
            button::service
            text::service
            label::service
            radio::service
            textarea::service
        
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
        
