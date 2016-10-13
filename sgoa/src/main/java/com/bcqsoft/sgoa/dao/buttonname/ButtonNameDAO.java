package com.bcqsoft.sgoa.dao.buttonname;

import java.util.List;

import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonName;
import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonNamePage;

/**
 * 按钮名称数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_BUTTON_NAME
 * </pre>
 */
public interface ButtonNameDAO {

	/**
	 * 根据条件查询按钮名称
	 * 
	 * @return 按钮名称
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	ButtonName findButtonNameInfo(ButtonName buttonName);

	/**
	 * 插入信息至按钮名称表
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Long insertIntoButtonName(ButtonName buttonName);

	/**
	 * 根据查询条件查询符合条件的按钮名称(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-09
	 */
	Integer findButtonNameInfoCount(ButtonNamePage page);

	/**
	 * 根据查询条件查询符合条件的按钮名称
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-09
	 */

	List<ButtonName> findButtonNameInfoList(ButtonNamePage page);

	/**
	 * 根据ID查询某一条按钮名称
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	ButtonName findButtonNameInfoById(long id);

	/**
	 * 根据ID更新某条按钮名称信息
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Integer updateButtonNameInfoById(ButtonName buttonName);
	
	/**
	 * 根据ID删除某条按钮名称信息
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Integer deleteButtonNameInfoById(long id);
}
