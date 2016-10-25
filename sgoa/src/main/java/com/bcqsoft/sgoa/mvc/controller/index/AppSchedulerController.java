package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.SchedulerPage;
import com.bcqsoft.sgoa.mvc.controller.index.util.SchedulerMapRes;
import com.bcqsoft.sgoa.mvc.controller.index.util.SchedulerRes;
import com.bcqsoft.sgoa.service.scheduler.SchedulerService;

@Controller
public class AppSchedulerController {
	private @Autowired SchedulerService schedulerService;
	/**
	 * 查看日程提醒列表
	 * 
	 * @param map
	 * @return 日程提醒页面
	 * 
	 * @Author zy
	 * @Date 20161020
	 */
	@RequestMapping("/home/scheduler/scheduler_list.htm")
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
		String retCode = "";
		String message = "";
		// 用户分页对象初始化
		SchedulerPage schedulerPage = new SchedulerPage();
		schedulerPage.setCurrentPage(Integer.parseInt(currentPage));
		schedulerPage.setPageSize(Integer.parseInt(pageSize));
		schedulerPage.setStartTime(startTime);
		schedulerPage.setEndTime(endTime);
		schedulerPage.setLoginId(loginId); // 登录人
		// 取得用户列表,分页显示
		SchedulerPage page = schedulerService
				.getSchedulerInfoList(schedulerPage);
		List<Scheduler> list = page.getSchedulerList();
		Map<String, Object> map = new HashMap<String, Object>();
		for(Scheduler i : list){
			String str = i.getStartTime();
			String[] date = str.split(" ");
			String[] mon = date[0].split("-");
			map.put(mon[0]+"-"+mon[1],null);
		}
		List<String> sortMap = new ArrayList<String>();
		for(String t : map.keySet()){
			sortMap.add(t);
		}
		
		Collections.sort(sortMap, new MySort());
		Map<String,Object> mapMon = new HashMap<String, Object>();
		for(String i:sortMap){
			System.out.println(i);
			mapMon.put(i, null);
		}
		List<SchedulerRes> schedulerResList = new ArrayList<SchedulerRes>();
		for(String t : sortMap){
			List<Scheduler> ggList = new ArrayList<Scheduler>();
			SchedulerRes scheduler = new SchedulerRes();
			for(Scheduler i:list){
				String str = i.getStartTime();
				String[] date = str.split(" ");
				String[] mon = date[0].split("-");
				String monNew = mon[0]+"-"+mon[1];
				if(monNew.equals(t)){
					ggList.add(i);
					scheduler.date=t;
				}
			}
			Collections.sort(ggList, new MySortForDate());
			scheduler.scheduler = ggList;
			schedulerResList.add(scheduler);
		}
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", schedulerResList);
		return resMap;
	}
	 public static String getPinYinHeadChar(String str) {
	        String convert = "";
	        for (int j = 0; j < str.length(); j++) {
	            char word = str.charAt(j);
	            // 提取汉字的首字母
	            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
	            if (pinyinArray != null) {
	                convert += pinyinArray[0].charAt(0);
	            } else {
	                convert += word;
	            }
	        }
	        return convert;
	    }
		
	  class MySort implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
	        	String p1 = ((String) object1); // 强制转换  
	        	String p2 = ((String) object2);  
	            return p2.compareTo(p1);  
	        }  
	    } 
	  class MySortForDate implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
	        	Scheduler p1 = ((Scheduler) object1); // 强制转换  
	        	Scheduler p2 = ((Scheduler) object2);  
	        	String[] str1 = p1.getStartTime().split(" ");
	        	String[] str2 = p2.getStartTime().split(" ");
	        	String[] st1 = str1[0].split("-");
	        	String[] st2 = str2[0].split("-");
	            return st2[2].compareTo(st1[2]);  
	        }  
	    } 
	  /**
		 * 查看日程提醒列表
		 * 
		 * @param map
		 * @return 日程提醒页面
		 * 
		 * @Author zy
		 * @Date 20161020
		 */
		@RequestMapping("/home/scheduler/scheduler_list_bymon.htm")
		@ResponseBody
		public Map<String,Object> schedulerListByMon(HttpServletRequest request,HttpServletResponse response) {
			String currentPage = request.getParameter("currentPage");
			String pageSize = request.getParameter("pageSize");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String loginId = request.getParameter("loginId");
			String yMon  = request.getParameter("yMon");
			Map<String,Object>  resMap = new HashMap<String, Object>();
			if (currentPage == null || "".equals(currentPage)) {
				currentPage = "1";
			}
			if (pageSize == null || "".equals(pageSize)) {
				pageSize = "20";
			}
			String retCode = "";
			String message = "";
			// 用户分页对象初始化
			SchedulerPage schedulerPage = new SchedulerPage();
			schedulerPage.setCurrentPage(Integer.parseInt(currentPage));
			schedulerPage.setPageSize(Integer.parseInt(pageSize));
			schedulerPage.setStartTime(startTime);
			schedulerPage.setEndTime(endTime);
			schedulerPage.setLoginId(loginId); // 登录人
			// 取得用户列表,分页显示
			SchedulerPage page = schedulerService
					.getSchedulerInfoList(schedulerPage);
			List<Scheduler> list = page.getSchedulerList();
			Map<String, Object> map = new HashMap<String, Object>();
			for(Scheduler i : list){
				String str = i.getStartTime();
				String[] date = str.split(" ");
				String[] mon = date[0].split("-");
				if(yMon.equals(mon[0]+"-"+mon[1])){
					map.put(mon[0]+"-"+mon[1],null);
				}
				
			}
			List<String> sortMap = new ArrayList<String>();
			for(String t : map.keySet()){
				sortMap.add(t);
			}
			
			Collections.sort(sortMap, new MySort());
			Map<String,Object> mapMon = new HashMap<String, Object>();
			for(String i:sortMap){
				System.out.println(i);
				mapMon.put(i, null);
			}
			List<SchedulerRes> schedulerResList = new ArrayList<SchedulerRes>();
			for(String t : sortMap){
				List<Scheduler> ggList = new ArrayList<Scheduler>();
				SchedulerRes scheduler = new SchedulerRes();
				for(Scheduler i:list){
					String str = i.getStartTime();
					String[] date = str.split(" ");
					String[] mon = date[0].split("-");
					String monNew = mon[0]+"-"+mon[1];
					if(monNew.equals(t)){
						ggList.add(i);
						scheduler.date=t;
					}
				}
				Collections.sort(ggList, new MySortForDate());
				scheduler.scheduler = ggList;
				schedulerResList.add(scheduler);
			}
			SchedulerRes sRes = new SchedulerRes();
			for(SchedulerRes i : schedulerResList){
				if(i.date.equals(yMon)){
					sRes.date=i.date;
					sRes.scheduler = i.scheduler;
				}
			}
			Map<String,Object> dayMap = new HashMap<String, Object>();
			List<String> listSort = new ArrayList<String>();
			if(sRes.scheduler==null){
				resMap.put("message", "该月份没有数据");
				resMap.put("retCode", 0);
				resMap.put("data", null);
				return resMap; 
			}
			for(Scheduler i  : sRes.scheduler){
				String [] tmpStr =i.getStartTime().split(" ");
				String [] tmpStrDay = tmpStr[0].split("-");
				dayMap.put(tmpStrDay[2],null);
			}
			
			for(String i : dayMap.keySet()){
				listSort.add(i);
			}
			Collections.sort(listSort, new MySortByDay());
			//List<SchedulerRes> listscheRes = new ArrayList<SchedulerRes>();
			List<SchedulerRes> listscheR = new ArrayList<SchedulerRes>();
			for(String i : listSort){
				List<Scheduler> listsche = new ArrayList<Scheduler>();
				SchedulerRes schedulerRes = new SchedulerRes();
				for(Scheduler j : sRes.scheduler){
					String [] tmpStr =j.getStartTime().split(" ");
					String [] tmpStrDay = tmpStr[0].split("-");
					if(i.equals(tmpStrDay[2])){
						schedulerRes.date = i;
						listsche.add(j);
					}
				}
				Collections.sort(listsche, new MySortByHour());
				schedulerRes.scheduler = listsche;
				listscheR.add(schedulerRes);
			}
			retCode = list==null?"0":"0";
			message = list==null?"取得成功":"取得成功";
		
			resMap.put("message", message);
			resMap.put("retCode", retCode);
			resMap.put("data", listscheR);
			return resMap;
		}
		  class MySortByDay implements Comparator {  
		        public int compare(Object object1, Object object2) {// 实现接口中的方法  
		        	String p1 = ((String) object1); // 强制转换  
		        	String p2 = ((String) object2);  

		            return p2.compareTo(p1);  
		        }  
		    } 
		  class MySortByHour implements Comparator {  
		        public int compare(Object object1, Object object2) {// 实现接口中的方法  
		        	Scheduler p1 = ((Scheduler) object1); // 强制转换  
		        	Scheduler p2 = ((Scheduler) object2);  
		        	String[] str1 = p1.getStartTime().split(" ");
		        	String[] str2 = p2.getStartTime().split(" ");
		        	String[] st1 = str1[1].split("-");
		        	String[] st2 = str2[1].split("-");
		            return st2[0].compareTo(st1[0]);  
		        }  
		    } 
	  
}
