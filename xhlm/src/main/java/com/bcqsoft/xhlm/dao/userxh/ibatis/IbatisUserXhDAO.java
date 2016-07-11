package com.bcqsoft.xhlm.dao.userxh.ibatis;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.userxh.UserXhDAO;
import com.bcqsoft.xhlm.dao.userxh.dataobject.UserXh;


/**
 * 资质图表数据库访问层Ibatis实现类
 * 
 * <pre>
 * TABLE: USERS
 * </pre>
 */
@Repository
public class IbatisUserXhDAO extends BaseDAO implements UserXhDAO {

	/**
	 * 协会企业列表
	 * 
	 * @param map
	 * @return 协会企业列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public UserXh getUserXhInfo(UserXh userXh) {
		return (UserXh) ibatis().queryForObject("userXh.getUserXhInfo",userXh);
	}

	/**
	 * 根据用户ID删除协会企业详细表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Integer deleteUserXhInfoById(UserXh userXh) {
		return (Integer) ibatis().delete("userXh.deleteUserXhInfoById",userXh);
	}
	
	/**
	 * 插入一条协会企业至协会企业表
	 * 
	 * @param userzzt
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoUserXh(UserXh userXh){
		return (Long) ibatis().insert("userXh.insertIntoUserXh",userXh);
	}
	
	/**
	 * 根据条件更新信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Integer updateUserXhInfo(UserXh userXh){
		return (Integer) ibatis().update("userXh.updateUserXhInfo",userXh);
	}
}
