package com.bcqsoft.xhlm.dao.userzzt.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.userzzt.UserzztDAO;
import com.bcqsoft.xhlm.dao.userzzt.dataobject.Userzzt;


/**
 * 资质图表数据库访问层Ibatis实现类
 * 
 * <pre>
 * TABLE: USERS
 * </pre>
 */
@Repository
public class IbatisUserzztDAO extends BaseDAO implements UserzztDAO {

	/**
	 * 资质图列表
	 * 
	 * @param map
	 * @return 资质图列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Userzzt> getUserzztList(Userzzt userzzt) {
		return (List<Userzzt>) ibatis().queryForList("userzzt.getUserzztList",userzzt);
	}

	/**
	 * 根据用户ID删除资质图详细表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@Override
	public Integer deleteUserZztInfoById(long userId) {
		return (Integer) ibatis().delete("userzzt.deleteUserZztInfoById",userId);
	}

	/**
	 * 插入一条资质图地址至资质图表
	 * 
	 * @param userzzt
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoUserZzt(Userzzt userzzt){
		return (Long) ibatis().insert("userzzt.insertIntoUserZzt",userzzt);
	}
}
