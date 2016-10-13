package com.bcqsoft.sgoa.dao.newslook.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.newslook.NewsLookDAO;
import com.bcqsoft.sgoa.dao.newslook.dataobject.NewsLook;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS
 * </pre>
 */
@Repository
public class IbatisNewsLookDAO extends BaseDAO implements NewsLookDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsLook> getAllNewsLookList(NewsLook newsLook) {

		return (List<NewsLook>) ibatis().queryForList("newsLook.getAllNewsLookList", newsLook);

	}

	@Override
	public Long addNewsInfo(NewsLook newsLook) {
		return (Long) ibatis().insert("newsLook.addNewsInfo", newsLook);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsLook> getAllNewsLookListAll(Long id) {

		return (List<NewsLook>) ibatis().queryForList("newsLook.getAllNewsLookListAll", id);

	}

}
