package com.bcqsoft.sgoa.common.util;

import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.apache.commons.lang.StringUtils.isBlank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密算法
 */
public class MD5Util {

	/**
	 * MD5
	 */
	public static final String MD5 = "MD5";

	/**
	 * MD5加密
	 * 
	 * <pre>
	 * 先进行字符串转换后在进行MD5加密
	 * </pre>
	 */
	public static String toMd5(String src) {
		if (isBlank(src)) {
			return EMPTY;
		}
		// 先将字符串进行转换(防止部分MD5被识别)
		// 将转换后的字符串进行MD5加密
		return encode(cqEncode(src));

	}

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param src
	 * @return
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	public static String encode(String src) {
		String md5 = EMPTY;
		try {
			MessageDigest md = MessageDigest.getInstance(MD5);
			md.update(src.getBytes());
			md5 = toMd5String(md.digest());
		}
		catch (NoSuchAlgorithmException e) {
		}
		return md5;

	}

	/**
	 * byte数组转换为MD5字符串
	 * 
	 * <pre>
	 * 转换规则:1+末位字符+字符串+首字符
	 * 例:a123b => ba123ba
	 * </pre>
	 * 
	 * @param bytes
	 * @return 转换后的字符串
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	private static String cqEncode(String src) {
		StringBuffer buf = new StringBuffer();
		String first = src.substring(0, 1); // 首字符
		String last = src.substring(src.length() - 1); // 末位字符
		// 转换方式
		// 1+末位字符+字符串+首字符
		buf.append(1);
		buf.append(last);
		buf.append(src);
		buf.append(first);
		
		return buf.toString();
	}

	/**
	 * byte数组转换为MD5字符串
	 * 
	 * @param bytes
	 * @return
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	private static String toMd5String(byte[] bytes) {
		int i;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < bytes.length; offset++) {
			i = bytes[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		return buf.toString().toUpperCase();

	}

	public static void main(String[] args) {
		System.out.println(toMd5("123"));
	}
}
