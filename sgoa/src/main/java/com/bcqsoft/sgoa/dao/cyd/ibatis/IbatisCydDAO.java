package com.bcqsoft.sgoa.dao.cyd.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.cyd.CydDAO;
import com.bcqsoft.sgoa.dao.cyd.dataobject.CydPage;
import com.bcqsoft.sgoa.dao.cyd.dataobject.Cyd;
import com.bcqsoft.sgoa.dao.sw.dataobject.Sw;
import com.bcqsoft.sgoa.dao.user.dataobject.User;

@Repository
public class IbatisCydDAO extends BaseDAO implements CydDAO{
	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param cyd
	 * @return 信息集合
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	public Integer findCydCount(CydPage cydPage) {
		return (Integer) ibatis().queryForObject("cyd.findCydCount",cydPage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param cyd
	 * @return 信息集合
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	@SuppressWarnings("unchecked")
	public List<Cyd> findCydList(CydPage cydPage) {
		return (List<Cyd>) ibatis().queryForList("cyd.findCydList", cydPage);
	}
	
	/**
	 * 传阅单表中添加数据
	 * 
	 * @param Cyd
	 * @return Long 当前数据ID
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	public Long insertIntoCyd(Cyd cyd) {
		return (Long) ibatis().insert("cyd.insertIntoCyd", cyd);
	}
	
	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id 信息ID
	 * @return Sw
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Cyd findCydDetailInfoById(Long id) {
		return (Cyd) ibatis().queryForObject("cyd.findCydDetailInfoById", id);
	}
	
	/**
	 * 更新主表记录
	 * @param entity
	 * @return
	 */
	@Override
	public Integer updateCydById(Cyd cyd) {
		return (Integer) ibatis().update("cyd.updateCydById",cyd);
	}
	@SuppressWarnings("unchecked")
	public List<User> findAllUserByDept() {
		return (List<User>) ibatis().queryForList("cyd.findAllUserByDept");
	}
	
	/**
	 * 删除详细表记录
	 * @param id
	 * @return
	 */
	@Override
	public Integer deleteCydById(long id) {
		return (Integer) ibatis().update("cyd.deleteCydById", id);
	}
}