package com.bcqsoft.xhlm.dao.qytm.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.qytm.QytmDAO;
import com.bcqsoft.xhlm.dao.qytm.dataobject.Qytm;
import com.bcqsoft.xhlm.dao.qytm.dataobject.QytmPage;

@Repository
/**
 *企业条目数据库访问层Ibatis实现类
 * 
 */
public class IbatisQytmDAO extends BaseDAO implements QytmDAO {
	/**
	 * 查找企业条目列表数量
	 * 
	 * @author cql2109
	 * @date 2013-9-12
	 * @return List&lt;Qytms&gt;
	 */
	public Integer findQytmInfoCount(QytmPage page) {
		return (Integer) ibatis().queryForObject("qytm.findQytmInfoCount", page);
	}

	/**
	 * 查找企业条目列表
	 * 
	 * @author cql2109
	 * @date 2013-9-12
	 * @return List&lt;Qytms&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Qytm> findQytmInfoList(QytmPage page) {
		return (List<Qytm>) ibatis().queryForList("qytm.findQytmInfoList", page);
	}

	/**
	 * 插入一条企业条目信息至企业条目表(SCZY_TB_USER)
	 * 
	 * @param qytm
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Long insertIntoQytm(Qytm qytm) {
		return (Long) ibatis().insert("qytm.insertIntoQytm", qytm);
	}

	/**
	 * 根据企业条目ID更新企业条目表信息
	 * 
	 * @param qytm
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Integer updateQytmInfoById(Qytm qytm) {
		return (Integer) ibatis().update("qytm.updateQytmInfoById", qytm);
	}

	/**
	 * 根据企业条目ID删除企业条目表信息
	 * 
	 * @param qytmId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Integer deleteQytmInfoById(Long qytmId) {
		return (Integer) ibatis().update("qytm.deleteQytmInfoById", qytmId);
	}

	/**
	 * 根据企业条目ID查询企业条目表信息
	 * 
	 * @param qytmId
	 * @return Qytm
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Qytm getQytmInfo(long qytmId) {
		return (Qytm) ibatis().queryForObject("qytm.getQytmInfo", qytmId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Qytm> getCagegoryList(Qytm qytm) {
		return (List<Qytm>) ibatis().queryForList("qytm.getQytmList", qytm);
	}

}
