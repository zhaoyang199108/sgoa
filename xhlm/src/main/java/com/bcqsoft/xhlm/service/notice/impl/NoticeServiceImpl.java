package com.bcqsoft.xhlm.service.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.notice.NoticeDAO;
import com.bcqsoft.xhlm.dao.notice.dataobject.Notice;
import com.bcqsoft.xhlm.dao.notice.dataobject.NoticePage;
import com.bcqsoft.xhlm.service.notice.NoticeService;

/**
 * 类别详细模块业务逻辑类接口
 */
@Service
public class NoticeServiceImpl extends BaseService implements NoticeService {
	/**
	 * 类别详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private NoticeDAO noticeDAO;
	/**
	 * 添加类别详细信息
	 * 
	 * @param notice
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public boolean createNotice(Notice notice) {
		// 数据库新增一条类别详细记录,并返回是否插入成功
		Long pk = noticeDAO.insertIntoNotice(notice);
		return isInsertSucc(pk);
	}

	/**
	 * 修改类别详细信息
	 * 
	 * @param notice
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public boolean modifyNotice(Notice notice) {
		// 更新该条类别详细信息,并返回是更新成功
		Integer count = noticeDAO.updateNoticeInfoById(notice);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细信息
	 * 
	 * @param noticeId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public boolean deleteNotice(long noticeId) {
		// 删除该条类别详细信息,并返回是否删除成功
		Integer count = noticeDAO.deleteNoticeInfoById(noticeId);
		// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
		//noticeRoleDAO.deleteNoticeRoleById(noticeId);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public boolean deleteNotices(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long noticeId : idArray) {
			// 删除类别详细信息
			Integer count = noticeDAO.deleteNoticeInfoById(noticeId);
			// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
			//noticeRoleDAO.deleteNoticeRoleById(noticeId);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param noticeId
	 * @return Notice
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public Notice getNoticeInfo(long noticeId) {
		Notice notice = noticeDAO.getNoticeInfo(noticeId);
		return notice;
	}

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param id
	 * @return 类别详细分页对象
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public NoticePage getNoticeInfoList(NoticePage page) {
		int count = noticeDAO.findNoticeInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Notice> noticeList = noticeDAO.findNoticeInfoList(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setNoticeList(noticeList); // 类别详细信息集合
		return page;
	}

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@Override
	public NoticePage getAllNoticeForList(NoticePage page) {
		// 取得类别详细信息集合(分页查询)
		List<Notice> noticeList = noticeDAO.findNoticeInfoListById(page);
		page.setNoticeList(noticeList); // 类别详细信息集合
		return page;
	}
}