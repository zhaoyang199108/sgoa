package com.bcqsoft.xhlm.dao.userxh;

import com.bcqsoft.xhlm.dao.userxh.dataobject.UserXh;

/**
 * 资质图表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: PSI_USER
 * </pre>
 */
public interface UserXhDAO {

	/**
	 * 协会企业列表
	 * 
	 * @param map
	 * @return 协会企业列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	UserXh getUserXhInfo(UserXh userXh);

	/**
	 * 根据用户ID删除协会企业详细表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Integer deleteUserXhInfoById(UserXh userXh);
	
	/**
	 * 插入一条协会企业至协会企业表
	 * 
	 * @param userzzt
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoUserXh(UserXh userXh);

	/**
	 * 根据条件更新信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Integer updateUserXhInfo(UserXh userXh);
}
