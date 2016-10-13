package com.bcqsoft.sgoa.core.base;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * 数据查询分页算法.<br>
 * 根据总条数可自动计算出页面数<br>
 * 根据当前页数可自动计算出行数<br>
 * <li>totalRow(总条数, 缺省为0条)</li><br>
 * <li>pageSize(每页显示条数, 缺省为5条)</li><br>
 * <li>currentPage(当前页, 缺省为1(首页))</li><br>
 * <li>totalPage(总页数)</li><br>
 * <li>StartRow(当前页开始记录位置, 从1开始记数)</li><br>
 * <li>EndRow(当前页最后记录位置)</li><br>
 */
public class BasePage implements Serializable {

	private static final long serialVersionUID = 7603300820027561064L;

	/** 每次显示条数, 默认 */
	private static final Integer DEFAULT_PAGE_SIZE = new Integer(12);

	/** 默认页数(第一页) */
	private static final Integer DEFALUT_PAGE = new Integer(1);

	/** 默认总数量(0条) */
	private static final Integer DEFAULT_TOTAL_ROW = new Integer(0);

	/** 查询结果总条数 */
	private Integer totalRow;

	/** 每页显示条数 */
	private Integer pageSize;

	/** 当前页码 */
	private Integer currentPage;
	
	/** 当前页码 */
	private Integer sqlServerSize;

	/**
	 * 取得默认页面显示条数(5条)
	 */
	protected final Integer getDefaultPageSize() {
		return DEFAULT_PAGE_SIZE;
	}

	/**
	 * 判断当前页是否为首页
	 */
	public boolean isFirstPage() {
		return this.getCurrentPage().intValue() == 1;
	}

	public Integer getSqlServerSize() {
		return sqlServerSize;
	}

	public void setSqlServerSize(Integer sqlServerSize) {
		this.sqlServerSize = sqlServerSize;
	}

	/**
	 * 取得上一页
	 */
	public int getPreviousPage() {
		int back = this.getCurrentPage().intValue() - 1;

		if (back <= 0) {
			back = 1;
		}

		return back;
	}

	/**
	 * 判断当前页是否为末页
	 */
	public boolean isLastPage() {
		return this.getTotalPage() == 0 || this.getTotalPage() == this.getCurrentPage().intValue();
	}

	/**
	 * 取得下一页
	 */
	public int getNextPage() {
		int back = this.getCurrentPage().intValue() + 1;

		if (back > this.getTotalPage()) {
			back = this.getTotalPage();
		}

		return back;
	}

	/**
	 * 取得当前页
	 */
	public Integer getCurrentPage() {
		if (currentPage == null) {
			return DEFALUT_PAGE;
		}

		return currentPage;
	}

	/**
	 * 设置当前页
	 */
	public void setCurrentPage(Integer cPage) {
		if ((cPage == null) || (cPage.intValue() <= 0)) {
			this.currentPage = DEFALUT_PAGE;
		}
		else {
			this.currentPage = cPage;
		}
	}

	/**
	 * 设置当前页(如果页面不是数字, 默认为首页)
	 */
	public void setCurrentPageString(String s) {
		if (StringUtils.isBlank(s)) {
			return;
		}

		try {
			setCurrentPage(Integer.parseInt(s));
		}
		catch (NumberFormatException ignore) {
			this.setCurrentPage(DEFALUT_PAGE);
		}
	}

	/**
	 * 取得页面显示条数
	 */
	public Integer getPageSize() {
		if (pageSize == null) {
			return getDefaultPageSize();
		}

		return pageSize;
	}

	/**
	 * 是否设置了页面条数
	 */
	public boolean hasSetPageSize() {
		return pageSize != null;
	}

	/**
	 * 设置页面显示条数
	 */
	public void setPageSize(Integer pSize) {
		if (pSize == null || pSize.intValue() <= 0) {
			return;
		}

		this.pageSize = pSize;
	}

	/**
	 * 设置页面显示条数
	 */
	public void setPageSizeString(String pageSize) {
		if (StringUtils.isBlank(pageSize)) {
			return;
		}

		try {
			Integer integer = new Integer(pageSize);
			this.setPageSize(integer);
		}
		catch (NumberFormatException ignore) {
		}
	}

	/**
	 * 取得总记录数(默认为0条).
	 */
	public Integer getTotalRow() {
		if (totalRow == null) {
			return DEFAULT_TOTAL_ROW;
		}

		return totalRow;
	}

	/**
	 * 设置总记录条数, 设置后可自动算出当前页数
	 */
	public void setTotalRow(Integer count) {
		if (count == null) {
			count = new Integer(0);
		}

		this.totalRow = count;
		int current = this.getCurrentPage().intValue();
		int lastPage = this.getTotalPage();

		if (current > lastPage) {
			this.setCurrentPage(new Integer(lastPage));
		}
	}

	/**
	 * 取得总页数
	 */
	public int getTotalPage() {
		int pgSize = this.getPageSize().intValue();
		int total = this.getTotalRow().intValue();
		int result = total / pgSize;

		if ((total % pgSize) != 0) {
			result++;
		}

		return result;
	}

	/**
	 * 取得当前页开始记录位置 MySQL分页从0条开始
	 */
	public int getStartRow() {
		int cPage = this.getCurrentPage().intValue();

		if (cPage == 1) {
			return 0;
		}
		cPage--;
		int pgSize = this.getPageSize().intValue();

		return (pgSize * cPage);
	}

	/**
	 * Oracle分页, MySQL分页从第0条开始
	 * 
	 * public int getStartRow() { int cPage = this.getCurrentPage().intValue();
	 * 
	 * if (cPage == 1) { return 1; } cPage--; int pgSize =
	 * this.getPageSize().intValue();
	 * 
	 * return (pgSize * cPage) + 1; }
	 */

	/**
	 * 取得当前页结束记录位置
	 */
	public int getEndRow() {
		int cPage = this.getCurrentPage().intValue();

		int pgSize = this.getPageSize().intValue();

		int result = pgSize * cPage;

		return result;

	}

}
