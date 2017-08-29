package com.wd.mina;


import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wd.model.ResponseModel;


public class MyHandler extends IoHandlerAdapter {

	@Autowired 
	EhCacheCacheManager cacheManager;
	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
		super.exceptionCaught(session, cause);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
	    String str = message.toString();
        System.out.println("message:"+str);
    
        ObjectMapper mapper = new ObjectMapper(); //转换器  
        
        try {
        	 ResponseModel rm;
             rm = mapper.readValue(str, ResponseModel.class);      //json转java对象 
             Cache cache = cacheManager.getCache("userCache");
             cache.put(rm.getResponseCode(), rm.getResult().toString());
             
             System.out.println(rm.getResponseCode());
             System.out.println(rm.getResult().toString());
		} catch (Exception e) {
			System.out.println("bad format");
			e.printStackTrace();
		}
        
	}

	 @Override
    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception
    {
        System.out.println( "IDLE " + session.getIdleCount( status ));
    }
}
