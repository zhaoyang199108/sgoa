package com.bcqsoft.xhlm.core.factory;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Beans工厂类
 */
public class BeansFactory implements ApplicationContextAware {

	/**
	 * 初始化状态
	 * <p>
	 * True:已经初始话, Flase:未初始化
	 * </p>
	 */
	private boolean alreadyInit = false;

	/**
	 * ApplicationContext上下文
	 */
	private ApplicationContext appContext;

	/**
	 * 单例模式(私有构造函数)
	 */
	private BeansFactory() {

	}

	/**
	 * 内部单例类
	 */
	private static class SingletonHolder {
		private static BeansFactory factory = new BeansFactory();
	}

	/**
	 * 获得Bean工厂静态实例
	 */
	public static BeansFactory getInstance() {
		return SingletonHolder.factory;
	}

	/**
	 * 根据名称取得Bean对象
	 * 
	 * @param beanName
	 * @return Bean对象
	 */
	@SuppressWarnings("unchecked")
	public <T> T getBeanEntity(String beanName) {
		if (StringUtils.isBlank(beanName)) {
			return null;
		}
		return (T) appContext.getBean(beanName);
	}

	/**
	 * 设置ApplicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeansFactory beansFactory = BeansFactory.SingletonHolder.factory;
		if (!beansFactory.alreadyInit) {
			beansFactory.appContext = applicationContext;
			beansFactory.alreadyInit = true;
		}
	}
}
