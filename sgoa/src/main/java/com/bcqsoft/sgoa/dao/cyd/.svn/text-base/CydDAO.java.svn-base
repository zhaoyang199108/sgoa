package com.bcqsoft.sgoa.dao.cyd;

import java.util.List;

import com.bcqsoft.sgoa.dao.cyd.dataobject.CydPage;
import com.bcqsoft.sgoa.dao.cyd.dataobject.Cyd;
import com.bcqsoft.sgoa.dao.sw.dataobject.Sw;
import com.bcqsoft.sgoa.dao.user.dataobject.User;

/**
 * 传阅单表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_CYD
 * </pre>
 */
public interface CydDAO {
	/**
	 * 根据条件查找传阅单信息
	 * 
	 * @param cyd
	 * @return 信息集合
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	Integer findCydCount(CydPage cydPage);
	
	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	List<Cyd> findCydList(CydPage cydPage);
	
	/**
	 * 传阅单表中添加数据
	 * 
	 * @param Cyd
	 * @return Long 当前数据ID
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	Long insertIntoCyd(Cyd cyd);
	
	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id
	 *            信息ID
	 * @return Sw
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Cyd findCydDetailInfoById(Long id);
	
	/**
	 * 更新主表记录
	 * @param entity
	 * @return
	 */
	Integer updateCydById(Cyd cyd);
	
	/**
	 * 查找局级用户列表
	 * 
	 * @author lzn
	 * @date 2012-01-04 
	 */
	List<User> findAllUserByDept();
	
	/**
	 * 删除详细表记录
	 * @param id
	 * @return
	 */
	Integer deleteCydById(long id);
}