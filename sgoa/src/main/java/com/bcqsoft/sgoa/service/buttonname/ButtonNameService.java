package com.bcqsoft.sgoa.service.buttonname;

import java.util.List;

import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonName;
import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonNamePage;
import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;

public interface ButtonNameService {
	
	/**
	 * 添加按钮名称信息
	 * 
	 * @param Duty
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	boolean createButtonNameInfo(ButtonName buttonName);

	/**
	 * 更新按钮名称信息
	 * 
	 * @param Duty
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	boolean updateButtonNameInfo(ButtonName buttonName);

	/**
	 * 删除一条按钮名称(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	void deleteButtonNameInfo(Long id);
	
	/**
	 * 删除按钮名称信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteButtonNames(long[] longArray);

	/**
	 * 取得按钮名称详细信息
	 * 
	 * @param id
	 * @return ButtonName
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	ButtonName getButtonNameDetailInfo(Long id);

	/**
	 * 查询按钮名称信息
	 * 
	 * @param page
	 * @return 按钮名称信息
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	ButtonNamePage findButtonNameInfo(ButtonNamePage page);
	
	/**
	 * 取得部门列表(分页)
	 * 
	 * @param page
	 * @return GrpoPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	List<Grpo> getGrpoListByAll(int cateGroy);
}
