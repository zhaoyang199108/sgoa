package com.bcqsoft.xhlm.mvc.form.common;

import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.xhlm.core.base.BaseForm;


public class CommonForm extends BaseForm {

	/**
	 * 上传文件流
	 */
	private MultipartFile srcUploadFile;
	
	/**
	 * 上传文件流
	 */
	private MultipartFile srcUploadFiles;
	
	/**
	 * 上传文件路径
	 */
	private MultipartFile defaultFileUploadDir;

	public MultipartFile getSrcUploadFile() {
		return srcUploadFile;
	}

	public void setSrcUploadFile(MultipartFile srcUploadFile) {
		this.srcUploadFile = srcUploadFile;
	}

	public MultipartFile getDefaultFileUploadDir() {
		return defaultFileUploadDir;
	}

	public void setDefaultFileUploadDir(MultipartFile defaultFileUploadDir) {
		this.defaultFileUploadDir = defaultFileUploadDir;
	}

	public MultipartFile getSrcUploadFiles() {
		return srcUploadFiles;
	}

	public void setSrcUploadFiles(MultipartFile srcUploadFiles) {
		this.srcUploadFiles = srcUploadFiles;
	}
	
}