package com.bcqsoft.sgoa.dao.approval.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.approval.ApprovalDAO;
import com.bcqsoft.sgoa.dao.approval.dataobject.Approval;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;

/**
 * 物资设备申领表表表数据库访问DAO实现类
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
@Repository
public class IbatisApprovalDAO extends BaseDAO implements ApprovalDAO {

	/**
	 * 查找流程审批列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Approvals&gt;
	 */
	public Integer findApprovalInfoCount(ApprovalPage page) {
		return (Integer) ibatis().queryForObject(
				"approval.findApprovalInfoCount", page);
	}

	/**
	 * 查找流程审批列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Approvals&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Approval> findApprovalInfoList(ApprovalPage page) {
		return (List<Approval>) ibatis().queryForList(
				"approval.findApprovalInfoList", page);
	}

	/**
	 * 插入一条流程审批信息至流程审批表
	 * 
	 * @param approval
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Long insertIntoApproval(Approval approval) {
		return (Long) ibatis().insert("approval.insertIntoApproval", approval);
	}
	/**
	 * 根据流程审批ID查询流程审批表信息
	 * 
	 * @param approvalId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Approval getApprovalInfo(long id) {
		return (Approval) ibatis().queryForObject("approval.getApprovalInfo", id);
	}

	/**
	 * 根据流程审批ID更新流程审批表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public Integer updateApprovalInfoById(Approval approval) {
		return (Integer) ibatis().update("approval.updateApprovalInfoById", approval);
	}


	/**
	 * 根据流程审批ID删除流程审批表信息
	 * 
	 * @param approvalId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer deleteApprovalInfoById(long id) {
		return (Integer) ibatis().update("approval.deleteApprovalInfoById", id);
	}

	/**
	 * 查找全部审批名称信息列表
	 * 
	 * @return 审批名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Approval> findAllApprovalInfo() {
		return (List<Approval>) ibatis().queryForList("approval.findAllApprovalInfo");
	}

}
