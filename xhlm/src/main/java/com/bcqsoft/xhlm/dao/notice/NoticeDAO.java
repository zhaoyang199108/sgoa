package com.bcqsoft.xhlm.dao.notice;

import java.util.List;

import com.bcqsoft.xhlm.dao.notice.dataobject.Notice;
import com.bcqsoft.xhlm.dao.notice.dataobject.NoticePage;

/**
 * 类别详细数据库访问层Ibatis接口
 */
public interface NoticeDAO {

	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Notices&gt;
	 */
	Integer findNoticeInfoCount(NoticePage page);

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Notices&gt;
	 */
	List<Notice> findNoticeInfoList(NoticePage page);

	/**
	 * 插入一条类别详细信息至类别详细表(SCOA_TB_NEWS)
	 * 
	 * @param notice
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoNotice(Notice notice);

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param notice
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updateNoticeInfoById(Notice notice);

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param noticeId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deleteNoticeInfoById(Long noticeId);

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param noticeId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Notice getNoticeInfo(long noticeId);

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Notice&gt;
	 */
	List<Notice> findNoticeInfoListById(NoticePage page);
}