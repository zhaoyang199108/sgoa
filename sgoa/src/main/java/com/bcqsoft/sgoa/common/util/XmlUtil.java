package com.bcqsoft.sgoa.common.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderScheduler;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkScheduler;

/**
 * 生成xml文件工具类
 * 
 * @author ly
 * @date 2011-12-21
 */
public class XmlUtil {

	/**
	 * 写入xml文件
	 * 
	 * @author ly
	 * @date 2011-12-21
	 * @param list
	 *            从数据库中传入的List对象，不能为null
	 * @param filePath
	 *            要传入文件生成的路径
	 * @throws IOException
	 */
	public static void writeToXml(List<?> list, String filePath) throws IOException {
		// 创建xml对象的节点
		Document doc = DocumentHelper.createDocument();
		// 创建xml对象的data节点
		Element root = doc.addElement("data");
		// 将取出的数据填入event节点中
		for (int i = 0; i < list.size(); i++) {
			
			Scheduler scheduler = (Scheduler) list.get(i);
			// 添加 id、content、start_time、end_time等属性
			root.addElement("event").addAttribute("id", scheduler.getId() == null ? "" : scheduler.getId().toString())
					.addAttribute("text", scheduler.getContent())
					.addAttribute("start_date", scheduler.getStartTime())
					.addAttribute("end_date", scheduler.getEndTime());
		}

		// 随机生成该xml文件名
		String xml = doc.asXML();
		// 定义文件输出对象
		FileOutputStream fos = null;
		// 定义写入对象
		Writer out = null;
		try {
			fos = new FileOutputStream(filePath);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 写入xml对象
			out.write(xml);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * 写入xml文件
	 * 
	 * @author ly
	 * @date 2011-12-21
	 * @param list
	 *            从数据库中传入的List对象，不能为null
	 * @param filePath
	 *            要传入文件生成的路径
	 * @throws IOException
	 */
	public static void writeToWorkSchedulerXml(List<?> list, String filePath) throws IOException {
		// 创建xml对象的节点
		Document doc = DocumentHelper.createDocument();
		// 创建xml对象的data节点
		Element root = doc.addElement("data");
		// 将取出的数据填入event节点中
		for (int i = 0; i < list.size(); i++) {
			
			WorkScheduler scheduler = (WorkScheduler) list.get(i);
			// 添加 id、content、start_time、end_time等属性
			root.addElement("event").addAttribute("id", scheduler.getId() == null ? "" : scheduler.getId().toString())
					.addAttribute("text", scheduler.getContent())
					.addAttribute("start_date", scheduler.getStartTime())
					.addAttribute("end_date", scheduler.getEndTime());
		}

		// 随机生成该xml文件名
		String xml = doc.asXML();
		// 定义文件输出对象
		FileOutputStream fos = null;
		// 定义写入对象
		Writer out = null;
		try {
			fos = new FileOutputStream(filePath);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 写入xml对象
			out.write(xml);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * 写入xml文件
	 * 
	 * @author ly
	 * @date 2011-12-21
	 * @param list
	 *            从数据库中传入的List对象，不能为null
	 * @param filePath
	 *            要传入文件生成的路径
	 * @throws IOException
	 */
	public static void writeToLeaderSchedulerXml(List<?> list, String filePath) throws IOException {
		// 创建xml对象的节点
		Document doc = DocumentHelper.createDocument();
		// 创建xml对象的data节点
		Element root = doc.addElement("data");
		// 将取出的数据填入event节点中
		for (int i = 0; i < list.size(); i++) {
			
			LeaderScheduler scheduler = (LeaderScheduler) list.get(i);
			// 添加 id、content、start_time、end_time等属性
			root.addElement("event").addAttribute("id", scheduler.getId() == null ? "" : scheduler.getId().toString())
					.addAttribute("text", scheduler.getContent())
					.addAttribute("start_date", scheduler.getStartTime())
					.addAttribute("end_date", scheduler.getEndTime());
		}

		// 随机生成该xml文件名
		String xml = doc.asXML();
		// 定义文件输出对象
		FileOutputStream fos = null;
		// 定义写入对象
		Writer out = null;
		try {
			fos = new FileOutputStream(filePath);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 写入xml对象
			out.write(xml);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * 写入xml文件
	 * 
	 * @author ly
	 * @date 2011-12-21
	 * @param list
	 *            从数据库中传入的List对象，不能为null
	 * @param filePath
	 *            要传入文件生成的路径
	 * @throws IOException
	 */
	public static void writeToLeaderSchedulerAllXml(List<?> list, String filePath) throws IOException {
		// 创建xml对象的节点
		Document doc = DocumentHelper.createDocument();
		// 创建xml对象的data节点
		Element root = doc.addElement("data");
		// 将取出的数据填入event节点中
		for (int i = 0; i < list.size(); i++) {
			
			LeaderScheduler scheduler = (LeaderScheduler) list.get(i);
			// 添加 id、content、start_time、end_time等属性
			root.addElement("event").addAttribute("id", scheduler.getId() == null ? "" : scheduler.getId().toString())
					.addAttribute("text", "【"+ scheduler.getUserName() +"】"+scheduler.getContent())
					.addAttribute("start_date", scheduler.getStartTime())
					.addAttribute("end_date", scheduler.getEndTime());
		}

		// 随机生成该xml文件名
		String xml = doc.asXML();
		// 定义文件输出对象
		FileOutputStream fos = null;
		// 定义写入对象
		Writer out = null;
		try {
			fos = new FileOutputStream(filePath);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 写入xml对象
			out.write(xml);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
