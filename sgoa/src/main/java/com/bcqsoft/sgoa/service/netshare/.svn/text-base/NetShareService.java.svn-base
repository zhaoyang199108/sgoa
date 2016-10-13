package com.bcqsoft.sgoa.service.netshare;



import com.bcqsoft.sgoa.dao.netshare.dataobject.NetShare;




public  interface NetShareService {
	/**
	 * 添加共享信息
	 * 
	 * @param netShare
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	
	boolean createNetShareInfo(NetShare netShare);

	/**
	 * 根据ID删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean deleteNetShareInfo(Long id);

	/**
	 * 删除共享信息(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzy
	 * @Date 2011-8-17
	 */
	boolean deleteNetShareInfos(long[] idArray,String status);

	/**
	 * 根据条件删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean deleteMyNetShareInfo(NetShare netShare);
	/**
	 * 根据条件查询共享信息
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	String[] getNetShareDetailInfo(Long id,String status);
}
