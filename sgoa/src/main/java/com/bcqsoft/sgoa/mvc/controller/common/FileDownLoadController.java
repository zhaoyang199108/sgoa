package com.bcqsoft.sgoa.mvc.controller.common;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.mvc.form.netfile.NetFileForm;

public class FileDownLoadController {

	/**
	 * 下载点击事件
	 * 
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	@RequestMapping("/common/download_file.htm")
	public void downloadFile(NetFileForm form, HttpServletResponse response) {
		// 文件下载工具类
		FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK", "upload", 21);
		ftpUtil.connectServer("upload");
		ftpUtil.downloadFile(form.getSrcFileName(), response);
	}
}
