package com.bcqsoft.sgoa.mvc.controller.netfile;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFile;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFilePage;
import com.bcqsoft.sgoa.dao.netshare.dataobject.NetShare;
import com.bcqsoft.sgoa.mvc.form.netfile.NetFileForm;
import com.bcqsoft.sgoa.service.netfile.NetFileService;
import com.bcqsoft.sgoa.service.netshare.NetShareService;

@Controller
public class NetFileController {

	@Autowired
	private NetFileService netFileService;
	
	@Autowired
	private NetShareService netShareService;

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
	@RequestMapping(value = "/netFile/add.htm", method = RequestMethod.GET)
	public String addNetFile() {
		return "netfile/add_netfile";
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
	@RequestMapping(value = "/netFile/upload_file.htm", method = RequestMethod.POST)
	public String addNetFile(NetFileForm form) {
		// 新增内容 处理附件上传，处理内容表单
		netFileService.createNetFileInfo(toBean(form));
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
	@RequestMapping("/netFile/list.htm")
	public String netFileList(NetFileForm form, ModelMap map) {
		NetFilePage netFilePage = new NetFilePage();
		setSearchKey(form, netFilePage); // 设置页面中的查询条件
		// 取得上传页面列表,分页显示
		NetFilePage page = netFileService.getNetFileListByPage(netFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "netfile_list");
		// 跳转至上传列表页面
		return "netfile/netfile_list";
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
	@RequestMapping("/netFile/search_list.htm")
	public String searchNetFileList(NetFileForm form, ModelMap map) {
		NetFilePage netFilePage = new NetFilePage();
		setSearchKey(form, netFilePage); // 设置页面中的查询条件
		// 取得上传页面列表,分页显示
		NetFilePage page = netFileService
				.getSearchNetFileListByPage(netFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "netfile_search_list");
		// 跳转至上传列表页面
		return "netfile/search_list";
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
	@RequestMapping("/netFile/sharelist.htm")
	public String netShareList(NetFileForm form, ModelMap map) {
		NetFilePage netFilePage = new NetFilePage(); // 分页对象
		setSearchKey(form, netFilePage); // 设置页面中的查询条件
		// 取得被共享的页面列表,分页显示
		NetFilePage page = netFileService
				.getNetFileShareListByPage(netFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 跳转至被共享的页面列表页面
		return "netfile/netfile_share_list";
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
	@RequestMapping("/netFile/shareDownList.htm")
	public String netShareDownList(NetFileForm form, ModelMap map) {
		NetFilePage netFilePage = new NetFilePage(); // 分页对象
		setSearchKey(form, netFilePage); // 设置页面中的查询条件

		// 取得列表,分页显示
		NetFilePage page = netFileService
				.getNetFileDownShareListByPage(netFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "shareDownList");
		// 跳转至列表页面
		return "netfile/netfile_down_list";
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
	@RequestMapping(value = "/netFile/detail.htm", method = RequestMethod.GET)
	public String detailNetFile(Long id, ModelMap map) {
		map.put("netFile", netFileService.getNetFileDetailInfo(id));
		String[] stringShare = netShareService.getNetShareDetailInfo(id, "1");
		String[] stringDown = netShareService.getNetShareDetailInfo(id, "2");
		map.put("netFile", netFileService.getNetFileDetailInfo(id));
		map.put("shareId", stringShare[0]);
		map.put("shareName", stringShare[1]);
		map.put("downId", stringDown[0]);
		map.put("downName", stringDown[1]);
		return "netfile/detail_netfile";
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
	@RequestMapping(value = "/netFile/dbdetail.htm", method = RequestMethod.GET)
	public String dbDetailNetFile(Long id, ModelMap map) {
		map.put("netFile", netFileService.getNetFileDetailInfo(id));
		String[] stringShare = netShareService.getNetShareDetailInfo(id, "1");
		String[] stringDown = netShareService.getNetShareDetailInfo(id, "2");
		map.put("netFile", netFileService.getNetFileDetailInfo(id));
		map.put("shareId", stringShare[0]);
		map.put("shareName", stringShare[1]);
		map.put("downId", stringDown[0]);
		map.put("downName", stringDown[1]);
		return "netfile/detailnetfile";
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
	@RequestMapping(value = "/netFile/findDetail.htm", method = RequestMethod.GET)
	public String findDetailNetFile(Long id, ModelMap map) {
		map.put("netFile", netFileService.getNetFileDetailInfo(id));
		return "netfile/finddetail_netfile";
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
	@RequestMapping(value = "/netFile/detail.htm", method = RequestMethod.POST)
	public String addNetFileShare(NetFileForm form, ModelMap map) {
		NetShare netShare = new NetShare();
		netShare.setNetId(form.getId());
		// 共享前先删除 以前共享信息
		netShareService.deleteNetShareInfo(form.getId());
		if (null != form.getIsShoreId() && !("").equals(form.getIsShoreId())) {
			// 添加只能浏览共享人
			netShare.setToShareId(form.getIsShoreId());
			netShare.setStatus("1");
			netShareService.createNetShareInfo(netShare);
		}
		// 添加可下载共享人
		if (null != form.getIsDownId() && !("").equals(form.getIsDownId())) {
			netShare.setToShareId(form.getIsDownId());
			netShare.setStatus("2");
			netShareService.createNetShareInfo(netShare);

		}
		// 将文件表的是否共享 设置成已共享
		NetFile netFile = new NetFile();
		netFile.setIsShore("Y");
		netFile.setId(form.getId());
		netFileService.updateNetFileInfo(netFile);
		NetFilePage netFilePage = new NetFilePage();
		netFilePage.setLoginId(SecurityUtils.getLoginId());
		// 取得上传页面列表,分页显示
		NetFilePage page = netFileService.getNetFileListByPage(netFilePage);
		map.put("page", page); // 保存页面渲染数据
		// 跳转至上传列表页面
		return "netfile/netfile_list";
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
	@RequestMapping("/netFile/delete.htm")
	@ResponseBody
	public boolean removeNetFile(Long id) {
		NetFile netFile = new NetFile();
		netFile = netFileService.getNetFileDetailInfo(id);
		if (("N").equals(netFile.getIsShore())) {

			netFileService.deleteNetFileInfo(id);
			// 检查是否存在附件 如果存在则删除
			if (netFile.getFileDir() != null) {
				File file = new File(netFile.getFileDir());
				file.delete();
			}
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
	@RequestMapping(value = "/netFile/edit.htm", method = RequestMethod.GET)
	public String updateGetNetFile(Long id, ModelMap map) {

		NetFile netFile = netFileService.getNetFileDetailInfo(id);

		map.put("netFile", netFile);
		return "netFile/edit_netfile";
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
	@RequestMapping(value = "/netFile/edit.htm", method = RequestMethod.POST)
	public String updateNetFile(NetFileForm form) {
		NetFile netFile = new NetFile();
		netFile.setTitle(form.getTitle());
		netFile.setId(form.getId());
		netFile.setContent(form.getContent());
		netFileService.editNetFileInfo(netFile);
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
	@RequestMapping("/netFile/delete_batch.htm")
	@ResponseBody
	public boolean removeNetFiles(String idArray) {
		return netFileService.deleteNetFileInfos((toLongArray(idArray)));

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
	@RequestMapping("/netShare/delete.htm")
	public String removeNetShare(Long id) {
		NetShare netShare = new NetShare();
		netShare.setNetId(id);
		netShare.setToShareId(SecurityUtils.getLoginId());
		netShare.setStatus("1");
		netShareService.deleteMyNetShareInfo(netShare);
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
	@RequestMapping("/netShare/delete_batch.htm")
	public String removeNetShanet(String idArray) {
		netShareService.deleteNetShareInfos(toLongArray(idArray), "1");
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
	@RequestMapping("/netShareDown/delete.htm")
	public String removeNetDownShare(Long id) {
		NetShare netShare = new NetShare();
		netShare.setNetId(id);
		netShare.setToShareId(SecurityUtils.getLoginId());
		netShare.setStatus("2");
		netShareService.deleteMyNetShareInfo(netShare);
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
	@RequestMapping("/netShareDown/delete_batch.htm")
	public String removeNetDownShanet(String idArray) {
		netShareService.deleteNetShareInfos(toLongArray(idArray), "2");
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
	@RequestMapping("/netShareDown/download_file.htm")
	public void downloadFile(NetFileForm form, HttpServletResponse response) {
		// 文件下载工具类
				FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK", "upload", 21);
				ftpUtil.connectServer("upload");
				ftpUtil.downloadFile(form.getSrcFileName(), response);
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
	@RequestMapping("/netFile/noShare.htm")
	public String removeShare(Long id) {
		netFileService.setNetNOShare(id);
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
	private NetFile toBean(NetFileForm form) {
		NetFile netFile = new NetFile();
		netFile.setFileDir(form.getFileDir());
		netFile.setSrcFileName(form.getSrcFileName());
		netFile.setTitle(form.getTitle());
		netFile.setContent(form.getContent());
		netFile.setLoginId(SecurityUtils.getLoginId());
		netFile.setIsShore("N");
		return netFile;
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
	private void setSearchKey(NetFileForm form, NetFilePage netFilePage) {
		netFilePage.setCurrentPage(form.getCp()); // 当前页数
		netFilePage.setTitle(form.getTitle());
		netFilePage.setLoginId(SecurityUtils.getLoginId());
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
	@RequestMapping("/netFile/delete_search.htm")
	public String delectNetFile(long id) {
		netFileService.deleteNetFileInfoById(id);
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
	@RequestMapping("/netFile/delete_search_netFileArray.htm")
	public String removeNetFile(String idArray) {
		// 删除通讯录信息
		netFileService.deleteNetFiles(toLongArray(idArray));
		// 返回到操作成功页面
		return "common/action_succ";
	}

}
