package com.bcqsoft.sgoa.mvc.controller.resfile;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFile;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFilePage;
import com.bcqsoft.sgoa.dao.resfolder.dataobject.ResFolder;
import com.bcqsoft.sgoa.dao.resshare.dataobject.ResShare;
import com.bcqsoft.sgoa.mvc.form.resfile.ResFileForm;
import com.bcqsoft.sgoa.mvc.form.resfolder.ResFolderForm;
import com.bcqsoft.sgoa.service.resfile.ResFileService;
import com.bcqsoft.sgoa.service.resfolder.ResFolderService;
import com.bcqsoft.sgoa.service.resshare.ResShareService;

@Controller
public class ResFileController {

	@Autowired
	private ResFileService resFileService;
	@Autowired
	private ResShareService resShareService;
	@Autowired
	private ResFolderService resFolderService;
	
	/**
	 * 跳转至添加文件夹页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping("/resFile/folder.htm")
	public String menuFolder(ModelMap map) {
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "resfile_folder");
		return "resfile/menu_folder";
	}

	/**
	 * 取得有效的部门列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/resFile/folder_list.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deptmenuList(ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ResFolder> resFolderList = resFolderService
				.getResFolderListByLoginId(SecurityUtils.getLoginId());
		dataMap.put("resFolderList", resFolderList);
		return dataMap;

	}

	/**
	 * 添加文件夹页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/resFile/add_folder.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addDept(String folderName, String pId)
			throws UnsupportedEncodingException {
		ResFolder resFolder = new ResFolder();
		resFolder.setFolderName(URLDecoder.decode(folderName, "UTF-8"));
		resFolder.setUnitId(new Long(pId));
		resFolder.setLoginId(SecurityUtils.getLoginId());
		resFolder.setIsFolder("1");
		resFolder.setEnabled("Y");
		resFolderService.createResFolderInfo(resFolder);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ResFolder> resFolderList = resFolderService
				.getResFolderListByLoginId(SecurityUtils.getLoginId());
		dataMap.put("resFolderList", resFolderList);
		return dataMap;
	}

	/**
	 * 更新部门页面
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * @throws UnsupportedEncodingException
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/resFile/uptate_folder.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> editResFolder(String id, String folderName,
			String pId) throws UnsupportedEncodingException {
		ResFolderForm form = new ResFolderForm();
		form.setId(new Long(id));
		form.setFolderName(URLDecoder.decode(folderName, "UTF-8"));
		resFolderService.updateResFolderInfo(toBean(form));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ResFolder> resFolderList = resFolderService
				.getResFolderListByLoginId(SecurityUtils.getLoginId());
		dataMap.put("resFolderList", resFolderList);
		return dataMap;
	}

	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	private ResFolder toBean(ResFolderForm form) {
		ResFolder resFolder = new ResFolder();
		BeanUtils.copyProperties(form, resFolder);
		resFolder.setFolderName(form.getFolderName());
		resFolder.setUnitId(form.getUnitId());
		resFolder.setEnabled("Y");
		return resFolder;
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/resFile/delete_folder.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> removeResFolder(String id) {
		resFolderService.deleteResFolderInfo(new Long(id),
				SecurityUtils.getLoginId());
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ResFolder> resFolderList = resFolderService
				.getResFolderListByLoginId(SecurityUtils.getLoginId());
		dataMap.put("resFolderList", resFolderList);
		return dataMap;
	}

	/**
	 * 查找部门人员
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/resFile/choose_folder_file.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<ResFile> chooseFolderFile(Long folderId) {
		// 根据部门列表查找部门下所有人员
		List<ResFile> resFileList = resFileService
				.findResFileInfoListByFolder(folderId);
		return resFileList;
	}

	/**
	 * 跳转至添加文件夹页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping("/resFile/folder_all.htm")
	public String menuFolderAll(ModelMap map) {
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "resfile_folder_all");
		return "resfile/menu_folder_all";
	}

	/**
	 * 取得有效的部门列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/resFile/folder_all_list.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> folderAllList(ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ResFolder> resFolderList = resFolderService
				.getResFolderListByAll();
		dataMap.put("resFolderList", resFolderList);
		return dataMap;

	}
	
	/**
	 * 文件夹管理
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping("/resFile/folder_system.htm")
	public String menuFolderSystem(ModelMap map) {
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "folder_system");
		return "resfile/menu_folder_system";
	}
	
	/**
	 * 添加文件夹页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/resFile/add_folder_system.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addFolderSystem(String folderName, String pId,String loginId)
			throws UnsupportedEncodingException {
		ResFolder resFolder = new ResFolder();
		resFolder.setFolderName(URLDecoder.decode(folderName, "UTF-8"));
		resFolder.setUnitId(new Long(pId));
		resFolder.setLoginId(loginId);
		resFolder.setIsFolder("1");
		resFolder.setEnabled("Y");
		resFolderService.createResFolderInfo(resFolder);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ResFolder> resFolderList = resFolderService.getResFolderListByAll();
		dataMap.put("resFolderList", resFolderList);
		return dataMap;
	}
	
	/**
	 * 更新部门页面
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * @throws UnsupportedEncodingException
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/resFile/uptate_folder_system.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> editResFolderSystem(String id, String folderName,
			String pId) throws UnsupportedEncodingException {
		ResFolderForm form = new ResFolderForm();
		form.setId(new Long(id));
		form.setFolderName(URLDecoder.decode(folderName, "UTF-8"));
		resFolderService.updateResFolderInfo(toBean(form));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ResFolder> resFolderList = resFolderService.getResFolderListByAll();
		dataMap.put("resFolderList", resFolderList);
		return dataMap;
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/resFile/delete_folder_system.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> removeResFolderSystem(String id) {
		resFolderService.deleteResFolderInfo(new Long(id),SecurityUtils.getLoginId());
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ResFolder> resFolderList = resFolderService.getResFolderListByAll();
		dataMap.put("resFolderList", resFolderList);
		return dataMap;
	}

	/**
	 * 新增共享内容
	 * 
	 * @param
	 * @param
	 * @return 新增页面
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/resFile/add.htm", method = RequestMethod.GET)
	public String addResFile(Long folderId, ModelMap map) {
		map.put("folderId", folderId);
		return "resfile/add_resfile";
	}

	/**
	 * 新增共享内容处理上传
	 * 
	 * @param
	 * @param
	 * @return 操作成功
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/resFile/upload_file.htm", method = RequestMethod.POST)
	public String addResFile(ResFileForm form) {
		// 新增内容 处理附件上传，处理内容表单

		resFileService.createResFileInfo(toBean(form), form.getSrcUploadFile());
		return "common/action_succ";
	}

	/**
	 * 所有上传文件的列表页面
	 * 
	 * @param
	 * @param
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resFile/list.htm")
	public String resFileList(ResFileForm form, ModelMap map) {
		ResFilePage resFilePage = new ResFilePage();
		setSearchKey(form, resFilePage); // 设置页面中的查询条件
		// 取得上传页面列表,分页显示
		ResFilePage page = resFileService.getResFileListByPage(resFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 跳转至上传列表页面
		return "resfile/resfile_list";
	}

	/**
	 * 所有查询共享的列表页面
	 * 
	 * @param
	 * @param
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resFile/search_list.htm")
	public String searchResFileList(ResFileForm form, ModelMap map) {
		ResFilePage resFilePage = new ResFilePage();
		setSearchKey(form, resFilePage); // 设置页面中的查询条件
		// 取得上传页面列表,分页显示
		ResFilePage page = resFileService
				.getSearchResFileListByPage(resFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 跳转至上传列表页面
		return "resfile/search_list";
	}

	/**
	 * 被共享的页面（只可以浏览，不可下载）
	 * 
	 * @param
	 * @param
	 * @return 被共享的页面列表页面
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resFile/sharelist.htm")
	public String resShareList(ResFileForm form, ModelMap map) {
		ResFilePage resFilePage = new ResFilePage(); // 分页对象
		setSearchKey(form, resFilePage); // 设置页面中的查询条件
		// 取得被共享的页面列表,分页显示
		ResFilePage page = resFileService
				.getResFileShareListByPage(resFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 跳转至被共享的页面列表页面
		return "resfile/resfile_share_list";
	}

	/**
	 * 被共享的页面（可下载）
	 * 
	 * @param
	 * @param
	 * @return 被共享的页面列表页面
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resFile/shareDownList.htm")
	public String resShareDownList(ResFileForm form, ModelMap map) {
		ResFilePage resFilePage = new ResFilePage(); // 分页对象
		setSearchKey(form, resFilePage); // 设置页面中的查询条件

		// 取得列表,分页显示
		ResFilePage page = resFileService
				.getResFileDownShareListByPage(resFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 跳转至列表页面
		return "resfile/resfile_down_list";
	}

	/**
	 * 共享点击事件 查看文件信息
	 * 
	 * @param
	 * @param
	 * @return 根据ID查询的文件信息
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/resFile/detail.htm", method = RequestMethod.GET)
	public String detailResFile(Long id, ModelMap map) {
		map.put("resFile", resFileService.getResFileDetailInfo(id));
		String[] stringShare = resShareService.getResShareDetailInfo(id, "1");
		String[] stringDown = resShareService.getResShareDetailInfo(id, "2");
		map.put("resFile", resFileService.getResFileDetailInfo(id));
		map.put("shareId", stringShare[0]);
		map.put("shareName", stringShare[1]);
		map.put("downId", stringDown[0]);
		map.put("downName", stringDown[1]);
		return "resfile/detail_resfile";
	}

	/**
	 * 双击点击事件 查看文件信息
	 * 
	 * @param
	 * @param
	 * @return 根据ID查询的文件信息
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/resFile/dbdetail.htm", method = RequestMethod.GET)
	public String dbDetailResFile(Long id, ModelMap map) {
		map.put("resFile", resFileService.getResFileDetailInfo(id));
		String[] stringShare = resShareService.getResShareDetailInfo(id, "1");
		String[] stringDown = resShareService.getResShareDetailInfo(id, "2");
		map.put("resFile", resFileService.getResFileDetailInfo(id));
		map.put("shareId", stringShare[0]);
		map.put("shareName", stringShare[1]);
		map.put("downId", stringDown[0]);
		map.put("downName", stringDown[1]);
		return "resfile/detailresfile";
	}

	/**
	 * （只浏览页面） 查看文件信息
	 * 
	 * @param
	 * @param
	 * @return 根据ID查询的文件信息
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/resFile/findDetail.htm", method = RequestMethod.GET)
	public String findDetailResFile(Long id, ModelMap map) {
		map.put("resFile", resFileService.getResFileDetailInfo(id));
		return "resfile/finddetail_resfile";
	}

	/**
	 * （ 共享页面 提交所选择共享人（包括能浏览，可下载）
	 * 
	 * @param
	 * @param
	 * @return 操作成功
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/resFile/detail.htm", method = RequestMethod.POST)
	public String addResFileShare(ResFileForm form, ModelMap map) {
		ResShare resShare = new ResShare();
		resShare.setResId(form.getId());
		// 共享前先删除 以前共享信息
		resShareService.deleteResShareInfo(form.getId());
		if (null != form.getIsShoreId() && !("").equals(form.getIsShoreId())) {
			// 添加只能浏览共享人
			resShare.setToShareId(form.getIsShoreId());
			resShare.setStatus("1");
			resShareService.createResShareInfo(resShare);
		}
		// 添加可下载共享人
		if (null != form.getIsDownId() && !("").equals(form.getIsDownId())) {
			resShare.setToShareId(form.getIsDownId());
			resShare.setStatus("2");
			resShareService.createResShareInfo(resShare);

		}
		// 将文件表的是否共享 设置成已共享
		ResFile resFile = new ResFile();
		resFile.setIsShore("Y");
		resFile.setId(form.getId());
		resFileService.updateResFileInfo(resFile);
		ResFilePage resFilePage = new ResFilePage();
		resFilePage.setLoginId(SecurityUtils.getLoginId());
		// 取得上传页面列表,分页显示
		ResFilePage page = resFileService.getResFileListByPage(resFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 跳转至上传列表页面
		return "resfile/resfile_list";
	}

	/**
	 * 删除我所共享的东西 删除之前检查是否被共享 被共享不可删除
	 * 
	 * @param
	 * @param
	 * @return true 可以删除 false 不可删除
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resFile/delete.htm")
	@ResponseBody
	public boolean removeResFile(Long id) {
		ResFile resFile = new ResFile();
		resFile = resFileService.getResFileDetailInfo(id);
		if (("N").equals(resFile.getIsShore())) {

			resFileService.deleteResFileInfo(id);
			// 检查是否存在附件 如果存在则删除
			FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK", "upload",
					21);
			ftpUtil.connectServer("upload");
			ftpUtil.deleteFile(resFile.getSrcFileName());

			return true;
		} else {
			return false;
		}
	}

	/**
	 * 更新我所共享的东西 之前检查是否被共享 被共享不可更新
	 * 
	 * @param
	 * @param
	 * @return true 可以删除 false 不可删除
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/resFile/edit.htm", method = RequestMethod.GET)
	public String updateGetResFile(Long id, ModelMap map) {

		ResFile resFile = resFileService.getResFileDetailInfo(id);

		map.put("resFile", resFile);
		return "resFile/edit_resfile";
	}

	/**
	 * 更新我所共享的东西
	 * 
	 * @param
	 * @param
	 * @return true 可以删除 false 不可删除
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/resFile/edit.htm", method = RequestMethod.POST)
	public String updateResFile(ResFileForm form) {
		ResFile resFile = new ResFile();
		resFile.setTitle(form.getTitle());
		resFile.setId(form.getId());
		resFile.setContent(form.getContent());
		resFileService.editResFileInfo(resFile,form.getSrcUploadFile());
		return "common/action_succ";
	}

	/**
	 * 批量 删除我所共享的东西 删除之前检查是否被共享 被共享不可删除
	 * 
	 * @param
	 * @param
	 * @return true 可以删除 false 不可删除
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resFile/delete_batch.htm")
	@ResponseBody
	public boolean removeResFiles(String idArray) {
		return resFileService.deleteResFileInfos((toLongArray(idArray)));

	}

	/**
	 * 删除被共享 只能浏览的文件
	 * 
	 * @param
	 * @param
	 * @return 操作成功
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resShare/delete.htm")
	public String removeResShare(Long id) {
		ResShare resShare = new ResShare();
		resShare.setResId(id);
		resShare.setToShareId(SecurityUtils.getLoginId());
		resShare.setStatus("1");

		resShareService.deleteMyResShareInfo(resShare);
		return "common/action_succ";
	}

	/**
	 * 批量 删除被共享 只能浏览的文件
	 * 
	 * @param
	 * @param
	 * @return 操作成功
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resShare/delete_batch.htm")
	public String removeResShares(String idArray) {

		resShareService.deleteResShareInfos(toLongArray(idArray), "1");
		return "common/action_succ";
	}

	/**
	 * 删除被共享 可下载的文件
	 * 
	 * @param
	 * @param
	 * @return 操作成功
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resShareDown/delete.htm")
	public String removeResDownShare(Long id) {
		ResShare resShare = new ResShare();
		resShare.setResId(id);
		resShare.setToShareId(SecurityUtils.getLoginId());
		resShare.setStatus("2");
		resShareService.deleteMyResShareInfo(resShare);
		return "common/action_succ";
	}

	/**
	 * 批量删除被共享 可下载的文件
	 * 
	 * @param
	 * @param
	 * @return 操作成功
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resShareDown/delete_batch.htm")
	public String removeResDownShares(String idArray) {
		resShareService.deleteResShareInfos(toLongArray(idArray), "2");
		return "common/action_succ";
	}

	/**
	 * 下载点击事件
	 * 
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	@RequestMapping("/resShareDown/download_file.htm")
	public void downloadFile(ResFileForm form, HttpServletResponse response) {
		// 文件下载工具类
		FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK", "upload", 21);
		ftpUtil.connectServer("upload");
		ftpUtil.downloadFile(form.getSrcFileNameOne(), response);
	}

	/**
	 * 取消共享按钮
	 * 
	 * @param
	 * @param
	 * @return 操作成功
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resFile/noShare.htm")
	public String removeShare(Long id) {
		resFileService.setResNOShare(id);
		return "common/action_succ";
	}

	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	private ResFile toBean(ResFileForm form) {
		ResFile resFile = new ResFile();
		resFile.setFolderId(form.getFolderId());
		resFile.setTitle(form.getTitle());
		resFile.setContent(form.getContent());
		resFile.setLoginId(SecurityUtils.getLoginId());
		resFile.setIsShore("N");
		return resFile;
	}

	/**
	 * 页面查询设置
	 * 
	 * @param
	 * @param
	 * @return 操作成功
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	private void setSearchKey(ResFileForm form, ResFilePage resFilePage) {
		resFilePage.setCurrentPage(form.getCp()); // 当前页数
		resFilePage.setTitle(form.getTitle());
		resFilePage.setLoginId(SecurityUtils.getLoginId());
		resFilePage.setSrcFileName(form.getSrcFileName());
		resFilePage.setIsShore(form.getIsShore());
		resFilePage.setUpdateDate(form.getUpdateDate());

	}

	/**
	 * 共享删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新共享成功页面
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/resFile/delete_search.htm")
	public String delectResFile(long id) {
		resFileService.deleteResFileInfoById(id);
		// 设置操作日志
		return "common/action_succ";

	}

	/**
	 * 删除 共享(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	@RequestMapping("/resFile/delete_search_resFileArray.htm")
	public String removeResFile(String idArray) {
		// 删除通讯录信息
		resFileService.deleteResFiles(toLongArray(idArray));
		// 设置操作日志
		// 返回到操作成功页面
		return "common/action_succ";
	}

}
