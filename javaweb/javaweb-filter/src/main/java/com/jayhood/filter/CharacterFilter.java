package com.jayhood.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("before doing");
        chain.doFilter(request,response);
        System.out.println("after doing");
    }

    public void destroy() {

    }
}
