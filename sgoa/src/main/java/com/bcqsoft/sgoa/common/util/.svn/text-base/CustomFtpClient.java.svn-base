package com.bcqsoft.sgoa.common.util;

import sun.net.ftp.FtpClient;

public class CustomFtpClient extends FtpClient {

	private CustomFtpClient() {
		super();
	}
	/**
	  * 初始化时必须指定服务器的编码格式
	  * @param encodingStr
	  */
	protected CustomFtpClient(String encodingStr) {
		super();
		sun.net.NetworkClient.encoding = encodingStr;
	}

	/**
	  * 设置连接编码 
	  * @param encodingStr
	  * void
	  *
	  */
	protected void setEncoding(String encodingStr) {
		sun.net.NetworkClient.encoding = encodingStr;
	}
	
	/**
	  * 取得编码格式
	  * @return
	  * String
	  *
	  */
	protected String getEncoding() {
		return sun.net.NetworkClient.encoding ;
	}

}
