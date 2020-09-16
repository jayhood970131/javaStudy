package com.jayhood.filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httprequestServlet = (HttpServletRequest)request;
        HttpServletResponse httpresponseServlet = (HttpServletResponse)response;

        if (httprequestServlet.getSession().getAttribute("USER_SESSION") == null){
            httpresponseServlet.sendRedirect(httprequestServlet.getContextPath() + "/error.jsp");
        }

        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
