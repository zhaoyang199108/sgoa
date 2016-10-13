package com.bcqsoft.sgoa.dao.grpo.dataobject;

import java.util.Date;

/**
 * 分组权限表
 * 
 * <pre>
 * 表: SCOA_TB_GRPO
 * </pre>
 */
public class Grpo {

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
	 * 分组名称
	 */
	private String grpoName;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 分类(1:分组, 2:职务)
	 */
	private Integer category;

	/**
	 * get&&set 方法
	 * 
	 * @return
	 */

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

	public String getGrpoName() {
		return grpoName;
	}

	public void setGrpoName(String grpoName) {
		this.grpoName = grpoName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

}
