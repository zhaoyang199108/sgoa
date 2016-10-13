package com.bcqsoft.sgoa.common.util;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.bcqsoft.sgoa.dao.user.dataobject.User;

/**
 * 短信发送工具类
 */
public class SendMsgUtil {

	/**
	 * 短信发送接口
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public Integer initLogin(String id, String pwd, String phoneStr, String memo) {
		// 定已返回值
		String result = "";
		// 定义一个http协议
		HttpClient client = new HttpClient();
		// 定义发送服务器地址
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
		// 设置头文件编码
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
		// 设置发送短信内容及电话号码
		NameValuePair[] data = { new NameValuePair("Uid", "bcqsoft"), new NameValuePair("Key", "8e4d9aeb58383d5c0a5f"),
				new NameValuePair("smsMob", phoneStr), new NameValuePair("smsText", memo) };
		// 将要发送的信息存到协议里
		post.setRequestBody(data);

		try {
			// 执行发送
			client.executeMethod(post);
			// Header[] headers = post.getResponseHeaders();
			// int statusCode = post.getStatusCode();
			// 取得发送结果 -1 没有该用户账户 ,-2 密钥不正确（不是用户密码）,-3 短信数量不足 ,-11 该用户被禁用
			// -14 短信内容出现非法字符 ,-4 手机号格式不正确 ,-41 手机号码为空 ,-42 短信内容为空 ,大于0 短信发送数量
			result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
			post.releaseConnection();
		} catch (HttpException e) {
			// 抛出异常
			e.printStackTrace();
		} catch (IOException e) {
			// 抛出异常
			e.printStackTrace();
		}
		return Integer.parseInt(result);
	}

	/**
	 * 短信发送接口字符转换
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public String[] stringArgToString(List<User> phoneArray) {

		int phoneLength = phoneArray.size();
		// 判断需要几个string数组存电话号码薄
		double iDouble = Double.parseDouble(String.valueOf(phoneLength)) / 100;
		int bInt = (int) Math.ceil(iDouble);
		// 定已返回值
		String[] result = new String[bInt];
		// 设置初始值
		int index = 100;
		// 设置基数
		int j = 1;
		StringBuffer sBuffer = new StringBuffer();
		// 循环取得电话号码列表
		for (int i = 0; i < phoneLength; i++) {
			sBuffer.append(phoneArray.get(i).getPhoneNo());
			// 如果到100个倍数电话号码的时候自动在存在下一个string字符串中
			if (phoneLength >= index * j) {
				j++;
			} else {
				sBuffer.append(",");
			}
			result[j - 1] = sBuffer.toString();
		}
		return result;
	}

	/**
	 * 短信发送接口字符转换
	 * 
	 * @author ly
	 * @date 2012-8-22
	 * @return String
	 */
	public Integer sendMsg(List<User> phoneArray, String memo) {

		Integer result = 0;
		String[] strArg = stringArgToString(phoneArray);
		for (String str : strArg) {
			result += initLogin("", "", str, memo);
		}
		return result;
	}
}
