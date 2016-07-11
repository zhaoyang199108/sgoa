package com.bcqsoft.xhlm.core.base;

/**
 * Form基类
 */
public class BaseForm {

	/**
	 * 当前页数
	 * 
	 * <pre>
	 * 页面分页时需继承此Form
	 * </pre>
	 */
	private int cp;

	/**
	 * 取得当前页数
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * 设置当前页数
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

}
