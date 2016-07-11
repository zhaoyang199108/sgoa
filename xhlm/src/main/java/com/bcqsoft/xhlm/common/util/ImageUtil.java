package com.bcqsoft.xhlm.common.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.springframework.web.multipart.MultipartFile;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/** 
 * 图片工具类
 * 
 * @author zbq
 * @date 2010-01-28
 */
public class ImageUtil {

	public static final String JPG = "jpeg";
	public static final String GIF = "gif";
	public static final String PNG = "png";
	public static final String BMP = "bmp";

	/**
	 * 判断文件是否是JPG格式
	 * 
	 * @author zbq
	 * @date 2010-01-28
	 * @param FormFile
	 * @return true:是 false:不是
	 */
	public static final boolean isJPG(MultipartFile mf) {
		String type = getImageType(mf);
		if (type == null) {
			return false;
		}
		return JPG.equals(type.toLowerCase());
	}

	/**
	 * 判断文件是否是GIF格式
	 * 
	 * @author zbq
	 * @date 2010-01-28
	 * @param FormFile
	 * @return true:是 false:不是
	 */
	public static final boolean isGIF(MultipartFile mf) {
		String type = getImageType(mf);
		if (type == null) {
			return false;
		}
		return GIF.equals(type.toLowerCase());
	}

	/**
	 * 判断文件是否是PNG格式
	 * 
	 * @author zbq
	 * @date 2010-01-28
	 * @param FormFile
	 * @return true:是 false:不是
	 */
	public static final boolean isPNG(MultipartFile mf) {
		String type = getImageType(mf);
		if (type == null) {
			return false;
		}
		return PNG.equals(type.toLowerCase());
	}

	/**
	 * 判断文件是否是BMP格式
	 * 
	 * @author zbq
	 * @date 2010-01-28
	 * @param FormFile
	 * @return true:是 false:不是
	 */
	public static final boolean isBMP(MultipartFile mf) {
		String type = getImageType(mf);
		if (type == null) {
			return false;
		}
		return BMP.equals(type.toLowerCase());
	}

	/**
	 * 取得图片格式, 如果产生异常为非图片格式
	 * 
	 * @author zbq
	 * @date 2010-01-28
	 * @param FormFile
	 * @return 图片格式
	 */
	private static final String getImageType(MultipartFile mf) {
		String format = null;
		if (mf == null) {
			return format;
		}

		ImageInputStream iis = null;
		try {
			// 读取图片, 取得图片格式, 如果出现异常为非图片格式
			iis = ImageIO.createImageInputStream(mf.getInputStream());
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if (iter.hasNext()) {
				format = iter.next().getFormatName();
			}
		}
		catch (IOException e) {

		}
		finally {
			try {
				if (iis != null) {
					iis.close();
				}
			}
			catch (IOException e) {

			}
		}
		return format;
	}

	/**
	 * 根据固定宽度等比例压缩图片后上传至服务器
	 * 
	 * @author zbq
	 * @date 2010-04-14
	 * @param source 源图片
	 * @param target 目的图片, 同名则覆盖
	 * @param maxsize 宽或高的最大值
	 * @throws IOException
	 */
	public static void uploadImageWithSize(MultipartFile mf, File target, int maxsize) throws IOException {

		if (mf == null || target == null) {
			throw new NullPointerException("fileItem and target can't be null");
		}
		if (maxsize < 0) {
			throw new IllegalArgumentException("maxsize must greater than 0");
		}

		// 创建文件目录
		target.getParentFile().mkdirs();
		// 根据最大的宽、高值等比例压缩图片
		compressImageInSharp(mf, target, maxsize);
	}

	/**
	 * 根据最大的宽、高值等比例压缩图片<br>
	 * 如果图片宽比高大，则以宽为基准<br>
	 * 如果图片高比宽大，则以高为基准
	 * 
	 * @author zbq
	 * @date 2010-04-14
	 * @param source 源图片
	 * @param target 目的图片, 同名则覆盖
	 * @param maxsize 宽或高的最大值
	 * @throws IOException
	 */
	public static void compressImageInSharp(MultipartFile mf, File target, int maxsize) throws IOException {

		Image src = ImageIO.read(mf.getInputStream());
		int oldwideth = src.getWidth(null);
		int oldheight = src.getHeight(null);
		
		// 如果图片尺寸合适(宽度小于最大宽度),上传图片
		if (oldwideth <= maxsize) {
			FileUtil.writeToFile(mf, target);
			return;
		}

		// 如果图片宽度大于最大宽度,等比例压缩
		int newwidth, newheigth;
		if (oldwideth > oldheight) {
			newwidth = maxsize;
			double dubwidth = (double) oldwideth;
			double dubheigth = (double) oldheight;
			newheigth = (int) (dubheigth / (dubwidth / maxsize));
		}
		else {
			newheigth = maxsize;
			double dubwidth = (double) oldwideth;
			double dubheigth = (double) oldheight;
			newwidth = (int) (dubwidth / (dubheigth / maxsize));
		}
		// 按照计算好的长,宽生成新图片
		writerImage(src, target, newwidth, newheigth);
	}

	/**
	 * 按照指定长度和宽度输出图片
	 * 
	 * @author zbq
	 * @date 2010-04-14
	 * @param target 目标文件
	 * @param src 源文件
	 * @param wideth 宽度
	 * @param height 高度
	 * @throws IOException
	 */
	private static void writerImage(Image src, File target, int wideth, int height) throws IOException {
		src = src.getScaledInstance(wideth, height, Image.SCALE_SMOOTH);
		BufferedImage tag = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
		FileOutputStream out = null;
		try {
			Graphics2D graphics = tag.createGraphics();
			graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			graphics.drawImage(src, 0, 0, null);
			out = new FileOutputStream(target);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);
		}
		finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
