package com.bcqsoft.sgoa.dao.resshare.ibatis;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.resshare.ResShareDAO;
import com.bcqsoft.sgoa.dao.resshare.dataobject.ResShare;

/**
 * 资源(文件)共享表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_RES_SHARE
 * </pre>
 */
@Repository
public class IbatisResShareDAO extends BaseDAO implements ResShareDAO {
	/**
	 * 插入一条信息至文件共享表
	 * 
	 * @param resShare
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */

	public Long insertIntoResShare(ResShare resShare) {
		return (Long) ibatis().insert("resshare.insertIntoResShare", resShare);
	}

	/**
	 * 根据ID删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public Integer updateResShareStatusToDisabled(long id) {
		return (Integer) ibatis().update("resshare.deleteResShareToDisabled", id);
	}

	/**
	 * 根据条件删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public Integer updateMyResShareStatusToDisabled(ResShare resShare) {
		return (Integer) ibatis().delete("resshare.deleteMyResShareToDisabled", resShare);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ResShare> findResShareInfo(ResShare resShare) {
		 return (List<ResShare>) ibatis().queryForList("resshare.findResShareInfoList", resShare);
		
	}

}
