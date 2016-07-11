package com.bcqsoft.xhlm.core.exception.observer;

import java.util.Observable;

/**
 * 数据库记录观察者
 * <p>
 * 异常信息发生时,记录数据库
 * </p>
 */
public class EmailSendingObserver extends ExceptionObserver {

	/**
	 * 当被观察者发生变化时,观察者需要执行此方法<br>
	 * 发送邮件通知管理员
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("email observer");
	}

}
