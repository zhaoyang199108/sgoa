package com.bcqsoft.xhlm.service.qytm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.qytm.QytmDAO;
import com.bcqsoft.xhlm.dao.qytm.dataobject.Qytm;
import com.bcqsoft.xhlm.dao.qytm.dataobject.QytmPage;
import com.bcqsoft.xhlm.dao.userdetail.UserdetailDAO;
import com.bcqsoft.xhlm.dao.userdetail.dataobject.Userdetail;
import com.bcqsoft.xhlm.service.qytm.QytmService;
/**
 * 企业条目模块业务逻辑类接口
 */
@Service
public class QytmServiceImpl extends BaseService implements QytmService {
	/**
	 * 企业条目数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private QytmDAO qytmDAO;
	
	/**
	 * 用户详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private UserdetailDAO userdetailDAO;
	
	/**
	 * 添加企业条目信息
	 * 
	 * @param qytm
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public boolean createQytm(Qytm qytm) {
		// 数据库新增一条企业条目记录,并返回是否插入成功
		qytmDAO.insertIntoQytm(qytm);
		Long pk = userdetailDAO.insertIntoUserDetail(toInsertUserDetail(qytm));
		return isInsertSucc(pk);
	}
	
	private Userdetail toInsertUserDetail(Qytm qytm) {
		Userdetail userDetail = new Userdetail();
		userDetail.setUserId(qytm.getLoginId());
		userDetail.setTmId(String.valueOf(qytm.getId()));
		userDetail.setType(2);
		return userDetail;
	}

	/**
	 * 修改企业条目信息
	 * 
	 * @param qytm
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public boolean modifyQytm(Qytm qytm) {
		// 更新该条企业条目信息,并返回是更新成功
		Integer count = qytmDAO.updateQytmInfoById(qytm);
		return isUpdateSucc(count);
	}

	/**
	 * 删除企业条目信息
	 * 
	 * @param qytmId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public boolean deleteQytm(long qytmId) {
		// 删除该条企业条目信息,并返回是否删除成功
		Integer count = qytmDAO.deleteQytmInfoById(qytmId);
		// 删除该协会条目Id的协会条目角色信息,并返回是否删除成功
		userdetailDAO.deleteUserDetailById(qytmId);
		return isUpdateSucc(count);
	}

	/**
	 * 删除企业条目(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public boolean deleteQytms(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long qytmId : idArray) {
			// 删除企业条目信息
			Integer count = qytmDAO.deleteQytmInfoById(qytmId);
			// 删除该企业条目Id的企业条目角色信息,并返回是否删除成功
			//qytmRoleDAO.deleteQytmRoleById(qytmId);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID查找某一企业条目的信息
	 * 
	 * @param qytmId
	 * @return Qytm
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Qytm getQytmInfo(long qytmId) {
		Qytm qytm = qytmDAO.getQytmInfo(qytmId);
		return qytm;
	}

	/**
	 * 根据查询条件查找企业条目信息列表
	 * 
	 * @param id
	 * @return 企业条目分页对象
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public QytmPage getQytmInfoList(QytmPage page) {
		int count = qytmDAO.findQytmInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得企业条目信息集合(分页查询)
		List<Qytm> qytmList = qytmDAO.findQytmInfoList(page);

		page.setTotalRow(count); // 企业条目总数量
		page.setQytmList(qytmList); // 企业条目信息集合
		return page;
	}

	@Override
	public List<Qytm> getCagegoryList(Qytm qytm) {
		return qytmDAO.getCagegoryList(qytm);
	}
}
