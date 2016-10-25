package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkScheduler;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkSchedulerPage;
import com.bcqsoft.sgoa.mvc.controller.index.AppSchedulerController.MySortForDate;
import com.bcqsoft.sgoa.mvc.controller.index.util.WorkSchedulerRes;
import com.bcqsoft.sgoa.service.workscheduler.WorkSchedulerService;
/*
 * App工作日程控制器
 * */
@Controller
public class AppWorkSchedulerController {
	private @Autowired WorkSchedulerService workSchedulerService;
	/**
	 * 查看日程提醒列表
	 * 
	 * @param map
	 * @return 日程提醒页面
	 * 
	 * @Author cql
	 * @Date 2012-03-02
	 */
	@RequestMapping("/home/workscheduler/workscheduler_list.htm")
	@ResponseBody
	public Map<String,Object> schedulerList(HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String loginId = request.getParameter("loginId");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
//		if (yMon == null || "".equals(yMon)) {
//			Map<String,Object>  resMap = new HashMap<String, Object>();
//			resMap.put("message", "请输入年月");
//			resMap.put("retCode", 1);
//			resMap.put("data", null);
//			return resMap;
//					
//		}
		String retCode = "";
		String message = "";
		// 用户分页对象初始化
		WorkSchedulerPage schedulerPage = new WorkSchedulerPage();
		// 设置查询条件
		schedulerPage.setCurrentPage(Integer.parseInt(currentPage));
		schedulerPage.setPageSize(Integer.parseInt(pageSize));
		schedulerPage.setStartTime(startTime);
		schedulerPage.setEndTime(endTime);
		schedulerPage.setLoginId(loginId); // 登录人
		//setSearchKey(form, schedulerPage);
		// 取得用户列表,分页显示
		WorkSchedulerPage page = workSchedulerService
				.getWorkSchedulerInfoList(schedulerPage);
		List<WorkScheduler> list = page.getWorkSchedulerList();
		Map<String,Object>  listMap = new HashMap<String, Object>();
		for(WorkScheduler i : list){
			String [] str = i.getStartTime().split(" ");
			String [] str1 = str[0].split("-");
			listMap.put(str1[0]+"-"+str1[1], null);
		}
		List<String> listStr = new ArrayList<String>();
		for(String i:listMap.keySet()){
			listStr.add(i);
		}
		Collections.sort(listStr, new MySortForMon());
		List<WorkScheduler> lisWorkScheduler = new ArrayList<WorkScheduler>();
		WorkSchedulerRes workSchedulerRes = new WorkSchedulerRes();
		for(WorkScheduler i :list){
			String [] str = i.getStartTime().split(" ");
			String [] str1 = str[0].split("-");
			if((str1[0]+"-"+str1[1]).equals(listStr.get(0))){
				workSchedulerRes.date=listStr.get(0);
				lisWorkScheduler.add(i);
			}
		}
		workSchedulerRes.workScheduler = lisWorkScheduler;
		Collections.sort(lisWorkScheduler, new MySortForDay());
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", workSchedulerRes);
		return resMap;
	}
	  class MySortForMon implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
	        	String p1 = ((String) object1); // 强制转换  
	        	String p2 = ((String) object2);  
	            return p2.compareTo(p1);  
	        }  
	    }
	  class MySortForDay implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
	        	WorkScheduler p1 = ((WorkScheduler) object1); // 强制转换  
	        	WorkScheduler p2 = ((WorkScheduler) object2);
	        	String[] str = p1.getStartTime().split(" ");
	        	String[] str1 = str[0].split("-");
	        	String[] str2 = p2.getStartTime().split(" ");
	        	String[] str3 = str2[0].split("-");
	            return (str3[0]+"-"+str3[1]).compareTo(str1[0]+"-"+str1[1]);  
	        }  
	    } 
	  /**
		 * 查看日程提醒列表
		 * 
		 * @param map
		 * @return 日程提醒页面
		 * 
		 * @Author cql
		 * @Date 2012-03-02
		 */
		@RequestMapping("/home/workscheduler/workscheduler_list_byMon.htm")
		@ResponseBody
		public Map<String,Object> schedulerListByMon(HttpServletRequest request,HttpServletResponse response) {
			String currentPage = request.getParameter("currentPage");
			String pageSize = request.getParameter("pageSize");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String loginId = request.getParameter("loginId");
			String yMon  = request.getParameter("yMon");
			if (currentPage == null || "".equals(currentPage)) {
				currentPage = "1";
			}
			if (pageSize == null || "".equals(pageSize)) {
				pageSize = "20";
			}
			if (yMon == null || "".equals(yMon)) {
				Map<String,Object>  resMap = new HashMap<String, Object>();
				resMap.put("message", "请输入年月");
				resMap.put("retCode", 1);
				resMap.put("data", null);
				return resMap;
						
			}
			String retCode = "";
			String message = "";
			// 用户分页对象初始化
			WorkSchedulerPage schedulerPage = new WorkSchedulerPage();
			// 设置查询条件
			schedulerPage.setCurrentPage(Integer.parseInt(currentPage));
			schedulerPage.setPageSize(Integer.parseInt(pageSize));
			schedulerPage.setStartTime(startTime);
			schedulerPage.setEndTime(endTime);
			schedulerPage.setLoginId(loginId); // 登录人
			//setSearchKey(form, schedulerPage);
			// 取得用户列表,分页显示
			WorkSchedulerPage page = workSchedulerService
					.getWorkSchedulerInfoList(schedulerPage);
			List<WorkScheduler> list = page.getWorkSchedulerList();
			Map<String,Object>  listMap = new HashMap<String, Object>();
			for(WorkScheduler i : list){
				String [] str = i.getStartTime().split(" ");
				String [] str1 = str[0].split("-");
				listMap.put(str1[0]+""+str1[1], null);
			}
			List<String> listStr = new ArrayList<String>();
			for(String i:listMap.keySet()){
				listStr.add(i);
			}
			Collections.sort(listStr, new MySortForMon());
			List<WorkScheduler> lisWorkScheduler = new ArrayList<WorkScheduler>();
			WorkSchedulerRes workSchedulerRes = new WorkSchedulerRes();
			for(WorkScheduler i :list){
				String [] str = i.getStartTime().split(" ");
				String [] str1 = str[0].split("-");
				if((str1[0]+"-"+str1[1]).equals(yMon)){
					workSchedulerRes.date=yMon;
					lisWorkScheduler.add(i);
				}
			}
			if(lisWorkScheduler.size()==0){
				Map<String,Object>  resMap = new HashMap<String, Object>();
				resMap.put("message", "该月没有数据");
				resMap.put("retCode", 0);
				resMap.put("data", null);
				return resMap;
			}
			workSchedulerRes.workScheduler = lisWorkScheduler;
			Collections.sort(lisWorkScheduler, new MySortForDay());
			retCode = list==null?"0":"0";
			message = list==null?"取得成功":"取得成功";
			Map<String,Object>  resMap = new HashMap<String, Object>();
			resMap.put("message", message);
			resMap.put("retCode", retCode);
			resMap.put("data", workSchedulerRes);
			return resMap;
		}
}
