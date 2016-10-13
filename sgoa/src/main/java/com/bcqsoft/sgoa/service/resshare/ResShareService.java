package com.bcqsoft.sgoa.service.resshare;



import com.bcqsoft.sgoa.dao.resshare.dataobject.ResShare;




public  interface ResShareService {
	/**
	 * 添加共享信息
	 * 
	 * @param resShare
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	
	boolean createResShareInfo(ResShare resShare);

	/**
	 * 根据ID删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean deleteResShareInfo(Long id);

	/**
	 * 删除共享信息(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzy
	 * @Date 2011-8-17
	 */
	boolean deleteResShareInfos(long[] idArray,String status);

	/**
	 * 根据条件删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean deleteMyResShareInfo(ResShare resShare);
	/**
	 * 根据条件查询共享信息
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	String[] getResShareDetailInfo(Long id,String status);
}
