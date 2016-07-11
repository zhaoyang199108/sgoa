package com.bcqsoft.xhlm.service.common;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传模块业务逻辑类接口
 */
public interface UploadService {

	/**
	 * 新闻发布上传图片
	 * 
	 * @param file
	 * @return 上传后文件名称
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-18
	 */
	String uploadNewsImage(MultipartFile file, String dir) throws IOException;

	/**
	 * 上传文件
	 * 
	 * <pre>
	 * 返回相对路径
	 * </pre>
	 * 
	 * @param file
	 * @return 上传后文件名称
	 * @throws IOException
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-18
	 */
	String uploadImageFile(MultipartFile mf, String dir, int maxWidth) throws IOException;
}
