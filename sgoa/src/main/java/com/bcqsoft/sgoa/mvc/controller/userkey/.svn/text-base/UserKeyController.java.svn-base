package com.bcqsoft.sgoa.mvc.controller.userkey;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.dao.userkey.dataobject.UserKey;
import com.bcqsoft.sgoa.mvc.form.userkey.UserKeyForm;
import com.bcqsoft.sgoa.service.userkey.UserKeyService;

/**
 * 用户KEY表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class UserKeyController {
	/**
	 * 用户KEY申领表的业务逻辑层
	 */
	@Autowired
	private UserKeyService userKeyService;
	
	/**
	 * 跳转至新增用户KEY页面
	 * 
	 * @return 新增用户KEY页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/userkey/add_user_key.htm", method = RequestMethod.GET)
	public String addUserKey(String loginId, ModelMap map) {
		String _SHA1 = "";
		String _3DES = "";
		int b = 0;
		int a = 0;
		Random r = new Random();
		for (int i = 0; i < 32; i++) {
			a = r.nextInt(26);
			b = (char) (a + 65);
			_SHA1 += new Character((char) b).toString();
		}
		for (int i = 0; i < 24; i++) {
			a = r.nextInt(26);
			b = (char) (a + 65);
			_3DES += new Character((char) b).toString();
		}
		map.put("_SHA1", _SHA1);
		map.put("_3DES", _3DES);
		map.put("menuHighLight", "user_key");
		map.put("loginId", loginId);
		return "user/add_user_key";
	}

	/**
	 * 用户KEY申领表新增处理
	 * 
	 * @param map
	 * @return 用户KEY申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/userkey/add_user_key.htm")
	public String addUserKey(UserKeyForm form, ModelMap map) {
		UserKey userKeySel = userKeyService.findUserKeyInfo(form.getServerIaguid());
		if (userKeySel == null) {
			userKeyService.createUserKey(setBeans(form));
		} else {
			userKeyService.editUserKey(setBeans(form));
		}
		return "user/key_success";
	}

	/**
	 * 用户KEY表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新用户KEY申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/userkey/delete_user_key.htm")
	public String delectSeal(String serverIaguid) {
		UserKey userKey = new UserKey();
		userKey.setServerIaguid(serverIaguid);
		userKeyService.deleteUserKeyInfoById(userKey);
		return "common/action_succ";
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Seal
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private UserKey setBeans(UserKeyForm form) {
		UserKey userKey = new UserKey();
		BeanUtils.copyProperties(form, userKey); // 设置表单属性
		return userKey;
	}
}
