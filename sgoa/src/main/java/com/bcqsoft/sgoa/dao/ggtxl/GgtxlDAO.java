package com.bcqsoft.sgoa.dao.ggtxl;

import java.util.List;

import com.bcqsoft.sgoa.dao.ggtxl.dataobject.Ggtxl;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.GgtxlPage;

/**
 * 物资设备申领表数据库访问DAO接口
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public interface GgtxlDAO {
	/**
	 * 查找公共通讯录列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	Integer findGgtxlInfoCount(GgtxlPage page);

	/**
	 * 查找公共通讯录列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	List<Ggtxl> findGgtxlInfoList(GgtxlPage page);
	/**
	 * 查找公共通讯录列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	Integer findGgtxlAllCount(GgtxlPage page);

	/**
	 * 查找公共通讯录列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	List<Ggtxl> findGgtxlAllList(GgtxlPage page);
	
	/**
	 * 查找公共通讯录列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	List<Ggtxl> findGgtxlInfoAllList();

	/**
	 * 插入一条公共通讯录信息至公共通讯录表
	 * 
	 * @param ggtxl
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Long insertIntoGgtxl(Ggtxl ggtxl);

	/**
	 * 根据公共通讯录ID查询公共通讯录表信息
	 * 
	 * @param ggtxlId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Ggtxl getGgtxlInfo(long id);
	/**
	 * 根据公共通讯录ID更新公共通讯录表信息
	 * 
	 * @param ggtxl
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateGgtxlInfoById(Ggtxl ggtxl);
	/**
	 * 根据公共通讯录ID删除公共通讯录表信息
	 * 
	 * @param ggtxlId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer deleteGgtxlInfoById(long id);

	Integer findGgtxlInfoSearchCount(GgtxlPage page);

	List<Ggtxl> findGgtxlInfoSearchList(GgtxlPage page);

}
