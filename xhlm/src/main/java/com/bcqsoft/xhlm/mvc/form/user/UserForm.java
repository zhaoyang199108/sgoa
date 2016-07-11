package com.bcqsoft.xhlm.mvc.form.user;

import java.util.Date;

import com.bcqsoft.xhlm.core.base.BaseForm;

/**
 * 人员表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_USER
 * </pre>
 */
public class UserForm extends BaseForm {

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
	 * 登录ID
	 */
	private String loginId;

	/**
	 * 登录密码(MD5加密)
	 */
	private String password;
	
	/**
	 * 登录旧密码(MD5加密)
	 */
	private String oldPassword;

	/**
	 * 名称
	 */
	private String userName;

	/**
	 * 名称简拼
	 */
	private String userNamePy;

	/**
	 * 行业ID
	 */
	private String sortId;
	
	/**
	 * 产品ID
	 */
	private String productId;
	
	/**
	 * 行业
	 */
	private String name;
	
	/**
	 * 产品
	 */
	private String pname;

	/**
	 * 省份
	 */
	private String s_province;
	
	/**
	 * 地级市
	 */
	private String s_city;
	
	/**
	 * 市、县级市
	 */
	private String s_county;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 介绍
	 */
	private String introduce;

	/**
	 * LOGO图
	 */
	private String logo;
	
	/**
	 * bannner图
	 */
	private String banner;
	
	/**
	 * 资质ID
	 */
	private String zztId;
	
	/**
	 * 资质图
	 */
	private String aptitude;
	
	/**
	 * 产品
	 */
	private String product;
	
	/**
	 * 类别（1、协会，2、企业）
	 */
	private Integer type;
	
	/**
	 * 状态(1:正常, 2:待审,3:禁用)
	 */
	private Integer status;
	
	/**
	 * 父ID
	 */
	private String deptId;
	
	/**
	 * 名称
	 */
	private String userNamep;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色ID数组
	 */
	private String[] roleIdArray;

	/**
	 * 模块ID数组
	 */
	private String[] modelsIdArray;
	
	/**
	 * 开始时间
	 */
	private String startTime;

	/**
	 * 结束时间
	 */
	private String endTime;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 条目ID
	 */
	private String tmId;
	
	/**
	 * 条目
	 */
	private String tmname;
	
	/**
	 * 条目企业
	 */
	private String tmnameq;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 推荐（1、是，2、否）
	 */
	private Integer tj;
	
	/**
	 * 经度
	 */
	private String jd;
	
	/**
	 * 纬度
	 */
	private String wd;
	
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
	 * 取得登录ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * 设置登录ID
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * 取得登录密码(MD5加密)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置登录密码(MD5加密)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * 取得姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 取得姓名简拼
	 */
	public String getUserNamePy() {
		return userNamePy;
	}

	/**
	 * 设置姓名简拼
	 */
	public void setUserNamePy(String userNamePy) {
		this.userNamePy = userNamePy;
	}

	/**
	 * 取得角色名称
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 取得角色ID列表
	 */
	public String[] getRoleIdArray() {
		return roleIdArray;
	}

	/**
	 * 设置角色ID列表
	 */
	public void setRoleIdArray(String[] roleIdArray) {
		this.roleIdArray = roleIdArray;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String[] getModelsIdArray() {
		return modelsIdArray;
	}

	public void setModelsIdArray(String[] modelsIdArray) {
		this.modelsIdArray = modelsIdArray;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getS_province() {
		return s_province;
	}

	public void setS_province(String s_province) {
		this.s_province = s_province;
	}

	public String getS_city() {
		return s_city;
	}

	public void setS_city(String s_city) {
		this.s_city = s_city;
	}

	public String getS_county() {
		return s_county;
	}

	public void setS_county(String s_county) {
		this.s_county = s_county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getAptitude() {
		return aptitude;
	}

	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getZztId() {
		return zztId;
	}

	public void setZztId(String zztId) {
		this.zztId = zztId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNamep() {
		return userNamep;
	}

	public void setUserNamep(String userNamep) {
		this.userNamep = userNamep;
	}

	public String getTmId() {
		return tmId;
	}

	public void setTmId(String tmId) {
		this.tmId = tmId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTmname() {
		return tmname;
	}

	public void setTmname(String tmname) {
		this.tmname = tmname;
	}

	public String getTmnameq() {
		return tmnameq;
	}

	public void setTmnameq(String tmnameq) {
		this.tmnameq = tmnameq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTj() {
		return tj;
	}

	public void setTj(Integer tj) {
		this.tj = tj;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}
	
}
