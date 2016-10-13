package com.bcqsoft.sgoa.dao.cyd.dataobject;

import java.util.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

public class CydPage extends BasePage{

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -8283983857955068668L;
	/**
	 * 通讯录集合
	 */
	List<Cyd> cydList;
	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 创建日期
	 */
	private Date createDate;

	/**
	 * 更新日期
	 */
	private Date updateDate;
	
	/**
	 * 文件编号 模糊查询
	 */
	private String num;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}


	/**
	 * 文件编号1
	 */
	private String numFirst;

	/**
	 * 文件编号2
	 */
	private String numSecond;
	
	/**
	 * 文件编号3
	 */
	private String numThird;
	
	/**
	 * 文件编号4
	 */
	private String numFourth;
	
	/**
	 * 份数
	 */
	private Integer count;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 用户ID
	 */
	private String createId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getNumFirst() {
		return numFirst;
	}

	public void setNumFirst(String numFirst) {
		this.numFirst = numFirst;
	}

	public String getNumSecond() {
		return numSecond;
	}

	public void setNumSecond(String numSecond) {
		this.numSecond = numSecond;
	}

	public String getNumThird() {
		return numThird;
	}

	public void setNumThird(String numThird) {
		this.numThird = numThird;
	}

	public String getNumFourth() {
		return numFourth;
	}

	public void setNumFourth(String numFourth) {
		this.numFourth = numFourth;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Cyd> getCydList() {
		return cydList;
	}

	public void setCydList(List<Cyd> cydList) {
		this.cydList = cydList;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}
}