package com.wd.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

//MINA 时间服务器
public class MinaTimeServer {

	private static final int PORT = 9123;

	public static void main(String[] args) throws IOException {

		System.out.println("main");

		// TODO Auto-generated method stub
		IoAcceptor acceptor = new NioSocketAcceptor();

		LoggingFilter loggingFilter = new LoggingFilter();
		acceptor.getFilterChain().addLast("logger", loggingFilter);
		//现有的 TextLine 工厂因为它将为你处理基于文本的消息 (你无须去编写 codec 部分)。
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("GBK"))));
		
		acceptor.setHandler(new TimeServerHandler());
		
		acceptor.getSessionConfig().setReadBufferSize( 2048 );
		//什么时候检查空闲 session
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );
        
		acceptor.bind(new InetSocketAddress(PORT));
		
		
		
		
//		acceptor.getManagedSessions();
		
		
	}

}
