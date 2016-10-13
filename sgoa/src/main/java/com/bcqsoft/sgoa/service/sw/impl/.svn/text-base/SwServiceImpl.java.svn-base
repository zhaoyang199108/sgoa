package com.bcqsoft.sgoa.service.sw.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.sw.SwDAO;
import com.bcqsoft.sgoa.dao.sw.dataobject.Sw;
import com.bcqsoft.sgoa.dao.sw.dataobject.SwPage;
import com.bcqsoft.sgoa.dao.swhu.SwHuDAO;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHu;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHuPage;
import com.bcqsoft.sgoa.service.sw.SwService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class SwServiceImpl extends BaseService implements SwService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private SwDAO swDAO;

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private SwHuDAO swHuDAO;
	
	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;
	
	/**
	 * 添加信息草稿
	 * 
	 * @param sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addSwDraftInfo(Sw sw) {
		// 设置信息状态为草稿状态
		sw.setEnabled(CommonChar.FILE_DRAFT);
		sw.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = swDAO.insertIntoSw(sw);
		
		String[] receiverIdObj = sw.getReceiverId().split(",");
		for(String receiverIds:receiverIdObj){
			SwHu swHu = new SwHu();
			swHu.setReceiverId(receiverIds);
			swHu.setDocinId(sw.getId());
			swHu.setIsqs(2);
			swHuDAO.addSwInfo(swHu);
			
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(pk);
			remind.setLoginId(receiverIds);
			remind.setModeName(CommonChar.MODE_SW);
			remind.setTitle(sw.getTitle());
			remind.setUrl("sw/detail_qf.htm?id="+pk);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		
		return isInsertSucc(pk);
	}

	/**
	 * 添加信息草稿
	 * 
	 * @param sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateSwDraftInfo(Sw sw) {
		sw.setEnabled(CommonChar.FILE_DRAFT); // 设置状态为草稿
		// 更新信息信息
		Integer count = swDAO.updateSwInfoById(sw);
		return isUpdateSucc(count);
	}
	
	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public boolean updateSwStatusById(Sw sw) {
		// 更新信息信息
		Integer count = swDAO.updateSwStatusById(sw);
		return isUpdateSucc(count);
	}

	/**
	 * 添加信息数据
	 * 
	 * <pre>
	 * <li>1.将信息信息添加至信息临时表</li>
	 * <li>2.将本次提交信息添加至信息审核表</li>
	 * </pre>
	 * 
	 * @param Sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addSwInfo(Sw sw) {
		// 设置信息状态为正常状态
		sw.setEnabled(CommonChar.FILE_NORMAL);
		sw.setStatus(CommonChar.STATUS_WD);
		sw.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = swDAO.insertIntoSw(sw);
		
		String[] receiverIdObj = sw.getReceiverId().split(",");
		for(String receiverIds:receiverIdObj){
			SwHu swHu = new SwHu();
			swHu.setReceiverId(receiverIds);
			swHu.setDocinId(sw.getId());
			swHu.setIsqs(2);
			swHuDAO.addSwInfo(swHu);
			
			
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(pk);
			remind.setLoginId(receiverIds);
			remind.setModeName(CommonChar.MODE_SW);
			remind.setTitle(sw.getTitle());
			remind.setUrl("sw/detail_qf.htm?id="+pk);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		
		
		
		return isInsertSucc(pk);
	}

	/**
	 * 拟稿的信息
	 * 
	 * @param SwPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public SwPage getMyDraftSwList(SwPage swPage) {
		// 根据条件查找用户信息拟稿数量
		int count = swDAO.findMyDraftSwCount(swPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return swPage;
		}

		// 根据条件查找用户信息拟稿集合
		List<Sw> swList = swDAO.findMyDraftSwList(swPage);
		swPage.setTotalRow(count); // 拟稿总数量
		swPage.setSwList(swList); // 拟稿信息集合

		// 返回分页对象
		return swPage;
	}
	
	/**
	 * 我的已收收文信息
	 * 
	 * @param SwPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public SwPage getMySwList(SwPage swPage) {
		// 根据条件查找用户信息拟稿数量
		int count = swDAO.findMySwCount(swPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return swPage;
		}

		// 根据条件查找用户信息拟稿集合
		List<Sw> swList = swDAO.findMySwList(swPage);
		swPage.setTotalRow(count); // 拟稿总数量
		swPage.setSwList(swList); // 拟稿信息集合

		// 返回分页对象
		return swPage;
	}
	/**
	 * 我的申请页面
	 * 
	 * @param SwPage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public SwPage getApprovedSwList(SwPage page) {
		int count = swDAO.findApprovedSwCount(page);
		if (count == 0) {
			return page;
		}
		// 根据条件查找用户待审核信息集合
		List<Sw> swList = swDAO.findApprovedSwList(page);
		page.setTotalRow(count); // 待审核总数量
		page.setSwList(swList); // 待审核信息集合
		// 返回分页对象
		return page;
	}

	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long
	 *            信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean removeOneSwInfo(Long id) {
		int count = swDAO.updateSwStatusToEnabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long
	 *            信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean removeOneSwInfo(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = removeOneSwInfo(storageId);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * 
	 * @param id
	 *            信息ID
	 * @return Sw
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Sw getUserDraftSwDetail(Long id) {
		Sw out = swDAO.findSwDetailInfoById(id);
		return out;
	}

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateSwInfo(Sw sw) {
		// 更新信息信息
		Integer count = swDAO.updateSwInfoById(sw);
		// 添加这条数据的历史记录
		return isUpdateSucc(count);
	}

	/**
	 * 根据信息ID撤销该条信息记录
	 * 
	 * 
	 * @param Long
	 *            信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateOneSwInfo(Long id) {
		Integer count = swDAO.updateOneSwInfo(id);

		// 添加步骤记录
		return isUpdateSucc(count);
	}

	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	public SwPage getSwSearchList(SwPage outPage) {
		int count = swDAO.findSwSeacheCount(outPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return outPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Sw> swList = swDAO.findSwSeacheList(outPage);
		outPage.setTotalRow(count); // 待审核总数量
		outPage.setSwList(swList); // 待审核信息
		return outPage;
	}

	@Override
	public SwHuPage getSwHuListById(Long id) {
		SwHuPage page = new SwHuPage();
		List<SwHu> swHuList = swHuDAO
				.findSwHuList(id);
		page.setSwHuList(swHuList);
		return page;
	}

}
