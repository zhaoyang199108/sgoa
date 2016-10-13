package com.bcqsoft.sgoa.dao.resshare;



import java.util.List;

import com.bcqsoft.sgoa.dao.resshare.dataobject.ResShare;


/**
 * 资源(文件)共享表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_RES_SHARE
 * </pre>
 */
public interface ResShareDAO {
	/**
	 * 插入一条信息至文件共享表
	 * 
	 * @param resShare
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Long insertIntoResShare(ResShare resShare);

	/**
	 * 根据ID删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Integer updateResShareStatusToDisabled(long id);

	/**
	 * 根据条件删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Integer updateMyResShareStatusToDisabled(ResShare resShare);
	List<ResShare>  findResShareInfo(ResShare resShare);

}
