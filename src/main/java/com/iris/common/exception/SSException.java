package com.iris.common.exception;

/**
 * SSException
 *
 * @author: zhangteng
 * @time: 13-12-11 上午9:23
 */
public class SSException extends Exception {

    private static final long serialVersionUID = 1L;

    public SSException() {

    }

    public SSException(String msg) {
        super(msg);
    }

    public SSException(Throwable e) {
        super(e);
    }

    public SSException(String msg, Throwable e) {
        super(msg, e);
    }
}
