package com.wd.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wd.model.RequestModel;
import com.wd.model.ResponseModel;
import com.wd.service.CacheService;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;

@RestController
public class MinaController {

	@Autowired
	NioSocketAcceptor ioAcceptor;
	
	@Autowired 
	EhCacheCacheManager cacheManager;
	
	@Autowired
	CacheService cacheService;

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
	
	@RequestMapping(value = "rest/receive",method = RequestMethod.POST)
	public void receive(@RequestParam("responseCode") String responseCode,
			@RequestParam("result") String result){
		
		 System.out.println(responseCode);
         System.out.println(result);
		 Cache cache = cacheManager.getCache("userCache");
         cache.put(responseCode, result);
	}

	//异步方法
	@RequestMapping(value = "rest/send",method = RequestMethod.POST)
	public WebAsyncTask  send(@RequestParam("id") Long id, @RequestParam("address") String address,
			@RequestParam("data") String data) {

		System.out.println("id:"+id+" address:"+address+" data:"+data);
		
		final String requestCode = UUID.randomUUID().toString().replace("-", "");
		
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
	
		
		
		Callable<ResponseModel> callable = new Callable<ResponseModel>() {
			 
            @Override
            public ResponseModel call() throws Exception {
            	
            	ResponseModel responseModel = new ResponseModel();
            	responseModel.setResponseCode(requestCode);
            	responseModel.setResult(cacheService.getCache(requestCode));
                return responseModel;
            }

        };

        WebAsyncTask asyncTask = new WebAsyncTask(60000, callable);
        asyncTask.onTimeout(
        		
                new Callable<ResponseModel>() {
                	
                    public ResponseModel call() throws Exception {
                    	
                    	throw new ResourceNoContentException();
//                    	ResponseModel responseModel = new ResponseModel();
//                    	responseModel.setResponseCode(requestCode);
//                    	responseModel.setResult("Timeout");
//                        return responseModel;
                    }
                }
        );
        
       return asyncTask;
	}
	
	//定义一个自定义异常，抛出时返回状态码 204 No Content 
	//服务器成功处理了请求，没有返回任何内容
	 @ResponseStatus(value = HttpStatus.NO_CONTENT)
	 public class ResourceNoContentException extends RuntimeException {
	     
	 }
	
	//缺点，多个连接等待时会卡死
	@RequestMapping(value = "rest/send2",method = RequestMethod.POST)
	public ResponseModel send2(@RequestParam("id") Long id, @RequestParam("address") String address,
			@RequestParam("data") String data) throws UnsupportedEncodingException, InterruptedException {

		System.out.println("id:"+id+" address:"+address+" data:"+data);
		
		final String requestCode = UUID.randomUUID().toString().replace("-", "");
		
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
	
		
		Cache cache = cacheManager.getCache("userCache");
//		cache.put(requestCode, data);
		ValueWrapper wrapper = null;
		do{
			wrapper  = cache.get(requestCode);
			Thread.sleep(100);
		}while (wrapper==null);
		
		System.out.println("wrapper"+wrapper.get().toString());
		ResponseModel responseModel = new ResponseModel();
		responseModel.setResponseCode(requestCode);
		responseModel.setResult(wrapper.get().toString());
		return responseModel;
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
