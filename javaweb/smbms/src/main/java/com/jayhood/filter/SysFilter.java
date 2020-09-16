package com.jayhood.filter;

import com.jayhood.entity.User;
import com.jayhood.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是过滤器sys----开始执行");

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        User user = (User)req.getSession().getAttribute(Constant.USER_SESSION);

        if(user == null){
            resp.sendRedirect(req.getContextPath() + "/syserror.jsp");
        }
        else{
            chain.doFilter(request,response);
        }
        System.out.println("我是过滤器sys----结束执行");
    }

    public void destroy() {

    }
}
