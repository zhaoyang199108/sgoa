package com.bcqsoft.sgoa.service.docinbox;

import java.util.List;

import com.bcqsoft.sgoa.dao.docinbox.dataobject.DocinBox;

/**
 * 信息发布模块业务逻辑类接口
 */
public interface DocinBoxService {

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<DocinBox> getAllDocinBoxList(DocinBox docinBox);

	/**
	 * 添加信息数据
	 * 
	 * @param Docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addDocinInfo(DocinBox docinBox);

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<DocinBox> getAllDocinBoxListAll(long id);
	/**
	 * 修改信息数据
	 * 
	 * @param Docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean updateDocinInfo(DocinBox docinBox);

}
