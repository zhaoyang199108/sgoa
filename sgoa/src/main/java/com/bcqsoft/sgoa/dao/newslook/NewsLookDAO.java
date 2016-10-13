package com.bcqsoft.sgoa.dao.newslook;

import java.util.List;

import com.bcqsoft.sgoa.dao.newslook.dataobject.NewsLook;

/**
 * 信息发布表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS
 * </pre>
 */
public interface NewsLookDAO {

	List<NewsLook> getAllNewsLookList(NewsLook newsLook);

	Long addNewsInfo(NewsLook newsLook);

	List<NewsLook> getAllNewsLookListAll(Long id);

}
