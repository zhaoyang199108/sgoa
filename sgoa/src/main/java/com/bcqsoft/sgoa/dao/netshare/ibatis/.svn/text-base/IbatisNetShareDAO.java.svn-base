package com.bcqsoft.sgoa.dao.netshare.ibatis;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.netshare.NetShareDAO;
import com.bcqsoft.sgoa.dao.netshare.dataobject.NetShare;

/**
 * 资源(文件)共享表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_NET_SHARE
 * </pre>
 */
@Repository
public class IbatisNetShareDAO extends BaseDAO implements NetShareDAO {
	/**
	 * 插入一条信息至文件共享表
	 * 
	 * @param netShare
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */

	public Long insertIntoNetShare(NetShare netShare) {
		return (Long) ibatis().insert("netshare.insertIntoNetShare", netShare);
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
	public Integer updateNetShareStatusToDisabled(long id) {
		return (Integer) ibatis().update("netshare.deleteNetShareToDisabled", id);
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
	public Integer updateMyNetShareStatusToDisabled(NetShare netShare) {
		return (Integer) ibatis().delete("netshare.deleteMyNetShareToDisabled", netShare);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NetShare> findNetShareInfo(NetShare netShare) {
		 return (List<NetShare>) ibatis().queryForList("netshare.findNetShareInfoList", netShare);
		
	}

}
