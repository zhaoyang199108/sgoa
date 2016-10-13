package com.bcqsoft.sgoa.dao.ipmac.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.ipmac.IpmacDAO;
import com.bcqsoft.sgoa.dao.ipmac.dataobject.Ipmac;
import com.bcqsoft.sgoa.dao.ipmac.dataobject.IpmacPage;


/**
 * IP/MAC表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE:SCOA_TB_MEETING_ROOM
 * </pre>
 */
@Repository
public class IbatisIpmacDAO extends BaseDAO implements IpmacDAO {
	/**
	 * 插入一条信息至IP/MAC表
	 * 
	 * @param ipmac
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Long insertIntoIpmac(Ipmac ipmac) {
		return (Long) ibatis().insert("ipmac.insertIntoIpmac", ipmac);
	}

	/**
	 * 根据查询条件查询符合条件的IP/MAC(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */

	public Integer findIpmacInfoCount(IpmacPage page) {
		return (Integer) ibatis().queryForObject("ipmac.findIpmacInfoCount", page);
	}

	/**
	 * 根据查询条件查询符合条件的IP/MAC
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */

	@SuppressWarnings("unchecked")
	public List<Ipmac> findIpmacInfoList(IpmacPage page) {
		return (List<Ipmac>) ibatis().queryForList("ipmac.findIpmacInfoList", page);
	}

	/**
	 * 根据ID查询某一条IP/MAC
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Ipmac findIpmacInfoById(long id) {
		return (Ipmac) ibatis().queryForObject("ipmac.findIpmacInfoById", id);
	}

	/**
	 * 根据ID更新某条IP/MAC信息
	 * 
	 * @param ipmac
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Integer updateIpmacInfoById(Ipmac ipmac) {
		return (Integer) ibatis().update("ipmac.updateIpmacInfoById", ipmac);
	}

	/**
	 * 根据ID删除某条IP/MAC信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Integer updateIpmacStatusToDisabled(long id) {
		return (Integer) ibatis().update("ipmac.updateIpmacStatusToDisabled", id);
	}

	/**
	 * 查找全部IP/MAC名称信息列表
	 * 
	 * @return IP/MAC名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	@SuppressWarnings("unchecked")
	public List<Ipmac> findAllIpmacInfo() {
		return (List<Ipmac>) ibatis().queryForList("ipmac.findAllIpmacInfo");
	}

}
