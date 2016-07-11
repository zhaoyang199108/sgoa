package com.bcqsoft.xhlm.dao.userdetail;

import java.util.List;

import com.bcqsoft.xhlm.dao.userdetail.dataobject.Userdetail;

/**
 * 用户详细表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: PSI_USER
 * </pre>
 */
public interface UserdetailDAO {

	/**
	 * 用户详细列表
	 * 
	 * @param map
	 * @return 用户详细列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<Userdetail> getUserdetailList(Userdetail userdetail);

	/**
	 * 插入一条用户详细信息
	 * 
	 * @param userdetail
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Long insertIntoUserDetail(Userdetail userdetail);

	/**
	 * 根据条目ID删除用户详细表信息
	 * 
	 * @param xhtmId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Integer deleteUserDetailById(Long id);

}
