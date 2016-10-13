package com.bcqsoft.sgoa.service.buttonname.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.buttonname.ButtonNameDAO;
import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonName;
import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonNamePage;
import com.bcqsoft.sgoa.dao.grpo.GrpoDAO;
import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.service.buttonname.ButtonNameService;

@Service
public class ButtonNameServiceImpl extends BaseService implements ButtonNameService {
	/**
	 * 按钮名称模块的DAO实现类
	 */
	@Autowired
	private ButtonNameDAO buttonNameDAO;
	
	/**
	 * 部门模块的DAO实现类
	 */
	@Autowired
	private GrpoDAO grpoDAO;
	
	/**
	 * 添加按钮名称信息
	 * 
	 * @param Duty
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean createButtonNameInfo(ButtonName buttonName) {
		Long pk = buttonNameDAO.insertIntoButtonName(buttonName);
		return isInsertSucc(pk);
	}

	/**
	 * 更新按钮名称信息
	 * 
	 * @param Duty
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean updateButtonNameInfo(ButtonName buttonName) {
		Integer count = buttonNameDAO.updateButtonNameInfoById(buttonName);
		return isUpdateSucc(count);
	}

	/**
	 * 删除一条按钮名称(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public void deleteButtonNameInfo(Long id) {
		buttonNameDAO.deleteButtonNameInfoById(id);
	}
	
	/**
	 * 删除按钮名称信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteButtonNames(long[] longArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除分组权限
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long buttonNameId : longArray) {

			// 删除分组权限
			Integer count = buttonNameDAO.deleteButtonNameInfoById(buttonNameId);

			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 取得按钮名称详细信息
	 * 
	 * @param id
	 * @return ButtonName
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public ButtonName getButtonNameDetailInfo(Long id){
		return buttonNameDAO.findButtonNameInfoById(id);
	}

	/**
	 * 查询按钮名称信息
	 * 
	 * @param page
	 * @return 按钮名称信息
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public ButtonNamePage findButtonNameInfo(ButtonNamePage page){
		int count = buttonNameDAO.findButtonNameInfoCount(page);
		if (count == 0) {
			return page;
		}
		// 取得分组权限信息集合(分页查询)
		List<ButtonName> buttonNameList = buttonNameDAO.findButtonNameInfoList(page);
		page.setTotalRow(count); // 分组权限总数量
		page.setButtonNameList(buttonNameList); // 分组权限信息集合
		return page;
	}
	
	/**
	 * 取得部门列表(分页)
	 * 
	 * @param page
	 * @return GrpoPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public List<Grpo> getGrpoListByAll(int cateGroy) {
		Grpo grpo = new Grpo();
		grpo.setCategory(cateGroy);
		// 取得部门集合(分页查询)
		List<Grpo> grpoList = grpoDAO.findAllGrpoInfo(grpo);
		return grpoList;
	}
}
