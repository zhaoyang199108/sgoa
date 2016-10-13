package com.bcqsoft.sgoa.dao.approvaldetail.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.approvaldetail.ApprovalDetailDAO;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;

/**
 * 物资设备申领表表表数据库访问DAO实现类
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
@Repository
public class IbatisApprovalDetailDAO extends BaseDAO implements
		ApprovalDetailDAO {
	/**
	 * 查找全部审批流程信息列表
	 * 
	 * @return 审批流程信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<ApprovalDetail> findAllApprovalDetailInfo() {
		return (List<ApprovalDetail>) ibatis().queryForList("approvalDetail.findAllApprovalDetailInfo");
	}

	/**
	 * 根据ID删除某条审批流程信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	public Integer updateApprovalDetailStatusToDisabled(Map<String, Object> data) {
		return (Integer) ibatis().update("approvalDetail.updateApprovalDetailStatusToDisabled",
				data);
	}
	/**
	 * 根据父ID查询所有子ID
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApprovalDetail> findAllApprovalDetailInfo(long detailId) {
		return (List<ApprovalDetail>) ibatis().queryForList("approvalDetail.findApprovalDetailInfoById", detailId);
	}

	/**
	 * 添加流程审批信息
	 * 
	 * @param approval
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@Override
	public Long insertIntoApprovalDetail(ApprovalDetail approvalDetail) {
		return (Long) ibatis().insert("approvalDetail.insertIntoApprovalDetail",approvalDetail);
	}

	/**
	 * 流程审批更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@Override
	public Integer updateApprovalDetailInfoById(ApprovalDetail approvalDetail) {
		return (Integer) ibatis().update("approvalDetail.updateApprovalDetailInfoById",approvalDetail);
	}

	/**
	 * 根据父ID查询子ID
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApprovalDetail> findAllApprovalDetailByPid(long detailId) {
		return (List<ApprovalDetail>) ibatis().queryForList("approvalDetail.findAllApprovalDetailByPid", detailId);
	}
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	public ApprovalDetail getApprovalDetailForList(
			ApprovalDetail approvalDetail) {
		return (ApprovalDetail) ibatis().queryForObject("approvalDetail.getApprovalDetailForList", approvalDetail);

	}
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApprovalDetail> getApprovalDetailForPIdList(
			ApprovalDetail approvalDetail) {
		return (List<ApprovalDetail>) ibatis().queryForList("approvalDetail.getApprovalDetailForPIdList", approvalDetail);

	}
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	public ApprovalDetail getApprovalDetailForId(long id){
		return (ApprovalDetail) ibatis().queryForObject("approvalDetail.getApprovalDetailForId",id);
	}
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@SuppressWarnings("unchecked")
	public List<ApprovalDetail> getApprovalDetailForIdByPId(ApprovalDetail approvalDetail){
		return (List<ApprovalDetail>) ibatis().queryForList("approvalDetail.getApprovalDetailForIdByPId", approvalDetail);
	}
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@SuppressWarnings("unchecked")
	public List<ApprovalDetail> getApprovalDetailForPositionId(ApprovalDetail approvalDetail){
		return (List<ApprovalDetail>) ibatis().queryForList("approvalDetail.getApprovalDetailForPositionId", approvalDetail);
	}
}
