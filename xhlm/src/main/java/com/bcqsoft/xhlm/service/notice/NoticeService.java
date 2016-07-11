package com.bcqsoft.xhlm.service.notice;

import com.bcqsoft.xhlm.dao.notice.dataobject.Notice;
import com.bcqsoft.xhlm.dao.notice.dataobject.NoticePage;


/**
 * 类别详细模块业务逻辑类接口
 */
public interface NoticeService {
	
	/**
	 * 添加类别详细信息
	 * 
	 * @param notice
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createNotice(Notice notice);

	/**
	 * 修改类别详细信息
	 * 
	 * @param notice
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifyNotice(Notice notice);

	/**
	 * 删除类别详细信息
	 * 
	 * @param noticeId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteNotice(long noticeId);

	/**
	 * 删除类别详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteNotices(long[] idArray);

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param noticeId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Notice getNoticeInfo(long noticeId);

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	NoticePage getNoticeInfoList(NoticePage page);

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	NoticePage getAllNoticeForList(NoticePage page);
}