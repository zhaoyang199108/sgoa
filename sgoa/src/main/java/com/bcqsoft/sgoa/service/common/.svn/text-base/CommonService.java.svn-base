package com.bcqsoft.sgoa.service.common;

import java.util.List;

import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;

/**
 * 共通业务模块业务逻辑接口
 */
public interface CommonService {

	/**
	 * 查找全部部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<Dept> getAllDeptInfo();

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
	List<User> getAllUserInfoByDeptId(Long deptId);

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
	List<User> getUsersInfoByLoginId(String ids);
	
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
	List<User> getAppUsersInfoByLoginId(String ids);

	/**
	 * 取得当前用户信息
	 * 
	 * @return 当前用户信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	User getCurrentUserInfo();

	/**
	 * 查找步骤三部门列表
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	List<Dept> findDeptInfoForLevel(String level);

	/**
	 * 取得用户信息
	 * 
	 * @return 当前用户信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	List<User> getUserInfoList(String userLoginId);

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
	List<User> findUserInfoByDeptId(Long deptId);

	/**
	 * 查找某一人员下的全部分组
	 * 
	 * @param loginId
	 * @return 分组列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-23
	 */
	List<UserRole> findUserInfoByLoginId(String loginId);

	/**
	 * 查找全部职务信息
	 * 
	 * @return 职务列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	List<Grpo> getGrpoListByAll(Grpo grpo);
	
	/**
	 * 取得button名称
	 * 
	 * @return 按钮名称
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	String getButtonName(String module,String moduleType);
	
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
	String getUsersNameByLoginIds(String ids);
	
	/**
	 * 根据用户职责查询出相应的用户信息
	 * 
	 * @return 按钮名称
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	List<User> findSchedulerUser();
	
	/**
	 * 根据用户职责查询出相应的用户信息
	 * 
	 * @return 按钮名称
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	List<User> findLeaderSchedulerUser();
	
	/**
	 * 添加消息中心信息
	 * 
	 * @param approval
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean createRemind(Remind remind);

	/**
	 * 根据消息提醒ID更新消息提醒表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean updateRemindInfoByLoginId(Remind remind);

	/**
	 * 文件编号查询
	 * 
	 * @return 文件编号查询页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	List<Docin> getDocinListByFileNum(String fileNum);

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
	List<User> getUserListByDP(User user);
}
