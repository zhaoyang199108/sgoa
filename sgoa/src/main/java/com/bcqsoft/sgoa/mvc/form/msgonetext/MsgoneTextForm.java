package com.bcqsoft.sgoa.mvc.form.msgonetext;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.core.base.BaseForm;

/**
 * 文稿拟订详细内容ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_MSG_TEXT
 * </pre>
 */
public class MsgoneTextForm extends BaseForm {


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
	 * 内容ID（关联eweboffice_t_documentfile.D_RecordID）
	 */
	private String dRecordid;
	
	/**
	 * 原附件名称
	 */
	private String srcFileName;
	
	/**
	 * 上传文件流
	 */
	private MultipartFile srcUploadFile;

	/**
	 * 附件路径(服务器相对路径, 例/abc/2011/dddkk.zip)
	 */
	private String fileDir;

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

	public String getdRecordid() {
		return dRecordid;
	}

	public void setdRecordid(String dRecordid) {
		this.dRecordid = dRecordid;
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

	
}
