package com.wd.service;

import org.springframework.stereotype.Service;

@Service
public interface CacheService {
	
	String getCache(String code);
}
