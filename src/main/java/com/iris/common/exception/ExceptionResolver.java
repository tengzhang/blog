package com.iris.common.exception;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ExceptionResolver
 *
 * @author: zhangteng
 * @time: 13-12-11 上午9:26
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String viewName = determineViewName(ex, request);
        if(viewName != null) {
            if(!(request.getHeader("accept").indexOf("application/json") > -1) ||
                    (request.getHeader("X-Requested-With") != null &&
                    request.getHeader("X_Requested-With").indexOf("XMLHttpRequest") > -1)) {
                Integer statusCode = determineStatusCode(request, viewName);
                if(statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return new ModelAndView(viewName, "errorMsg", ex.getMessage());
            } else {
                try {
                    PrintWriter pw = response.getWriter();
                    pw.write(ex.getMessage());
                    pw.flush();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        } else {
            return null;
        }
    }
}
