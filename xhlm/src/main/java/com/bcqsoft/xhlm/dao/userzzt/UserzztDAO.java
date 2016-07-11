package com.bcqsoft.xhlm.dao.userzzt;

import java.util.List;

import com.bcqsoft.xhlm.dao.userzzt.dataobject.Userzzt;

/**
 * 资质图表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: PSI_USER
 * </pre>
 */
public interface UserzztDAO {

	/**
	 * 资质图列表
	 * 
	 * @param map
	 * @return 资质图列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<Userzzt> getUserzztList(Userzzt userzzt);

	/**
	 * 根据用户ID删除资质图详细表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Integer deleteUserZztInfoById(long userId);
	
	/**
	 * 插入一条资质图地址至资质图表
	 * 
	 * @param userzzt
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoUserZzt(Userzzt userzzt);

}
