package com.bcqsoft.sgoa.core.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.bcqsoft.sgoa.core.exception.observer.DatabaseRecordObserver;
import com.bcqsoft.sgoa.core.exception.observer.EmailSendingObserver;
import com.bcqsoft.sgoa.core.exception.observer.ExceptionObserver;

/**
 * 全局异常处理类
 * <p>
 * 当应用程序运行时抛出异常并且没有捕获时,会执行此类中方法.<br>
 * 程序出现异常时,跳转至全局异常页面(增加页面友好度)并记录及通知管理员
 * </p>
 * 
 * <pre>
 * 此处采用观察者模式,每次操作或通知都为一个观察者
 * 当前类为被观察者如果出现异常及通知各个观察者执行相应操作
 * </pre>
 */
public class GlobalExceptionResolver extends Observable implements HandlerExceptionResolver {

	/**
	 * 观察者集合
	 */
	static List<ExceptionObserver> observers = new ArrayList<ExceptionObserver>();

	/**
	 * 添加观察者
	 */
	static {
		observers.add(new DatabaseRecordObserver()); // DB记录
		observers.add(new EmailSendingObserver()); // 邮件通知
	}

	/**
	 * 全局异常异常处理方法<br>
	 * <li>通知各个观察者</li><br>
	 * <li>捕获异常跳转错误页面</li>
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		addAllObserver();
		setChanged();
		notifyObservers(ex);

		// 如果是权限错误,跳转至权限错误页面
		if (ex instanceof AccessDeniedException) {
		}
		return new ModelAndView("/common/error");
	}

	/**
	 * 添加各个观察者
	 * 
	 * @author zbq2109
	 * @date 2011-5-19
	 */
	private void addAllObserver() {
		for (ExceptionObserver observer : observers) {
			addObserver(observer);
		}
	}

}
