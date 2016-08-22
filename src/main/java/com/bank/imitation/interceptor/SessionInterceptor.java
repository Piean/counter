package com.bank.imitation.interceptor;

import com.bank.imitation.model.Counter;
import com.bank.imitation.service.ICounterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by mogu on 2016/8/15.
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Resource
    private ICounterService counterService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String userId =  httpServletRequest.getSession().getId();
        if (StringUtils.isBlank(userId)) {
            httpServletResponse.sendRedirect("/counter/index.do");
            return false;
        } else {
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Counter counter = (Counter) session.getAttribute(session.getId());

        counter.setLastLeaveTime((int) (System.currentTimeMillis()/1000) + session.getMaxInactiveInterval());
        counterService.updateCounter(counter);
    }
}
