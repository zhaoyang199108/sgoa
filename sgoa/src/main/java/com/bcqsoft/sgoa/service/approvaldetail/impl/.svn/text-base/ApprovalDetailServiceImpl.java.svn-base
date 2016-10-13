package com.bcqsoft.sgoa.service.approvaldetail.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.approvaldetail.ApprovalDetailDAO;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;
import com.bcqsoft.sgoa.service.approvaldetail.ApprovalDetailService;

/**
 * 物资设备申领表模块业务逻辑实现类
 */
@Service
public class ApprovalDetailServiceImpl extends BaseService implements
		ApprovalDetailService {
	/**
	 * 审批流程模块的DAO实现类
	 */
	@Autowired
	private ApprovalDetailDAO approvalDetailDAO;
	
	/**
	 * 审批流程列表ID
	 * 
	 */
	private List<Long> strList = null;

	/**
	 * 取得审批流程列表(分页)
	 * 
	 * @param page
	 * @return ApprovalDetailPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	public List<ApprovalDetail> getApprovalDetailListByAll() {
		// 取得审批流程集合(分页查询)
		List<ApprovalDetail> approvalDetailList = approvalDetailDAO.findAllApprovalDetailInfo();
		return approvalDetailList;
	}

	/**
	 * 删除一条审批流程(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	public void deleteApprovalDetailInfo(Long id) {
		// 取得所有审批流程列表
		List<ApprovalDetail> approvalDetailList = approvalDetailDAO.findAllApprovalDetailInfo();
		strList = new ArrayList<Long>();
		// 取得登录人审批流程下的所有审批流程ID
		getNodeString(approvalDetailList, id);
		// 对审批流程下的所有审批流程进行删除
		approvalDetailDAO.updateApprovalDetailStatusToDisabled(toMap("idList", strList));
	}

	/**
	 * 取得所有登录人下的所有审批流程节点
	 */
	private void getNodeString(List<ApprovalDetail> approvalDetailList, Long pId) {
		strList.add(pId);
		for (ApprovalDetail approvalDetail : approvalDetailList) {

			if (pId.equals(approvalDetail.getpId())) {
				strList.add(approvalDetail.getId());
				getNodeString(approvalDetailList, approvalDetail.getId());
			}
		}
	}
	/**
	 * 根据父ID查询所有子ID
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	public List<ApprovalDetail> getApprovalDetailListByAll(long detailId) {
		// 取得审批流程集合(分页查询)
		return approvalDetailDAO.findAllApprovalDetailInfo(detailId);
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
	public boolean createApproval(ApprovalDetail approvalDetail) {
		Long pk = approvalDetailDAO.insertIntoApprovalDetail(approvalDetail);
		return isInsertSucc(pk);
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
	public boolean editApprovalDetailInfo(ApprovalDetail approvalDetail) {
		Integer count = approvalDetailDAO.updateApprovalDetailInfoById(approvalDetail);
		return isUpdateSucc(count);
	}

	/**
	 * 根据父ID查询子ID
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	public List<ApprovalDetail> getApprovalDetailListByPid(long detailId) {
		// 取得审批流程集合(分页查询)
		return approvalDetailDAO.findAllApprovalDetailByPid(detailId);
	}
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@Override
	public List<ApprovalDetail> getApprovalDetailForPIdList(
			ApprovalDetail approvalDetail) {
		return approvalDetailDAO.getApprovalDetailForPIdList(approvalDetail);
	}
	
	/**
	 * 根据查询条件查找流程审批信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	@Override
	public ApprovalDetail getApprovalDetailForList(ApprovalDetail approvalDetail) {
		 approvalDetail = approvalDetailDAO.getApprovalDetailForList(approvalDetail);
		return approvalDetail;
	}
	
	/**
	 * 根据查询条件查找流程审批信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public ApprovalDetail getApprovalDetailForId(long id){
		ApprovalDetail approvalDetail = approvalDetailDAO.getApprovalDetailForId(id);
		return approvalDetail;
	}
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	public List<ApprovalDetail> getApprovalDetailForIdByPId(ApprovalDetail approvalDetail){
		return approvalDetailDAO.getApprovalDetailForIdByPId(approvalDetail);
	}
	
	/**
	 * 根据条件查询列表
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	public List<ApprovalDetail> getApprovalDetailForPositionId(ApprovalDetail approvalDetail){
		return approvalDetailDAO.getApprovalDetailForPositionId(approvalDetail);
	}
}
