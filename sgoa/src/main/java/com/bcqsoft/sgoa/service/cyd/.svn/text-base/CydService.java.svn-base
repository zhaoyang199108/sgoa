package com.bcqsoft.sgoa.service.cyd;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.cyd.dataobject.Cyd;
import com.bcqsoft.sgoa.dao.cyd.dataobject.CydEntity;
import com.bcqsoft.sgoa.dao.cyd.dataobject.CydPage;
import com.bcqsoft.sgoa.dao.sw.dataobject.Sw;
import com.bcqsoft.sgoa.dao.user.dataobject.UsersPage;

/**
 * 传阅单模块业务逻辑类接口
 */
@Service
public interface CydService {
	
	/**
	 * 传阅单页面
	 * 
	 * @param cydpage
	 * @return 分页对象
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	CydPage getCydList(CydPage cydpage);

	/**
	 * 添加传阅单数据
	 * 
	 * @param Cyd
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	boolean addCydInfo(CydEntity entity);
	
	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @return Sw
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	Cyd getCydDetailById(Long id);
	
	/**
	 * 删除详细表记录
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteCydDetailInfoById(long id);
	/**
	 * 新增一条详细表记录
	 * 
	 * @param applyGetDetail
	 * @return
	 */
	boolean creatCydDetail(CydEntity entity);
	
	/**
	 * 更新主表记录
	 * 
	 * @param entity
	 * @return
	 */
	boolean updateCyd(Cyd cyd);
	
	UsersPage getAllUserByDept();
	/**
	 * 删除详细表记录
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteCydById(long id);
}