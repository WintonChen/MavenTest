package com.wd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import com.wd.service.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

	@Autowired 
	EhCacheCacheManager cacheManager;
	
	@Override
	public String getCache(String code) {
		Cache cache = cacheManager.getCache("userCache");
//		cache.put(requestCode, data);
		ValueWrapper wrapper = null;
		do{
			wrapper  = cache.get(code);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while (wrapper==null);
		return wrapper.get().toString();
	}

}
