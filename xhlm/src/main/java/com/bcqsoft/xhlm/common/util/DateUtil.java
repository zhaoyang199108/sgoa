package com.bcqsoft.xhlm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

/**
 * 日期操作工具类
 */
public class DateUtil {

	private static final ThreadLocal<Formats> LOCAL = new ThreadLocal<Formats>();


	/**
	 * 日期格式内部类
	 * 
	 * @author zbq
	 * @date 2010-01-29
	 */
	private static class Formats {
		public SimpleDateFormat FORMAT = new SimpleDateFormat();
		public SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
		public SimpleDateFormat YYYYMMDDE = new SimpleDateFormat(
				"yyyy年MM月dd日 E");
		public SimpleDateFormat HHMMSSSSS = new SimpleDateFormat("hh24mmssSSS");
		public SimpleDateFormat YYYYMMDDHHMMSSSSS = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		public SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		public SimpleDateFormat YYYYMMDDSTR = new SimpleDateFormat("yyyy-MM-dd");
		public SimpleDateFormat YYYYMMDDMM = new SimpleDateFormat("yyyy-MM");
	}
	

	/**
	 * 取得日期格式
	 * 
	 * @author zbq
	 * @date 2010-01-29
	 */
	private static final Formats getFormats() {
		Formats f = LOCAL.get();
		if (f == null) {
			f = new Formats();
			LOCAL.set(f);
		}
		return f;
	}

	/**
	 * 判断是否是日期类型字符串
	 * 
	 * @param date
	 * @return True:是 False:否
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static boolean isDate(String date) {
		// 将字符串转换为日期类型, 如果出现异常为非日期类型
		try {
			getFormats().YYYYMMDD.parse(date);
		}
		catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * 日期对象转换(String -> Date)
	 * 
	 * @param String
	 * @return Date
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static Date toDate(String d) {
		Date date;
		try {
			date = getFormats().FORMAT.parse(d);
		}
		catch (ParseException e) {
			date = new Date();
		}
		return date;
	}

	/**
	 * 判断某日期是否是今天
	 * 
	 * @param date
	 * @return True:是 False:否
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static boolean isToday(String date) {
		if (!isDate(date)) {
			return false;
		}
		return DateUtils.isSameDay(toDate(date), new Date());
	}

	/**
	 * 取得当前日期字符串
	 * 
	 * @return YYYYMMDD(例:20110829)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getToday() {
		return getFormats().YYYYMMDD.format(new Date());
	}

	/**
	 * 取得当前时间字符串
	 * 
	 * @return hhmmssSSS(例:123855333)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getNow() {
		return getFormats().HHMMSSSSS.format(new Date());
	}

	/**
	 * 取得当前日期字符串
	 * 
	 * @return YYYYMMDD(例:20110829)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getTodays() {
		return getFormats().YYYYMMDDE.format(new Date());
	}

	/**
	 * 取得当前日期字符串
	 * 
	 * @return yyyyMMddHHmmss(例:20110829122222)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getDateTimeForYh() {
		return getFormats().yyyyMMddHHmmss.format(new Date());
	}
	
	/**
	 * 取得当前日期字符串
	 * 
	 * @return YYYYMMDDSTR(例:2011-08-29)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getDateForYMD (Date date) {
		return getFormats().YYYYMMDDSTR.format(date);
	}
	
	/**
     * 根据日期获得所在周的日期 
     * @param mdate
     * @return
     */
    @SuppressWarnings("deprecation")
    public static List<Date> dateToWeek(Date mdate) {
        int b = mdate.getDay();
        Date fdate;
        List<Date> list = new ArrayList<Date>();
        Long fTime = mdate.getTime();
        for (int a = 1; a <= 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a-1, fdate);
        }
        return list;
    }
    
    /** * 获取指定日期是星期几
     * 参数为null时表示获取当前日期是星期几
     * @param date
     * @return
   */
   public static String getWeekOfDate(Date date) {      
       String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};        
       Calendar calendar = Calendar.getInstance();      
       if(date != null){        
            calendar.setTime(date);      
       }        
       int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
       if (w < 0){        
           w = 0;      
       }      
       return weekOfDays[w];    
   }
   
   /**
	 * 两个日期比较
	 * 
	 * @return 比较结果0为相等、小于0为前小于后，大于0为前大于后
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static int getDateTimeCompare(String dateStrStart,String dateStrEnd) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c2.setTime(getFormats().YYYYMMDDSTR.parse(dateStrEnd));
			c1.setTime(getFormats().YYYYMMDDSTR.parse(dateStrStart));
		} catch (java.text.ParseException e) {
			
		}
		int result = c1.compareTo(c2);
		return result;
	}
}
