package com.bcqsoft.sgoa.common.util;

import java.util.ResourceBundle;

/**
 * FTP配置工具类
 */
public class PropertiesUtil {
	
	public static final ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

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
	 * FTP服务器编码
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getFileUploadDir() {
		return bundle.getString("file.upload.dir");
	}
	
	/**
	 * FTP服务器编码
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public static final String getFileUploadDomain() {
		return bundle.getString("file.upload.domain");
	}
}
