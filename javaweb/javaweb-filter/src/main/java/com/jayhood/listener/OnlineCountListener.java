package com.jayhood.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 统计网站在线人数
public class OnlineCountListener implements HttpSessionListener {
    // 创建session监听
    // 一旦创建session就会触发一次这个事件
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount == null){
            onlineCount = 1;
        }
        else {
            ++onlineCount;
        }
        servletContext.setAttribute("onlineCount",onlineCount);
    }

    // 销毁session监听
    // 一旦销毁session就会触发
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        // 关闭浏览器并不会销毁session，需要手动指定或者在xml中指定销毁日期
        se.getSession().invalidate();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount == null){
            onlineCount = 0;
        }
        else {
            --onlineCount;
        }
        servletContext.setAttribute("onlineCount",onlineCount);
    }
}
