package com.bcqsoft.sgoa.mvc.controller.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.mvc.form.common.CommonForm;

@Controller
public class FileUploadController {

	/**
	 * 文件上传
	 * 
	 * @param map
	 * @return 视频添加信息
	 * @throws IOException
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/common/file_upload.htm")
	public ResponseEntity<Map<String, Object>> fileUpload(CommonForm form,HttpServletResponse response) throws IOException {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);
		response.setContentType("text/html;charset=UTF-8");
		// 得到文件名
		String filename = form.getSrcUploadFile().getOriginalFilename();
		if ("".equals(filename)) {
			dataMap.put("message", "请选择一个文件后在上传");
			return new ResponseEntity<Map<String, Object>>(dataMap,headers, HttpStatus.OK);
		}
		String message = filename;
		String dateStr = DateUtil.getDateTimeForYh();
		String fileDir = dateStr + "_" + filename;
		if (form.getSrcUploadFile() != null && form.getSrcUploadFile().getSize() != 0) {

			// 文件上传
			try {
				InputStream input = form.getSrcUploadFile().getInputStream();
				FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK","upload", 21);
				ftpUtil.connectServer("upload");
				ftpUtil.uploadFile(input,fileDir);
			} catch (FileNotFoundException e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return new ResponseEntity<Map<String, Object>>(dataMap,headers, HttpStatus.OK);
			} catch (IOException e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return new ResponseEntity<Map<String, Object>>(dataMap,headers, HttpStatus.OK);
			} catch (Exception e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return new ResponseEntity<Map<String, Object>>(dataMap,headers, HttpStatus.OK);
			}
		}
		dataMap.put("fileDir", fileDir);
		dataMap.put("id", dateStr);
		dataMap.put("message", message);
		return new ResponseEntity<Map<String, Object>>(dataMap,headers, HttpStatus.OK);
	}
	
	/**
	 * 文件删除
	 * 
	 * @param map
	 * @return 视频添加信息
	 * @throws IOException
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/common/file_delete.htm")
	@ResponseBody
	public void fileDelete(String fileNameDel) {
		// 文件删除
		try {
			FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK","upload", 21);
			ftpUtil.connectServer("upload");
			ftpUtil.deleteFile(fileNameDel);
		} catch (Exception e) {
			
		}
	}
}
