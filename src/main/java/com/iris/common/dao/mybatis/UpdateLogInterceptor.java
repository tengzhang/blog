package com.iris.common.dao.mybatis;

import java.util.Properties;

import com.iris.common.log.LogClerk;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;


@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class UpdateLogInterceptor implements Interceptor {

    private static Log log = LogFactory.getLog(UpdateLogInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
	Object[] args = invocation.getArgs();

	if (args != null && args.length > 0) {
	    MappedStatement ms = (MappedStatement) args[0];
	    Object param = args[1];
	    LogClerk.sqlLog.debug("sql@@@@@:" + ms.getBoundSql(param).getSql());
	}

	Object result = invocation.proceed();
	return result;
    }

    @Override
    public Object plugin(Object target) {
	return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
