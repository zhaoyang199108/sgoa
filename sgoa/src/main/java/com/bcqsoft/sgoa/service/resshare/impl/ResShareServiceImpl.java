package com.bcqsoft.sgoa.service.resshare.impl;

import java.util.List;
import static com.bcqsoft.sgoa.common.util.ArrayUtil.toStringArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.resshare.ResShareDAO;
import com.bcqsoft.sgoa.dao.resshare.dataobject.ResShare;
import com.bcqsoft.sgoa.service.resshare.ResShareService;

@Service
public class ResShareServiceImpl extends BaseService implements ResShareService {
	@Autowired
	private ResShareDAO resShareDAO;

	/**
	 * 添加共享信息
	 * 
	 * @param resShare
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean createResShareInfo(ResShare resShare) {
		String str = resShare.getToShareId();
		String[] idArray = toStringArray(str);
		boolean returnValue = false;
		for (String tosid : idArray) {
			// 根据toShareId添加信息
			resShare.setToShareId(tosid);
			Long pk = resShareDAO.insertIntoResShare(resShare);
			if (isInsertSucc(pk)) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean deleteResShareInfo(Long id) {
		Integer count = resShareDAO.updateResShareStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除共享信息(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzy
	 * @Date 2011-8-17
	 */
	public boolean deleteResShareInfos(long[] idArray, String status) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除共享信息
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : idArray) {
			ResShare resShare = new ResShare();
			resShare.setResId(storageId);
			resShare.setToShareId(SecurityUtils.getLoginId());
			resShare.setStatus(status);

			// 物理删除
			boolean isUpdate = deleteMyResShareInfo(resShare);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据条件删除一条共享信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean deleteMyResShareInfo(ResShare resShare) {
		Integer count = resShareDAO.updateMyResShareStatusToDisabled(resShare);
		return isUpdateSucc(count);
	}

	/**
	 * 根据条件查询共享信息
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public String[] getResShareDetailInfo(Long id,String status) {
		String[] stringVal=new String[2];
		String stringValF="";
		String stringValS="";
		ResShare resShare=new ResShare();
		resShare.setStatus(status);
		resShare.setResId(id);
		List<ResShare> resShareList=resShareDAO.findResShareInfo(resShare);
		Integer count =resShareList.size();
		for(int i=0;i<count;i++){
			 if (i > 0) {
                 stringValF = stringValF + ",";
                 stringValS = stringValS + ",";    
                 }
			 stringValF = stringValF + resShareList.get(i).getToShareId();
			 stringValS = stringValS + resShareList.get(i).getToShareName();	
		}
		stringVal[0]=stringValF;
		stringVal[1]=stringValS;
		
		return stringVal;
	}

}
