package com.wd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	@RequestMapping(value = "rest/getSessionsList")
	public List<Jxc> getSessionsList(){
		
		List<Jxc> list = new ArrayList<Jxc>();
		
		Map<Long, IoSession> map = ioAcceptor.getManagedSessions();
		
		for (Entry<Long, IoSession> entry : map.entrySet()) {  
			  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getRemoteAddress().toString()); 
		    Jxc jxc = new Jxc();
		    jxc.setId(entry.getKey());
		    jxc.setAddress(entry.getValue().getRemoteAddress().toString());
		    list.add(jxc);
		}  
		
//		 try {
////			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return list;
	}
	
	class Jxc{
		Long id;
		String address;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		
	}
}
