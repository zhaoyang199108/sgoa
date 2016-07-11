package com.bcqsoft.xhlm.dao.notice.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.notice.NoticeDAO;
import com.bcqsoft.xhlm.dao.notice.dataobject.Notice;
import com.bcqsoft.xhlm.dao.notice.dataobject.NoticePage;

@Repository
/**
 *类别详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisNoticeDAO extends BaseDAO implements NoticeDAO {
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findNoticeInfoCount(NoticePage page) {
		return (Integer) ibatis().queryForObject("notice.findNoticeInfoCount", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Notices&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Notice> findNoticeInfoList(NoticePage page) {
		return (List<Notice>) ibatis().queryForList("notice.findNoticeInfoList", page);
	}

	/**
	 * 插入一条类别详细信息至类别详细表
	 * 
	 * @param notice
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoNotice(Notice notice) {
		return (Long) ibatis().insert("notice.insertIntoNotice", notice);
	}

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param notice 	 	
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateNoticeInfoById(Notice notice) {
		return (Integer) ibatis().update("notice.updateNoticeInfoById", notice);
	}

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param noticeId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteNoticeInfoById(Long noticeId) {
		return (Integer) ibatis().update("notice.deleteNoticeInfoById", noticeId);
	}

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param noticeId
	 * @return Notice
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Notice getNoticeInfo(long noticeId) {
		return (Notice) ibatis().queryForObject("notice.getNoticeInfo", noticeId);
	}

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Notices&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> findNoticeInfoListById(NoticePage page) {
		return (List<Notice>) ibatis().queryForList("notice.findNoticeSortInfoList", page);
	}
}