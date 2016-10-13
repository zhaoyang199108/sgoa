package com.bcqsoft.sgoa.service.seal.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.seal.SealDAO;
import com.bcqsoft.sgoa.dao.seal.dataobject.Seal;
import com.bcqsoft.sgoa.dao.seal.dataobject.SealPage;
import com.bcqsoft.sgoa.service.seal.SealService;

/**
 * 物资设备申领表模块业务逻辑实现类
 */
@Service
public class SealServiceImpl extends BaseService implements SealService {

	/**
	 * 签章模块模块DAO实现类
	 */
	@Autowired
	private SealDAO sealDAO;
	
	/**
	 * 文件访问地址
	 */
	@Value("${file.upload.dir}")
	private String uploadDomain;

	/**
	 * 根据查询条件查找签章模块信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	@Override
	public SealPage getSealInfoList(SealPage page) {
		int count = sealDAO.findSealInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得签章模块信息集合(分页查询)
		List<Seal> sealList = sealDAO.findSealInfoList(page);

		page.setTotalRow(count); // 签章模块总数量
		page.setSealList(sealList); // 签章模块信息集合
		return page;
	}

	/**
	 * 添加签章模块信息
	 * 
	 * @param seal
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean createSeal(Seal seal) {
		// 数据库新增一条签章模块记录,并返回是否插入成功
		Long pk = sealDAO.insertIntoSeal(seal);
		return isInsertSucc(pk);
	}

	/**
	 * 签章模块详细信息
	 * 
	 * @param seal
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public Seal getSealInfo(long id) {
		Seal seal = sealDAO.getSealInfo(id);
		return seal;
	}
	/**
	 * 签章模块详细信息和输出流
	 * 
	 * @param seal
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public Seal getSealInfoToOut(Seal seal) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(uploadDomain+"\\seal\\"+seal.getSealName()+"."+seal.getFileType());
			fout.write(seal.getFileBody());
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return seal;
	}
	/**
	 * 修改签章模块信息
	 * 
	 * @param seal
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */

	public boolean editSealInfo(Seal seal) {
		Integer count = sealDAO.updateSealInfoById(seal);
		return isUpdateSucc(count);
	}

	/**
	 * 删除签章模块信息
	 * 
	 * @param sealId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteSeal(long id) {
		// 根据id取得用户信息
		Integer count = sealDAO.deleteSealInfoById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除签章模块信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteSeals(long[] longArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long sealId : longArray) {

			// 删除用户信息
			Integer count = sealDAO.deleteSealInfoById(sealId);

			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

}
