package com.bcqsoft.sgoa.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件工具类
 * 
 * @author zbq
 * @date 2010-01-28
 */
public class FileUtil {

	public static final String DOT = ".";

	public static final int SIZE_1024 = 1024;

	public static final String IMG_UPLOAD_DIR = "/images";

	/**
	 * 上传文件
	 * 
	 * @author zbq
	 * @date 2010-01-28
	 * @param ff 从web层得到的文件上传对象，不能为null
	 * @param f 目的文件，如果已经存在，将被覆盖
	 * @throws IOException
	 */
	public static void writeToFile(MultipartFile mf, File f) throws IOException {
		if (mf == null || f == null) {
			throw new NullPointerException("file and fileItem can't be null");
		}

		// 创建文件目录
		f.getParentFile().mkdirs();

		// 创建输入流, 输出流, 写入至目标文件
		InputStream is = mf.getInputStream();
		FileOutputStream fos = new FileOutputStream(f);
		try {
			byte[] buffer = new byte[SIZE_1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
				fos.flush();
			}
		}
		finally {
			if (fos != null) {
				fos.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}

	/**
	 * 移动文件
	 * 
	 * @author deng
	 * @date 2010-04-13
	 * @param srcFile 源文件，已经存在，不能为null
	 * @param desFile 目的文件，如果已经存在，将被覆盖
	 * @throws IOException
	 */
	public static void moveFile(File srcFile, File desFile) throws IOException {
		if (srcFile == null || desFile == null) {
			throw new NullPointerException("file and fileItem can't be null");
		}

		// 创建文件目录
		desFile.getParentFile().mkdirs();

		// 创建输入流, 输出流, 写入至目标文件
		InputStream is = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(desFile);
		try {
			byte[] buffer = new byte[SIZE_1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
				fos.flush();
			}
		}
		finally {
			if (fos != null) {
				fos.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}

	/**
	 * 取得文件后缀名
	 * 
	 * @author zbq
	 * @date 2010-01-28
	 * @param file
	 * @return String
	 */
	public static String getFileSuffix(String file) {
		String type = "";
		int count = file.indexOf(DOT);
		if (count > 0) {
			type = file.substring(count);
		}
		return type;
	}
}
