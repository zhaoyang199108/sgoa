package com.bcqsoft.xhlm.common.util;

import java.util.ResourceBundle;

/**
 * FTP配置工具类
 */
public class PropertiesUtil {
	
	public static final ResourceBundle bundle = ResourceBundle.getBundle("xhlm");

	/**
	 * FTP服务器IP地址
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getFtpSeverIp() {
		return bundle.getString("ftp.serverip");
	}

	/**
	 * FTP服务器用户名
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getFtpUserName() {
		return bundle.getString("ftp.username");
	}
	
	/**
	 * FTP服务器密码
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getFtpPassWord() {
		return bundle.getString("ftp.password");
	}
	
	/**
	 * FTP服务器编码
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getFtpEncoding() {
		return bundle.getString("ftp.encoding");
	}
	
	/**
	 * 取得上传视频文件路径
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getVideoDir() {
		
		// 取得title名
		return bundle.getString("file.video.dir");
	}
	
	/**
	 * 取得上传视频文件路径
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getUploadDomain() {
		
		// 取得title名
		return bundle.getString("file.upload.domain");
	}
	
	/**
	 * 取得上传视频文件路径
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getWebappServerHost() {
		
		// 取得title名
		return bundle.getString("webapp.server.host")+":"+bundle.getString("webapp.server.port");
	}
	
	/**
	 * 取得上传视频文件路径
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getBgcxDir() {
		
		// 取得title名
		return bundle.getString("file.bgcx.dir");
	}
}
