package com.bcqsoft.sgoa.dao.unit.dataobject;

import java.util.Date;

/**
 * 单位总表(记录当前单位及下属单位)ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_UNIT
 * </pre>
 */
public class Unit {

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
	 * 单位名称
	 */
	private String unitName;

	/**
	 * 单位地址
	 */
	private String unit;

	/**
	 * 单位级别(0为当前系统中的一级单位,其余为下属单位,9为上级单位)
	 */
	private Integer rank;

	/**
	 * 上级单位ID(LEVEL字段为0时,该字段为0, 其余为上级单位的ID)
	 */
	private Long parentId;

	/**
	 * 是否是有效记录(Y:有效, N:无效)
	 */
	private String enabled;

	/**
	 * 取得自增型主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置自增型主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 取得创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 取得更新日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置更新日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 取得单位名称
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * 设置单位名称
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * 取得单位地址
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 设置单位地址
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 取得单位级别(0为当前系统中的一级单位,其余为下属单位,9为上级单位)
	 */
	public Integer getRank() {
		return rank;
	}

	/**
	 * 设置单位级别(0为当前系统中的一级单位,其余为下属单位,9为上级单位)
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/**
	 * 取得上级单位ID(LEVEL字段为0时,该字段为0, 其余为上级单位的ID)
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置上级单位ID(LEVEL字段为0时,该字段为0, 其余为上级单位的ID)
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 取得是否是有效记录(Y:有效, N:无效)
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * 设置是否是有效记录(Y:有效, N:无效)
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
