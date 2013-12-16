package com.iris.common.log;

import org.apache.log4j.Appender;

/**
 * 日志类的抽象父类
 * 
 * @author Lionel pang
 * @date 2010-7-7
 */
public abstract class Log{
	/**
	 * 获取实体类
	 * @return
	 */
	protected abstract CLogger instance();
	
	/**
	 * 增加appender
	 * @param newAppender
	 */
	public void addAppender(Appender newAppender) {
		instance().addAppender(newAppender);
	}

	/**
	 * 断言log
	 * @param assertion
	 * @param msg
	 */
	public void assertLog(boolean assertion, String msg) {
		instance().assertLog(assertion, msg);
	}

	/**
	 * debug信息
	 * @param message
	 * @param t
	 */
	public void debug(Object message, Throwable t) {
		instance().debug(message, t);
	}

	/**
	 * debug信息
	 * @param message
	 */
	public void debug(Object message) {
		instance().debug(message);
	}

	public boolean equals(Object obj) {
		return instance().equals(obj);
	}

	/**
	 * 错误消息
	 * @param message
	 * @param t
	 */
	public void error(Object message, Throwable t) {
		instance().error(message, t);
	}

	/**
	 * 错误信息 如果message 是Throwable类型  则instance().error("Log4j Log Stack:", throwable);
	 * @param message
	 */
	public void error(Object message) {
		if(message instanceof Throwable){
			Throwable throwable = (Throwable) message;
			instance().error("Log4j Log Stack:", throwable);
		} else{
			instance().error(message);
		}
	}

	/**
	 * 致命错误
	 * @param message
	 * @param t
	 */
	public void fatal(Object message, Throwable t) {
		instance().fatal(message, t);
	}

	/**
	 * 致命错误
	 * @param message
	 */
	public void fatal(Object message) {
		instance().fatal(message);
	}

	/**
	 * 提示信息
	 * @param message
	 * @param t
	 */
	public void info(Object message, Throwable t) {
		instance().info(message, t);
	}

	/**
	 * 提示信息
	 * @param message
	 */
	public void info(Object message) {
		instance().info(message);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return instance().toString();
	}

	/**
	 * 追踪消息
	 * @param message
	 * @param t
	 */
	public void trace(Object message, Throwable t) {
		instance().trace(message, t);
	}

	/**
	 * 追踪消息
	 * @param message
	 */
	public void trace(Object message) {
		instance().trace(message);
	}

	/**
	 * 警告消息
	 * @param message
	 * @param t
	 */
	public void warn(Object message, Throwable t) {
		instance().warn(message, t);
	}

	/**
	 *  警告消息
	 * @param message
	 */
	public void warn(Object message) {
		instance().warn(message);
	}
}
