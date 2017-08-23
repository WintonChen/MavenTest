package com.wd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wd.model.RequestModel;

@RestController
public class MinaController {

	@Autowired
	NioSocketAcceptor ioAcceptor;

	@RequestMapping(value = "rest/getSessions")
	public Map<Long, String> getSessions() {

		Map<Long, String> result = new HashMap<Long, String>();

		Map<Long, IoSession> map = ioAcceptor.getManagedSessions();

		for (Entry<Long, IoSession> entry : map.entrySet()) {

			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getRemoteAddress().toString());
			result.put(entry.getKey(), entry.getValue().getRemoteAddress().toString());
		}

		return result;
	}

	@RequestMapping(value = "rest/getSessionsList")
	public List<Jxc> getSessionsList() {

		List<Jxc> list = new ArrayList<Jxc>();

		Map<Long, IoSession> map = ioAcceptor.getManagedSessions();

		for (Entry<Long, IoSession> entry : map.entrySet()) {

			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getRemoteAddress().toString());
			Jxc jxc = new Jxc();
			jxc.setId(entry.getKey());
			jxc.setAddress(entry.getValue().getRemoteAddress().toString());
			list.add(jxc);
		}

		return list;
	}

	@RequestMapping(value = "rest/send",method = RequestMethod.POST)
	public String send(@RequestParam("id") Long id, @RequestParam("address") String address,
			@RequestParam("data") String data) {

		System.out.println("id:"+id+" address:"+address+" data:"+data);
		
		final String requestCode = UUID.randomUUID().toString();
		
		Map<Long, IoSession> map = ioAcceptor.getManagedSessions();

		IoSession session = map.get(id);

		RequestModel requestModel = new RequestModel();
		requestModel.setRequestCode(requestCode);
		requestModel.setData(data);
		
		ObjectMapper mapper = new ObjectMapper();  
		String json ="";
				
		try {
			json = mapper.writeValueAsString(requestModel);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("json:"+json);
		
		if (session != null) {
			System.out.println(session.getRemoteAddress());
			session.write(json);
		}
	
		
		  try {

              Thread.sleep(5000);
          } catch (InterruptedException e) { 
        	  e.printStackTrace();
          }

		return json;
	}

	@RequestMapping(value = "rest/send1",method = RequestMethod.GET)
	public String send1(@RequestParam("id") Long id, @RequestParam("address") String address,
			@RequestParam("data") String data) {

		System.out.println("id:"+id+" address:"+address+" data:"+data);
		
		final String requestCode = UUID.randomUUID().toString();
		
		Map<Long, IoSession> map = ioAcceptor.getManagedSessions();

		IoSession session = map.get(id);

		RequestModel requestModel = new RequestModel();
		requestModel.setRequestCode(requestCode);
		requestModel.setData(data);
		
		ObjectMapper mapper = new ObjectMapper();  
		String json ="";
				
		try {
			json = mapper.writeValueAsString(requestModel);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("json:"+json);
		
		if (session != null) {
			System.out.println(session.getRemoteAddress());
			session.write(json);
		}
	
		  try {

              Thread.sleep(5000);
          } catch (InterruptedException e) { 
        	  e.printStackTrace();
          }

		return json;
	}
	
	class Jxc {
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
