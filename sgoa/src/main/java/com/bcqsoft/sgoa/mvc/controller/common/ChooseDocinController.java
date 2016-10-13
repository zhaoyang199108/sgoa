package com.bcqsoft.sgoa.mvc.controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.service.common.CommonService;

/**
 * 通用选择用户控制器
 */
@Controller
public class ChooseDocinController {

	/**
	 * 共通业务模块业务逻辑接口
	 */
	@Autowired
	private CommonService commonService;
	
	/**
	 * 文件编号
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/docin_fileNum_list.htm")
	@ResponseBody
	public void searche(String fileNum, HttpServletResponse response) {
				PrintWriter out = null;
		String result = "";
		try {
			// 判断传入的值是否为空
			if (fileNum == null || "".equals(fileNum.trim())) {
				// 为空的时候，直接输出[]
				result = "[]";
			} else {
				// 不为空的时候通过调用service方法取得相应的list
				List<Docin> docinList = commonService.getDocinListByFileNum(fileNum);
				result = "[";
				// 当取出值不为空时，循环取出并且输出页面需要格式的数据
				if (docinList != null && docinList.size() > 0) {
					Iterator it = docinList.iterator();
					while (it.hasNext()) {
						Docin docin = (Docin) it.next();
						result = result + "{id:'" + docin.getId()
								+ "',fileNum:'" + docin.getFileNum() + "'},";
					}
					result = result.substring(0, result.length() - 1);
				}
				result = result + "]";
			}
			// 输出到页面
			
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
