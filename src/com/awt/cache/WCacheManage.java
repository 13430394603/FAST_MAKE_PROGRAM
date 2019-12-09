package com.awt.cache;

import com.cache.listener.CacheListener;
import com.cache.opcache.ICacheManager;
import com.cache.opcache.impl.CacheManagerImpl;

/**
 * <b>缓存插件</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年7月29日 下午2:52:03 
 * @see com.cache.opcache.ICacheManager
 * @see com.cache.listener.CacheListener
 * @since 1.0
 */
public class WCacheManage {
	private final static ICacheManager caches;
	/**
	 * 初始化缓存插件
	 */
	static {
		caches = new CacheManagerImpl();
		CacheListener l = new CacheListener(caches);
		l.startListen();
	}  
	/**
	 * 返回缓存插件管理对象
	 * <p>	 
	 * @return
	 * ICacheManager
	 * @since 1.0
	 */
	public static ICacheManager getCacheManage(){
		return caches;
	}
}
