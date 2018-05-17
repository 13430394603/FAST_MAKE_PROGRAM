package com.awt.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <b>控制类标注</b>
 * @author 威 
 * <br>2018年4月20日 下午1:28:43 
 * @since 1.0
 */
//可添加元注解 这里使用RumTime
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
//可添加注解标记的地方 这里使用Type
@Target(java.lang.annotation.ElementType.TYPE)
public @interface Control {
	/**
	 * 执行创建的优先级
	 * <p>
	 * 默认为1<br>
	 * 最高为9<br>
	 * 最低为0
	 * @return
	 * int
	 * @since 1.0
	 */
	int priority() default 1;
}
