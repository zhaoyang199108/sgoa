package com.bcqsoft.sgoa.service.netshare.impl;

import java.util.List;
import static com.bcqsoft.sgoa.common.util.ArrayUtil.toStringArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.netshare.NetShareDAO;
import com.bcqsoft.sgoa.dao.netshare.dataobject.NetShare;
import com.bcqsoft.sgoa.service.netshare.NetShareService;

@Service
public class NetShareServiceImpl extends BaseService implements NetShareService {
	@Autowired
	private NetShareDAO netShareDAO;

	/**
	 * 添加共享信息
	 * 
	 * @param netShare
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean createNetShareInfo(NetShare netShare) {
		String str = netShare.getToShareId();
		String[] idArray = toStringArray(str);
		boolean returnValue = false;
		for (String tosid : idArray) {
			// 根据toShareId添加信息
			netShare.setToShareId(tosid);
			Long pk = netShareDAO.insertIntoNetShare(netShare);
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
	public boolean deleteNetShareInfo(Long id) {
		Integer count = netShareDAO.updateNetShareStatusToDisabled(id);
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
	public boolean deleteNetShareInfos(long[] idArray, String status) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除共享信息
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : idArray) {
			NetShare netShare = new NetShare();
			netShare.setNetId(storageId);
			netShare.setToShareId(SecurityUtils.getLoginId());
			netShare.setStatus(status);

			// 物理删除
			boolean isUpdate = deleteMyNetShareInfo(netShare);
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
	public boolean deleteMyNetShareInfo(NetShare netShare) {
		Integer count = netShareDAO.updateMyNetShareStatusToDisabled(netShare);
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
	public String[] getNetShareDetailInfo(Long id,String status) {
		String[] stringVal=new String[2];
		String stringValF="";
		String stringValS="";
		NetShare netShare=new NetShare();
		netShare.setStatus(status);
		netShare.setNetId(id);
		List<NetShare> netShareList=netShareDAO.findNetShareInfo(netShare);
		Integer count =netShareList.size();
		for(int i=0;i<count;i++){
			 if (i > 0) {
                 stringValF = stringValF + ",";
                 stringValS = stringValS + ",";    
                 }
			 stringValF = stringValF + netShareList.get(i).getToShareId();
			 stringValS = stringValS + netShareList.get(i).getToShareName();	
		}
		stringVal[0]=stringValF;
		stringVal[1]=stringValS;
		
		return stringVal;
	}

}
