package com.bcqsoft.xhlm.service.xhtm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.userdetail.UserdetailDAO;
import com.bcqsoft.xhlm.dao.userdetail.dataobject.Userdetail;
import com.bcqsoft.xhlm.dao.xhtm.XhtmDAO;
import com.bcqsoft.xhlm.dao.xhtm.dataobject.Xhtm;
import com.bcqsoft.xhlm.dao.xhtm.dataobject.XhtmPage;
import com.bcqsoft.xhlm.service.xhtm.XhtmService;
/**
 * 协会条目模块业务逻辑类接口
 */
@Service
public class XhtmServiceImpl extends BaseService implements XhtmService {
	/**
	 * 协会条目数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private XhtmDAO xhtmDAO;
	
	/**
	 * 用户详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private UserdetailDAO userdetailDAO;
	
	/**
	 * 添加协会条目信息
	 * 
	 * @param xhtm
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public boolean createXhtm(Xhtm xhtm) {
		// 数据库新增一条协会条目记录,并返回是否插入成功
		xhtmDAO.insertIntoXhtm(xhtm);
		// 数据库新增一条用户详细记录,并返回是否插入成功
		Long pk = userdetailDAO.insertIntoUserDetail(toInsertUserDetail(xhtm));
		return isInsertSucc(pk);
	}
	
	private Userdetail toInsertUserDetail(Xhtm xhtm) {
		Userdetail userDetail = new Userdetail();
		userDetail.setUserId(xhtm.getLoginId());
		userDetail.setTmId(String.valueOf(xhtm.getId()));
		userDetail.setType(1);
		return userDetail;
	}

	/**
	 * 修改协会条目信息
	 * 
	 * @param xhtm
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public boolean modifyXhtm(Xhtm xhtm) {
		// 更新该条协会条目信息,并返回是更新成功
		Integer count = xhtmDAO.updateXhtmInfoById(xhtm);
		return isUpdateSucc(count);
	}

	/**
	 * 删除协会条目信息
	 * 
	 * @param xhtmId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public boolean deleteXhtm(long xhtmId) {
		// 删除该条协会条目信息,并返回是否删除成功
		Integer count = xhtmDAO.deleteXhtmInfoById(xhtmId);
		// 删除该协会条目Id的协会条目角色信息,并返回是否删除成功
		userdetailDAO.deleteUserDetailById(xhtmId);
		return isUpdateSucc(count);
	}

	/**
	 * 删除协会条目(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public boolean deleteXhtms(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long xhtmId : idArray) {
			// 删除协会条目信息
			Integer count = xhtmDAO.deleteXhtmInfoById(xhtmId);
			// 删除该协会条目Id的协会条目角色信息,并返回是否删除成功
			//xhtmRoleDAO.deleteXhtmRoleById(xhtmId);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID查找某一协会条目的信息
	 * 
	 * @param xhtmId
	 * @return Xhtm
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Xhtm getXhtmInfo(long xhtmId) {
		Xhtm xhtm = xhtmDAO.getXhtmInfo(xhtmId);
		return xhtm;
	}

	/**
	 * 根据查询条件查找协会条目信息列表
	 * 
	 * @param id
	 * @return 协会条目分页对象
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public XhtmPage getXhtmInfoList(XhtmPage page) {
		int count = xhtmDAO.findXhtmInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得协会条目信息集合(分页查询)
		List<Xhtm> xhtmList = xhtmDAO.findXhtmInfoList(page);

		page.setTotalRow(count); // 协会条目总数量
		page.setXhtmList(xhtmList); // 协会条目信息集合
		return page;
	}

	@Override
	public List<Xhtm> getCagegoryList(Xhtm xhtm) {
		return xhtmDAO.getCagegoryList(xhtm);
	}
}
