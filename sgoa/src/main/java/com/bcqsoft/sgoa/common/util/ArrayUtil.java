package com.bcqsoft.sgoa.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 数组操作工具类
 */
public class ArrayUtil {

	public static final String SEPARATOR = ",";

	/**
	 * 字符串转换为long数组(默认使用","分隔)
	 * 
	 * <pre>
	 * "1,2,3" -> {1,2,3}
	 * </pre>
	 * 
	 * @param 转换的字符串
	 * @return long数组
	 * 
	 * @Author zbq
	 * @Date 2011-8-26
	 */
	public static long[] toLongArray(String str) {
		return toLongArray(str, SEPARATOR);
	}

	/**
	 * /** 字符串转换为long数组(默认使用","分隔)
	 * 
	 * <pre>
	 * "1,2,3" -> {1,2,3}
	 * "1-2-3" -> {1-2-3}
	 * </pre>
	 * 
	 * @param 转换的字符串
	 * @param 字符串中的分隔符
	 * @return long数组
	 * 
	 * @Author zbq
	 * @Date 2011-8-26
	 */
	public static long[] toLongArray(String str, String separator) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		String[] strArray = str.split(separator);
		long[] array = new long[strArray.length];

		for (int i = 0; i < strArray.length; i++) {
			array[i] = NumberUtils.toLong(strArray[i]);
		}
		return array;
	}

	/**
	 * 字符串转换为String数组(默认使用","分隔)
	 * 
	 * <pre>
	 * "1,2,3" -> {1,2,3}
	 * </pre>
	 * 
	 * @param 转换的字符串
	 * @return long数组
	 * 
	 * @Author zbq
	 * @Date 2011-8-26
	 */
	public static String[] toStringArray(String str) {
		return toStringArray(str, SEPARATOR);
	}

	/**
	 * /** 字符串转换为String数组(默认使用","分隔)
	 * 
	 * <pre>
	 * "1,2,3" -> {1,2,3}
	 * "1-2-3" -> {1-2-3}
	 * </pre>
	 * 
	 * @param 转换的字符串
	 * @param 字符串中的分隔符
	 * @return long数组
	 * 
	 * @Author zbq
	 * @Date 2011-8-26
	 */
	public static String[] toStringArray(String str, String separator) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		return str.split(separator);
	}

}
