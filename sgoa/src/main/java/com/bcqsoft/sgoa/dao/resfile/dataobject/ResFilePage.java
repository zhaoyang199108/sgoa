package com.bcqsoft.sgoa.dao.resfile.dataobject;


import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

public class ResFilePage extends BasePage {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 8664820498438260413L;

	private List<ResFile> ResFileList;

	/**
	 * @return the resFileList
	 */
	public List<ResFile> getResFileList() {
		return ResFileList;
	}

	/**
	 * @param resFileList
	 *            the resFileList to set
	 */
	public void setResFileList(List<ResFile> resFileList) {
		ResFileList = resFileList;
	}

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 创建日期
	 */
	private String createDate;

	/**
	 * 更新日期
	 */
	private String updateDate;

	/**
	 * 用户ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	private String loginId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 原附件名称
	 */
	private String srcFileName;

	/**
	 * 附件路径(服务器相对路径, 例/abc/2011/dddkk.zip)
	 */
	private String fileDir;

	/**
	 * 是否共享(Y:共享, N:不共享)
	 */
	private String isShore;

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
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 取得更新日期
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置更新日期
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 取得用户ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * 设置用户ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * 取得标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 取得内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 取得原附件名称
	 */
	public String getSrcFileName() {
		return srcFileName;
	}

	/**
	 * 设置原附件名称
	 */
	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	/**
	 * 取得附件路径(服务器相对路径, 例/abc/2011/dddkk.zip)
	 */
	public String getFileDir() {
		return fileDir;
	}

	/**
	 * 设置附件路径(服务器相对路径, 例/abc/2011/dddkk.zip)
	 */
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}

	/**
	 * 取得是否共享(Y:共享, N:不共享)
	 */
	public String getIsShore() {
		return isShore;
	}

	/**
	 * 设置是否共享(Y:共享, N:不共享)
	 */
	public void setIsShore(String isShore) {
		this.isShore = isShore;
	}

}