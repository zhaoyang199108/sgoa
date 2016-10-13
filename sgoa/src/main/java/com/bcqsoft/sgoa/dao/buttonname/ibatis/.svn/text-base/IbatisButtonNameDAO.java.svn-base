package com.bcqsoft.sgoa.dao.buttonname.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.buttonname.ButtonNameDAO;
import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonName;
import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonNamePage;

/**
 * 部门科室表(记录当前单位科室及下属单位科室)数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DEPT
 * </pre>
 */
@Repository
public class IbatisButtonNameDAO extends BaseDAO implements ButtonNameDAO {
	
	/**
	 * 根据条件查询按钮名称
	 * 
	 * @return 按钮名称
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	public ButtonName findButtonNameInfo(ButtonName buttonName){
		return (ButtonName) ibatis().queryForObject("buttonName.findButtonNameInfo",buttonName);
	}

	/**
	 * 插入信息至按钮名称表
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Long insertIntoButtonName(ButtonName buttonName){
		return (Long) ibatis().insert("buttonName.insertIntoButtonName",buttonName);
	}

	/**
	 * 根据查询条件查询符合条件的按钮名称(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-09
	 */
	public Integer findButtonNameInfoCount(ButtonNamePage page){
		return (Integer) ibatis().queryForObject("buttonName.findButtonNameInfoCount",page);
	}

	/**
	 * 根据查询条件查询符合条件的按钮名称
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-09
	 */
	@SuppressWarnings("unchecked")
	public List<ButtonName> findButtonNameInfoList(ButtonNamePage page){
		return (List<ButtonName>) ibatis().queryForList("buttonName.findButtonNameInfoList",page);
	}

	/**
	 * 根据ID查询某一条按钮名称
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public ButtonName findButtonNameInfoById(long id){
		return (ButtonName) ibatis().queryForObject("buttonName.findButtonNameInfoById",id);
	}

	/**
	 * 根据ID更新某条按钮名称信息
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Integer updateButtonNameInfoById(ButtonName buttonName){
		return (Integer) ibatis().update("buttonName.updateButtonNameInfoById",buttonName);
	}
	
	/**
	 * 根据ID删除某条按钮名称信息
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Integer deleteButtonNameInfoById(long id){
		return (Integer) ibatis().delete("buttonName.deleteButtonNameInfoById",id);
	}
}
