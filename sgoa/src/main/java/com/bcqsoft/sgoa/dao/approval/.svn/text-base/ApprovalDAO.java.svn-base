package com.bcqsoft.sgoa.dao.approval;

import java.util.List;

import com.bcqsoft.sgoa.dao.approval.dataobject.Approval;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;

/**
 * 物资设备申领表数据库访问DAO接口
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public interface ApprovalDAO {
	/**
	 * 查找流程审批列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Approvals&gt;
	 */
	Integer findApprovalInfoCount(ApprovalPage page);
	/**
	 * 查找流程审批列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Approvals&gt;
	 */
	List<Approval> findApprovalInfoList(ApprovalPage page);
	/**
	 * 插入一条流程审批信息至流程审批表
	 * 
	 * @param approval
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Long insertIntoApproval(Approval approval);
	/**
	 * 根据流程审批ID查询流程审批表信息
	 * 
	 * @param approvalId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Approval getApprovalInfo(long id);
	/**
	 * 根据流程审批ID更新流程审批表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateApprovalInfoById(Approval approval);
	/**
	 * 根据流程审批ID删除流程审批表信息
	 * 
	 * @param approvalId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer deleteApprovalInfoById(long id);
	
	/**
	 * 查找全部审批名称信息列表
	 * 
	 * @return 审批名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	List<Approval> findAllApprovalInfo();
}
