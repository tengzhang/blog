package com.iris.common.dao.mybatis;

import java.util.Properties;

import com.iris.common.log.LogClerk;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;



/**
 * @author lijian
 * @Date 2012-8-8
 */
@Intercepts({@Signature(type=Executor.class,method = "query",args={MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})})
public class QueryLogIntercepter implements Interceptor {
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement)args[0];
		Object param = args[1];
		LogClerk.sqlLog.debug("sql:"+ms.getBoundSql(param).getSql());
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	@Override
	public void setProperties(Properties arg0) {

	}

}
