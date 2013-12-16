package com.iris.common.log;

import org.apache.log4j.Appender;

/**
 * 日志logger
 * 
 * @author Lionel pang
 * @date 2010-7-7
 */
public interface CLogger {

	/**
	 * 增加appender
	 * 
	 * @param newAppender
	 */
	public void addAppender(Appender newAppender);

	/**
	 * 断言log
	 * @param assertion
	 * @param msg
	 */
	public void assertLog(boolean assertion, String msg);

	/**
	 * debug消息
	 * @param message
	 * @param t
	 */
	public void debug(Object message, Throwable t);

	/**
	 * debug消息
	 * @param message
	 */
	public void debug(Object message);

	/**
	 * @param obj
	 * @return
	 */
	public boolean equals(Object obj);

	/**
	 * 错误消息
	 * @param message
	 * @param t
	 */
	public void error(Object message, Throwable t);

	/**
	 * 错误消息
	 * @param message
	 */
	public void error(Object message);

	/**
	 * 致命错误消息
	 * @param message
	 * @param t
	 */
	public void fatal(Object message, Throwable t);

	/**
	 * 致命错误消息
	 * @param message
	 */
	public void fatal(Object message);

	/**
	 * 提示消息
	 * @param message
	 * @param t
	 */
	public void info(Object message, Throwable t);

	/**
	 * 提示消息
	 * @param message
	 */
	public void info(Object message);

	/**
	 * 追踪消息
	 * @param message
	 * @param t
	 */
	public void trace(Object message, Throwable t);

	/**
	 * 追踪消息
	 * @param message
	 */
	public void trace(Object message);

	/**
	 * 警告消息
	 * @param message
	 * @param t
	 */
	public void warn(Object message, Throwable t);

	/**
	 * 警告消息
	 * @param message
	 */
	public void warn(Object message);

}
