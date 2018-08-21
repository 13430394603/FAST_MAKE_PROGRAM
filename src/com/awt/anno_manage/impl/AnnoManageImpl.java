package com.awt.anno_manage.impl;

import java.util.HashSet;
import java.util.Set;

import com.awt.anno_manage.IAnnoManage;
import com.awt.cache.WCacheManage;
import com.cache.opcache.ICacheManager;

/**
 * <b>注解管理实现类</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年7月29日 下午2:47:14 
 * @see
 * @since 1.0
 */
public class AnnoManageImpl implements IAnnoManage {
	private Set<String> keys = new HashSet<>();
	@Override
	public void init(Set<String> keys) {
		this.keys.addAll(keys);
	}
	@Override
	public void destroy() {
		ICacheManager caches = WCacheManage.getCacheManage();
		for(String key : keys)
			caches.clearByKey(key);
	}
}
