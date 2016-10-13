package com.bcqsoft.sgoa.service.common.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.FileUtil;
import com.bcqsoft.sgoa.common.util.ImageUtil;
import com.bcqsoft.sgoa.service.common.UploadImageService;

/**
 * 上传模块业务逻辑类接口
 */
@Service
public class UploadImageServiceImpl implements UploadImageService {

	/**
	 * 文件上传地址
	 */
	@Value("${file.upload.dir}")
	private String baseDir;

	/**
	 * 文件访问地址
	 */
	@Value("${file.upload.domain}")
	private String uploadDomain;

	/**
	 * 图片上传最大宽度
	 */
	private int IMAGE_MAX_WIDTH = 600;

	/**
	 * 新闻发布上传图片
	 * 
	 * <pre>
	 * 返回可访问的全部路径
	 * </pre>
	 * 
	 * @param file
	 * @return 上传后文件名称
	 * @throws IOException
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-18
	 */
	public String uploadNewsImage(MultipartFile mf, String dir)
			throws IOException {
		// 取得文件保存目录路径(images/当天日期/时间.jpg)
		String path = appendUploadDir(mf, dir);
		// 设置图片上传目录,如果图片过大按照最大宽度进行等比例压缩
		// 将图片上传至服务器
		File f = new File(appendPath(baseDir, path));
		FileUtil.writeToFile(mf, f);
		// 返回上传图片路径(web访问路径)
		return appendPathDomain(uploadDomain, path);
	}

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
	public String uploadImageFile(MultipartFile mf, String dir, int maxWidth)
			throws IOException {
		// 取得文件保存目录路径(images/当天日期/时间.jpg)
		String path = appendUploadDir(mf, dir);
		// 设置图片上传目录,如果图片过大按照最大宽度进行等比例压缩
		// 将图片上传至服务器
		File f = new File(appendPath(baseDir, path));
		ImageUtil.uploadImageWithSize(mf, f, maxWidth);
		// 返回上传图片路径(web访问路径)
		return path;
	}

	/**
	 * 取得上传图片路径
	 * 
	 * @param mf
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-21
	 */
	private String appendUploadDir(MultipartFile mf, String dir) {
		StringBuffer buf = new StringBuffer();
		// 图片上传目录(image目录)
		//buf.append(FileUtil.IMG_UPLOAD_DIR);
		buf.append(File.separator);
		buf.append(dir);
		buf.append(File.separator);
		// 文件名(格式:当前时间(201304111523333.jpg))
		buf.append(DateUtil.getDateTimeForYh());
		buf.append(FileUtil.getFileSuffix(mf.getOriginalFilename()));

		return buf.toString();
	}

	/**
	 * 设置上传后文件web访问地址
	 * 
	 * @param path
	 * @return String
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-21
	 */
	private String appendPath(String base, String path) {
		StringBuffer buf = new StringBuffer();
		// 上传文件访问地址
		buf.append(base);
//		if (!(base.endsWith("/"))) {
//			buf.append(File.separator);
//		}
		// 上传后文件路径
		buf.append(path);
		return buf.toString();
	}
	
	/**
	 * 设置上传后文件web访问地址
	 * 
	 * @param path
	 * @return String
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-21
	 */
	private String appendPathDomain(String doMain, String path) {
		StringBuffer buf = new StringBuffer();
		// 上传文件访问地址
		buf.append(doMain);
//		if (!(base.endsWith("/"))) {
//			buf.append(File.separator);
//		}
		// 上传后文件路径
		String pathTemp = path.replaceAll("\\\\", "/");
		buf.append(pathTemp);
		return buf.toString();
	}
}
