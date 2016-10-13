package com.bcqsoft.sgoa.service.common.impl;

import static com.bcqsoft.sgoa.common.util.ListUtil.toStringList;
import static com.bcqsoft.sgoa.core.security.SecurityUtils.getLoginId;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.buttonname.ButtonNameDAO;
import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonName;
import com.bcqsoft.sgoa.dao.dept.DeptDAO;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.docin.DocinDAO;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.grpo.GrpoDAO;
import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.UserDAO;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.userrole.UserRoleDAO;
import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;
import com.bcqsoft.sgoa.service.common.CommonService;

/**
 * 共通业务模块业务逻辑类实现类
 */
@Service
public class CommonServiceImpl extends BaseService implements CommonService {

	/**
	 * 部门科室表数据库访问DAO接口
	 */
	@Autowired
	private DeptDAO deptDAO;

	/**
	 * 用户角色科室表数据库访问DAO接口
	 */
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	/**
	 * 消息中心模块DAO实现类
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 部门列表ID
	 * 
	 */
	private List<Long> strList = null;

	/**
	 * 人员表数据库访问DAO接口
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 分组职务表数据库访问DAO接口
	 */
	@Autowired
	private GrpoDAO grpoDAO;
	
	/**
	 * 按钮名称模块的DAO实现类
	 */
	@Autowired
	private ButtonNameDAO buttonNameDAO;
	
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocinDAO docinDAO;

	/**
	 * 查找全部部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	public List<Dept> getAllDeptInfo() {
		return deptDAO.findAllDeptInfo();
	}

	/**
	 * 查找某一部门下的全部人员
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-23
	 */
	public List<User> getAllUserInfoByDeptId(Long deptId) {
		return userDAO.findUsersInfoForChoose(toMap("deptId", deptId));
	}

	/**
	 * 根据用户名查找用户信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-23
	 */
	public List<User> getUsersInfoByLoginId(String ids) {
		return userDAO
				.findUsersInfoForChoose(toMap("idList", toStringList(ids)));
	}

	/**
	 * 根据用户名查找用户信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-23
	 */
	public List<User> getAppUsersInfoByLoginId(String ids) {
		return userDAO.findAppUsersInfoForChoose(toMap("idList",
				toStringList(ids)));
	}

	/**
	 * 取得当前用户信息
	 * 
	 * @return 当前用户信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	public User getCurrentUserInfo() {
		return userDAO.getUserInfoByLoginId(getLoginId());
	}

	/**
	 * 查找步骤三部门列表
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public List<Dept> findDeptInfoForLevel(String level) {
		List<Dept> deptList = null;

		return deptList;
	}

	/**
	 * 取得用户信息
	 * 
	 * @return 当前用户信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	public List<User> getUserInfoList(String userLoginId) {
		return userDAO
				.findUsersByMsg(toMap("MsgIds", toStringList(userLoginId)));
	}

	/**
	 * 查找某一部门下的全部人员
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-23
	 */
	public List<User> findUserInfoByDeptId(Long deptId) {
		// 取得所有部门列表
		List<Dept> deptList = deptDAO.findAllDeptInfo();
		strList = new ArrayList<Long>();
		// 取得登录人部门下的所有部门ID
		getNodeString(deptList, deptId);
		// 取得所有子部门下的所有用户
		List<User> userList = null;
		if (strList.size() > 0) {
			userList = userDAO.findUsersInfoForDeptId(toMap("idList", strList));

		}
		return userList;
	}

	/**
	 * 取得所有登录人下的所有部门节点
	 */
	private void getNodeString(List<Dept> deptList, Long unitId) {
		strList.add(unitId);
		for (Dept dept : deptList) {

			if (unitId.equals(dept.getUnitId())) {
				strList.add(dept.getId());
				getNodeString(deptList, dept.getId());
			}
		}
	}

	/**
	 * 查找某一人员下的全部分组
	 * 
	 * @param loginId
	 * @return 分组列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-23
	 */
	@Override
	public List<UserRole> findUserInfoByLoginId(String loginId) {
		List<UserRole> userRoleList = userRoleDAO.findUserRoleInfoList(loginId);
		return userRoleList;
	}

	/**
	 * 查找全部职务信息
	 * 
	 * @return 职务列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	@Override
	public List<Grpo> getGrpoListByAll(Grpo grpo) {
		return grpoDAO.findAllGrpoInfo(grpo);
	}

	/**
	 * 取得button名称
	 * 
	 * @return 按钮名称
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	public String getButtonName(String module,String moduleType) {
		// 取出当前登录人
		String loginId = SecurityUtils.getLoginId();
		// 通过登录人ID取出当前人职务信息
		User user = userDAO.getUserInfoByLoginId(loginId);
		// 根据用户ID取得当前职务ID
		String buttonName = "";
		if (user != null) {
			ButtonName buttonNameObj = new ButtonName();
			buttonNameObj.setPositionId(user.getPositionId());
			buttonNameObj.setModule(module);
			buttonNameObj.setModuleType(moduleType);
			ButtonName buttonNameRus = buttonNameDAO.findButtonNameInfo(buttonNameObj);
			buttonName = buttonNameRus==null?"":buttonNameRus.getBtnName();
		}
		if ("".equals(buttonName)) {
			if ("1".equals(moduleType)) {
				buttonName = "审批";
			} else {
				buttonName = "提交审核";
			}
			
		}
		return buttonName;
	}

	/**
	 * 根据用户名查找用户信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-23
	 */
	public String getUsersNameByLoginIds(String ids) {
		StringBuffer sBuffer = new StringBuffer();
		if (null==ids||"".equals(ids)) {
			return "";
		}
		List<User> userList = userDAO.findUsersInfoForChoose(toMap("idList",
				toStringList(ids)));
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			sBuffer.append(user.getUserName());
			if (i != userList.size() - 1) {
				sBuffer.append(",");
			}
		}
		return sBuffer.toString();
	}
	
	/**
	 * 根据用户职责查询出相应的用户信息
	 * 
	 * @return 按钮名称
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	public List<User> findSchedulerUser() {
		// 通过登录人ID取出当前人职务信息
		User user = userDAO.getUserInfoByLoginId(SecurityUtils.getLoginId());
		List<User> userList = new ArrayList<User>();
		// 根据用户ID取得当前职务ID
		if (user != null) {
			if (user.getPositionId() == 7 || user.getPositionId() == 4) {
				userList = userDAO.findUserInfoListByDeptId(user.getDeptId());
			} else {
				userList = userDAO.findSchedulerUserInfoList(user.getPositionId());
			} 
		}
		return userList;
	}
	
	/**
	 * 根据用户职责查询出相应的用户信息
	 * 
	 * @return 按钮名称
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	public List<User> findLeaderSchedulerUser() {
		ArrayList<Long> deptIdList = new ArrayList<Long>();
		deptIdList.add(new Long(17));
		deptIdList.add(new Long(18));
		List<User> userList = userDAO.findUsersInfoForDeptId(toMap("idList", deptIdList));
		return userList;
	}
	
	/**
	 * 添加消息中心信息
	 * 
	 * @param remind
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createRemind(Remind remind) {
		// 数据库新增一条消息中心记录,并返回是否插入成功
		Long pk = remindDAO.insertIntoRemind(remind);
		return isInsertSucc(pk);
	}
	
	/**
	 * 根据消息提醒ID更新消息提醒表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean updateRemindInfoByLoginId(Remind remind){
		Integer count = remindDAO.updateRemindInfoByLoginId(remind);
		return isUpdateSucc(count);
	}

	/**
	 * 文件编号查询
	 * 
	 * @return 文件编号查询页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@Override
	public List<Docin> getDocinListByFileNum(String fileNum) {
		return docinDAO.getDocinListByFileNum(fileNum);
	}

	/**
	 * 预选
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@Override
	public List<User> getUserListByDP(User user) {
		return userDAO.getUserListByDP(user);
	}
}
