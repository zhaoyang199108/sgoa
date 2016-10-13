package com.bcqsoft.sgoa.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

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
		public SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat(
				"yyyyMMddHHmm");
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
		} catch (ParseException e) {
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
		} catch (ParseException e) {
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
	 * 取得当前日期字符串
	 * 
	 * @return YYYY-MM-DD HH:mm:ss(例:2011-08-29 12:22:22)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getDateTime() {
		return getFormats().YYYYMMDDHHMMSSSSS.format(new Date());
	}

	/**
	 * 取得当前日期字符串
	 * 
	 * @return YYYY-MM-DD HH:mm:ss(例:2011-08-29 12:22:22)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getDateString(Date date) {
		return getFormats().YYYYMMDDHHMMSSSSS.format(date);
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
	 * @return yyyyMMddHHmmss(例:20110829122222)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getDateTimeForMm() {
		return getFormats().yyyyMMddHHmm.format(new Date());
	}

	/**
	 * 取得当前日期字符串
	 * 
	 * @return yyyyMMddHHmmss(例:20110829122222)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getDateTimeForYhhh() {
		return getFormats().YYYYMMDDMM.format(new Date());
	}

	/**
	 * 取得当前日期字符串
	 * 
	 * @return yyyyMMddHHmmss(例:20110829122222)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getDateTimeForYhMM(Date date) {
		return getFormats().YYYYMMDDMM.format(date);
	}
	
	/**
	 * 取得当前日期字符串
	 * 
	 * @return yyyy-MM-dd(例:2012-12-12)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static String getDateTimeForYMD(Date date) {
		return getFormats().YYYYMMDDSTR.format(date);
	}
	
	/**
	 * 取得当前日期字符串
	 * 
	 * @return yyyy-MM-dd(例:2012-12-12)
	 * 
	 * @Author zbq
	 * @Date 2011-8-30
	 */
	public static Date getDateTimeForYM(String dateStr) {
		Date date = null;
		try {
			date = getFormats().YYYYMMDDSTR.parse(dateStr);
		} catch (ParseException e) {
			date = new Date();
		}
		return date;
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
			c1.setTime(getFormats().YYYYMMDDHHMMSSSSS.parse(dateStrStart));
			c2.setTime(getFormats().YYYYMMDDHHMMSSSSS.parse(dateStrEnd));
		} catch (java.text.ParseException e) {
			
		}
		int result = c1.compareTo(c2);
		return result;
	}

	 /**
     * 某一个月第一天和最后一天
     * @param date
     * @return
     */
    public static Map<String, String> getFirstday_Lastday_Month(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        Date theDate = calendar.getTime();
        
        //上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());

        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }
    
  
}
