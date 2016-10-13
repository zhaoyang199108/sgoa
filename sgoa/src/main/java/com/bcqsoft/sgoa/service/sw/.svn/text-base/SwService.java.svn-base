package com.bcqsoft.sgoa.service.sw;


import com.bcqsoft.sgoa.dao.sw.dataobject.Sw;
import com.bcqsoft.sgoa.dao.sw.dataobject.SwPage;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHuPage;

/**
 * 信息发布模块业务逻辑类接口
 */
public interface SwService {

	/**
	 * 添加信息草稿
	 * 
	 * @param sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addSwDraftInfo(Sw sw);
	
	/**
	 * 更新信息草稿
	 * 
	 * @param sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean updateSwDraftInfo(Sw sw);

	/**
	 * 添加信息数据
	 * 
	 * <pre>
	 * <li>1.将信息信息添加至信息临时表</li>
	 * <li>2.将本次提交信息添加至信息审核表</li>
	 * </pre>
	 * 
	 * @param Sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addSwInfo(Sw sw);

	/**
	 * 拟稿信息页面
	 * 
	 * @param SwPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	SwPage getMyDraftSwList(SwPage outPage);
	
	/**
	 * 我的申请页面
	 * 
	 * @param SwPage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	SwPage getApprovedSwList(SwPage page);
	
	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long 信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	boolean removeOneSwInfo(Long id);

	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long 信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	boolean removeOneSwInfo(long[] longArray);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @return Sw
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Sw getUserDraftSwDetail(Long id);

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Sw
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean updateSwInfo(Sw sw);
	
	/**
	 * 我的已收收文信息页面
	 * 
	 * @param DocinPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	SwPage getMySwList(SwPage page);

	SwHuPage getSwHuListById(Long id);

}
