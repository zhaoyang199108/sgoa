package com.bcqsoft.sgoa.service.approvaldetail;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;

/**
 * 物资设备申领表模块业务逻辑类接口
 */
@Service
public interface ApprovalDetailService {
	/**
	 * 取得审批流程列表(分页)
	 * 
	 * @param page
	 * @return ApprovalDetailPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	List<ApprovalDetail> getApprovalDetailListByAll();

	/**
	 * 删除一条审批流程(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	void deleteApprovalDetailInfo(Long id);
	/**
	 * 根据父ID查询所有子ID
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	List<ApprovalDetail> getApprovalDetailListByAll(long detailId);

	/**
	 * 添加流程审批信息
	 * 
	 * @param approval
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	boolean createApproval(ApprovalDetail approvalDetail);

	/**
	 * 流程审批更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	boolean editApprovalDetailInfo(ApprovalDetail approvalDetail);
	/**
	 * 根据父ID查询子ID
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	List<ApprovalDetail> getApprovalDetailListByPid(long detailId);
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	List<ApprovalDetail>  getApprovalDetailForPIdList(ApprovalDetail approvalDetail);
	
	/**
	 * 根据查询条件查找流程审批信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	ApprovalDetail getApprovalDetailForList(ApprovalDetail approvalDetail); 
	
	/**
	 * 根据查询条件查找流程审批信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
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
	List<ApprovalDetail>getApprovalDetailForIdByPId(ApprovalDetail approvalDetail);
	
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
