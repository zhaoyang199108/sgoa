package com.bcqsoft.sgoa.service.cyd.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.cyd.dataobject.Cyd;
import com.bcqsoft.sgoa.dao.cyd.dataobject.CydEntity;
import com.bcqsoft.sgoa.dao.cyd.dataobject.CydPage;
import com.bcqsoft.sgoa.dao.cyddetail.CydDetailDAO;
import com.bcqsoft.sgoa.dao.cyddetail.dataobject.CydDetail;
import com.bcqsoft.sgoa.dao.cyd.CydDAO;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.user.dataobject.UsersPage;

import com.bcqsoft.sgoa.service.cyd.CydService;

@Service
public class CydServiceImpl extends BaseService implements CydService{
	
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private CydDAO cydDAO;
	@Autowired
	private CydDetailDAO cydDetailDAO;
	/**
	 * 我的申请页面
	 * 
	 * @param CydPage
	 * @return 分页对象
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	public CydPage getCydList(CydPage page) {
		int count = cydDAO.findCydCount(page);
		if (count == 0) {
			return page;
		}
		// 根据条件查找用户待审核信息集合
		List<Cyd> cydList = cydDAO.findCydList(page);
		page.setTotalRow(count); // 待审核总数量
		page.setCydList(cydList); // 待审核信息集合
		// 返回分页对象
		return page;
	}
	
	/**
	 * 添加传阅单数据
	 * 
	 * @param Cyd
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	public boolean addCydInfo(CydEntity entity){
		Cyd cyd=CydDo(entity);	
		Long cydId = cydDAO.insertIntoCyd(cyd);		
		Integer size = entity.getUserId().length;
		for (int i = 0; i < size; i++) {		
				CydDetail cydDetail = addCydDetail(entity,i,cydId);				
				cydDetailDAO.insertIntoCydDetail(cydDetail);
			}		
		return true;
	}
	
	/**
	 * 设置报损表ORM对象ApplyGet
	 * sbq
	 */
	private Cyd CydDo(CydEntity entity) {
		Cyd cyd = new Cyd();
		cyd.setId(entity.getId());
		cyd.setCreateDate(entity.getCreateDate());
		cyd.setNumFirst(entity.getNumFirst());
		cyd.setNumSecond(entity.getNumSecond());
		cyd.setNumThird(entity.getNumThird());
		cyd.setNumFourth(entity.getNumFourth());
		cyd.setCount(entity.getCount());
		cyd.setRemark(entity.getRemark());
		cyd.setCreateId(entity.getCreateId());
		cyd.setEnabled(entity.getEnabled());
		return cyd;
	}
	
	/**
	 * 设置报损详细表ORM对象applyGetDetail
	 * sbq
	 */
	private CydDetail addCydDetail(CydEntity entity,int i, Long cydId) {
		CydDetail cydDt = new CydDetail();		
		cydDt.setCydId(cydId);// 传阅单ID
		cydDt.setUserId(entity.getUserId()[i]);// 用户ID		
		cydDt.setOutTime(entity.getOutTime()[i]); // 送文时间
		cydDt.setInTime(entity.getInTime()[i]);// 退文时间
		return cydDt;
	}
	
	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * 
	 * @param id
	 *            信息ID
	 * @return Sw
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Cyd getCydDetailById(Long id) {
		Cyd cyd = cydDAO.findCydDetailInfoById(id);
		return cyd;
	}
	
	/**
	 * 删除详细表记录
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteCydDetailInfoById(long id) {
		Integer count = cydDetailDAO.deleteCydDetailInfoById(id);
		return isUpdateSucc(count);
	}
	
	/**
	 * 新增一条详细表记录
	 * 
	 * @param applyGetDetail
	 * @return
	 */
	@Override
	public boolean creatCydDetail(CydEntity entity) {

		Long cydId = entity.getId();
		// 循环为每个添加物资设备申领记录
		Integer size = entity.getUserId().length;
		for (int i = 0; i < size; i++) {		
			CydDetail cydDetail = addCydDetail(entity,i,cydId);				
			cydDetailDAO.insertIntoCydDetail(cydDetail);
		}	
		// 暂时不需要返回值
		return true;
	}
	
	/**
	 * 更新主表记录
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public boolean updateCyd(Cyd cyd) {
		Integer count = cydDAO.updateCydById(cyd);
		return isUpdateSucc(count);
	}
	public UsersPage getAllUserByDept() {	
		UsersPage page= new UsersPage();
		List<User> userList= cydDAO.findAllUserByDept();
		page.setUserList(userList);
		return page;
	}
	
	/**
	 * 删除详细表记录
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteCydById(long id) {
		Integer count = cydDAO.deleteCydById(id);
		return isUpdateSucc(count);
	}
}