package com.bcqsoft.xhlm.dao.ptfw;

import java.util.List;

import com.bcqsoft.xhlm.dao.ptfw.dataobject.Ptfw;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.PtfwPage;

/**
 * 类别详细数据库访问层Ibatis接口
 */
public interface PtfwDAO {

	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Ptfws&gt;
	 */
	Integer findPtfwInfoCount(PtfwPage page);

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Ptfws&gt;
	 */
	List<Ptfw> findPtfwInfoList(PtfwPage page);

	/**
	 * 插入一条类别详细信息至类别详细表(SCOA_TB_NEWS)
	 * 
	 * @param ptfw
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoPtfw(Ptfw ptfw);

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param ptfw
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updatePtfwInfoById(Ptfw ptfw);

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param ptfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deletePtfwInfoById(Long ptfwId);

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param ptfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Ptfw getPtfwInfo(long ptfwId);

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Ptfw&gt;
	 */
	List<Ptfw> findPtfwInfoListById(PtfwPage page);

	/**
	 * 根据LOGIN_ID查询协会的协会服务列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	List<Ptfw> getPtfwInfoListByLoginId(String loginId);
}