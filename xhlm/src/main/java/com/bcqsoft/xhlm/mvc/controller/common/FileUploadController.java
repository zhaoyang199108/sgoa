package com.bcqsoft.xhlm.mvc.controller.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.xhlm.common.util.DateUtil;
import com.bcqsoft.xhlm.common.util.FtpFileUtil;
import com.bcqsoft.xhlm.common.util.PropertiesUtil;
import com.bcqsoft.xhlm.mvc.form.common.CommonForm;


@Controller
public class FileUploadController {

    /**
	 * 视频上传
	 * 
	 * @param map
	 * @return 视频添加信息
	 * @throws IOException
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/common/file_upload.htm")
	@ResponseBody
	public Map<String, Object> fileUpload(CommonForm form) throws IOException {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 得到视频名
		String filename = form.getSrcUploadFile().getOriginalFilename();
		if ("".equals(filename)) {
			dataMap.put("message", "请选择一个视频后在上传");
			return dataMap;
		}
		String message = filename;
		String dateStr = DateUtil.getDateTimeForYh();
		String fileDir = dateStr + "_" + filename;
		if (form.getSrcUploadFile() != null && form.getSrcUploadFile().getSize() != 0) {

			// 视频上传
			try {
				InputStream input = form.getSrcUploadFile().getInputStream();
				FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "UTF-8","upload", 21);
				ftpUtil.connectServer("www");
				ftpUtil.cdServer("upload");
				ftpUtil.cdServer("video");
				ftpUtil.uploadFile(input,fileDir);
			} catch (FileNotFoundException e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return dataMap;
			} catch (IOException e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return dataMap;
			} catch (Exception e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return dataMap;
			}
		}
		dataMap.put("fileDir", fileDir);
		dataMap.put("id", dateStr);
		dataMap.put("message", message);
		return dataMap;
	}
	
	
	/**
	 * 文件上传
	 * 
	 * @param map
	 * @return 文件添加信息
	 * @throws IOException
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/common/file_uploadFile.htm")
	@ResponseBody
	public Map<String, Object> fileUploadFile(CommonForm form) throws IOException {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 得到文件名
		String filename = form.getSrcUploadFile().getOriginalFilename();
		if ("".equals(filename)) {
			dataMap.put("message", "请选择一个文件后在上传");
			return dataMap;
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
				return dataMap;
			} catch (IOException e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return dataMap;
			} catch (Exception e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return dataMap;
			}
		}
		dataMap.put("fileDir", fileDir);
		dataMap.put("id", dateStr);
		dataMap.put("message", message);
		return dataMap;
	}
	
	/**
	 * 视频文件上传
	 * 
	 * @param map
	 * @return 视频添加信息
	 * @throws IOException
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/common/file_uploadImg.htm")
	@ResponseBody
	public Map<String, Object> fileUploadImg(CommonForm form) throws IOException {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 文件上传后，保存在c:\\upload
		String saveDirectory = PropertiesUtil.getVideoDir();
		// 得到文件�名
		String filename = form.getSrcUploadFile().getOriginalFilename();
		if ("".equals(filename)) {
			dataMap.put("message", "请选择一个文件后在上传");
			return dataMap;
		}
		String message = filename;
		String fileDir = saveDirectory  +"\\"+ filename;
		if (form.getSrcUploadFile().getSize() > 0) {
			try {
				InputStream stream = form.getSrcUploadFile().getInputStream();
				FileOutputStream fs = new FileOutputStream(fileDir);
				byte[] buffer = new byte[1024 * 1024];
				int bytesum = 0;
				int byteread = 0;
				while ((byteread = stream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
					fs.flush();
				}
				fs.close();
				stream.close();

			} catch (IOException e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return dataMap;
			}
		}
		dataMap.put("fileDir", PropertiesUtil.getUploadDomain()+"/video/"+filename);
		dataMap.put("message", message);
		return dataMap;
	}
	
	/**
	 * 文件上传
	 * 
	 * @param map
	 * @return 文件添加信息
	 * @throws IOException
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 *//*
	@RequestMapping("/admin/common/file_upload.htm")
	@ResponseBody
	public Map<String, Object> fileUpload(CommonForm form) throws IOException {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 文件上传后，保存在c:\\upload
		String saveDirectory = PropertiesUtil.getVideoDir();
		// 得到文件�名
		String filename = form.getSrcUploadFile().getOriginalFilename();
		if ("".equals(filename)) {
			dataMap.put("message", "请选择一个文件后在上传");
			return dataMap;
		}
		String message = filename;
		String fileDir = saveDirectory  +"\\"+ filename;
		if (form.getSrcUploadFile().getSize() > 0) {
			try {
				InputStream stream = form.getSrcUploadFile().getInputStream();
				FileOutputStream fs = new FileOutputStream(fileDir);
				byte[] buffer = new byte[1024 * 1024];
				int bytesum = 0;
				int byteread = 0;
				while ((byteread = stream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
					fs.flush();
				}
				fs.close();
				stream.close();

			} catch (IOException e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return dataMap;
			}
		}
		dataMap.put("fileDir", fileDir);
		dataMap.put("message", message);
		return dataMap;
	}*/
	
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
	@RequestMapping("/admin/common/file_delete.htm")
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
