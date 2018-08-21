package com.awt.anno_manage;

import java.util.Set;

/**
 * <b>注解管理接口</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年7月29日 下午2:47:35 
 * @see
 * @since 1.0
 */
public interface IAnnoManage {
	/**
	 * 初始化
	 * <p>	 
	 * @param keys
	 * void
	 * @see
	 * @since 1.0
	 */
	void init(Set<String> keys);
	/**
	 * 销毁
	 * <p>
	 * 将在界面创建完之后销毁缓存数据 
	 * void
	 * @see
	 * @since 1.0
	 */
	void destroy();
}
