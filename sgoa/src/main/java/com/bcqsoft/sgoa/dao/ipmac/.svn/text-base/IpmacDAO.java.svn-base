package com.bcqsoft.sgoa.dao.ipmac;

import java.util.List;

import com.bcqsoft.sgoa.dao.ipmac.dataobject.Ipmac;
import com.bcqsoft.sgoa.dao.ipmac.dataobject.IpmacPage;


/**
 * IP/MAC表数据库访问DAO接口
 * 
 * <pre>
 * TABLE:SCOA_TB_MEETING_ROOM
 * </pre>
 */
public interface IpmacDAO {

	/**
	 * 插入信息至IP/MAC表
	 * 
	 * @param ipmac
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Long insertIntoIpmac(Ipmac ipmac);

	/**
	 * 根据查询条件查询符合条件的IP/MAC(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Integer findIpmacInfoCount(IpmacPage page);

	/**
	 * 根据查询条件查询符合条件的IP/MAC
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */

	List<Ipmac> findIpmacInfoList(IpmacPage page);

	/**
	 * 根据ID查询某一条IP/MAC
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Ipmac findIpmacInfoById(long id);

	/**
	 * 根据ID更新某条IP/MAC信息
	 * 
	 * @param ipmac
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Integer updateIpmacInfoById(Ipmac ipmac);

	/**
	 * 根据ID删除某条IP/MAC信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Integer updateIpmacStatusToDisabled(long id);

	/**
	 * 查找全部IP/MAC名称信息列表
	 * 
	 * @return IP/MAC名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	List<Ipmac> findAllIpmacInfo();

}
