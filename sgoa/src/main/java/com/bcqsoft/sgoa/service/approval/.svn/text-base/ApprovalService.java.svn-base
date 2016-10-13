package com.bcqsoft.sgoa.service.approval;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.approval.dataobject.Approval;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;

/**
 * 物资设备申领表模块业务逻辑类接口
 */
@Service
public interface ApprovalService {
	/**
	 * 根据查询条件查找流程审批信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	ApprovalPage getApprovalList(ApprovalPage page);

	/**
	 * 添加流程审批信息
	 * 
	 * @param approval
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean createApproval(Approval approval);

	/**
	 * 流程审批详细信息
	 * 
	 * @param approval
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	Approval getApprovalInfo(long id);

	/**
	 * 修改流程审批信息
	 * 
	 * @param approval
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean editApprovalInfo(Approval approval);

	/**
	 * 删除流程审批信息
	 * 
	 * @param approvalId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteApproval(long id);

	/**
	 * 删除流程审批信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteApprovals(long[] longArray);
}
