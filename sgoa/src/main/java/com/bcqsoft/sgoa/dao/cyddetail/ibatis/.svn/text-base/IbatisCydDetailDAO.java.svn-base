package com.bcqsoft.sgoa.dao.cyddetail.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.cyddetail.CydDetailDAO;
import com.bcqsoft.sgoa.dao.cyddetail.dataobject.CydDetail;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHu;

@Repository
public class IbatisCydDetailDAO extends BaseDAO implements CydDetailDAO{

	@SuppressWarnings("unchecked")	
	public List<CydDetail> findCydDetailList(Long id) {
		return (List<CydDetail>) ibatis().queryForList("cydDetail.findCydDetailList", id);
	}
	
	/**
	 * 插入一条用户角色信息至用户职务表(SCOA_TB_USER_ROLE)
	 * 
	 * @param userGrpo
	 * @return 插入记录的ID
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */	
	public Long insertIntoCydDetail(CydDetail cydDetail) {
		return (Long) ibatis().insert("cydDetail.insertIntoCydDetail", cydDetail);
	}
	
	/**
	 * 删除详细表记录
	 * @param id
	 * @return
	 */
	@Override
	public Integer deleteCydDetailInfoById(long id) {
		return (Integer) ibatis().update("cydDetail.deleteCydDetailInfoById", id);
	}
}
