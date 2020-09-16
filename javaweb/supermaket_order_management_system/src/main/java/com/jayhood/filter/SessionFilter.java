package com.jayhood.filter;

import com.jayhood.utils.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 判断当前会话是否有效，无效则退回error页面
public class SessionFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Object obj = req.getSession().getAttribute(Constant.USER_SESSION);

        if (obj == null){
            // 用dispatcher会无限循环
            //req.getRequestDispatcher("/sessionerror.jsp").forward(request,response);
            resp.sendRedirect(req.getContextPath() + "/sessionerror.jsp");
        }
        else{
            chain.doFilter(request,response);
        }

    }

    public void destroy() {

    }
}
