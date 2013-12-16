package com.iris.common.Advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * LogAdvice
 *
 * @author: zhangteng
 * @time: 13-12-12 下午4:32
 */
public class LogAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("系统日志：" + new Date() + ":" + "调用了" + method.getName() + ",试用了参数" + (Arrays.toString(objects)));
    }
}
