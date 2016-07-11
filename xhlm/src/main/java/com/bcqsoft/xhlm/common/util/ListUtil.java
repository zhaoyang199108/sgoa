package com.bcqsoft.xhlm.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 集合操作工具类
 */
public class ListUtil {

	public static final String SEPARATOR = ",";

	/**
	 * 字符串转换为集合(默认使用","分隔)
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
	public static List<String> toStringList(String str) {
		return toStringList(str, SEPARATOR);
	}

	/**
	 * 字符串转换为集合(默认使用","分隔)
	 * 
	 * <pre>
	 * "1,2,3" -> {1,2,3}
	 * "1-2-3" -> {1,2,3}
	 * </pre>
	 * 
	 * @param 转换的字符串
	 * @param 字符串中的分隔符
	 * @return 集合
	 * 
	 * @Author zbq
	 * @Date 2011-8-26
	 */
	public static List<String> toStringList(String str, String separator) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		String[] strArray = str.split(separator);
		List<String> list = new ArrayList<String>(strArray.length);
		for (String s : strArray) {
			list.add(s);
		}
		return list;
	}

	/**
	 * 是否是空的集合
	 * 
	 * @param list
	 * @return True:是, Flase:否
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-13
	 */
	public static boolean isEmpty(List<?> list) {
		return list == null || list.size() == 0;
	}
}
