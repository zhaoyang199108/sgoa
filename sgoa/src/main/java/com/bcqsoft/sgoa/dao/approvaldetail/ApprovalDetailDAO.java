package com.bcqsoft.sgoa.dao.approvaldetail;

import java.util.List;
import java.util.Map;

import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;

/**
 * 物资设备申领表数据库访问DAO接口
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public interface ApprovalDetailDAO {
	
	/**
	 * 查找全部审批流程信息列表
	 * 
	 * @return 审批流程信息列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-2
	 */
	List<ApprovalDetail> findAllApprovalDetailInfo();

	/**
	 * 根据ID删除某条审批流程信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-2
	 */
	Integer updateApprovalDetailStatusToDisabled(Map<String, Object> map);
	/**
	 * 根据父ID查询所有子ID
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	List<ApprovalDetail> findAllApprovalDetailInfo(long detailId);

	/**
	 * 添加流程审批信息
	 * 
	 * @param approval
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	Long insertIntoApprovalDetail(ApprovalDetail approvalDetail);

	/**
	 * 流程审批更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	Integer updateApprovalDetailInfoById(ApprovalDetail approvalDetail);

	/**
	 * 根据父ID查询子ID
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	List<ApprovalDetail> findAllApprovalDetailByPid(long detailId);
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	ApprovalDetail getApprovalDetailForList(ApprovalDetail approvalDetail);

	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	List<ApprovalDetail> getApprovalDetailForPIdList(
			ApprovalDetail approvalDetail);
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	ApprovalDetail getApprovalDetailForId(long id);
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	List<ApprovalDetail> getApprovalDetailForIdByPId(ApprovalDetail approvalDetail);
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	List<ApprovalDetail> getApprovalDetailForPositionId(ApprovalDetail approvalDetail);
}
