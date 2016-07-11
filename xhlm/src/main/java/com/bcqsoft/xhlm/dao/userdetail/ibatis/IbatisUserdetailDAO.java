package com.bcqsoft.xhlm.dao.userdetail.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.userdetail.UserdetailDAO;
import com.bcqsoft.xhlm.dao.userdetail.dataobject.Userdetail;


/**
 * 用户详细表数据库访问层Ibatis实现类
 * 
 * <pre>
 * TABLE: USERS
 * </pre>
 */
@Repository
public class IbatisUserdetailDAO extends BaseDAO implements UserdetailDAO {

	/**
	 * 用户详细列表
	 * 
	 * @param map
	 * @return 用户详细列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Userdetail> getUserdetailList(Userdetail userdetail) {
		return (List<Userdetail>) ibatis().queryForList("userdetail.getUserdetailList",userdetail);
	}

	/**
	 * 插入一条用户详细信息
	 * 
	 * @param userdetail
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@Override
	public Long insertIntoUserDetail(Userdetail userdetail) {
		return (Long) ibatis().insert("userdetail.insertIntoUserDetail",userdetail);
	}

	/**
	 * 根据条目ID删除用户详细表信息
	 * 
	 * @param xhtmId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@Override
	public Integer deleteUserDetailById(Long id) {
		return (Integer) ibatis().delete("userdetail.deleteUserDetailById",id);
	}

}
