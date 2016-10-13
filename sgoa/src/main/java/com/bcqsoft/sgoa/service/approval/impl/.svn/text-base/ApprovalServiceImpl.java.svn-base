package com.bcqsoft.sgoa.service.approval.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.approval.ApprovalDAO;
import com.bcqsoft.sgoa.dao.approval.dataobject.Approval;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;
import com.bcqsoft.sgoa.service.approval.ApprovalService;

/**
 * 流程审批表模块业务逻辑实现类
 */
@Service
public class ApprovalServiceImpl extends BaseService implements ApprovalService {
	/**
	 * 流程审批模块DAO实现类
	 */
	@Autowired
	private ApprovalDAO approvalDAO;


	/**
	 * 根据查询条件查找流程审批信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public ApprovalPage getApprovalList(ApprovalPage page) {
		int count = approvalDAO.findApprovalInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得流程审批信息集合(分页查询)
		List<Approval> approvalList = approvalDAO.findApprovalInfoList(page);

		page.setTotalRow(count); // 流程审批总数量
		page.setApprovalList(approvalList); // 流程审批信息集合
		return page;
	}

	/**
	 * 添加流程审批信息
	 * 
	 * @param approval
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createApproval(Approval approval) {
		Long pk = approvalDAO.insertIntoApproval(approval);
		return isInsertSucc(pk);
	}

	/**
	 * 流程审批详细信息
	 * 
	 * @param approval
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public Approval getApprovalInfo(long id) {
		Approval approval = approvalDAO.getApprovalInfo(id);
		return approval;
	}

	/**
	 * 修改流程审批信息
	 * 
	 * @param approval
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean editApprovalInfo(Approval approval) {
		Integer count = approvalDAO.updateApprovalInfoById(approval);
		return isUpdateSucc(count);
	}

	/**
	 * 删除流程审批信息
	 * 
	 * @param approvalId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteApproval(long id) {
		// 根据id取得用户信息
		Integer count = approvalDAO.deleteApprovalInfoById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除流程审批信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteApprovals(long[] longArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long approvalId : longArray) {

			// 删除用户信息
			Integer count = approvalDAO.deleteApprovalInfoById(approvalId);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}
}
