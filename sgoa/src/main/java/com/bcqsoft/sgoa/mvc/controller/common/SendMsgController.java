package com.bcqsoft.sgoa.mvc.controller.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.SendMsgUtil;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.service.common.CommonService;

/**
 * 短信控制器
 */
@Controller
public class SendMsgController {

	/**
	 * 共通业务模块业务逻辑接口
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * 短消息发送
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/common/send_msg.htm", method = RequestMethod.GET)
	@ResponseBody
	public void sendMsg(String userLoginId, String memo) {
		// 根据部门列表查找部门下所有人员
		List<User> userList = commonService.getUserInfoList(userLoginId);
		// 发送信息
		SendMsgUtil sendMsgUtil = new SendMsgUtil();
		String memoTemp = "";
		try {
			memoTemp = URLDecoder.decode(memo, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// 转码异常
			e.printStackTrace();
		}
		// 发送短信
		sendMsgUtil.sendMsg(userList, memoTemp);
	}
}
