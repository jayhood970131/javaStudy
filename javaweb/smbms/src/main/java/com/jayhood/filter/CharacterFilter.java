package com.jayhood.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是过滤器Char----开始执行");

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        chain.doFilter(request,response);
        System.out.println("我是过滤器Char----结束执行");

    }

    public void destroy() {

    }
}
