package com.bcqsoft.xhlm.dao.manage.dataobject;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.xhlm.core.base.BasePage;

public class ManagePage extends BasePage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2302003436618542725L;

	private List<Manage> manageList;
	/**
	 * 主键ID(PK)
	 */
	private long id;

	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

	/**
	 * 分类ID
	 */
	private String modelsId;
	
	/**
	 * 分类名称
	 */
	private String name;

	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 标题
	 */
	private String titletb;
	
	/**
	 * 发布单位
	 */
	private String releaseUnit;

	/**
	 * 发布日期
	 */
	private String releaseDate;

	/**
	 * 信息来源
	 */
	private String newsSrc;

	/**
	 * 内容
	 */
	private String content;
	/**
	 * 原附件名称
	 */
	private String srcFileName;

	/**
	 * 原附件名称
	 */
	private String srcFileNameOne;

	/**
	 * 上传文件流
	 */
	private MultipartFile srcUploadFile;

	/**
	 * 附件路径(服务器相对路径, 例/abc/2011/dddkk.zip)
	 */
	private String fileDir;
	/**
	 * 数据类型
	 */
	private String moduleName;
	/**
	 * 创建人ID
	 */
	private String loginId;

	/**
	 * 是否有效(Y:有效, N:无效)
	 */
	private String enabled;

	/**
	 * ===================<br>
	 * Getter&Setter<br>
	 * ===================
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseUnit() {
		return releaseUnit;
	}

	public void setReleaseUnit(String releaseUnit) {
		this.releaseUnit = releaseUnit;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getNewsSrc() {
		return newsSrc;
	}

	public void setNewsSrc(String newsSrc) {
		this.newsSrc = newsSrc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getModelsId() {
		return modelsId;
	}

	public void setModelsId(String modelsId) {
		this.modelsId = modelsId;
	}

	public String getTitletb() {
		return titletb;
	}

	public void setTitletb(String titletb) {
		this.titletb = titletb;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public MultipartFile getSrcUploadFile() {
		return srcUploadFile;
	}

	public void setSrcUploadFile(MultipartFile srcUploadFile) {
		this.srcUploadFile = srcUploadFile;
	}

	public String getFileDir() {
		return fileDir;
	}

	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getSrcFileNameOne() {
		return srcFileNameOne;
	}

	public void setSrcFileNameOne(String srcFileNameOne) {
		this.srcFileNameOne = srcFileNameOne;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<Manage> getManageList() {
		return manageList;
	}

	public void setManageList(List<Manage> manageList) {
		this.manageList = manageList;
	}
	/**
	 * 图片地址
	 */
	private String pictureDir;

	public String getPictureDir() {
		return pictureDir;
	}

	public void setPictureDir(String pictureDir) {
		this.pictureDir = pictureDir;
	}
}
