package com.akira.demo.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * learn-spring-cloud
 *
 * @auther Akira Liu
 * @date 2018/5/2
 */
@Component
public class ZuulDemoFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ZuulDemoFilter.class);
    /**
     * 过滤触发点
     * pre：路由之前
     * route：路由之时
     * post： 路由之后
     * error：发送错误调用
     * org.springframework.cloud.netflix.zuul.filters.support.FilterConstants 有常量
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器顺序 越小越先越前
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if (token == null) {
            log.warn("token is empty!");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
            try {
                currentContext.getResponse().getWriter().write("token is empty!");
            } catch (IOException e) {
                log.error("error in filter",e);
            }
        }
        return null;
    }
}
