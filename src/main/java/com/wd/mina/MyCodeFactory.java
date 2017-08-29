package com.wd.mina;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineDecoder;
import org.apache.mina.filter.codec.textline.TextLineEncoder;

/**
 * 过滤器 
 *
 */
public class MyCodeFactory implements ProtocolCodecFactory {
	private final TextLineEncoder encoder;
	private final TextLineDecoder decoder;

	public MyCodeFactory() {
		this(Charset.forName("GBK"));
		setEncoderMaxLineLength(100*1024*1024);  //自定义最大长度
		setDecoderMaxLineLength(100*1024*1024);
	}

	public MyCodeFactory(Charset charset) {
//		encoder = new TextLineEncoder(charset, LineDelimiter.UNIX);
//		decoder = new TextLineDecoder(charset, LineDelimiter.AUTO);
		//自定义截取尾部
		encoder = new TextLineEncoder(charset, LineDelimiter.UNIX);
		decoder = new TextLineDecoder(charset, new LineDelimiter("!@#"));
	}

	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		return decoder;
	}

	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		return encoder;
	}

	public int getEncoderMaxLineLength() {
		return encoder.getMaxLineLength();
	}

	public void setEncoderMaxLineLength(int maxLineLength) {
		encoder.setMaxLineLength(maxLineLength);
	}

	public int getDecoderMaxLineLength() {
		return decoder.getMaxLineLength();
	}

	public void setDecoderMaxLineLength(int maxLineLength) {
		decoder.setMaxLineLength(maxLineLength);
	}
}
