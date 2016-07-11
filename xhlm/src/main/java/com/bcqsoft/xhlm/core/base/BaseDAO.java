package com.bcqsoft.xhlm.core.base;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * DAO层基类.<br>
 * 所有DAO需继承此类<br>
 */
public class BaseDAO extends SqlMapClientDaoSupport {

	/**
	 * sqlMapClient
	 */
	@Resource(name = "sqlMapClient")
	private SqlMapClient sqlMapClient;

	/**
	 * 初始化sqlMapClient
	 */
	@PostConstruct
	public void initSqlMapClient() {
		super.setSqlMapClient(sqlMapClient);
	}

	/**
	 * 取得SqlMapClientTemplate<br>
	 * <p>
	 * 为了代码简洁,方便调用
	 * </p>
	 * 
	 * <pre>
	 * 可直接调用ibatis().queryForObject()等方法
	 * </pre>
	 * 
	 * @author zbq2109
	 * @date 2011-5-13
	 * @return
	 */
	public SqlMapClientTemplate ibatis() {
		return super.getSqlMapClientTemplate();
	}
}
