package com.wd.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MinaController {
	
	@Autowired
	NioSocketAcceptor ioAcceptor;
	
	@RequestMapping(value = "rest/getSessions")
	public Map<Long, String> getSessions(){
		
		Map<Long,String> result = new HashMap<Long, String>();
		
		Map<Long, IoSession> map = ioAcceptor.getManagedSessions();
		
		for (Entry<Long, IoSession> entry : map.entrySet()) {  
			  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getRemoteAddress().toString());  
		    result.put(entry.getKey(), entry.getValue().getRemoteAddress().toString());
		}  
		
		return result;
	}
}
