package com.bcqsoft.xhlm.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JsonBackUtil {
     
    /**
     * 输出json
     * @return
     */
	public static final void jsonOutPut(String str,HttpServletResponse response) {
    	PrintWriter out = null;
		try {
			// 输出到页面
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
    }
	
	/**
     * 输出json
     * @return
     */
	public static final void responseOutPut(String str,HttpServletResponse response) {
    	PrintWriter out = null;
		try {
			// 输出到页面
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
    }
}
