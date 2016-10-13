package com.bcqsoft.sgoa.core.base;

import java.util.HashMap;
import java.util.Map;

public class BaseService {

	/**
	 * 判断插入是否成功<br>
	 * 数据库插入成功后会返回新增主键,判断主键是否大于0即可
	 * 
	 * @param pk
	 * @return
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	public boolean isInsertSucc(Long pk) {
		return pk != null && pk > 0;
	}

	/**
	 * 判断更新是否成功<br>
	 * 数据库更新成功后会返回更新记录条数,判断条数是否大于0即可
	 * 
	 * @param pk
	 * @return
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	public boolean isUpdateSucc(Integer count) {
		return count != null && count > 0;
	}

	/**
	 * 设置HashMap
	 * 
	 * @param key
	 * @param value
	 * @return HashMap
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Map<String, Object> toMap(String key, Object value) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put(key, value);
		return data;
	}

	/**
	 * 设置HashMap
	 * 
	 * @param key
	 * @param value
	 * @return HashMap
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Map<String, Object> toMap(String[] keys, Object[] values) {
		Map<String, Object> data = new HashMap<String, Object>();
		for (int i = 0; i < keys.length; i++) {
			data.put(keys[i], values[i]);
		}
		return data;
	}

}
