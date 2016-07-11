package com.bcqsoft.xhlm.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SendMessageUtil {
	public static final String URL = "smtp.163.com";

	public static String sendCode(String mobile) {
		// 发送内容
		String codeString = SendMessageUtil.randomString(9);
		String content = "尊敬的用户:您正在办理业务的动态验证码为"+codeString;
		content += "。请确保是您本人办理，勿将验证码告诉任何人，慎防诈骗。";
		String sign = "协会联盟";
		try {
			content = URLEncoder.encode(content, "UTF-8");
			sign = URLEncoder.encode(sign, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// 
		}
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://web.duanxinwang.cc/asmx/smsservice.aspx?");

		// 向StringBuffer追加用户名
		sb.append("name=gdtone");

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=F5D0F3CC78FF5B571DABD1D0B809");

		// 向StringBuffer追加手机号码
		sb.append("&mobile="+mobile);

		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content=" + content);

		// 追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");

		// 加签名
		sb.append("&sign=" + sign);

		// type为固定值pt extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");
		// 创建url对象
		// String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
		System.out.println("sb:" + sb.toString());
		URL url = null;
		InputStream is = null;
		try {
			url = new URL(sb.toString());
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");
			// 发送
			is = url.openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO: handle exception
		}

		// 转换返回值
		String returnStr = SendMessageUtil.convertStreamToString(is);
		// 查看返回值是否为成功
		String[] codeSplit = returnStr.split(",");
		if (!"0".equals(codeSplit[0])) {
			codeString = "";
		} 
		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
		System.out.println(returnStr);
		// 返回发送结果
		return codeString;
	}
	
	public static boolean sendMsg(String mobile,String content) {
		// 发送内容
		boolean result = false;
		String sign = "协会联盟";
		try {
			content = URLEncoder.encode(content, "UTF-8");
			sign = URLEncoder.encode(sign, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// 
		}
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://web.duanxinwang.cc/asmx/smsservice.aspx?");

		// 向StringBuffer追加用户名
		sb.append("name=gdtone");

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=9C66E781AA134249DFCCBA71EEF2");

		// 向StringBuffer追加手机号码
		sb.append("&mobile="+mobile);

		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content=" + content);

		// 追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");

		// 加签名
		sb.append("&sign=" + sign);

		// type为固定值pt extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");
		// 创建url对象
		// String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
		System.out.println("sb:" + sb.toString());
		URL url = null;
		InputStream is = null;
		try {
			url = new URL(sb.toString());
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");
			// 发送
			is = url.openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO: handle exception
		}

		// 转换返回值
		String returnStr = SendMessageUtil.convertStreamToString(is);
		// 查看返回值是否为成功
		String[] codeSplit = returnStr.split(",");
		if (!"0".equals(codeSplit[0])) {
			result = true;
		}
		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
		System.out.println(returnStr);
		// 返回发送结果
		return result;
	}
	
	/**
	 * 转换返回值类型为UTF-8格式.
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;  
        
        try {    
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
	
	/**
	 * 返回4位的随机数.
	 * @param count
	 * @return
	 */
	public static String randomString(Integer count) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 4; i++) {
        	int a = (int)(Math.random()*count);
        	sb1.append(a);
		}
        return sb1.toString();
    }

	public static void main(String[] args) {
		// 发送邮件
		SendMessageUtil.sendCode("18043130999");

	}
}
