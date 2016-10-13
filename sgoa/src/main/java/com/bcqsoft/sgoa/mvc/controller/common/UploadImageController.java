package com.bcqsoft.sgoa.mvc.controller.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.mvc.form.common.CommonForm;
import com.bcqsoft.sgoa.mvc.result.UploadBean;
import com.bcqsoft.sgoa.service.common.UploadImageService;

/**
 * 上传图片模块控制器
 * 
 * @author Bcqsoft.com zbq
 * 
 */
@Controller
public class UploadImageController {

	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * 上传模块业务逻辑层
	 */
	@Autowired
	private UploadImageService uploadService;

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
	@RequestMapping("/common/image_upload.htm")
	@ResponseBody
	public Map<String, Object> fileUpload(CommonForm form) throws IOException {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 得到文件�名
		String filename = form.getSrcUploadFile().getOriginalFilename();
		if ("".equals(filename)) {
			dataMap.put("message", "请选择一个文件后在上传");
			return dataMap;
		}
		String message = filename;
		String dateStr = DateUtil.getDateTimeForYh();
		String upDir = "";
		if (form.getSrcUploadFile() != null
				&& form.getSrcUploadFile().getSize() != 0) {
			try {
				// 上传图片,返回图片访问路径,如果上传出错返回错误信息
				upDir = uploadService.uploadNewsImage(form.getSrcUploadFile(),
						"photo");
			} catch (IOException e) {
				message = filename + "上传失败！";
				dataMap.put("message", message);
				return dataMap;
			}
		}
		dataMap.put("fileDir", upDir);
		dataMap.put("id", dateStr);
		dataMap.put("message", message);
		return dataMap;
	}
	
	/**
	 * 发布新闻上传图片
	 * 
	 * @param dir
	 * @return 上传路径
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-18
	 */
	@RequestMapping(value="/upload_image.htm",method=RequestMethod.POST)
	@ResponseBody
	public UploadBean uploadImage(@RequestParam("filedata") MultipartFile filedata, String dir) {
		String upDir = "";
		try {
			// 上传图片,返回图片访问路径,如果上传出错返回错误信息
			upDir = uploadService.uploadNewsImage(filedata,dir);
		}
		catch (IOException e) {
			log.error("upload image error....", e);
			return getResult("", "上传图片错误,请联系管理员");
		}
		return getResult(upDir, "");
	}

	/**
	 * 设置XHEditor上传返回需要的Bean
	 * 
	 * @param err
	 * @param msg
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-18
	 */
	private UploadBean getResult(String msg, String err) {
		UploadBean upBean = new UploadBean();
		upBean.setErr(err);
		upBean.setMsg("!" + msg); // !表示立即上传页面中不需要点击确定
		return upBean;
	}
}
