package com.iris.web.intercepter;

import com.iris.common.utils.WebConstants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AdminInterceptor
 *
 * @author: zhangteng
 * @time: 13-12-5 下午5:53
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer uid = (Integer) request.getSession().getAttribute(WebConstants.SESSIONUID);

        if(uid != null) {
            return true;
        }

        String requestUrl = request.getRequestURL().toString();
        // 如果是登陆请求，跳转到登陆页
        if(requestUrl.indexOf("login") > -1) {
            return true;
        }

        String forReturn = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        response.sendRedirect(forReturn + "/admin/login");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
         super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
