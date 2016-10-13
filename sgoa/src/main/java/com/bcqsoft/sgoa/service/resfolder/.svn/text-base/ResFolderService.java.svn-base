package com.bcqsoft.sgoa.service.resfolder;

import java.util.List;

import com.bcqsoft.sgoa.dao.resfolder.dataobject.ResFolder;

public interface ResFolderService {
	
	/**
	 * 创建一条新的文件夹名称
	 * 
	 * @param dept
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	boolean createResFolderInfo(ResFolder resFolder);

	/**
	 * 更新文件夹名称信息
	 * 
	 * @param dept
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	boolean updateResFolderInfo(ResFolder resFolder);

	/**
	 * 取得文件夹名称列表(分页)
	 * 
	 * @param page
	 * @return DeptPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	List<ResFolder> getResFolderListByAll();
	
	/**
	 * 取得登录ID下的文件夹名称列表
	 * 
	 * @param page
	 * @return DeptPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	List<ResFolder> getResFolderListByLoginId(String loginId);

	/**
	 * 删除一条文件夹名称(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	void deleteResFolderInfo(Long id,String loginId);

	/**
	 * 取得文件夹名称详细信息
	 * 
	 * @param id
	 * @return Dept
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	ResFolder getResFolderDetailInfo(Long id);
}
